Feature: Validating Filters

@Regression
Scenario Outline: Verify Status of Filters Type
Given Header
When Call URI with "<Resource>" with "get" http request
Then The API call got success with status code 200

Examples:
   |Resource           |
   |getManufactureAPI  |
   |getCountryAPI      |
   |getDriveTypeAPI    |
   |getFuelTypesAPI    |
   |getSeatsAPI        |
   |getStatesAPI       |
   |getTransmissionAPI |
   |getModelAPI        |

@BodyType
Scenario Outline: Verify status of Body Type filter
Given Header And queryParameter
When Call URI with "<Resource>" with "get" http request
Then The API call got success with status code 200  

Examples:
|Resource        |
|getBodyTypeAPI  |



   
   
   