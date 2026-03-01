package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ChildTab {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		BrowserContext context=browser.newContext();
        Page page = context.newPage();
        
        
        page.navigate("https://demoqa.com/browser-windows");
        
        Page childPage=page.waitForPopup(()->{
        	page.locator("#tabButton").click();
        });
        
      System.out.println(childPage.locator("#sampleHeading").textContent());
        
        System.out.println(childPage.url());
        page.bringToFront();
        
       
        Page anotherchild = page.waitForPopup(()->{
        	 page.locator("#windowButton").click();
        });
        
       System.out.println(anotherchild.locator("#sampleHeading").innerText());
	}

}
