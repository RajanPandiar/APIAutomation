package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.testng.Assert;

import java.net.URL;
import java.util.List;

public class listusersteps {
    Response response;

    @Given("a fake api endpoint")
    public void initialize_endpoint() {
        RestAssured.baseURI = "https://reqres.in/api/users";
        //code//
    }

    @When("i retrieve the list of users")
    public void retrieve_the_list_of_users() {
        response = SerenityRest.given()
                .contentType("application/json")
                .header("content-type","application/json")
                .queryParams("page", "2")
                .when().get();


    }

    @Then("the users names are listed")
    public void validate_users() {
       Assert.assertEquals(response.getStatusCode(),200);
       List<String> nameList = response.jsonPath().getList("data.first_name");
       System.out.println(nameList);



    }
}
