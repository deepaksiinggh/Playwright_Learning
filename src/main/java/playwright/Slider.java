package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Slider {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		
		page.navigate("https://demo.automationtesting.in/Slider.html");
		page.locator("//div[@id='slider']/a").focus();
		
		for(int i=0;i<10;i++) {
			page.keyboard().press("ArrowRight");
		}
		

	}

}
