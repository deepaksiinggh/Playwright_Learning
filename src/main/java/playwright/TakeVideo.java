package playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TakeVideo {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setRecordVideoSize(1000,800).setRecordVideoDir(Paths.get("./video/")));
		
		Page page =context.newPage();
		
		page.navigate("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		
		context.close();
		playwright.close();

	}

}
