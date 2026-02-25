package project;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class firstProject {
	Playwright playwright;
	Browser browser;
	Page page;

	
	@Test(priority = 0)
	public void tearup() {
		playwright = Playwright.create();
		browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page =browser.newPage();
		
	}
	
	
	@Test(priority = 1)
	public void signUp() {
		page.navigate("https://demoqa.com/automation-practice-form");
		page.getByPlaceholder("First Name").fill("lavi");
		page.getByPlaceholder("Last Name").fill("singh");
		page.locator("#userEmail").fill("Deepak@gmail.com");
		Locator gender=page.getByText("Male").nth(0);
		gender.click();
//		PlaywrightAssertions.assertThat(gender).isChecked();
		page.getByPlaceholder("Mobile Number").fill("9981410004");
		page.locator("#dateOfBirthInput").click();
		page.locator(".react-datepicker__month-select").selectOption("April");
		
		page.locator(".react-datepicker__year-select").selectOption("2001");
		page.locator(".react-datepicker__day.react-datepicker__day--011").first().click();
		page.locator("#subjectsInput").fill("Math");
		page.getByText("Maths").click();
		page.getByText("Sports").click();
		page.locator("#currentAddress").fill("indore, madhyapradesh");
		page.locator("#state").click();
		page.getByText("Uttar Pradesh").click();
		page.locator("#city").click();
		page.getByText("Agra").click();
		
	}
	
		
	
	@Test(priority = 10)
	public void teardown() {
		browser.close();
		playwright.close();
		
	}
	
	

}
