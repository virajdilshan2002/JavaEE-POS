package sessionfactory;

import entity.Customer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.hibernate.cfg.Configuration;

@WebListener
public class SessionFactoryListener implements ServletContextListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        org.hibernate.SessionFactory sessionFactory = new Configuration()
                .configure("/sessionfactory/hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        System.out.println("Session Factory is created");

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("sessionFactory", sessionFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        org.hibernate.SessionFactory sessionFactory = (org.hibernate.SessionFactory) servletContext.getAttribute("sessionFactory");
        try {
            sessionFactory.close();
            System.out.println("Session Factory is destroyed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session is created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session is destroyed");
    }
}
