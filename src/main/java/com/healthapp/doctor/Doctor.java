package com.healthapp.doctor;

import com.healthapp.user.User;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Doctor implements Serializable {

    private static final  long serialVersionUID = 1L ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Did",nullable = false,updatable = false)
    private long    id ;
    @NotBlank(message="Please enter your name")
    private String  firstName;
    //@NotBlank(message="Please enter your last name")
    private String  lastName;
    //@NotBlank(message="Please enter your birthday")
    private Date    birthDate;
    private byte[]  photo;
    @NotBlank(message="Please enter your email")
    //@Email(message="Please enter a valid email")
    private String  email;
    //@NotBlank(message="Please enter your public Code")
    private String  publicCode;
    //@NotBlank(message="Please enter your phone number")
    //@Pattern(regexp="[\\d]{8}",message = "Check your phone Number")
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
