package functional;

import functional.apis.ScreenApi;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BannerTest {

    private ScreenApi screen;

    @Before
    public void setUp() throws Exception {
        screen = new ScreenApi(new FirefoxDriver());
    }

    @Ignore
    @Test
    public void testBannerDisplays() {
        screen
                .showsBanner();

    }
}
