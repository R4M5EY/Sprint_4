package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {
    private WebDriver driver;
    // локатор для лого "Яндекс"
    private By yandexLogo =  By.className("Header_LogoYandex__3TSOI");
    // локатор для лого "Самокат"
    private By samokatLogo = By.className("Header_LogoScooter__3lsAR");
    // локатор кнопки куки
    private By buttonCookie = By.id("rcc-confirm-button");
    // локатор для кнопки "Заказать" вверху страницы
    private By buttonOrderUp = By.xpath(".//button[@class='Button_Button__ra12g']");
    // локатор для кнопки "Заказать" внизу страницы
    private By buttonOrderDown = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // локатор для поля "Имя"
    private By name = By.xpath("//input[@placeholder='* Имя']");
    // локатор для поля "Фамилия"
    private By surname = By.xpath("//input[@placeholder='* Фамилия']");
    // локатор для поля "Адрес"
    private By address = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор для поля "Станция метро"
    private By metro = By.xpath("//input[@placeholder='* Станция метро']");
    // локатор для выбора станции
    private By metroStation = (By.xpath("//*[@class='select-search__select']//*[text() = 'Бульвар Рокоссовского']"));
    // локатор для поля "Телефон"
    private By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // локатор для кнопки "Далее"
    private By buttonThen = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // локатор для поля Когда привезти самокат
    private By date = (By.xpath("//input[@placeholder='* Когда привезти самокат']"));
    // локатор для поля "Про аренду"
    private By aboutRent = (By.xpath("//*[text() = 'Про аренду']"));
    // локатор для поля "Срок аренды"
    private By rentalPeriod = (By.xpath("//*[@class='Dropdown-control']"));
    private By day = (By.xpath("//*[text() = 'сутки']"));
    // локатор для поля "Цвет Самоката"
    private By scooterColor = (By.id("black"));
    // локатор для поля "Комментарий"
    private By comment = (By.xpath("//input[@placeholder='Комментарий для курьера']"));
    // локатор для кнопки "Заказать"
    private By buttonOrderRent = (By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
    // локатор для кнопки "Да"
    private By buttonYes = (By.xpath("//*[text() = 'Да']"));
    // локатор для кнопки "Статус заказа"
    private By buttonOrderStatus = (By.xpath("//button[@class='Header_Link__1TAG7']"));
    // локатор для поля "Введите номер заказа"
    private By orderNumber = (By.xpath("//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']"));
    // локатор для кнопки "GO"
    private By buttonGO = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");

    public Main(WebDriver driver) {
        this.driver = driver;
    }

    public void setYandexLogo() { driver.findElement(yandexLogo).click(); }
    public void setSamokatLogo() { driver.findElement(samokatLogo).click(); }
    public void setButtonCookie(){
        driver.findElement(buttonCookie).click();
    }
    public void setButtonOrderUp(){
        driver.findElement(buttonOrderUp).click();
    }
    public void setButtonOrderDown(){
        driver.findElement(buttonOrderDown).click();
    }
    public void setName(String nameEnter){
        driver.findElement(name).sendKeys(nameEnter);
    }
    public void setSurname(String surnameEnter){
        driver.findElement(surname).sendKeys(surnameEnter);
    }
    public void setAddress(String addressEnter){
        driver.findElement(address).sendKeys(addressEnter);
    }
    public void setMetro(){
        driver.findElement(metro).sendKeys(Keys.ARROW_DOWN);
    }
    public void setMetro2(){
        driver.findElement(metroStation).click();
    }
    public void setPhone(String phoneEnter){
        driver.findElement(phone).sendKeys(phoneEnter);
    }
    public void setButtonThen(){
        driver.findElement(buttonThen).click();
    }
    public void setDate(String dateEnter){
        driver.findElement(date).sendKeys(dateEnter);
    }
    public void setAboutRent(){
        driver.findElement(aboutRent).click();
    }
    public void setRentalPeriod(){
        driver.findElement(rentalPeriod).click();
    }
    public void setDay(){
        driver.findElement(day).click();
    }
    public void setScooterColor(){
        driver.findElement(scooterColor).click();
    }
    public void setComment(String commentEnter){
        driver.findElement(comment).sendKeys(commentEnter);
    }
    public void setButtonOrderRent(){
        driver.findElement(buttonOrderRent).click();
    }
    public void setButtonYes(){
        driver.findElement(buttonYes).click();
    }
    // методы для поля "Номер заказа"
    public void setButtonOrderStatus() {
        driver.findElement(buttonOrderStatus).click();
    }
    public void setOrderNumber(int orderNumberEnter) {
        driver.findElement(orderNumber).sendKeys();
    }
    public void setButtonGO() {
        driver.findElement(buttonGO).click();
    }

    // метод заполнения полей заказа через верхнюю кнопку "заказать"
    public void Order(String nameEnter, String surnameEnter, String addressEnter, String phoneEnter, String dateEnter, String commentEnter){
        setButtonCookie(); // клик по кнопке куки
        setButtonOrderUp(); // клик по верхней кнопке заказать
        setName(nameEnter); // ввод имени
        setSurname(surnameEnter); // ввод фамилии
        setAddress(addressEnter); // ввод адреса
        setMetro(); // выбор станции метро
        setMetro2(); // клик по станции
        setPhone(phoneEnter); // ввод номера
        setButtonThen(); // клик по кнопке далее
        setDate(dateEnter); // ввод даты
        setAboutRent(); // клик по про аренду
        setRentalPeriod(); // клик по сроку аренды
        setDay(); // выбор срока
        setScooterColor(); // клик по цвету
        setComment(commentEnter); // ввод комментария
        setButtonOrderRent(); // клик по кнопке заказать
        setButtonYes(); // клик по кнопке да
    }
    // конструктор заполнения полей заказа через нижнюю кнопку "заказать"
    public void Order2(String nameEnter, String surnameEnter, String addressEnter, String phoneEnter, String dateEnter, String commentEnter){
        setButtonCookie(); // клик по кнопке куки
        setButtonOrderDown(); // клик по нижней кнопке заказать
        setName(nameEnter); // ввод имени
        setSurname(surnameEnter); // ввод фамилии
        setAddress(addressEnter); // ввод адреса
        setMetro(); // выбор станции метро
        setMetro2(); // клик по станции
        setPhone(phoneEnter); // ввод номера
        setButtonThen(); // клик по кнопке далее
        setDate(dateEnter); // ввод даты
        setAboutRent(); // клик по про аренду
        setRentalPeriod(); // клик по сроку аренды
        setDay(); // выбор срока
        setScooterColor(); // клик по цвету
        setComment(commentEnter); // ввод комментария
        setButtonOrderRent(); // клик по кнопке заказать
        setButtonYes(); // клик по кнопке да
    }
}