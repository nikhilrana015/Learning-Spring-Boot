package com.nikhilrana.mvc.validationDemo.validation;

import com.nikhilrana.mvc.validationDemo.CourseCodeConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
public @interface CourseCode {

    // defining value for course-code
    public String value() default "NICK";

    // defining value for message
    public String message() default "course code must starts with NICK";

    // defining default user-groups
    public Class<?>[] groups() default {};

    // defining the payloads
    public Class<? extends Payload>[] payload() default {};

}
