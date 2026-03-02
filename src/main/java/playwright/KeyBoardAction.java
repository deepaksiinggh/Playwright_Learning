package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyBoardAction {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		
		page.navigate("https://demowebshop.tricentis.com/login");
		
		Locator email=page.locator("#Email");
		email.fill("Deepak@gmail.com");
		
		page.keyboard().press("Control+A");
		page.keyboard().press("Control+C");
		page.keyboard().press("Tab");
		page.keyboard().press("Control+V");

	}

}
