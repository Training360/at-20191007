import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LocationsMainScreen {

    private WebDriver driver;

    public LocationsMainScreen(WebDriver driver) {
        this.driver = driver;
    }

    public LocationsMainScreen kattintsALetrehozLinkre() {
        driver.findElement(By.id("create-location-link")).click();
        return this;
    }

    public LocationsMainScreen toltsdKiAzUrlapot() {
        return toltsdKiAzUrlapot("Budapest", "20,20");
    }

    public LocationsMainScreen toltsdKiAzUrlapot(String nev) {
        return toltsdKiAzUrlapot(nev, "20,20");
    }

    public LocationsMainScreen toltsdKiAzUrlapot(String nev, String koordinatakat) {
        driver.findElement(By.id("location-name")).click();
        driver.findElement(By.id("location-name")).sendKeys(nev);
        driver.findElement(By.id("location-coords")).click();
        driver.findElement(By.id("location-coords")).sendKeys(koordinatakat);
        return this;
    }

    public LocationsMainScreen kuldElAKerdoivet() {
        driver.findElement(By.cssSelector(".btn:nth-child(5)")).click();
        return this;
    }

    public LocationsMainScreen ellenorizdHogyAzUzenet(String uzenet) throws InterruptedException{
        {
            WebDriverWait wait = new WebDriverWait(driver, 3);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message-div")));
        }
        assertThat(driver.findElement(By.id("message-div")).getText(), is("Location has created"));
        return this;
    }


}
