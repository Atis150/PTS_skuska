package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class Main {
    public static void main(String[] args) {
        //DRIVER SETUP
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\attil\\Desktop\\UKF\\Magisterske_studium\\2Z\\PTS\\chromedriver-119.0.6\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //OPEN FIRST PAGE BY DRIVER
        driver.get("https://ais2.ukf.sk/ais/start.do");

        try {
            Thread.sleep(1000);
//LOGIND DATA
            String login = "290202";
            String password = "***";

            //log in to ais
            driver.findElement(
                    By.xpath("/html/body/div[6]/button[1]")).click();

            driver.findElement(
                    By.xpath("//*[@id=\"login\"]")
            ).sendKeys(login);

            driver.findElement(
                    By.xpath("//*[@id=\"heslo\"]")
            ).sendKeys(password);

            driver.findElement(
                    By.id("login-form-submit-btn")
            ).click();

            Thread.sleep(2000);

            //start and stop video
            driver.findElement(
                    By.xpath("html/body")).click();
            Thread.sleep(7000);
            driver.findElement(
                    By.xpath("html/body")).click();

            Thread.sleep(2000);

            //logging out
            driver.findElement(
                    By.xpath("/html/body/app-root/lib-app-header/nav/div[3]/a/span")).click();
            driver.findElement(
                    By.xpath("/html/body/app-root/lib-app-header/nav/div[3]/div/a/span")).click();


            Thread.sleep(5000);


        }catch (InterruptedException e){
            //PRINT THE ERROR OUT
            e.printStackTrace();
        }

        //CLOSE THE BROWSER
        driver.quit();
    }
}