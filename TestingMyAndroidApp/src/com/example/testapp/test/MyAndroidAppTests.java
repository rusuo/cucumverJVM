package com.example.testapp.test;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class MyAndroidAppTests extends UiAutomatorTestCase{
	
	private UiObject messageTextBox = new UiObject(new UiSelector().text("Enter a message"));
	private UiObject sendButton = new UiObject(new UiSelector().text("Send"));
	String myText = "My cucumber text";
	private UiObject textThatWasSubmitted = new UiObject(new UiSelector().text(myText));
	
	public void testInitAndroidApp() throws UiObjectNotFoundException{
		
		//go to Home on the device
		getUiDevice().pressHome();
		
		//go to all apps, by clicking the middle button on the device
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();

		//go to Apps tab
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		
		//find the app, using a scroll is necessary, click and wait for a new window
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsHorizontalList();
		UiObject testApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), "TestApp");
		testApp.clickAndWaitForNewWindow();

		// Validate that the package name is the expected one
	    UiObject myAppValidation = new UiObject(new UiSelector().packageName("com.example.testapp"));
	    assertTrue("Unable to detect TestApp aplication", myAppValidation.exists());   		
		
	}
	
	public void testPutText() throws UiObjectNotFoundException{
		if (messageTextBox.exists()){
			messageTextBox.clearTextField();
			messageTextBox.setText("My new text");
		}	
	}
	
	public void testSubmitText() throws UiObjectNotFoundException{
		sendButton.clickAndWaitForNewWindow();
		assertTrue("Text not correct", textThatWasSubmitted.getText().equals(myText));
		
		getUiDevice().pressBack();
	}
	
	public String getTextEntered() throws UiObjectNotFoundException{
		return textThatWasSubmitted.getText();
	}
	
}
