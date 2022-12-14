package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.checkerframework.checker.signature.qual.BinaryNameWithoutPackage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
TestDate testDate = new TestDate();
    RegistrationPage clickOnButton = new RegistrationPage();

    RegistrationPage downloadIms = new RegistrationPage();




    @BeforeAll
    static void openURl() {
        Configuration.browserSize = "1366x710";
        Configuration.baseUrl = "https://demoqa.com";
     //   DesiredCapabilities capabilities = new DesiredCapabilities();
//capabilities.setCapability("enableVNC",true);
        //capabilities.setCapability("enableVNC",true);
//Configuration.browserCapabilities = capabilities;
//Configuration.remote = "https://user1:1234@selenoid.autotest.cloud/wd/hub";
    }

    @BeforeEach
    void addListener(){
        SelenideLogger.addListener("AllureSelenide",new AllureSelenide());
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
