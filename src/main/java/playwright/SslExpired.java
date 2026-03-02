package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SslExpired {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		NewContextOptions contextoptions = new Browser.NewContextOptions();
		contextoptions.setIgnoreHTTPSErrors(true);
		BrowserContext context = browser.newContext(contextoptions);
		Page page =context.newPage();
		page.navigate("https://expired.badssl.com/");
		browser.close();
		playwright.close();

	}

}
