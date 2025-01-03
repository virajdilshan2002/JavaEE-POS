package dao.custom.impl;

import entity.Customer;
import dao.custom.CustomerDAO;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public List<Customer> getAll() {
        return List.of();
    }

    @Override
    public boolean add(Customer entity) {
        return false;
    }

    @Override
    public boolean update(Customer entity) {
        return false;
    }

    @Override
    public String generateNewID() {
        return "";
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
