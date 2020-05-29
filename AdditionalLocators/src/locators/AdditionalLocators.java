package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

public class AdditionalLocators
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		
		//1. ByAll -> It accept multiple By class locators
		     //It will try to identify element with 1st Locator if not found then it will search with next locator and so on
		driver.findElement(new ByAll(By.name("user_name"), By.xpath("//input[@name='user_name']"))).sendKeys("admin");
		
		//2. ByIdOrName
		    //It will try to identify the element with Id or Name
		driver.findElement(new ByIdOrName("user_password")).sendKeys("manager");
		
		//3. ByChained
		    //It will accept multiple locators, where in it will work on parent child relation
		    //It will search the element from specified parent to specified child and so on
		driver.findElement(new ByChained(By.className("inputs"),By.className("input"), By.name("user_name"))).sendKeys("Ha ha ha");
		
	}
}
