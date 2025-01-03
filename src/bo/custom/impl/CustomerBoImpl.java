package bo.custom.impl;


import dto.CustomerDTO;
import entity.Customer;
import bo.custom.CustomerBo;
import dao.DAOFactory;
import dao.custom.CustomerDAO;

import java.util.List;

import static dao.DAOFactory.DAOType.CUSTOMER;

public class CustomerBoImpl implements CustomerBo {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(CUSTOMER);

    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> dtoList = customerDAO.getAll();
        return null;
    }

    @Override
    public boolean add(CustomerDTO dto) {
        return false;
    }

    @Override
    public boolean update(CustomerDTO dto) {
        return false;
    }

    @Override
    public String generateNewID() {
        return "";
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
