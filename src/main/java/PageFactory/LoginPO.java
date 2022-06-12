package PageFactory;

import decorator.Button;
import decorator.CustomFieldDecorator;
import decorator.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPO {
    private WebDriver driver;
    @FindBy (xpath = "//input[contains(@id, \"email\")]")
    private Input emailInput;

    @FindBy (xpath = "//input[contains(@id, \"password\")]")
    private Input passwordInput;

    @FindBy (xpath = "//button[contains(text(), \"Log in\")]")
    private Button loginButton;

    @FindBy (xpath = "//a[contains(@aria-label, \"Inbox\")]")
    private Button inboxButton;
    public LoginPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }
    public void fillEmail (String value) {
        emailInput.sendData(value);
    }
    public void fillPassword (String value) {
        passwordInput.sendData(value);
    }
    public void clickLogin () {
        loginButton.pressMe(new WebDriverWait(driver, Duration.ofSeconds(2)));
    }
    public boolean verifyLogin () {
        return inboxButton.checkIfMeVisible(new WebDriverWait(driver, Duration.ofSeconds(2)));
    }

}
