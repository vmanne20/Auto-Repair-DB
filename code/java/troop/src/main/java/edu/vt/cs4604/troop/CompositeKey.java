package edu.vt.cs4604.troop;
import java.io.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Embeddable
public class CompositeKey implements Serializable {
   
    // @Id
    // private Long c_id;

    // @Id
    @NotNull
    @ManyToOne
    @JoinColumn(name="c_id")
    private Customer customer;
   
    // @Id
    @NotNull
    @Size(max = 20)
    private String c_number;
   

    public CompositeKey() {

    }

    public CompositeKey(String c_number, Customer customer) {
        this.customer = customer;
        this.c_number = c_number;
    }

    public Long getCustomerId() {
        return customer.getId();
    }

    public void setCustomerId(Long c_id) {
        customer.setId(c_id);
    }

    public String getCustomerNumber() {
        return c_number;
    }

    public void setCustomerNumber(String c_number) {
        this.c_number = c_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompositeKey that = (CompositeKey) o;

        if (!c_number.equals(that.c_number)) return false;
        return customer.getId().equals(that.customer.getId());
    }

    @Override
    public int hashCode() {
        int result = customer.getId().hashCode();
        result = 31 * result + c_number.hashCode();
        return result;
    }
}