package decorator;

import org.openqa.selenium.WebElement;

public class Element {
    protected WebElement element;

    public Element(WebElement element) {
        this.element = element;
    }
}
