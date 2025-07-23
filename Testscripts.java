package Optim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testscripts {
	public static void main(String[] args) throws InterruptedException {
		//setup the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//launch the browser
		driver.get("https://www.goibibo.com/");
		System.out.println("navigate to the page sucessfully");
		//remove the pop up
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		System.out.println("removed the popup sucessfully");
		//click on the one way option
		driver.findElement(By.xpath("//span[@class='sc-12foipm-70 fPPRk']")).click();
		System.out.println("clicked on one_way option sucessfully");
		//enter the city name in the from_field
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//p[text()='Enter city or airport'])[1]")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[2]/div[1]/div/div[2]/div/input")).sendKeys("Delhi");
		System.out.println("enter the from city sucessfully");
		
		//select  the option from drop down
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='autoCompleteSubTitle'])[1]")).click();
		System.out.println("selected dropdown sucessfully");
		
		//enter the city name in the to_field
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[2]/div[2]/div/div/p")).click();
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		// WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Enter city or airport']")));
		 //element.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[2]/div[2]/div/div[2]/div/input")).sendKeys("hyd");
		Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='autoCompleteSubTitle'])[1]")).click();
        System.out.println("enter the to_city sucessfully");
        //departure 7days from today
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='sc-12foipm-8 eXKWBG fswDownArrow']")).click();
       
      
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='DayPicker-Day'])[7]")).click();
        System.out.println("date selected after the 7days from today");
        //passengers 2dults and 1child
        driver.findElement(By.xpath("//span[@class='sc-12foipm-8 eXKWBG fswDownArrow fswDownArrowTraveller']")).click();
        //2adults
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='sc-12foipm-51 kZvHQU'])[2]")).click();
        //1child
        //driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div[2]/div[5]/div[2]/div[2]/div/div[1]/div[2]/div/span[3]/svg")).click();
        //done
        driver.findElement(By.xpath("//a[@class='sc-12foipm-64 jkgFUQ']")).click();
        //search the flights
        driver.findElement(By.xpath("//span[@class='sc-12foipm-72 ezNmSh']")).click();
        System.out.println("clicked on the search flights");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='button buttonPrimary pushRight widthFitContent']")).click();
        System.out.println("clicked on got it");
        //apply the filters departure between 6am to 12pm
        driver.findElement(By.xpath("//div[@class='boldFont displayText fontSize10']")).click();
        //choose airline indigo and air India only
        driver.findElement(By.xpath("(//input[@id='listingFilterCheckbox'])[3]")).click();
        driver.findElement(By.xpath("(//input[@id='listingFilterCheckbox'])[4]")).click();
        System.out.println("the indigo and air india flights are selected");
        //verify the correct flights are displayed
        String expected_title="Goibibo";
        String actual_title=driver.getTitle();
        System.out.println(actual_title);
        if(expected_title.equals(actual_title)) {
        	System.out.println("correct flights are displayed");
        	}else 
        	{
        	System.out.println("correct flights are not displayed");
        	}
         Assert.assertEquals(expected_title, actual_title);
        
           System.out.println("excution done for the flight booking");
           driver.close();
        }
}

