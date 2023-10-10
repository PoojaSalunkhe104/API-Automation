package StepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Utils;

public class Get_Filters extends Utils
{
	//Declare global variables here
	RequestSpecification requestSpecification;
	Response response;
	String Res;
	
	

	 @Given("^Header$")
	  public void header() throws Throwable 
	 {
		 requestSpecification=given().spec(RequestSpecification()).header("Authorization","Bearer ".concat(ReadPropertiesFile("AccessToken"))).header("Accept","application/json");
	  }
	 
	@When("^Call URI with \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void call_URI_with_with_http_request(String resource, String HttpMethod) throws Throwable 
	{
		APIResources resourceAPI =  APIResources.valueOf(resource);
		System.out.println("Resource API is: "+resourceAPI.getResource());
		
		if(HttpMethod.equalsIgnoreCase("POST"))
       	 response =requestSpecification.when().post(resourceAPI.getResource());
       else if(HttpMethod.equalsIgnoreCase("GET"))
       	 response =requestSpecification.when().get(resourceAPI.getResource());
		
	}

	
	@Then("^The API call got success with status code 200$")
    public void the_api_call_got_success_with_status_code_200() throws Throwable {
		 assertEquals(response.getStatusCode(),200);
		 
		 Res =  response.then().extract().response().asString();
    }
	
	

	
	@Given("^Header And queryParameter$")
    public void header_and_queryparameter() throws Throwable
	{
		requestSpecification=given().spec(RequestSpecification()).queryParam("filters%5Bmanufacturer%5D", "2").header("Authorization","Bearer ".concat(ReadPropertiesFile("AccessToken"))).header("Accept","application/json");
    }

	
	@Given("^Header and \"([^\"]*)\" And (.+)$")
    public void header_and_something_and(String phonenumber, int id) throws Throwable
	{
		requestSpecification=given().spec(RequestSpecification()).
												queryParam("number", phonenumber).
												queryParam("phone_number_type_id",id).
												header("Authorization","Bearer ".concat(ReadPropertiesFile("AccessToken"))).
												header("Accept","application/json");
    }
	
	@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void in_response_body_is(String key, String value) throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
          //   String resp = response.asString();
        //    JsonPath js = new JsonPath(resp);
        //assertEquals(js.get(key).toString(), value);
       assertEquals(getJsonPath(response, key),value);
	}
	
	@And("^Store \"([^\"]*)\" which present in responce body$")
    public void store_something_which_present_in_responce_body(String id) throws Throwable
	{
		JsonPath js =new  JsonPath(Res);
		String ID = js.getString(id);
		System.out.println("ID : "+ID);
		
	}
	
	 @Given("^Header , \"([^\"]*)\" And \"([^\"]*)\"$")
	    public void header_something_and_something(String pin, String pinconfirmation) throws Throwable
	    {
		 requestSpecification=given().spec(RequestSpecification()).
					queryParam("pin", pin).
					queryParam("pin_confirmation",pinconfirmation).
					header("Authorization","Bearer ".concat(ReadPropertiesFile("AccessToken"))).
					header("Accept","application/json");

	    }
	



}
