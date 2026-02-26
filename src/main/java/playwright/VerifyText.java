package playwright;
import java.util.regex.Pattern;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class VerifyText {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch();
		Page page =browser.newPage();
		
		page.navigate("https://demowebshop.tricentis.com/");
		
		String logouttxt =page.locator(".ico-login").textContent();
		System.out.println("textcontent text"+logouttxt);
		
		String innertext = page.locator(".ico-login").innerText();
		System.out.println("inner test - "+innertext);
		
		String textjs = (String)page.evaluate("document.getElementsByClassName('ico-login')[0].textContent");
		System.out.println(textjs);
		
		Assert.assertEquals(logouttxt, "Log in");
		PlaywrightAssertions.assertThat(page.locator(".ico-login")).containsText(Pattern.compile("Log"));
		PlaywrightAssertions.assertThat(page.locator(".ico-login")).containsText("Log in");
		System.out.println("hello deepak");
	}

}
