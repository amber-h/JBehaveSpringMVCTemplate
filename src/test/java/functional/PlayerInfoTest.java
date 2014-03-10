package functional;

import functional.apis.ScreenApi;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Thoughtworker on 3/10/14.
 */
public class PlayerInfoTest {
    private ScreenApi screen;
    private static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        screen = new ScreenApi(driver);
    }


    @Test
    public void testBannerDisplays() {
        screen
                .showsPlayersInfo();

    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();

    }
}
