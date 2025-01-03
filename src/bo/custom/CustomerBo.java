package bo.custom;


import dto.CustomerDTO;
import bo.SuperBO;

import java.util.List;

public interface CustomerBo extends SuperBO {
    List<CustomerDTO> getAll();

    boolean add(CustomerDTO dto);

    boolean update(CustomerDTO dto);

    String generateNewID() ;

    boolean delete(int id);
}
