package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils 
{
	public static RequestSpecification requestSpecBuilder;

	
  public RequestSpecification RequestSpecification() throws IOException
  {
	//Declare one time baseuri & addquery parameter

  if(requestSpecBuilder==null)
  {
	  PrintStream log = new PrintStream(new File("LoggingDocument/logging.txt"));

	  requestSpecBuilder =new RequestSpecBuilder().setBaseUri(ReadPropertiesFile("BaseUrl")).
				  addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		 return requestSpecBuilder;
  }
  
  return requestSpecBuilder;
  }
  
  
  //read Properties file
  public static String ReadPropertiesFile(String Key) throws IOException
  {
	  Properties prop = new Properties();
	  FileInputStream fis = new FileInputStream("./Configuration/config.properties");
	  prop.load(fis);
	  return  prop.getProperty(Key);
	  
  }
  
  //for json path
  public String getJsonPath(Response response, String Key)
  {
	  String resp = response.asString();
	  JsonPath js = new JsonPath(resp);
	return js.get(Key).toString();
	  
  }
  


  }