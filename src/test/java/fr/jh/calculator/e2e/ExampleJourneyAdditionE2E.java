package fr.jh.calculator.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExampleJourneyAdditionE2E {
    @LocalServerPort
    private Integer port;
    private WebDriver webDriver = null;
    private String baseUrl;

    @BeforeAll
    public static void setUpChromeDriver(){WebDriverManager.chromedriver().setup();}

    @BeforeEach
    public void setUpWebDriver(){
        webDriver = new ChromeDriver();
        baseUrl = "http:localhost:" + port + "/calculator";
    }

    @AfterEach
    public void quitWebDriver(){webDriver.quit();}

    @Test
    public void aUserUsesTheCalculatorToAddTwoAndTwenty(){
        // GIVEN
        webDriver.get(baseUrl);
        WebElement firstField = webDriver.findElement(By.id("first-number"));
        WebElement secondField = webDriver.findElement(By.id("second-number"));
        WebElement typeField = webDriver.findElement(By.id("type"));
        WebElement submitButton = webDriver.findElement(By.id("submit"));

        // WHEN
        firstField.sendKeys("2");
        secondField.sendKeys("20");
        typeField.sendKeys("+");
        submitButton.click();

        // THEN
        final WebDriverWait waiter = new WebDriverWait(webDriver, 5);
        WebElement solutionElement = waiter.until(
                ExpectedConditions.presenceOfElementLocated(By.id("solution")));

        String solution = solutionElement.getText();
        assertThat(solution).isEqualTo("22");
    }
}
