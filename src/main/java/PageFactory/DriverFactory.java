package PageFactory;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> INSTANCE= new InheritableThreadLocal<>();

    public static WebDriver getDriver(){
        if(INSTANCE.get()==null){
            ChromeDriverManager.getInstance().setup();
            INSTANCE.set(new ChromeDriver());
        }
        return INSTANCE.get();
    }
}
