package Entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "cus_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cus_name")
    private String name;

    @Column(name = "cus_address")
    private String address;

    @Column(name = "cus_contact")
    private String contact;

    public Customer() {

    }

    public Customer(int id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
