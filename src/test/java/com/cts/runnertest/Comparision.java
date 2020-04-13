package com.cts.runnertest;
/**
 * @author GALI.HARSHA VARDHAN (853482),NARAHARI.DINESH(853480),KOTHURI.MANJUSHA(853483),CHEBROLU.PRASANNA(853447)
 *
 */
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		plugin = {"pretty","html:Reports1/opencart"},
		glue = {"com/cts/stepdefinitions"},
		features = {"Feature/Comparision.feature"}
		)
@Test
public class Comparision extends AbstractTestNGCucumberTests {

}
