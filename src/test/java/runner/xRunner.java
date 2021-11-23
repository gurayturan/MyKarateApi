package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Viktor Sidochenko viktor.sidochenko@gmail.com
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},plugin  = { "pretty", "io.qameta.allure.junit4.AllureJunit4"},tags = {"@gry"})
public class xRunner {

}