package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.gecko.driver", "driver/win/geckodriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    void test() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id=\"name\"] input")).sendKeys("Иванов Иван");
        driver.findElement(By.cssSelector("[data-test-id=\"phone\"] input")).sendKeys("+79031234567");
        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector(".button__text")).click();
        String text=driver.findElement(By.cssSelector(".paragraph")).getText();
        assertEquals("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text);
    }

    @AfterEach
    void tearsDown(){
        driver.quit();
        driver=null;
    }
}
