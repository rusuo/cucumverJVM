package android.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.testapp.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyAndroidAppStepDef extends ActivityInstrumentationTestCase2<MainActivity>{

        MainActivityTest mainActivityTest;
        
        public MyAndroidAppStepDef() {
                super(MainActivity.class);
                mainActivityTest = new MainActivityTest();
        }
        
         @Given("^I open my android app$")
         public void I_open_my_android_app() throws Exception {
        	 assertNotNull(getActivity());
//        	 mainActivityTest.setUp();
         }

         @When("^I am on the first page$")
         public void I_am_on_the_first_page() throws InterruptedException {
        	 Thread.sleep(4000);

        	 mainActivityTest.testPreconditions();
        	 
         }
        
        
         @Then("^I check that labels are correct$")
         public void I_check_that_labels_are_correct() throws InterruptedException {
        	 Thread.sleep(4000);
//             mainActivityTest.testTextView_labelText();
//             mainActivityTest.testButtonText_labelText();
         }
}