import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyJunit {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops=new FirefoxOptions();
        ops.addArguments("--headed");
        driver=new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void getTitle(){
        driver.get("https://demoqa.com");
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("ToolsQA"));
    }
    @Test
    public void checkifElementExists() throws InterruptedException {
        driver.get("https://demoqa.com");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Boolean status=wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//img[@src='/images/Toolsqa.jpg']"))).isDisplayed();
        Assert.assertEquals(status,true);

    }


    @After
    public void finishTest(){
        driver.close();
    }

}
