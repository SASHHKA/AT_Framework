package PageFactory;

import decorator.Button;
import decorator.CustomFieldDecorator;
import decorator.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserSearchPO {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/header/div/ol[2]/li[2]/a")
    private Input searchInput;
    @FindBy(xpath = "//a[contains(text(), \"Steave Jobs\")]")
    private Button jobsButton;


    public UserSearchPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }
    public void fillUser (String value) {
        searchInput.sendData(value);
    }

    public void clickJobs () {
        jobsButton.pressMe(new WebDriverWait(driver, Duration.ofSeconds(2)));
    }

}
