package testbase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import testdata.TestData;

public class TestBase extends TestData {


    @Step("Подготовка")
    @BeforeAll
    static void setup() {
        new ChromeOptions().addArguments("start-maximized");
        Configuration.baseUrl = System.getProperty("base_url","https://demoqa.com");
        Configuration.browser = System.getProperty("browser","chrome");
        Configuration.remote = System.getProperty("remoteUrl","https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.browserSize = System.getProperty("browserSize","1320x800");
        Configuration.browserVersion = System.getProperty("browserVersion","100");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @Step("Добавить логгер")
    @BeforeEach
    void addLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Step("Добавить вложения")
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
