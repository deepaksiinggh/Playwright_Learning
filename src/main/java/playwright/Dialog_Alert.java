package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Dialog_Alert {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://testpages.eviltester.com/pages/basics/alerts-javascript/");
		//simple alert
//		page.onDialog(dialog->{
//			String sms = dialog.message();
//			System.out.println(sms);
//		});
//		page.locator("#alertexamples").click();
		
		//Confirmation alert
//		page.onDialog(dialog->{
////			dialog.accept();
//			dialog.dismiss();
//		});
//		page.locator("#confirmexample").click();

		
		// prompt alert 
		
		page.onDialog(dialog->{
			dialog.accept("deepak");
		});
		page.locator("#promptexample").click();
	}

}
