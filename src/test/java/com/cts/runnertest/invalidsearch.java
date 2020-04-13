package com.cts.runnertest;

/**
 * @author GALI.HARSHA VARDHAN (853482),NARAHARI.DINESH(853480),KOTHURI.MANJUSHA(853483),CHEBROLU.PRASANNA(853447)
 *
 */

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features= {"Feature/InvalidSearch.feature"},
		//tags= {"@LoginPage"},
		glue= {"com/cts/stepdefinitions/"},
		plugin= {"html:reports/","pretty"})
@Test

public class invalidsearch extends AbstractTestNGCucumberTests{

}
