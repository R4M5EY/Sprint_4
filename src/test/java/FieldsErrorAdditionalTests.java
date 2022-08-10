import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FieldsErrorAdditionalTests {
    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // Проверка ошибки поля "Имя"
    @Test
    public void nameFieldError() {
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys("rmm");
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[text()='Введите корректное имя']")).getText()
                .contains("Введите корректное имя"));
    }

    // Проверка ошибки поля "Фамилия"
    @Test
    public void surnameFieldError() {
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys("cmvpr");
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).click();
        Assertions.assertTrue( driver.findElement(By.xpath("//*[text()='Введите корректную фамилию']")).getText()
                .contains("Введите корректную фамилию"));
    }

    // Проверка ошибки поля "Адрес"
    @Test
    public void addressFieldError() {
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"))
                .sendKeys("рмр");
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).click();
        Assertions.assertTrue( driver.findElement(By.xpath("//*[text()='Введите корректный адрес']")).getText()
                .contains("Введите корректный адрес"));
    }

    // Проверка ошибки поля "Станция метро"
    @Test
    public void metroStationFieldError1() {
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys("Александр");
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys("Огурцов");
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"))
                .sendKeys("г. Москва, ул. Попова д.47");

        driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"))
                .sendKeys("89001502000");
        driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")).click();
        Assertions.assertTrue( driver.findElement(By.xpath("//*[text()='Выберите станцию']")).getText()
                .contains("Выберите станцию"));
    }
    // Проверка ошибки поля "Станция метро"
    @Test
    public void metroStationFieldError2() {
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys("Александр");
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys("Огурцов");
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"))
                .sendKeys("г. Москва, ул. Попова д.47");
        driver.findElement(By.xpath("//input[@placeholder='* Станция метро']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//*[@class='select-search__select']//*[text() = 'Бульвар Рокоссовского']")).click();

        driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"))
                .sendKeys("ыаы");
        driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")).click();
        Assertions.assertTrue( driver.findElement(By.xpath("//*[text()='Введите корректный номер']")).getText()
                .contains("Введите корректный номер"));
    }


    @After
    public void teardown() {
        driver.quit();
    }

}
