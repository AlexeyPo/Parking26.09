package servlets;

import beans.*;
import dao.CustomerDAO;
import dao.FactOfParkingDAO;
import dao.ParkingDAO;
import dao.UserDAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "MainServlet", urlPatterns = {"*.html"})
public class MainServlet extends HttpServlet {

    @EJB
    LoginBean loginBean;
    @EJB
    CustomerDAO customerDAO;
    @EJB
    ParkingDAO parkingDAO;
    @EJB
    UserDAO userDAO;
    @EJB
    FactOfParkingDAO factOfParkingDAO;

    Customer customer;
    User user;
    String sessionId;
    HttpSession session;
    Parking parking;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("/index.html") || requestURI.endsWith("/")) {
            List<Parking> parkings = parkingDAO.findAllParking();
            request.setAttribute("parkingBean", new ParkingBean(parkings));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        if (requestURI.endsWith("/signin.html")) {
            request.getRequestDispatcher("/signin.jsp").forward(request, response);
        }
        if (requestURI.endsWith("/login.html")) {
            if ("signIn".equals(request.getParameter("button"))) {
                String login = request.getParameter("login").trim();
                String password = request.getParameter("password");
                user = loginBean.find(login, password);
                if (user.getId() == 0) {
                    request.setAttribute("message", "Логин или пароль введен не верно.");
                    request.getRequestDispatcher("/signin.jsp").forward(request, response);
                } else if (user.getId() > 0) {
                    request.getSession().setAttribute("user", user);
//                    sessionId = session.getId();
                    getCustomerList(request, response);
                }
            }
        }

//header menu logic
        if (requestURI.endsWith("/menu.html") || requestURI.endsWith("/")) {
            if ("home".equals(request.getParameter("button"))) {
                getCustomerList(request, response);
            } else if ("customer".equals(request.getParameter("button1"))) {
                List<Customer> customerList = customerDAO.getAllCustomers(user.getId());
                request.setAttribute("customerList", customerList);
                request.getRequestDispatcher("/customer.jsp").forward(request, response);
            } else if ("payment".equals(request.getParameter("button2"))) {
                List<Customer> customerList = customerDAO.getAllCustomers(user.getId());
                request.setAttribute("customerList", customerList);
                request.getRequestDispatcher("/payments.jsp").forward(request, response);
            } else if ("employee".equals(request.getParameter("button3"))) {
                List<User> users = userDAO.findUsersById(user.getId());
                request.setAttribute("userBean", new UserBean(users));
                request.getRequestDispatcher("/employee.jsp").forward(request, response);
            } else if ("signOut".equals(request.getParameter("button4"))) {
                request.getSession().setAttribute("user", new User());
                request.getRequestDispatcher("/index.html").forward(request, response);
            }
        }

// come in / go out control
        if (requestURI.endsWith("/moveControl.html")) {
            if ("comeIn".equals(request.getParameter("comeIn"))) {
                String carNumber = request.getParameter("carNumber").trim();
                if (customerDAO.isCarInDataBase(carNumber)) {
                    if (!factOfParkingDAO.isCarOnParking(carNumber)) {
                        factOfParkingDAO.startParking(carNumber, user.getId());
                        parkingDAO.countOccupiedParking(user.getId());
                        getCustomerList(request, response);
                    } else {
                        request.setAttribute("message", "Транспортное средство уже на парковке");
                        getCustomerList(request, response);
                    }
                } else {
                    request.setAttribute("message", "Номер тр. средства отсутствует в базе");
                    getCustomerList(request, response);
                }

            } else if ("goOut".equals(request.getParameter("goOut"))) {
                String carNumberOut = request.getParameter("carNumberOut").trim();
                if (customerDAO.isCarInDataBase(carNumberOut)) {
                    if (factOfParkingDAO.isCarOnParking(carNumberOut)) {
                        factOfParkingDAO.stopParking(carNumberOut, user.getId());
                        parkingDAO.countOccupiedParking(user.getId());
                        getCustomerList(request, response);
                    } else {
                        request.setAttribute("message", "Тр. средство отсутствует на стоянке");
                        getCustomerList(request, response);
                    }
                } else {
                    request.setAttribute("message", "Номер тр. средства отсутствует в базе");
                    getCustomerList(request, response);
                }
            }
        }

//add new Customer
        if (requestURI.endsWith("client.html")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String make = request.getParameter("carMake");
            String model = request.getParameter("carModel");
            String carNumber = request.getParameter("carNumber");

            Customer customer = new Customer(firstName, lastName, phone, make, model, carNumber);

            if (!customerDAO.isCarInDataBase(carNumber)) {
                customerDAO.addNewCustomer(customer);
                factOfParkingDAO.startParking(carNumber, user.getId());
                getCustomerList(request, response);
            } else {
                request.setAttribute("messageClient", "Клиент с таким номером уже зарегистрирован");
                getCustomerList(request, response);
            }
        }

// payment logic
        if (requestURI.endsWith("payment.html")) {
            String carNumber = request.getParameter("carNumberPayment");

            if ("toPay".equals(request.getParameter("toPay"))) {
                if (factOfParkingDAO.isCarOnParking(carNumber)) {
                    factOfParkingDAO.makePayment(factOfParkingDAO.countDaysOnParking(carNumber, user.getId()), factOfParkingDAO.findRate(carNumber), carNumber);
                    factOfParkingDAO.stopParking(carNumber, user.getId());
                    request.setAttribute("daysOnParking", factOfParkingDAO.countDaysOnParking(carNumber, user.getId()));
                    request.setAttribute("rate", factOfParkingDAO.findRate(carNumber));
                    getCustomerList(request, response);

                } else {
                    request.setAttribute("messagePayment", "Тр. средство отсутствует на стоянке");
                    getCustomerList(request, response);
                }
            }
        }
    }

    private void getCustomerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerListOnParking = customerDAO.getAllCarsOnParking(user.getId());
        request.setAttribute("customerListOnParking", customerListOnParking);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
        response.setIntHeader("", 3);
    }
}