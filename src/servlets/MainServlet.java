package servlets;

import beans.*;
import dao.CustomerDAO;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("/index.html")) {
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
                User user = loginBean.find(login, password);

                if (user.getId() == 0) {
                    request.setAttribute("message", "Login failed. User or password incorrect");
                    request.getRequestDispatcher("/signin.jsp").forward(request, response);
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("/home.jsp").forward(request, response);

                }
            }


        }


        if (requestURI.endsWith("/menu.html")) {
            if ("home".equals(request.getParameter("button"))) {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else if ("customer".equals(request.getParameter("button1"))) {
                List<Customer> customers = customerDAO.getAllCustomers();
                request.setAttribute("customerBean", new CustomerBean(customers));
                request.getRequestDispatcher("/customer.jsp").forward(request, response);
            } else if ("payment".equals(request.getParameter("button2"))) {
                request.getRequestDispatcher("/payments.jsp").forward(request, response);
            } else if ("employee".equals(request.getParameter("button3"))) {
                List<User> users = userDAO.findAllUssers();
                request.setAttribute("userBean", new UserBean(users));
                request.getRequestDispatcher("/employee.jsp").forward(request, response);
            } else if ("signOut".equals(request.getParameter("button4"))) {
                request.getSession().setAttribute("user", new User());
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }

        }
    }
}
