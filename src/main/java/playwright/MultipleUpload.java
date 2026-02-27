package playwright;

import java.nio.file.Path;
import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class MultipleUpload {

	public static void main(String[] args) {
		Playwright playwright =Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page =browser.newPage();
        
        page.navigate("https://the-internet.herokuapp.com/upload");
        
        FileChooser chooser = page.waitForFileChooser(() -> {
            page.locator("#drag-drop-upload").click();
        });
        chooser.setFiles(new Path[] {
        		Paths.get(System.getProperty("user.dir")+"/file/parrot.avif"),
        		Paths.get(System.getProperty("user.dir")+"/file/love.avif")
        });
        
        browser.close();
        playwright.close();
	}
	

}
