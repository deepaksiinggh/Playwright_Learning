package project;
import java.util.List;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultiTab_Window {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context =browser.newContext();
        Page page=context.newPage();
        
        page.navigate("https://practice-automation.com/window-operations/");
        page.getByText("New Tab").click();
        page.getByText("Replace Window").click();
        page.goBack();
        page.getByText("New Window").click();
        
        List<Page> pages = context.pages();
        
        for(Page elem:pages) {
        	if(elem.url().contains("https://automatenow.io/")) {
        		elem.bringToFront();
        		String str=elem.locator("//div[@class='entry-content']/h2/strong").innerText();
        		System.out.println(str);
        	}
        }
        
       browser.close();
       playwright.close();
	}

}
