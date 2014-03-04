package functional.apis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScreenApi {

    private WebDriver webDriver;

    public ScreenApi(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void showsBanner() {
        String message = webDriver.findElement(By.id("banner")).getText();
        assertThat(message, is("Football League"));
    }
}
