package playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class start {
	public static void main(String[] args) {

		Browser browser =Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		
		page.navigate("https://demowebshop.tricentis.com/");
		
		PlaywrightAssertions.assertThat(page).hasTitle("Demo Web Shopsss");
		browser.close();
		page.close();
	}
}