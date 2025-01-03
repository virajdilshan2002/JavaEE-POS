package session;

import Entity.Customer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@WebListener
public class SessionFactoryListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder()
                .loadProperties("hibernate.properties").build())
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .build().buildSessionFactory();

        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.setAttribute("sessionFactory", sessionFactory);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        SessionFactory sessionFactory = (SessionFactory) servletContext.getAttribute("sessionFactory");
        try {
            sessionFactory.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
