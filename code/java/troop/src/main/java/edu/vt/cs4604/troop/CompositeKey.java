package edu.vt.cs4604.troop;
import java.io.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Embeddable
public class CompositeKey implements Serializable {
   
    @NotNull
    private Long c_id;
   
    @NotNull
    @Size(max = 20)
    private String c_number;

    public CompositeKey() {

    }

    public CompositeKey(long c_id, String c_number) {
        this.c_id = c_id;
        this.c_number = c_number;
    }

    public Long getCustomerId() {
        return c_id;
    }

    public void setCustomerId(Long c_id) {
        this.c_id = c_id;
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
        return c_id.equals(that.c_id);
    }

    @Override
    public int hashCode() {
        int result = c_id.hashCode();
        result = 31 * result + c_number.hashCode();
        return result;
    }
}