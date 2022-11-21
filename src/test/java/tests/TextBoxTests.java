package tests;


import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {


    @Test
    void fillFormTest() {
        String firstName = "First";
        String lastName = "Test";
        String email = "testEmail@yandex.ru";
        String gender = "Male";
        String mobileNumber = "1234567890";
        String subjects = "Math";
        String hobbies = "Reading";
        String currentAddress = "Apt 42";
        String state = "Uttar Pradesh";
        String city = "Lucknow";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(mobileNumber)
                .setBirhDate("08", "August", "1994")
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setCurrentAddress(currentAddress)
                .state(state)
                .city(city);

        RegistrationPage clickOnButton = new RegistrationPage();
        clickOnButton.submit();

        RegistrationPage downloadIms = new RegistrationPage();
        downloadIms.uploadImg();

        registrationPage.modalVerifyResults()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", mobileNumber)
                .verifyResult("Date of Birth", "08 August,1994")
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Address", "Apt 42")
                .verifyResult("State and City", state + " " + city);


    }


}
