import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.By;
import java.time.LocalDateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Checks if QA Engineer Internship position is shown.
 */
public class PositionChecker {

    /**
     * Main method for execution
     */
    public static void main(String[] args) {
        checkQAEngineerPosition();
    }

    /**
     * Task for checking if QA Engineer (Intern) position is open
     * @return true/false
     */
    static boolean checkQAEngineerPosition() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.playtech.ee/";
        driver.get(baseUrl);
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.linkText("INTERNSHIP"));
        element.click();

        boolean testResult = driver.getPageSource().contains("Development QA Engineer (Intern)");
        writeResult(testResult);
        driver.quit();

        return testResult;
    }

    /**
     * Writes results in a text file
     * @param result true/false
     */
    private static void writeResult(boolean result) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[").append(getTimeStamp()).append("] ");
        stringBuilder.append("Development QA Engineer (Intern) position verification test. ");
        stringBuilder.append("Expected result: false. Test result: " ).append(result).append("\n");

        try {
            FileWriter file = new FileWriter("result.txt", true);
            file.write(stringBuilder.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns time in dd.MM.yyyy HH:mm:ss format
     * @return current timestamp
     */
    private static String getTimeStamp() {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        return currentTime.format(timeFormat);
    }
}