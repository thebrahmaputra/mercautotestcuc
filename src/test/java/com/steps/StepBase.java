package com.steps;

import cucumber.api.java.en.Given;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class StepBase {
    public static WebDriver driver;
    Iterator rows;
    XSSFSheet sheet;

    public StepBase(){
        XSSFWorkbook workbook = null;
        String fileName = "src/test/resources/TestObjectRepository.xlsx";
        try {
            //Getting the workbook instance for xlsx file
            workbook = new XSSFWorkbook(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = workbook.getSheetAt(0);

        System.out.println();
        rows = sheet.rowIterator();

        }

        public WebElement findElm(WebDriver driver, String element) {
            String identifier = "NA";
            String val = "NA";
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                if (sheet.getRow(i).getCell(1).toString().equalsIgnoreCase(element)) {
                    identifier = sheet.getRow(i).getCell(2).toString();
                    val = sheet.getRow(i).getCell(3).toString();
                }
                if (identifier.equalsIgnoreCase("xpath")) {
                    return driver.findElement(By.xpath(val));
                } else if (identifier.equalsIgnoreCase("linktext")) {
                    return driver.findElement(By.linkText(val));
                } else if (identifier.equalsIgnoreCase("id")) {
                    return driver.findElement(By.id(val));
                }
            }
            return null;
        }

    public void initDriver() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/selenium/newtours/index.php");
    }

    public void initDriver(String url) {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }
}
