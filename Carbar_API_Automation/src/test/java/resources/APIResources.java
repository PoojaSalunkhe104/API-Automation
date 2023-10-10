package resources;


//enum is a special class in java which has collection of constant or methods
public enum APIResources 
{
	
   
   getCountryAPI("/countries"),
   getDriveTypeAPI("/drivetypes"),
   getFuelTypesAPI("/fuel-types"),
   getManufactureAPI("/manufacturers"),
   getSeatsAPI("/seats"),
   getStatesAPI("/states"),
	getTransmissionAPI("/transmissions"),
	getVehicleConditionsAPI("/vehicle-conditions"),
	getModelAPI("/models"),
	getBodyTypeAPI("/bodytypes"),
    postCreatePhoneNumberAPI("/create-phone-number"),
	postCreatePinAPI("/create-pin");
   
	private String resource;
	
	APIResources (String resource)
	{
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}
