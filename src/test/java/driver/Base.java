package driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    public static WebDriver driver;

    @BeforeSuite
    public void setup(){

    }

    @BeforeScenario
    public void beforeScenario(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterScenario
    public void afterScenario(){
        driver.quit();
    }

}
