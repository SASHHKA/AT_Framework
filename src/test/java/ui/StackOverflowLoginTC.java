package ui;

import PageFactory.BO;
import PageFactory.DriverFactory;
import allure.AllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners({AllureListener.class})
public class StackOverflowLoginTC {
    private WebDriver driver;
    private BO bo;

    @DataProvider
    public Object[][] testDP () {
        return new Object[][] {
                {
                    "test1", "password1"
                },
                {
                    "test2", "password2"
                },
                {
                    "heredchuk04@mail.ru", "%cYH73Fg_vsY7VR"
                }
        };
    }

    @BeforeTest
    void init() {
        driver = DriverFactory.getDriver();
    }

    @Test (dataProvider = "testDP")
    void test(String email, String password) {
        bo = new BO(driver);
        Assert.assertTrue(
                bo
                        .goHomePage()
                        .login(email, password)
                        .verifyLogin()
        );
    }

    @AfterTest
    void closeDriver() {
        driver.close();
        driver.quit();
    }
}
