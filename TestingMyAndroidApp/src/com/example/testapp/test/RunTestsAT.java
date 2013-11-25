package com.example.testapp.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",  format = {"pretty", "html:/sdcard/cucumber/report"})

public class RunTestsAT {

}
