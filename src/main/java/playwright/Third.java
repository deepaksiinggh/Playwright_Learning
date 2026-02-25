package playwright;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class Third {
	
	

	Playwright playwright;
	Browser browser;
	Page page;
	
	@Test(priority = 0)
	public void basePage() {
		playwright = Playwright.create();
		 browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		 page = browser.newPage();
	}

	@Test
	public void register() {
		 
		  page.navigate("https://demowebshop.tricentis.com/");
		  page.getByText("Register").click();
		  page.locator(".forcheckbox").nth(0).click();
		  page.getByLabel("First name").fill("deepakde");
		  page.getByLabel("Last name").fill("mohitd");
		  page.getByLabel("Email").fill("mohitddedsx@gmail.com");
		  page.locator("#Password").fill("mohit@gmail1234");
		  page.locator("#ConfirmPassword").fill("mohit@gmail1234");
		  page.locator("#register-button").click();
		  Locator sucess = page.locator(".result");
		  PlaywrightAssertions.assertThat(sucess).containsText("Your registration completed");
		 
	}
	
	
	@Test(priority = 9)
	public void tearDown() {
		browser.close();
		playwright.close();
	}
	
	
	

}
