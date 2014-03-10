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
        webDriver.get("http://localhost:8080");
        String message = webDriver.findElement(By.id("banner")).getText();
        assertThat(message, is("Welcome to the Fabulous Football League Manager!"));
    }

    public void showsPlayersInfo() {
        webDriver.get("http://localhost:8080");
    String playerHeaders = webDriver.findElement(By.tagName("thead")).getText();
        assertThat(playerHeaders, is("Name Team Number Age"));
    }
}
