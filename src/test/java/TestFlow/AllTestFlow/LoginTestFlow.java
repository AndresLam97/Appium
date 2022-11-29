package TestFlow.AllTestFlow;

import Model.Components.Login.LoginFormComponent03;
import Model.Pages.LoginScreenModel03;
import TestFlow.BaseFlow.LoginBaseFlow;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.validator.routines.EmailValidator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestFlow extends LoginBaseFlow {

    private String email;
    private String password;

    public LoginTestFlow(AppiumDriver<MobileElement> appiumDriver, String email, String password) {
        super(appiumDriver);
        this.email = email;
        this.password = password;
    }

    public void performLogin()
    {
        goToLoginScreen();
        LoginScreenModel03 loginScreenModel = new LoginScreenModel03(appiumDriver);
        LoginFormComponent03 loginFormComp = loginScreenModel.loginFormComponent03();
        loginFormComp.inputUserName(this.email);
        loginFormComp.inputPassword(this.password);
        loginFormComp.clickOnLoginButton();
        verifyLogin(loginFormComp);
    }

    private void verifyLogin(LoginFormComponent03 loginFormComp)
    {
        boolean isEmailValid = validateEmail();
        boolean isPasswordValid = validatePassword();
        if(!isEmailValid)
        {
            verifyIncorrectEmail(loginFormComp);
        }else if (!isPasswordValid)
        {
            verifyIncorrectPassword(loginFormComp);
        }else
        {
            verifyCorrectEmailAndPassword(loginFormComp);
        }
    }

    private boolean validatePassword() {
        return password.length() >= 8;
    }

    private boolean validateEmail() {
        return EmailValidator.getInstance().isValid(this.email);
    }

    private void verifyIncorrectEmail(LoginFormComponent03 loginFormComp) {
        String actualErrorMessage = loginFormComp.getIncorrectEmailText();
        String expectedErrorMessage = "Please enter a valid email address";
        System.out.println("=================================");
        System.out.println("Verify incorrect email error message");
        System.out.println("Actual error message: " + actualErrorMessage);
        System.out.println("Expected error message: " + expectedErrorMessage);
    }

    private void verifyIncorrectPassword(LoginFormComponent03 loginFormComp) {
        String actualErrorMessage = loginFormComp.getIncorrectPasswordText();
        String expectedErrorMessage = "Please enter at least 8 characters";
        System.out.println("=================================");
        System.out.println("Verify incorrect password error message");
        System.out.println("Actual error message: " + actualErrorMessage);
        System.out.println("Expected error message: " + expectedErrorMessage);
    }

    private void verifyCorrectEmailAndPassword(LoginFormComponent03 loginFormComp) {
        WebDriverWait waitDriver = new WebDriverWait(appiumDriver,5L);
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated
                (loginFormComp.getLoginSuccessPopupDetailSelector()));
        String actualDetailMessage = loginFormComp.getLoginSuccessPopupDetailText();
        String expectedDetailMessage = "You are logged in!";
        System.out.println("=================================");
        System.out.println("Verify login success popup detail message");
        System.out.println("Actual detail message: " + actualDetailMessage);
        System.out.println("Expected detail message: " + expectedDetailMessage);
    }


}
