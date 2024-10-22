package defaultPackage;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Intro {

	 
		// TODO Auto-generated method stub
	    WebDriver driver;
	    WebElement parentElement;
	    List<WebElement> liElements;
	    int count;
		
	    @BeforeTest
		public void prerequiste() {
		driver=new ChromeDriver();
		driver.get("http://127.0.0.1/");
		System.out.println(driver.getTitle());
		System.out.println("Launched the site successfully");
        System.out.println("---------------------------------");
		}

		//Find profile Name and role
	    @Test
	    public void Profile() {
		System.out.println(driver.findElement(By.xpath("//div[@class='left_Side']//h2[1]")).getText());
        System.out.println("---------------------------------");
	    }

		
		//Contact - Ph No, Email, Website, LinkedIn, Location
	    @Test
	    public void ContactDetails() {
        parentElement = driver.findElement(By.xpath("//div[@class='contactInfo']"));
        liElements = parentElement.findElements(By.tagName("li"));
        count = liElements.size();
        for(int i=1;i<=count;i++) {
        	System.out.println(driver.findElement(By.cssSelector("div[class='contactInfo'] li:nth-child("+i+") span:nth-child(2)")).getText());
        }
        System.out.println("---------------------------------");
	    }
        
        //Education details
	    @Test
	    public void EducationDetails() {
        parentElement = driver.findElement(By.xpath("//div[@class='contactInfo education']"));
        liElements = parentElement.findElements(By.tagName("li"));
        count = liElements.size();
        for(int i=1;i<=count;i++) {
        	String year= driver.findElement(By.cssSelector("li:nth-child("+i+") h5:nth-child(1)")).getText();
        	String boardName= driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(2) > li:nth-child("+i+") > h4:nth-child(2)")).getText();
        	String UniName= driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(2) > li:nth-child("+i+") > h4:nth-child(3)")).getText();
        	System.out.println("Year: "+year+" BoardName: "+boardName+" UniName: "+UniName);
        }
        System.out.println("---------------------------------");
	    }
        
        //Languages
	    @Test
	    public void Languages() {
        parentElement = driver.findElement(By.xpath("//div[@class='contactInfo language']"));
        liElements = parentElement.findElements(By.tagName("li"));
        count = liElements.size();
        for(int i=1;i<=count;i++) {
        	String languageName = driver.findElement(By.cssSelector("div[class='contactInfo language'] li:nth-child("+i+") span:nth-child(1)")).getText();
        	System.out.println("Language Names: "+languageName);
        }
        System.out.println("---------------------------------");
	    }
        
        //Profile
	    @Test
	    public void ProfileDetails() {
        String Desc= driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > p:nth-child(2)")).getText();
        System.out.println("Profile desc is "+Desc);
        System.out.println("---------------------------------");
	    }
        
        //Experience
	    @Test
	    public void Experience() {
        parentElement = driver.findElement(By.xpath("(//div[@class='about'])[2]"));
        liElements = parentElement.findElements(By.tagName("div"));
        count = liElements.size();
        for(int i=1;i<=(count/3);i++) {
        	String year= driver.findElement(By.xpath("//div[@class='about']//div["+i+"]//div[1]//h5[1]")).getText();
            String Company= driver.findElement(By.xpath("//div[@class='about']//div["+i+"]//div[1]//h5[2]")).getText();
            String role = driver.findElement(By.xpath("//div[@class='about']//div["+i+"]//div[2]//h4")).getText();
            String roleDesc = driver.findElement(By.xpath("//div[@class='about']//div["+i+"]//div[2]//p")).getText();
        	System.out.println("Year is "+year+"Company is "+Company+"Role is "+role+"Role Description "+roleDesc);
        }
	    }
        
        //Professional Skills
	    @Test
	    public void ProfessionalSkills() {
        parentElement = driver.findElement(By.xpath("//div[@class='about skills']"));
        liElements = parentElement.findElements(By.tagName("h4"));
        count = liElements.size();
        System.out.println("---------------------------------------");
        for(int i=2;i<=(count+1);i++) {
        	String PLName= driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child("+i+") > h4:nth-child(1)")).getText();
        	System.out.println("PLName "+PLName); 
        }
        System.out.println("---------------------------------------");
	    }
        
        //Certifications
	    @Test
	    public void Certifications() {
        parentElement = driver.findElement(By.xpath("//div[@class='About certificates']"));
        liElements = parentElement.findElements(By.tagName("li"));
        count = liElements.size();
        System.out.println("---------------------------------------");
        for(int i=1;i<=count;i++) {
        	String Cert= driver.findElement(By.cssSelector("div[class='About certificates'] li:nth-child("+i+")")).getText();
        	System.out.println("Certifications "+Cert);
        }
        System.out.println("---------------------------------------");
	    }

        //Interest
	    @Test
	    public void Interest() {
        parentElement = driver.findElement(By.xpath("//div[@class='About interest']"));
        liElements = parentElement.findElements(By.tagName("li"));
        count = liElements.size();
        System.out.println("Count is"+count);
        for(int i=1;i<=count;i++) {
        	String hobbies= driver.findElement(By.cssSelector("div[class='About interest'] li:nth-child("+i+")")).getText();
        	System.out.println("Hobbies are  "+hobbies);
        }
        System.out.println("----------------------------------------");
	    }
        
        //Word Occurences
	    @Test
	    public void WordOccurences() {
        String wordToCount = "SDET"; // Change this to the word you want to count
        int c = 0;
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), '" + wordToCount + "')]"));
        for (WebElement element : elements) {
            String text = element.getText().toLowerCase(); // Convert to lowercase for case-insensitive count
            String[] words = text.split(" "); // Split text into words
            for (String word : words) {
                if (word.equals(wordToCount.toLowerCase())) { // Check for the word
                    c++;
                }
            }
        }
        System.out.println("The word '" + wordToCount + "' occurs " + c + " times.");
	    }

	    @AfterTest
	    public void Closure() {
		driver.close();
	}

}
