package dao;


import dao.custom.impl.CustomerDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private static CustomerDAOImpl customerDAO;

    private DAOFactory(){
        customerDAO = new CustomerDAOImpl();
    }

    public static DAOFactory getInstance(){
        return daoFactory = daoFactory == null ? new DAOFactory() : daoFactory;
    }

    public enum DAOType{
        CUSTOMER
    }

    public CrudDAO getDAO(DAOType type){
        return switch (type){
            case CUSTOMER -> customerDAO;
        };
    }
}
