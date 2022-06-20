package PageFactory;

import decorator.Button;
import decorator.CustomFieldDecorator;
import decorator.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangeProfilePO {
    private WebDriver driver;

    @FindBy(xpath = "//input[contains(@id, \"displayName\")]")
    private Input nameInput;
    @FindBy(xpath = "//input[contains(@id, \"location\")]")
    private Input locationInput;
    @FindBy(xpath = "//input[contains(@id, \"Title\")]")
    private Input titleInput;

    @FindBy(xpath = "//input[contains(@id, \"GitHubUrl\")]")
    private Input gitInput;

    @FindBy(xpath = "//input[contains(@id, \"RealName\")]")
    private Input realNameInput;

    @FindBy(xpath = "//textarea[contains(@id, \"wmd-input\")]")
    private Input aboutTextArea;
    @FindBy(xpath = "//a[contains(text(), \" Edit profile\")]")
    private Button editButton;
    @FindBy(xpath = "//button[contains(text(), \"Save profile\")]")
    private Button saveButton;



    public ChangeProfilePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }
    public void fillName (String value) {
        nameInput.sendData(value);
    }

    public void fillLocation (String value) {
        locationInput.sendData(value);
    }

    public void fillTitle (String value) {
        titleInput.sendData(value);
    }

    public void fillArea(String value) {
        aboutTextArea.sendData(value);
    }

    public void fillGit(String value) {
        gitInput.sendData(value);
    }
    public void fillRealName(String value) {
        realNameInput.sendData(value);
        realNameInput.takeInput();
    }

    public void clickEdit () {
        editButton.pressMe(new WebDriverWait(driver, Duration.ofSeconds(0)));
    }
//    public void clickSave () {
//        saveButton.pressMe(new WebDriverWait(driver, Duration.ofSeconds(2)));
//    }

}
