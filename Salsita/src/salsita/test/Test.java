package salsita.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import salsita.pages.MainPage;
import salsita.pages.CodePage;
import salsita.pages.ListsPage;

public class Test {
	
		
	static MainPage objMainPage;
    static CodePage objCodePage;
    static ListsPage objListsPage;

	static String FamousQuotesCategorie = "Famous Quotes";
	static String AwesomeQuotesCategorie = "Awesome Quotes";
	static By AllQuotes = By.xpath("//li/ul/li");
	static By ScoreLocator = By.xpath("//span[@class='score']");
	
	
	
		public static void main(String[] args) {
      
  // Test cases
			 
	   // @BeforeTest	- Setup
			
		System.setProperty("webdriver.gecko.driver","C:\\Work\\Automatizovane testovani - filles\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	      WebDriver driver= new FirefoxDriver();		
          driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
          driver.get("https://qa-engineer.herokuapp.com");	 
	      
	
	 
	// @Test(priority=1)       
        	//Verification of categories   
		
		 //Create main page
		
		objMainPage = new MainPage(driver);
		objMainPage.MainPageUse();
		
		 //Code page
		
		objCodePage = new CodePage(driver);
		objCodePage.CodePageUse();
		
		//Lists page
		objListsPage = new ListsPage(driver);
		
		
	//Verification of categories 

   if(driver.getPageSource().contains(FamousQuotesCategorie))
   {
   	System.out.println("Test FamousQuotesCategorie Passed!");
   }
   else
   {
   	 System.out.println("Test FamousQuotesCategorie Failed!");
     }
   
   
   if(driver.getPageSource().contains(AwesomeQuotesCategorie))
   {
   	  System.out.println("Test AwesomeQuotesCategorie Passed!");
   }
   else
   {
   	 System.out.println("Test AwesomeQuotesCategorie Failed!");
     }

   
   //Verification - correct number of quotes
   
   List<WebElement> optionCount = driver.findElements(AllQuotes);
   if (optionCount.size() == 10)
      		 {
 	  System.out.println("Test Correct number of quotes Passed!");
 }
 else
 {
 	 System.out.println("Test Correct number of quotes Failed!");
   }
  
   
   // Verification of all quotes
          
   String[] QuotesList = {
   		"A classic is something that everyone wants to have read and nobody wants to read.", 
           "If your life was a horse, you'd have to shoot it.",
           "You have taken yourself too seriously.",
           "You have taken yourself too seriously.",
           "You have the capacity to learn from mistakes.",
           "Yes there is a lot of people doing a great job out there.",
           "Do something unusual today.",
           "I love deadlines. I love the whooshing sound they make as they fly by.",
           "Nothing so needs reforming as other people's habits.",
           "Beware of low-flying butterflies.",
           "Excellent time to become a missing person."};
   	   
   	    for(int i=0; i< QuotesList.length; i++){
   	       if(driver.getPageSource().contains(QuotesList[i]));    	    	
   	       else
   	       {
   	    	   System.out.println("On a page is missing quote - Failed");
   	    	   System.out.println(QuotesList[i]);
   	       }    	      
   	    }
   	    System.out.println("Verification of all quotes - Passed");
   	    
   	     
   	 // Verification that the "Total score:" is the sum of all quote scores  
   	        	    
   	    List<WebElement> ScoreList = driver.findElements(ScoreLocator);
           int sum = 0;
           for(WebElement li1:ScoreList)
           {   
               String s = li1.getText().replace("(", "");
               sum = sum + Integer.parseInt(s.replace(")", ""));
           }

           System.out.println("Total sum is: " + sum);
           
           String SumText = Integer.toString(sum); 
                              
            
               if (driver.getPageSource().contains("Total score: "+SumText))
       		 {
	               System.out.println("Sum of all quote scores Passed!");
                  }
              else
                 {
	                System.out.println("Sum of all quote scores Failed!");
            }
	}}
   	   
	


