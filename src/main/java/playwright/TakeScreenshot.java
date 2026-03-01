package playwright;
import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TakeScreenshot {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		
		page.navigate("https://demowebshop.tricentis.com/");
		
		page.locator("#newsletter-subscribe-button").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("elemtscreenshot.png")));
		
		Utility.getScreenshot(page);
		page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("screentshofullpage.png")));

	}

}
