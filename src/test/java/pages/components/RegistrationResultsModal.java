package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public void modalVerify(){
        $(".modal-dialog").should(appear);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));

    }
    public void verifyResul(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}