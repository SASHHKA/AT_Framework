package decorator;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Button extends Element {
    public Button(WebElement element) {
        super(element);
        this.element = element;

    }

    public void pressMe(WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            Assert.fail("Couldn't click button with text " + element.getText());
        }

        element.click();

    }
    public boolean checkIfMeVisible (WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
