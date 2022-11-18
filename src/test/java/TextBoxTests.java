import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextBoxTests {


    @BeforeAll
    static void openURl() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1366x710";
        Configuration.baseUrl = "https://demoqa.com";
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    @Test
    void fillFormTest() {
        String firstTest = "First Test";
        String email = "testEmail@yandex.ru";
        String state = "Uttar Pradesh";
        String city = "Lucknow";
        String mobileNumber = "1234567890";
        //name
        $x(("//input[@id='firstName']")).setValue("First");
        $x(("//input[@id='lastName']")).setValue("Test");
        //email
        $x(("//input[@id='userEmail']")).setValue("testEmail@yandex.ru");
        //gender
        $x("//label[text()='Male']").click();
        //mobile
        $x("//input[@placeholder=\"Mobile Number\"]").setValue("1234567890");
        //dateOfBirth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--008:not(.react-datepicker__day--outside-month)").click();
        //subjects
        $x("//input[@id=\"subjectsInput\"]").click();
        $x("//input[@id=\"subjectsInput\"]").sendKeys("Maths");
        $x("//input[@id=\"subjectsInput\"]").sendKeys(Keys.ENTER);
        //Hobbies
        $("#hobbiesWrapper").$(new ByText("Reading")).click();
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

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstTest), text(email), text("Male"), text(mobileNumber), text("08 August,1994"), text("Maths"),text("Reading"), text("Apt 42"), text(state), text(city));
    }


}
