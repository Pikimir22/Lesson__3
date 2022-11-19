package pages.components;

import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selenide.$;

public class StateAndCity {
    public void state(String state){
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText(state)).click();
    }
    public void city(String city){
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText(city)).click();
    }

}
