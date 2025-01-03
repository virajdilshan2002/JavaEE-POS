import Entity.Customer;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Customer Servlet is initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Customer doGet() is called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Customer doPost() is called");
        try {
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            String contact = req.getParameter("contact");

            Customer customer = new Customer(1, name, address, contact);

            System.out.println(name + " " + address + " " + contact);

            SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("sessionFactory");
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
            session.close();

            resp.setStatus(HttpServletResponse.SC_CREATED);
            System.out.println("Customer is saved successfully");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}