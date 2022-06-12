package decorator;

import org.openqa.selenium.WebElement;

public class TextArea extends Element{

    public TextArea(WebElement element) {
        super(element);
        this.element = element;
    }
    public void sendData (String value) {
        element.clear();
        element.sendKeys(value);
    }
}
