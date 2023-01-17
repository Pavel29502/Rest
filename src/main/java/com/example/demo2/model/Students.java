package com.example.demo2.model;
import javax.persistence.*;
@Entity
@Table(name = "student_list")
public class Students {
    @Id
    Long id;
    String firstName;
    String lastName;
    String groupp;
    boolean payment;
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Students(Long id, String firstName, String lastName, String groupp, boolean payment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupp = groupp;
        this.payment = payment;
    }

    public Students() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public String getGroupp() {
        return groupp;
    }

    public void setGroupp(String groupp) {
        this.groupp = groupp;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }
}
