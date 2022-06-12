package PageFactory;

import decorator.Button;
import decorator.CustomFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePO {

    private WebDriver driver;
    @FindBy(xpath = "//a[contains(text(), \"Log in\")]")
    private Button loginButton;

    @FindBy(xpath = "//a[contains(text(), \"Ask Question\")]")
    private Button askQuestion;

    @FindBy(xpath = "//div[contains(text(), \" Users\")]")
    private Button users;

    @FindBy(xpath = "/html/body/header/div/ol[2]/li[2]/a")
    private Button profileButton;

    public HomePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void getHomePage() {
        driver.get("https://stackoverflow.com/");
    }

    public void pressCommunity() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/header/div/div[1]/div[1]/div/a")).click();
    }

    public void pressLogin() {
        loginButton.pressMe(new WebDriverWait(driver, Duration.ofSeconds(2)));
    }

    public void pressAsk() {
        askQuestion.pressMe(new WebDriverWait(driver, Duration.ofSeconds(2)));
    }

    public void pressUser() {
        users.pressMe(new WebDriverWait(driver, Duration.ofSeconds(2)));
    }

    public void pressProfile() {
        profileButton.pressMe(new WebDriverWait(driver, Duration.ofSeconds(2)));
    }
}
