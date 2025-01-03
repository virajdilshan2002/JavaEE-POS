import entity.Customer;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    List<Customer> customerList;

    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");

            //get all customers
            SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("sessionFactory");
            Session session = sessionFactory.openSession();
            customerList = session.createQuery("From Customer", Customer.class).list();
            if (customerList == null) {
                resp.getWriter().write("customer table is empty");
                return;
            }

            //create json array
            JsonArrayBuilder allCusJson = Json.createArrayBuilder();

            for (Customer customer : customerList) {
                //create a single json object
                JsonObjectBuilder cusJson = Json.createObjectBuilder();
                cusJson.add("id", customer.getId());
                cusJson.add("name", customer.getName());
                cusJson.add("address", customer.getAddress());
                cusJson.add("contact", customer.getContact());

                allCusJson.add(cusJson.build());
            }
            resp.getWriter().write(allCusJson.build().toString());
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Customer doPost() is called");
        try {
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            String contact = req.getParameter("contact");

            Customer customer = new Customer(1, name, address, contact);

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