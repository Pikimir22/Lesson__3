package tests;


import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

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
                .setHobbies(hobbies);


        //image
        $("#uploadPicture").uploadFile(new File("src\\test\\resources\\forTest.jpg"));
        //currenAddress
        $x("//textarea[@id=\"currentAddress\"]").click();
        $x("//textarea[@id=\"currentAddress\"]").setValue("Apt 42");
        //state
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("Uttar Pradesh")).click();
        //city
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Lucknow")).click();
        //submit
        $x("//button[@id=\"submit\"]").click();

        registrationPage.modalVerifyResults()
                .verifyResul("Student Name", firstName + " " + lastName)
                .verifyResul("Student Email", email)
                .verifyResul("Gender", gender)
                .verifyResul("Mobile", mobileNumber)
                .verifyResul("Date of Birth", "08 August,1994")
                .verifyResul("Subjects", subjects)
                .verifyResul("Hobbies", hobbies)
                .verifyResul("Address", "Apt 42")
                .verifyResul("State and City", state + " " + city);

        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text("Male"),
                text(mobileNumber),
                text("08 August,1994"),
                text("Maths"),
                text("Reading"),
                text("Apt 42"),
                text(state),
                text(city));

    }


}
