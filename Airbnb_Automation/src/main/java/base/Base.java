package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis =new FileInputStream
		("D:\\Work\\Airbnb_Automation\\src\\main\\java\\utilities\\data.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		 if (browser.equals("chrome"))
		{
			//ChromeOptions option=new ChromeOptions();
			//option.addArguments("--remote-allow-origins=*");
			//driver=new ChromeDriver(option);
			driver=new ChromeDriver();
		}
		return driver;
		
	}
	public String getUrl() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis =new FileInputStream(
		"D:\\Work\\Airbnb_Automation\\src\\main\\java\\utilities\\data.properties");
		prop.load(fis);
		String url=prop.getProperty("url");
		return url;
		
	}
	public void takeScreenshot(WebDriver driver,String path)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        	String destinationFile = 
        			System.getProperty("user.dir")+"\\screenshots\\"+path+".png";
        	FileUtils.copyFile(scrFile,new File(destinationFile));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			
		}
	}


}
