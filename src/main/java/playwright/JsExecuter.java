package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JsExecuter {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		page.navigate("https://login.yahoo.com/");
		
		Locator cheackbox=page.locator("#persistent");
		cheackbox.evaluate("element=>element.click()");
		 page.evaluate("window.scrollBy(0,2000)");
		 
		 String title = (String)page.evaluate("document.title");
		 System.out.println(title);
		 
		 browser.close();
		 playwright.close();
		

	}

}
