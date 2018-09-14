package servlets;

import beans.Customer;
import beans.CustomerBean;
import beans.LoginBean;
import beans.User;
import dao.CustomerDAO;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("/login.html")) {
            if ("Sign In".equals(request.getParameter("button"))) {
                String login = request.getParameter("login").trim();
                String password = request.getParameter("password");
                User user = loginBean.find(login, password);

                if (user.getId() == 0) {
                    request.setAttribute("message", "Login failed. User or password incorrect");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    List<Customer> customers = customerDAO.getAllCustomers();
                    request.setAttribute("customerBean", new CustomerBean(customers));
                    request.getRequestDispatcher("/home.jsp").forward(request, response);
                }
            }
        } else if (requestURI.endsWith("/signout.html")) {
            request.getSession().setAttribute("user", new User());
            List<Customer> customers = customerDAO.getAllCustomers();
            request.setAttribute("customerBean", new CustomerBean(customers));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
