package decorator;

import org.openqa.selenium.WebElement;

public class Input extends Element {

    public Input(WebElement element) {
        super(element);
        this.element = element;
    }

    public void sendData(String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void takeInput() {
        String value = element.getAttribute("value");
        //String newValue = "Not Steave Jobs";
        System.out.println(value);
        element.clear();
        element.sendKeys(value);
        //System.out.println(newValue);
    }
}
