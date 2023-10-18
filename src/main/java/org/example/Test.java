package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class Test {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public String baseUrl = "https://www.ebay.com/";

    @BeforeTest
    @Parameters({"browser", "url"})
    public void beforeTest() {
        // Set the path of the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/LENOVO/Desktop/chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait time
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Navigate to the base URL
        driver.get(baseUrl);
    }

    @org.testng.annotations.Test(priority = 0)
    public void checkPageTitle() {
        // Navigate to eBay homepage
        driver.get("https://www.ebay.com/");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Electronics, Cars, Fashion, Collectibles & More | eBay");
    }

    @org.testng.annotations.Test(priority = 1)
    public void testPage() {
        // Verify that the correct page is opened
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);
    }
}