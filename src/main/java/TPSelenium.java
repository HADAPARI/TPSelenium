import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;

public class TPSelenium {
    public static void main(String[] args) {
        String website = "https://www.kibo.mg/";
        String searchItem = "Confiture pomme";
        int quantity = 5;

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Ouvrir la page web
        driver.get(website);

        // Rechercher l'élement
        WebElement searchBox = driver.findElement(By.xpath("/html/body/main/header/div[3]/div[1]/div[1]/div[3]/div/div/form/input[2]"));
        searchBox.sendKeys(searchItem);
        searchBox.submit();

        List<WebElement> articles = driver.findElements(By.className("product-title"));

        //verifier si le produit contient le mot recherché avant de le cliquer
        for (WebElement article : articles) {
            if(article.findElement(By.tagName("a")).getText().contains(searchItem)){
                article.click();
                break;
            }
        }

        //ajuster la quantité
        WebElement quantityInput = driver.findElement(By.id("quantity_wanted"));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));

        //commander le produit
        WebElement btnCommand1 = driver.findElement(By.xpath("/html/body/main/section/div[1]/div/div/section/div[1]/div[2]/div[3]/div[1]/form/div[3]/div/div[2]/button"));
        btnCommand1.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement btnCommand2 = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div/div/a"));
        btnCommand2.click();

        // Capturer l'écran
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // Déplacer le fichier de capture d'écran vers le bureau
        screenshotFile.renameTo(new File("C:/Users/inclu/Desktop/capture.png"));

        driver.quit();

    }
}
