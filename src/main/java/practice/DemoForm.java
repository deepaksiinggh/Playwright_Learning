package practice;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DemoForm {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		Browser browser =browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		page.navigate("https://demoqa.com/text-box");
		page.locator("#userName").fill("deepak");
		page.locator("#userName").press("Tab");
		page.locator("#userEmail").fill("deepak@gmail.com");
		page.locator("#userEmail").press("Tab");
		page.locator("#currentAddress").fill("pume maharastra india");
		page.locator("#currentAddress").press("Control+A");
		page.locator("#currentAddress").press("Control+C");
		page.locator("#currentAddress").press("Tab");
		page.locator("#permanentAddress").press("Control+V");
		page.locator("#submit").click();
        browser.close();
        playwright.close();
	}

}
