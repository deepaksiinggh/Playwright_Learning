package playwright;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CrossBrowserTesting {

	Playwright playwright;
	Browser browser;
	Page page;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void setUp(@Optional("chrome") String browserName) {
		
		playwright = Playwright.create();
		BrowserType browsertype = null;
		
		if(browserName.equals("chrome")) {
			browsertype=playwright.chromium();
		    System.out.println("run in chrome");
		    }
		else if(browserName.equals("firefox")) {
			browsertype=playwright.firefox();
		    System.out.println("run in firefox");
		    }
		else {
			browsertype=playwright.webkit();
			System.out.println("run in safari");
		}
        browser=browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
        page=browser.newPage();
		
	}
	
	@Test
	
	public void login() {
		page.navigate("https://demowebshop.tricentis.com/");
		page.locator("#small-searchterms").fill("deepak bhai");
	}
	
	
	@AfterTest
	public void tearDown() {
		browser.close();
		playwright.close();
	}
}
