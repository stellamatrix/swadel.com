package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Utility.Utility;
import basecontainer.basecontainers;
import pages.loginpage;

public class logintest extends basecontainers {

	Utility utils = new Utility();
	
	
	@Test
	public void invalidlogin() throws IOException, InterruptedException {
		loginpage login = new loginpage();
		
		login.clickAvatarIcon();
		Thread.sleep(3000);
		login.clickemailfield();
		Thread.sleep(5000);
		login.typeinemailfield("email");
		Thread.sleep(10000);
		login.clickpasswordfield();
		Thread.sleep(10000);
		login.typeinpasswordfield("password");
		Thread.sleep(5000);
		login.clicksubmitbutton();
		
		
	}
}
