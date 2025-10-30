package com.SparkHub.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Hooks {

    private WebDriver driver;
    private Path userDataDir;

    @Before
    public void setUp() throws Exception {
        System.out.println("Before each Scenario - starting browser");

        ChromeOptions options = new ChromeOptions();

        // 1) Disable password manager + autofill (prefs)
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);

        // (optional) also tone down Safe Browsing surfaces that can trigger warnings
        // NOTE: for tests only — don’t do this on dev/prod machines
        prefs.put("safebrowsing.enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // 2) Disable feature surfaces that show the dialog
        options.addArguments(
            "--disable-features=PasswordLeakDetection,PasswordCheck,AutofillServerCommunication,AutofillEnableAccountWalletStorage",
            "--disable-save-password-bubble",
            "--no-first-run",
            "--no-default-browser-check",
            "--safebrowsing-disable-auto-update",
            "--disable-client-side-phishing-detection",
            "--incognito" // incognito never offers to save passwords
        );

        // (Optional) hide “controlled by automated test software”
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        // 3) Fresh profile (prevents any saved creds)
        userDataDir = Files.createTempDirectory("chrome-profile-");
        options.addArguments("--user-data-dir=" + userDataDir.toAbsolutePath());

        // your usual args
        options.addArguments("--window-size=1382,768", "--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        // Log so we’re sure this Hooks is actually used
        System.out.println("Chrome started with profile: " + userDataDir);
    }

    public WebDriver getDriver() { return driver; }

//    @After
//    public void tearDown() {
//        System.out.println("After each Scenario - closing browser");
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
}
