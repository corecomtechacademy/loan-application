package com.cta.training.testingapplication.application;

import org.aspectj.lang.annotation.DeclareError;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Application {

    private static final String POSTCODEREGEX = "([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})";

    //BUG - REGEX allows invalid email addresses through
    private static final String EMAILREGEX = "[a-zA-Z0-9._%+-]+\\@.+\\..+";


    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min=5, max=30, message="The name must be between 5 and 30 characters")
    private String firstName;

    @NotNull
    @Size(min=5, max=30, message="The name must be between 5 and 30 characters")
    private String lastName;

    @NotNull
    @Min(18)
    private Integer age;

   //This has been commented out, so that it appears mandatory in the application form however is a 'bug' as it will allow you to leave it blank when submitting the form even though it is marked with a *//
    private String addressLine1;

    @NotNull
    @Size(min=2, max=25, message="Value must be between 10 and 30 characters")
    private String addressLine2;


    private String addressLine3;


    private String addressLine4;

    @NotNull
    @Pattern(regexp = POSTCODEREGEX)
    private String postCode;

    @NotNull
    @Pattern(regexp = EMAILREGEX, message="Must be a valid email address")
    private String email;

    @NotNull
    @Min(1000)
    @Max(20000)
    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() { return age; }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() { return addressLine2; }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Integer getAmount() { return amount; }

    public void setAmount(Integer amount) { this.amount = amount; }
}