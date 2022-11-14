import com.codeborne.selenide.Configuration;
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
    void Name() {
        String firstName = "First";
        String lastName = "Test";

        $x(("//input[@id='firstName']")).setValue("First");
        $x(("//input[@id='lastName']")).setValue("Test");

        $x(("//input[@id='firstName']")).shouldHave(value(firstName));
        $(By.xpath("//input[@id='lastName']")).shouldHave(value(lastName));
    }

    @Test
    void Email() {
        String email = "testEmail@yandex.ru";

        $x(("//input[@id='userEmail']")).setValue("testEmail@yandex.ru");

        $x("//input[@id='userEmail']").shouldHave(value(email));

    }

    @Test
    void Gender() {
        $(".custom-control-label").click();
    }


    @Test
    void Mobile() {
        $x("//input[@placeholder=\"Mobile Number\"]").setValue("1234567890");
        $x(("//input[@placeholder=\"Mobile Number\"]")).shouldHave(value("1234567890"));
    }

    @Test
    void DateOfBirth() {

    }

    @Test
    void Subjects() {
        $x("//div[@class=\"subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3\"]").click();
        sleep(2000);
        $x("//div[contains(@class,\"subjects-auto-complete__value-container\")]").sendKeys("m");
        $x("//div[contains(@class,\"subjects-auto-complete__value-container\")]").sendKeys(Keys.ENTER);

        // $x("//div[@id = 'react-select-2-option-0']").click();
    }

    @Test
    void CurrentAddress(){
        $x("//textarea[@id=\"currentAddress\"]").click();
        $x("//textarea[@id=\"currentAddress\"]").setValue("Apt 42");

        $(By.xpath("//textarea[@id=\"currentAddress\"]")).shouldHave(text("Apt 42"));

    }


    @Test
    void StateAndCity() {
        String state = "Uttar Pradesh";
        String city = "Lucknow";

        //State
        $(".css-tlfecz-indicatorContainer").click();
        $x("//div[text()='Uttar Pradesh']").click();
        $(By.xpath("//div[text()='Uttar Pradesh']")).shouldHave(text(state));


//City
        $(".css-tlfecz-indicatorContainer").click();
        $x("//div[text()='Lucknow']").click();
        $(By.xpath("//div[text()='Lucknow']")).shouldHave(text(city));


    }

    @AfterAll
   static void Submit(){
        $x("//button[@id=\"submit\"]").click();
    }

}
