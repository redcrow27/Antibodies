package _API.step_definition;

import _API.api_utils.APIutils;
import _UI.step_definition.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.is;

public class ApiTest {
    ScenarioContext context;

    public ApiTest(ScenarioContext scenarioContext){
        context = scenarioContext;
    }


}
