package playwright;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;

public class Utility {

	public static byte[] getScreenshot(Page page) {
		SimpleDateFormat frm =  new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		Date date = new Date();
		String path = "./screenshot/deepakrt"+frm.format(date)+".png";
		byte[] scr = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		return scr;
	}

}
