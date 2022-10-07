package demo.selenium.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Calendar;

public class Driver {

    private static final Logger logger = LogManager.getLogger(Driver.class);
    public static WebDriver webDriver;
    public static String tbValue = "yunusbalaman";

    @BeforeAll
    public static void beforeAll(){

        logger.info("***** beforeAll *****");
    }

    @BeforeEach
    public void beforeEach(){

        logger.info("====== beforeEach ======");
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.merge(desiredCapabilities);
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.get("https://pazarlama.migrosnext.com/");
        setTestBoxCookies();
        webDriver.navigate().refresh();
    }

    @AfterEach
    public void afterEach(){

        if (webDriver != null){
            webDriver.quit();
        }
        logger.info("====== afterEach ======");
    }

    @AfterAll
    public static void afterAll(){

        logger.info("***** afterAll *****");
    }

    private void setTestBoxCookies() {

        if (!tbValue.equals("")) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR,2);
            Cookie tbCookie = new Cookie("tb", tbValue, ".migrosnext.com", "/", calendar.getTime());
            webDriver.manage().addCookie(tbCookie);
        }
    }

}
