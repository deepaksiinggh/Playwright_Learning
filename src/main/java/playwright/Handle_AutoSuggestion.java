package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Handle_AutoSuggestion {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://www.google.com/");
		page.locator("#APjFqb").fill("selenium");
		Locator suggesation = page.locator("xpath =//ul[@role='listbox']/li");
		suggesation.first().waitFor();
		System.out.println(suggesation.count());
		
		for(int i=0;i<suggesation.count();i++) {
			String text = suggesation.nth(i).innerText();
			if(text.contains("tutorial")) {
				
				suggesation.nth(i).click();
			
				break;
			}
	
		}
		
        browser.close();
        playwright.close();
	}

}
