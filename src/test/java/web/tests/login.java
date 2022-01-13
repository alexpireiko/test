package web.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import web.pages.base;

import static com.codeborne.selenide.Selenide.*;




@Owner("alexP")
@DisplayName("Suit for auth")
public class login extends base {

    String testURL = "https://dima.77staging.com",
           incorrectUname = "dev-77staging.com",
           correctUname = "dev@77staging.com",
           incorrectPass = "incorrectpass",
           correctPass = "foobar";

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
       // Configuration.startMaximized=true;
        //Configuration.browserSize =
    }

    @Test
    @Feature("auth")
    @Story("Check that user receive hint message with incorrect input Uname")
    @Tags({@Tag("web"), @Tag("regress")})
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Login with invalid syntax of Uname")
    public void incorrectUserLogin() {
        open(testURL);
        mainPage.clickLoginButton();
        mainPage.inputEmail(incorrectUname);
        mainPage.inputPassword(incorrectPass);
        mainPage.clickGoButton();
        $("#login_error").shouldHave(Condition.text("The UName field may only contain letters and numbers"));
    }

    @Test
    @Feature("auth")
    @Story("Check that user receive hint message with incorrect input Uname or password")
    @Tags({@Tag("web"), @Tag("regress")})
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Login with invalid password")
    public void incorrectUserPass() {
        open(testURL);
        mainPage.clickLoginButton();
        mainPage.inputEmail(correctUname);
        mainPage.inputPassword(incorrectPass);
        mainPage.clickGoButton();
        $("#login_error").shouldHave(Condition.text("Username or password is incorrect"));
    }

    @Test
    @Feature("auth")
    @Story("Check that user can login")
    @Tags({@Tag("web"), @Tag("regress")})
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Login with valid Uname and pass")
    public void correctUserLogin() {
        open(testURL);
        mainPage.clickLoginButton();
        mainPage.inputEmail(correctUname);
        mainPage.inputPassword(correctPass);
        mainPage.clickGoButton();

     //   $("#login_error").shouldHave(Condition.text("Username or password is incorrect"));
    }
}
