package com.healthapp.doctor;

import com.healthapp.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Doctor implements Serializable {

    private static final  long serialVersionUID = 1L ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Did",nullable = false,updatable = false)
    private long    id ;
    private String  firstName;
    private String  lastName;
    private Date    birthDate;
    private byte[]  photo;
    private String  email;
    private String  publicCode;
    private String  phone;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Doctor(String firstName, String lastName, Date birthDate, byte[] photo, String email, String code, String phone, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.photo = photo;
        this.email = email;
        this.publicCode = code;
        this.phone = phone;
        this.user = user;
    }

    public Doctor() {
    }

    public long getId() {
        return id;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public  boolean equals(Doctor doctor)
    {
        return (this.id == doctor.id);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPublicCode() {
        return publicCode;
    }

    public void setPublicCode(String publicCode) {
        this.publicCode = publicCode;
    }
}
