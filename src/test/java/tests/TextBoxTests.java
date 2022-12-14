package tests;


import com.codeborne.selenide.selector.ByText;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TextBoxTests extends TestBase {


    @Test
    void fillFormTest() {

        SimpleDateFormat date = new SimpleDateFormat("dd MMM yyy", Locale.ENGLISH);
        String[] birthday = date.format(faker.date().birthday()).split(" ");

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = "Male",
                mobileNumber = faker.phoneNumber().subscriberNumber(11),
                userBirthDay = birthday[0],
                userBirthMonth = TestDate.monthRandom(),
                userBirthYear = birthday[2],
                subjects = "Math",
                hobbies = "Reading",
                currentAddress = faker.address().streetAddress(),
                state = "Uttar Pradesh",
                city = "Lucknow";



        step("open page", () -> {
            registrationPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setPhone(mobileNumber)
                    .setBirhDate(userBirthDay, userBirthMonth, userBirthYear)
                    .setSubjects(subjects)
                    .setHobbies(hobbies)
                    .setCurrentAddress(currentAddress)
                    .state(state)
                    .city(city);
        });
        step("click button", () -> {
            clickOnButton.submit();
        });
        step("downloadImg", () -> {
            downloadIms.uploadImg();
        });
        step("registrationPage", () -> {
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
        });


    }


}
