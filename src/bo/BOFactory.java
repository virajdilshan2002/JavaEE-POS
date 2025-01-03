package bo;

import bo.custom.impl.CustomerBoImpl;

public class BOFactory implements SuperBO{
    private static BOFactory boFactory;
    private static CustomerBoImpl customerBo;

    private BOFactory(){
        customerBo = new CustomerBoImpl();
    }

    public static BOFactory getInstance(){
        return boFactory = boFactory == null ? new BOFactory() : boFactory;
    }

    public enum BOType {
        CUSTOMER
    }

    public SuperBO getBO(BOType type){
        return switch (type) {
            case CUSTOMER -> customerBo;
        };
    }

}
