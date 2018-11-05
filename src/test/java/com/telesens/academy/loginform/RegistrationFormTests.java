package com.telesens.academy.loginform;

import com.academy.fx.model.RegistrationForm;
import com.academy.fx.validator.RegistrationValidator;
import org.testng.annotations.Test;

import java.util.Scanner;

public class RegistrationFormTests {

    @Test
    public void testFirstNameValidation() {
        RegistrationForm registrationForm = new RegistrationForm()
                .withFirstName("FirstName", "")
                .withLastName("", "test")
                .withMail("", "test@mail.ru")
                .withPassword("", "1qweEtyuiq")
                .withConfirmPassword("q", "1qweEtyuiq");

        RegistrationValidator validator = new RegistrationValidator();
        boolean isValid = validator.validate(registrationForm);
        String msgError = validator.getMsgError();
        System.out.println(msgError);
    }

    @Test
    public void testLastNameValidation() {//Empty Last Name
        RegistrationForm registrationForm = new RegistrationForm()
                .withFirstName("", "testName")
                .withLastName("LastName", "")
                .withMail("", "test@mail.ru")
                .withPassword("", "1qweEtyuiq")
                .withConfirmPassword("q", "1qweEtyuiq");

        RegistrationValidator validator = new RegistrationValidator();
        boolean isValid = validator.validate(registrationForm);
        String msgError = validator.getMsgError();
        System.out.println(msgError);
    }

    @Test
    public void testEmailValidation() {//Empty Email
        RegistrationForm registrationForm = new RegistrationForm()
                .withFirstName("", "testFirstName")
                .withLastName("", "testLastName")
                .withMail("e-mail", "test@mail.com")
                .withPassword("", "1qweEtyuiq")
                .withConfirmPassword("q", "1qweEtyuiq");

        RegistrationValidator validator = new RegistrationValidator();
        boolean isValid = validator.validate(registrationForm);
        String msgError = validator.getMsgError();
        System.out.println(msgError);
    }

    @Test
    public void testPasswordValidation() {//Empty Email
        RegistrationForm registrationForm = new RegistrationForm()
                .withFirstName("", "testFirstName")
                .withLastName("", "testLastName")
                .withMail("", "aksjdh@asdasd.com")
                .withPassword("PassworsID", "12asd1212AS")
                .withConfirmPassword("PassworsIDConfirm", "12asd1212AS");

        RegistrationValidator validator = new RegistrationValidator();
        boolean isValid = validator.validate(registrationForm);
        String msgError = validator.getMsgError();
        System.out.println(msgError);
    }


}
