package playwright;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Second {

    public static void main(String[] args) {

        Playwright pw = Playwright.create();

        Browser browser = pw.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://demowebshop.tricentis.com/");

      
        System.out.println(page.title());
        System.out.println(page.url());

        
        assertThat(page).hasTitle("Demo Web Shopgg");
        assertThat(page).hasURL("https://demowebshop.tricentis.com/");

        browser.close();
        pw.close();
    }
}