package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class orangeHrmWebsite {
WebDriver driver;
	
	//framework called data driven testing in TestNG
  @Test(dataProvider = "dp")
  public void f(String n, String s) throws InterruptedException {
	  driver.findElement(By.id("txtUsername")).sendKeys(n);
	  driver.findElement(By.id("txtPassword")).sendKeys(s);
	  driver.findElement(By.id("btnLogin")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("welcome")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
  }
  
  

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "linda.anderson", "linda.anderson" },
    };
  }
  
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","D:\\Jigsaw WorkSpace\\All Jar Files\\chromedriver.exe"); //to open an URL iwas using driver.get 
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();//To maximize the screen }

  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(20000);
	  driver.close();
	  
	  
  }


}
