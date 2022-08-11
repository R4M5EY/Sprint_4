import pageObject.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoAdditionalTests {
    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order/");
    }
    // Тест на проверку логотипа "Самокат"
    @Test
    public void samokatLogoTest() {
        Main main = new Main(driver);
        main.setSamokatLogo();
        Assertions.assertTrue(driver.findElements(By.className("Home_Header__iJKdX")).size()==1, "Главная страница не открылась");
    }
    // Тест на проверку логотипа "Яндекс"
    @Test
    public void yandexLogoTest() {
        Main main = new Main(driver);
        main.setYandexLogo();
    }
    @After
    public void teardown() {
        driver.quit();
    }
}