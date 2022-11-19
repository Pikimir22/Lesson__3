package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

   private CalendarComponent calendarComponent = new CalendarComponent();
    private final String TITLE_TEXT = "Student Registration Form";
   private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            dateOfBirthInput = $("#dateOfBirthInput"),

            hobbiesInput = $("#hobbiesWrapper");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhone(String mobile) {
        numberInput.setValue(mobile);
        return this;
    }

    public RegistrationPage setBirhDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        subjectsInput.click();
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        hobbiesInput.$(new ByText(hobbies)).click();
        return this;
    }



    public RegistrationPage modalVerifyResults() {
        registrationResultsModal.modalVerify();
        return this;
    }

    public RegistrationPage verifyResul(String key, String value){
       registrationResultsModal.verifyResul(key,value);

       return this;
    }

}
