package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {   // Login tests for saucedemo.com

    @Test
    void successfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        assert loginPage.waitForSuccessfulLogin();
    }
    @Test
    void loginWithWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");

        assert loginPage.isErrorDisplayed();
    }
    @Test
    void loginWithLockedUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        assert loginPage.isErrorDisplayed();
    }
    @Test
    void loginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");

        assert loginPage.isErrorDisplayed();
    }
    @Test
    void loginWithPerformanceGlitchUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("performance_glitch_user", "secret_sauce");

        assert loginPage.waitForSuccessfulLogin();
    }


}
