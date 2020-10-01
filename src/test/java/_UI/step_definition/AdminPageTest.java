package _UI.step_definition;

/**
 * In this class all step definitions for those steps in feature file are stored. Good practice to keep your steps
 * as short as possible. If you think your Test method will look bigger, try to create a method in implementation class
 * and call it in your step definition method.
 */
public class AdminPageTest {

    ScenarioContext context;

    public AdminPageTest(ScenarioContext scenarioContext){
        this.context = scenarioContext;
    }
}
