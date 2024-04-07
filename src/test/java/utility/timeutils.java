package utility;

import java.util.concurrent.TimeUnit;

import basepackage.Baseclass;

public class timeutils {
	public static int pageloadtime=20;
	public static void pageloading() {
		Baseclass.driver.manage().timeouts().pageLoadTimeout(timeutils.pageloadtime, TimeUnit.SECONDS);
	}
}
