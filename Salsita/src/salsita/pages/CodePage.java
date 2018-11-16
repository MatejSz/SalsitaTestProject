package salsita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CodePage {
	
	WebDriver driver; 
	static By Value = By.xpath("//*[@type='hidden'and @name='secret']");
	static By FieldCodeLocator = By.name("code");
	static By CheckBoxLocator = By.name("robot");
	static By SubmitLocator = By.xpath("//*[@type='submit']");	
	
	
	
	public CodePage(WebDriver driver) {
		 this.driver = driver;
	}

	public void FindAndFillHiddenElement() {
						 
	    String HiddenValue = driver.findElement(Value).getAttribute("value");
	 
	    WebElement Code = driver.findElement(FieldCodeLocator);
	    Code.sendKeys(HiddenValue);
	 
	    }
	 
	public void CheckCheckbox() {
		
	      if ( driver.findElement(CheckBoxLocator).isSelected());
	      else {    
		       driver.findElement(CheckBoxLocator).click();
          }
	    }
 
	public void ButtonSubmit() {
	 
		WebElement ButtonSubmit = driver.findElement(SubmitLocator);
		ButtonSubmit.click();
	   }
	
	
	// Method used for TC
	
	public void CodePageUse() {
		
		this.FindAndFillHiddenElement();
		this.CheckCheckbox();
		this.ButtonSubmit();
		
	   }
	
	
	}
