package PageFactory;

import decorator.Button;
import decorator.CustomFieldDecorator;
import decorator.Input;
import decorator.TextArea;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AskPO {
    private WebDriver driver;
    @FindBy(xpath = "//input[contains(@id, \"title\")]")
    private Input titleInput;

    @FindBy(xpath = " //input[contains(@id, \"tageditor-replacing-tagnames--input\")]")
    private Input tagsInput;

    @FindBy(xpath = "//button[contains(text(), \"Review your question\")]")
    private Button reviewButton;

    @FindBy(xpath = "//button[contains(text(), \"Post your question\")]")
    private Button postButton;

    @FindBy (xpath = "//textarea[contains(@id, \"wmd-input\")]")
    private TextArea areaInput;

    public AskPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void fillTitle(String value) {
        titleInput.sendData(value);
    }

    public void fillTags(String value) {
        tagsInput.sendData(value);
    }

    public void fillArea(String value) {
        areaInput.sendData(value);
    }

    public void clickReview () {
        reviewButton.pressMe(new WebDriverWait(driver, Duration.ofSeconds(0)));
    }

    public void clickPost () {
        postButton.pressMe(new WebDriverWait(driver, Duration.ofSeconds(2)));
    }

}
