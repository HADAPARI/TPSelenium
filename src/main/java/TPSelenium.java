import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TPSelenium {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        // Rechercher "inclusiv academy"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("inclusiv academy");
        searchBox.submit();

        // Attendre un peu pour laisser le temps à la page de se charger
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Cliquer sur le premier résultat
        WebElement firstResult = driver.findElement(By.cssSelector("h3"));
        firstResult.click();

        //driver.quit();
    }
}
