package functional;

import functional.apis.ScreenApi;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BannerTest {

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
                .showsBanner();

    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();

    }
}
