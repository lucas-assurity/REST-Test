package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentSteps {
    private Response response;
    @When("I check the details of student {int}")
    public void i_check_the_details_of_student(Integer studentId) {
        RestAssured.baseURI = "https://it-foundations.app.ap.assurity.cloud/";
        response = RestAssured.get("people/" + studentId);

    }
    @Then("I can see that their name is {string}")
    public void i_can_see_that_their_name_is(String name) {
        String firstName = response.path("firstName");
        String lastName = response.path("lastName");
        assertEquals(name, firstName + " " +lastName);

    }
    @Then("they have a {string} from {string}")
    public void they_have_a_from(String degree, String university) {
        assertEquals(degree ,response.path("degree"));
        assertEquals(university, response.path("university"));
    }
}
