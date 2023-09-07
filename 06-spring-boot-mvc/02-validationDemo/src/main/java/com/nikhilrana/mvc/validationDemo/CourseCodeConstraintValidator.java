package com.nikhilrana.mvc.validationDemo;

import com.nikhilrana.mvc.validationDemo.validation.CourseCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {

        if(code == null)
            return false;

        // here code value is the one that we entered in html form means user entered value.
        return code.startsWith(coursePrefix);
    }

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }
}
