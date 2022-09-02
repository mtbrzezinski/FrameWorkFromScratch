package com.tests.openmrs.hook;


import com.tests.openmrs.utils.ConfigReader;
import com.tests.openmrs.utils.DriverHelper;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;



public class OpenMrs_Hook {
    WebDriver driver = DriverHelper.getDriver();

    @Before
    public void setup(){
        driver.navigate().to(ConfigReader.readProperty("QA_url"));
    }
    @After
    public void tearDown(Scenario scenario){
        Date currentDate = new Date();
        String screenShotFileName=currentDate.toString().replace(" ", "-").replace(":", "-");
        if(scenario.isFailed()){
            File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile, new File("src/main/java/com/tests/openmrs/screenshot"+screenShotFileName+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }


}
