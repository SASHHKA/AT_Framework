package ui;

import PageFactory.BO;
import PageFactory.ChangeProfilePO;
import PageFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class StackOverflowChangeUserTC {

    private WebDriver driver;
    private BO bo;

    @BeforeTest
    void init() {
        driver = DriverFactory.getDriver();
    }

    @Test()
    void test() {

        bo = new BO(driver);
        bo.goHomePage();
        bo.login("heredchuk04@mail.ru", "%cYH73Fg_vsY7VR");
        bo.pressProfile();
    }

    @AfterTest
    void closeDriver() {
        driver.close();
        driver.quit();
    }
}
