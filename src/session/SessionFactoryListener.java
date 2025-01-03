package session;

import Entity.Customer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebListener
public class SessionFactoryListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SessionFactory  sessionFactory = new Configuration()
                .configure("/session/hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        System.out.println("Session Factory is created");

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("sessionFactory", sessionFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        SessionFactory sessionFactory = (SessionFactory) servletContext.getAttribute("sessionFactory");
        try {
            sessionFactory.close();
            System.out.println("Session Factory is closed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
