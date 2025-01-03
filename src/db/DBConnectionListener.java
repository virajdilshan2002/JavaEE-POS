package db;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.commons.dbcp2.BasicDataSource;

@WebListener
public class DBConnectionListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/company");
        ds.setUsername("root");
        ds.setPassword("Ijse@1234");
        ds.setMaxTotal(5);
        ds.setInitialSize(5);

        //Common Interface to share data between servlets
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("dataSource", ds);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        BasicDataSource datasource = (BasicDataSource) servletContext.getAttribute("dataSource");
        try {
            datasource.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
