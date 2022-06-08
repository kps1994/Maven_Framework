package pages.login;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "txtUsername")
    WebElement userNameLoginInput;

    @FindBy(id = "txtPassword")
    WebElement userPasswordLoginInput;

    @FindBy(id = "btnLogin")
    WebElement loginSubmitBtn;

    @FindBy(xpath = "//SPAN[@id='spanMessage']")
    WebElement loginErrorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputUserName(String login) {
        userNameLoginInput.sendKeys(login);
    }

    public void inputPassword(String pswd) {
        userPasswordLoginInput.sendKeys(pswd);
    }

    public void submitLogin() {
        loginSubmitBtn.click();
    }

    public void verifyLoginErrorMessage(String error) {
        assertThat(loginErrorMessage.getText(), containsString(error));
    }

    public void landingToDashboardPage() {
        assertThat(driver.getCurrentUrl(), containsString("http://127.0.0.1/orangehrm-4.0/symfony/web/index.php/dashboard"));
    }

    public void loginToOHRM(String name, String pasword) {
        userNameLoginInput.sendKeys(name);
        userPasswordLoginInput.sendKeys(pasword);
        loginSubmitBtn.click();
    }
}

