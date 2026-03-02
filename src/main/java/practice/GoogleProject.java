package practice;
import java.util.regex.Pattern;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class GoogleProject {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		Browser browser =browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		page.navigate("https://demowebshop.tricentis.com/");
		page.locator("#small-searchterms").fill("computer");
		page.locator("#small-searchterms").press("Enter");
		PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("computer"));
		browser.close();
		playwright.close();

	}

}
