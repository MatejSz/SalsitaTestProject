package salsita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
	    
	    WebDriver driver;
    	static By EnterButtonLocator = By.id("enter");
           
	
        public MainPage(WebDriver driver){
           this.driver = driver;
	       } 	 
	 
        public void ClickEnterButton(){
	        WebElement Enter = driver.findElement(EnterButtonLocator);
	        Enter.click();
	        }
        
        // Method used for TC
        public void MainPageUse() {
        	
        	this.ClickEnterButton();
        	
        }
        
}
