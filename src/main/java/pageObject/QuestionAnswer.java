package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class QuestionAnswer {
    private WebDriver driver;
    public QuestionAnswer(WebDriver driver) {
        this.driver = driver;
    }
    public String getQuestionText(String text) {
        return driver.findElement(By.xpath("//*[text()='" + text + "']")).getText();
    }
    public void waitForLoadHomePage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_SubHeader__zwi_E")));
    }
    public void waitForLoadQuestionText(String text) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + text + "']")));

    }
}
