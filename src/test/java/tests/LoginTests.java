package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import io.qameta.allure.*;

@Epic("Authentication")
@Feature("Login")
public class LoginTests extends BaseTest {   // Login tests for saucedemo.com

    @Test
    @Story("Successful login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User logs in with valid credentials")
    void successfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        assert loginPage.waitForSuccessfulLogin();
    }
    @Test
    @Story("Login with wrong password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Login attempt with incorrect password shows error")
    void loginWithWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");

        assert loginPage.isErrorDisplayed();
    }
    @Test
    @Story("Login with locked user")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Locked user cannot log in and sees an error message")
    void loginWithLockedUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        assert loginPage.isErrorDisplayed();
    }
    @Test
    @Story("Login with empty fields")
    @Severity(SeverityLevel.NORMAL)
    @Description("Login attempt with empty username and password shows error")
    void loginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");

        assert loginPage.isErrorDisplayed();
    }
    @Test
    @Story("Login with performance glitch user")
    @Severity(SeverityLevel.MINOR)
    @Description("Performance glitch user can log in despite possible delays")
    void loginWithPerformanceGlitchUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("performance_glitch_user", "secret_sauce");

        assert loginPage.waitForSuccessfulLogin();
    }


}
