package allure;

import PageFactory.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener{
    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        getScreenshot();
    }

    @Attachment(value="Page screen", type="image/png")
    public byte[] getScreenshot(){
        return ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value="{0}", type="text/plain")
    public String getDom(){
        return DriverFactory.getDriver().getPageSource();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        getScreenshot();
        getDom();
    }
}
