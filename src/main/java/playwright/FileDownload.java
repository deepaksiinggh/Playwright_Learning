package playwright;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileDownload {

	public static void main(String[] args) throws IOException {
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		page.navigate("https://demo.automationtesting.in/FileDownload.html");
		
		Download download =page.waitForDownload(()->{
			page.locator("//a[text()='Download']").nth(0).click();
		});

		String filePath = System.getProperty("user.dir")+"/downloadFile/"+download.suggestedFilename();
		download.saveAs(Path.of(filePath));
		
		if(filePath.endsWith(".pdf")) System.out.println("right file");
		else {
			System.out.println("wrong file");
			browser.close();
			return;
		}
		
		if(Files.size(Path.of(filePath)) > 0) {
             System.out.println("right file size");
		}else {
			System.out.println("wrong file size");
			browser.close();
			return;
		}
		
		browser.close();
		playwright.close();
	}

}
