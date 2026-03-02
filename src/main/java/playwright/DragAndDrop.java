package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DragAndDrop {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		
		page.navigate("https://the-internet.herokuapp.com/drag_and_drop");
		
		Locator sourse =page.locator("#column-a");
		Locator destination =page.locator("#column-b");
		sourse.dragTo(destination);

	}

}
