import Page_Object.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;


public class OrderTest {

    private WebDriver driver;

    @Test
    public void orderInputChromeTest() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        Main main = new Main(driver);
        main.waitForLoadHomePage();

        driver.findElement(By.className("Button_Button__ra12g")).click();
        main.waitForLoadOrderPage();

        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys("Артем");
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys("Попов");
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys("Москва, ул. Борисовские Пруды 1, кв 1");
        driver.findElement(By.xpath("//input[@placeholder='* Станция метро']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//*[@class='select-search__select']//*[text() = 'Бульвар Рокоссовского']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys("88005553535");
        driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")).click();

        driver.findElement(By.xpath("//input[@placeholder='* Когда привезти самокат']")).click();
        driver.findElement(By.xpath("//*[@class='react-datepicker__day react-datepicker__day--004 react-datepicker__day--weekend react-datepicker__day--outside-month']")).click();
        driver.findElement(By.xpath("//*[@class='Dropdown-placeholder']")).click();
        driver.findElement(By.xpath("//*[text() = 'сутки']")).click();
        driver.findElement(By.xpath("//*[@class='Checkbox_Input__14A2w']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Комментарий для курьера']")).sendKeys("жду");
        driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")).click();
        driver.findElement(By.xpath("//*[text() = 'Да']")).click(); // не работает кнопка "Да" в Chrome
    }

    @Test
    public void orderInputFirefoxTest() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        Main main = new Main(driver);
        main.waitForLoadHomePage();

        driver.findElement(By.className("Button_Button__ra12g")).click();
        main.waitForLoadOrderPage();

        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys("Артем");
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys("Попов");
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys("Москва, ул. Борисовские Пруды 1, кв 1");
        driver.findElement(By.xpath("//input[@placeholder='* Станция метро']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//*[@class='select-search__select']//*[text() = 'Бульвар Рокоссовского']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys("88005553535");
        driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")).click();

        driver.findElement(By.xpath("//input[@placeholder='* Когда привезти самокат']")).click();
        driver.findElement(By.xpath("//*[@class='react-datepicker__day react-datepicker__day--004 react-datepicker__day--weekend react-datepicker__day--outside-month']")).click();
        driver.findElement(By.xpath("//*[@class='Dropdown-placeholder']")).click();
        driver.findElement(By.xpath("//*[text() = 'сутки']")).click();
        driver.findElement(By.xpath("//*[@class='Checkbox_Input__14A2w']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Комментарий для курьера']")).sendKeys("жду");
        driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")).click();
        driver.findElement(By.xpath("//*[text() = 'Да']")).click();
    }

    // Заказ через верхнюю кнопку "Заказать"
    @Test
    public void orderInputFirefoxTest1() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        Main main = new Main(driver);
        main.Order("Артем", "Попов", "г.Москва", "88005553535", "04.09.2022", "жду");
        Assertions.assertTrue(driver.findElements(By.xpath("//button[text()='Посмотреть статус']")).size()==1, "Кнопка 'Посмотреть статус' не отобразилась");
        }

    // Заказ через нижнюю кнопку "Заказать"
    @Test
    public void orderInputFirefoxTest2() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        Main main = new Main(driver);
        main.Order2("Андрей", "Николаев", "г.Тверь", "89001002525", "01.010.2022", "Чем быстрее, тем лучше");
        Assertions.assertTrue(driver.findElements(By.xpath("//button[text()='Посмотреть статус']")).size()==1, "Кнопка 'Посмотреть статус' не отобразилась");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
