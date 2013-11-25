package com.example.testapp.test;

import android.test.ActivityInstrumentationTestCase2;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.example.testapp.*;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

@CucumberOptions(features = "features")
public class MyAndroidAppStepDef extends ActivityInstrumentationTestCase2<MainActivity>{

	MyAndroidAppTests myAndroidAppTests;
	
	public MyAndroidAppStepDef(Class<MainActivity> activityClass) {
		super(activityClass);
		myAndroidAppTests = new MyAndroidAppTests();
	}
	
	 @Given("^I am on the first page$")
	 public void I_am_on_the_first_page() throws UiObjectNotFoundException {
		 myAndroidAppTests.testInitAndroidApp();
     }

	 @When("^I enter a text$")
	 public void I_enter_a_text() throws UiObjectNotFoundException {
		 myAndroidAppTests.testEnterText();
	 }
	 
	 @And("^I submit it$")
	 public void I_submit_it() throws UiObjectNotFoundException {
		myAndroidAppTests.testSubmitText(); 
	 }
	 
	 @Then("^I can see the new page with the text entered$")
	 public void I_can_see_the_new_page_with_the_text_entered() throws UiObjectNotFoundException {
		 assertTrue("Text is incorrect", myAndroidAppTests.getTextEntered().equals("My cucumber text"));
		 System.out.print(myAndroidAppTests.getTextEntered());
		 
	 }
}
