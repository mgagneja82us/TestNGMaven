package Utility;

import java.net.MalformedURLException;
import java.net.URI;
import org.openqa.selenium.remote.HttpCommandExecutor;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getdriver() {
        return driver.get();
    }
    
    

    public static void logExecutionDetails(String testCaseName, WebDriver driver) {
        RemoteWebDriver remoteDriver = (RemoteWebDriver) driver;
        String sessionId = remoteDriver.getSessionId().toString();
        String browser = remoteDriver.getCapabilities().getBrowserName();
        String nodeURL = "Unavailable";

        if (remoteDriver.getCommandExecutor() instanceof HttpCommandExecutor) {
            HttpCommandExecutor executor = (HttpCommandExecutor) remoteDriver.getCommandExecutor();
            nodeURL = executor.getAddressOfRemoteServer().toString();
        }

        System.out.println("Test Case: " + testCaseName);
        System.out.println("Executed on Browser: " + browser);
        System.out.println("Node URL: " + nodeURL);
        System.out.println("Session ID: " + sessionId);
    }

    public static void setdriver(String browser, String nodeTag) throws MalformedURLException, URISyntaxException {
        URI uri = new URI("http://localhost:4444/wd/hub");
        URL gridUrl = uri.toURL();

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("se:slotCapability", Map.of("node", nodeTag));
                driver.set(new RemoteWebDriver(gridUrl, chromeOptions));
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("se:slotCapability", Map.of("node", nodeTag));
                driver.set(new RemoteWebDriver(gridUrl, edgeOptions));
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("se:slotCapability", Map.of("node", nodeTag));
                driver.set(new RemoteWebDriver(gridUrl, firefoxOptions));
                break;

            default:
                throw new IllegalArgumentException("Invalid Browser: " + browser);
        }

        getdriver().manage().window().maximize();
    }
    
    public static void quitdriver() {
        if (getdriver() != null) {
            getdriver().quit();
            driver.remove();
        }
    }
}