import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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
    void fillFormTest(){

        //name
        String firstName = "First";
        String lastName = "Test";

        $x(("//input[@id='firstName']")).setValue("First");
        $x(("//input[@id='lastName']")).setValue("Test");

        //email
        String email = "testEmail@yandex.ru";

        $x(("//input[@id='userEmail']")).setValue("testEmail@yandex.ru");

        //gender

        $(".custom-control-label").click();

        //mobile
        $x("//input[@placeholder=\"Mobile Number\"]").setValue("1234567890");

        //dateOfBirth
        $x("//input[@id=\"dateOfBirthInput\"]").click();
        $x("//div[text()=\"18\"]").click();

        //subjects
        $x("//input[@id=\"subjectsInput\"]").click();
        $x("//input[@id=\"subjectsInput\"]").sendKeys("Maths");
        $x("//input[@id=\"subjectsInput\"]").sendKeys(Keys.ENTER);

        //currenAddress

        $x("//textarea[@id=\"currentAddress\"]").click();
        $x("//textarea[@id=\"currentAddress\"]").setValue("Apt 42");

        //stateAndCity

        String state = "Uttar Pradesh";
        String city = "Lucknow";

        //state
       // $x("//input[@id=\"react-select-3-input\"]").click();
        //$x("//div[text()='Uttar Pradesh']").click();

        //city
    $("#state").click();
    $("#stateCity-wrapper").$(new ByText("Uttar Pradesh")).click();
    $("#city").click();
    $("#stateCity-wrapper").$(new ByText("Agra")).click();

//        $(".css-tlfecz-indicatorContainer").click();
//        $x("//div[text()='Lucknow']").click();

        //submit
        $x("//button[@id=\"submit\"]").click();


    $(".modal-title").shouldHave(text("Thanks for submitting the form"));
    $(".table-responsive").shouldHave(text("First Test"), text(email), text("18 November,2022"), text("Male"), text("Maths"), text("Apt 42"));
    }





}
