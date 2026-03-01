package playwright;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SingleUpload {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		
		page.navigate("https://the-internet.herokuapp.com/upload");
		Locator fileUpload=page.locator("#file-upload");
		page.locator("#file-upload").setInputFiles(Paths.get(System.getProperty("user.dir")+"/file/parrot.avif"));
//		page.locator("#file-upload").setInputFiles(new Path[] {
//				Paths.get(System.getProperty("user.dir")+"/file/parrot.avif")
//		});
		
		fileUpload.setInputFiles(new Path[] {});
		
		browser.close();
		playwright.close();
		
	}
 
}
