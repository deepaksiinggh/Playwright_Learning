package project;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class HandlingMultipleBrowser {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        
        page.navigate("https://demowebshop.tricentis.com/");
        Locator socialMedia = page.locator("//h3[text()='Follow us']/following-sibling::ul/li/a");
        for(int i=0;i<socialMedia.count();i++) {
        	
        	socialMedia.nth(i).click();
        	if(i==2)page.goBack();
        }
        
         List<Page> allPage = context.pages();
      
          for(Page elem:allPage) {

          elem.waitForLoadState();

          String url = elem.url();
          System.out.println(url);

         
          if (url.contains("facebook")) {

              elem.bringToFront();

              elem.locator("input[name='email']").last().fill("deepak@test.com");
          }
      }
	}

}
