package web.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class mainpage {

    @Step("Click login button")
    public void clickLoginButton() {
        $("[data-tracker-name='/login']").click();
    }

    @Step("Input email = #email")
    public void inputEmail(String incorrectUname) {
        $("#uName").setValue(incorrectUname);
    }

    @Step("Input password = #password")
    public void inputPassword (String incorrectPass) {
        $("#uPass").setValue(incorrectPass);
    }

    @Step("Click 'Go' button to log in")
    public void clickGoButton() {
        $x("//button[contains (text(), 'GO')]").click();
    }


}
