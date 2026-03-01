package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NastedIframe {

	public static void main(String[] args) {
		Playwright playwright =Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        
        page.navigate("https://www.dezlearn.com/nested-iframes-example/");
        
        String str=page.locator("//div[@class='elementor-widget-container']/h2").innerText();
        System.out.println(str);
        
        FrameLocator frameLocator = page.frameLocator("iframe[name='demo_parent_iframe']");
        frameLocator.getByText("Click").nth(0).click();
        

        FrameLocator frameLocator1=frameLocator.frameLocator("iframe[name='demo_frame1']");
        String str2 =frameLocator1.locator("//p[@id='processing']").innerText();
        
        System.out.println(str2);
        
	}

}
