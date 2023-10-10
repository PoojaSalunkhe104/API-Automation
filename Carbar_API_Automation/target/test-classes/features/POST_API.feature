Feature: Validating API


Scenario Outline:Create phone number
Given Header and "<PhoneNumber>" And <ID>
When Call URI with "<Resource>" with "post" http request
Then The API call got success with status code 200
And "success" in response body is "Phone Number added successfully"
And Store "id" which present in responce body

Examples:
   |Resource                |PhoneNumber  |ID       |
   |postCreatePhoneNumberAPI|0412345678   |2        |
   
@API  
Scenario Outline:Create PIN
Given Header , "<pin>" And "<pin_confirmation>"
When Call URI with "<Resource>" with "post" http request
Then The API call got success with status code 200
And "success" in response body is "Pin created successfully."

Examples: 
  |Resource        |pin   |pin_confirmation |
  |postCreatePinAPI|3305  |3305             |