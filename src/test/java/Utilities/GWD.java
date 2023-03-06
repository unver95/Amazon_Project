package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.logging.Level;
import java.util.logging.Logger;


public class GWD {
    // ! Paralel static local anlatmadna önce mikroişlemci gelişimini anlatalık, thread e gelelimki
    // aşağıdaki değişkenler için, thread.Sşeep den bahsedilebilir, pipeline, local ama static değişken olmalı
    // pipeline-thread-tread.sleep selenium dedği explicit kullanın biz böyle yaptık.burada thread bazlı static değişken
    // yaplaıyızı o lokale özel

    // biz burada tüm sistemi static driver üzerine kurduk, bu durumda bize local static lazım thread özel

    //  hem static hemde her thread e özel değişken : static WebDriver1, static Webdriver2
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); // webDriver 1, webDriver 2
    private static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // Chrome, firefox ...

    public static void setThreadBrowserName(String browserName) {
        GWD.threadBrowserName.set(browserName);
    }
    public static String getThreadBrowserName() {
        return GWD.threadBrowserName.get();
    }
    // threadDriver.get() -> will return the driver in the current thread
    // threadDriver.set(driver) -> sets the driver to the current thread
    public static WebDriver getDriver() {
/*        // extend report was added because Other languages support was not working
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");*/

        Logger.getLogger("").setLevel(Level.SEVERE);

        if (threadBrowserName.get() == null) // when we run our other tests directly, since parameters will not come from XML,
            threadBrowserName.set("chrome"); // chrome is assigned as the default option.


        if (threadDriver.get() == null) // If the driver has been initialized once, there will be no need to perform the operations below again; the function will simply return the driver.
        {
            switch (threadBrowserName.get()) {
                case "chrome" -> {
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions opt = new ChromeOptions();
                    opt.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
                    threadDriver.set(new ChromeDriver(opt));
                }
                case "firefox" -> {
                    //System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());
                }
                case "safari" -> {
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());
                }
                case "edge" -> {
                    // System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());
                }
            }
        }
        return threadDriver.get();
    }

    public static void quitDriver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            WebDriver driver = threadDriver.get();
            driver = null;
            threadDriver.set(driver);
        }
    }

}
