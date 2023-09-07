package com.nikhilrana.mvc.validationDemo;

import com.nikhilrana.mvc.validationDemo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "field required")
    @Size(min=1, max=100, message = "first name length should be between 1 and 100")
    private String firstName="";

    @NotNull(message = "field required")
    @Size(min=1, max=100, message = "last name length should be between 1 and 100")
    private String lastName="";

    @NotNull(message = "freePasses must be required")
    @Min(value = 0, message = "value must be greater than and equal to 0")
    @Max(value = 10, message = "value must be smaller than and equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "postal-code must be of length 5 characters")
    private String postalCode;

    @CourseCode(value = "AFS", message = "must start with AFS")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
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
}
