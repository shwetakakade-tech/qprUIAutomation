@Regression
Feature: Sample API Test


  Scenario: Get Universities list of India
  	* def query = {country:'India'}
    Given url baseurl
    And params query
    When method GET
    Then status 200
    * print response
    * print response[0].name
    * def jsonObject = response
    * print jsonObject[0].name
    And match jsonObject[0].name == 'University of Petroleum and Energy Studies'
    
  
  Scenario: Creata user and verify the user is created
  	* url 'https://gorest.co.in/public/v2/users/'
  	* def randomemail = 
	  	"""
	  		function(s){
	  		var email="";
	  		var pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	  		for(var i=0;i<s;i++)
	  			email = email + pattern.charAt(Math.floor(Math.random()* pattern.length()));
	  			return email;
	  			}
	  	"""
  	* def email = randomemail(15)
  	* def requestPayload =
  	"""
  		{ "name": "Test Auto User", "gender": "male", "status": "active" }
  	"""
  	* set requestPayload.email = email+"@gmail.com"
    #Given url baseurl1
    And request requestPayload
    And header Authorization = 'Bearer '+ tokenID
    When method post
    Then status 201
    * print response
    * def jsonObject = response
    * def id = jsonObject.id
 		Given url baseurl1
 		And path id
 		And header Authorization = 'Bearer '+ tokenID
 		When method GET
 		Then status 200
 		* def jsonResponse = response
 		And match jsonResponse.email == email+"@gmail.com"
 		
 	
 	Scenario: Delete User
 #		* url 'https://gorest.co.in/public/v1/users'
  	* def randomemail =
  	"""
  		function(s){
  		var email="";
  		var pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  		for(var i=0;i<s;i++)
  			email = email + pattern.charAt(Math.floor(Math.random()* pattern.length()));
  			return email;
  			}
  	"""
  	* def requestPayload =
  	"""
  		{ "name": "Test Auto User", "gender": "male", "status": "active" }
  	"""
  	* def email = randomemail(15)
  	* set requestPayload.email = email+"@gmail.com"
    Given url baseurl1
    And request requestPayload
    And header Authorization = 'Bearer '+ tokenID
    When method post
    Then status 201
    * def jsonObject = response
    * def id = jsonObject.id
 		Given url baseurl1
 		And path id
 		And header Authorization = 'Bearer '+ tokenID
 		When method GET
 		Then status 200
 		* def jsonResponse = response
 		And match jsonResponse.email == email+"@gmail.com"
 		Given url baseurl1
 		And path id
 		And header Authorization = 'Bearer '+ tokenID
 		When method delete
 		Then status 204
 		Given url baseurl1
 		And path id
 		And header Authorization = 'Bearer '+ tokenID
 		When method GET
 		Then status 404
 		And match response.message == "Resource not found"
 		
 		
 Scenario: Inactivate user
 #		* url 'https://gorest.co.in/public/v1/users'
  	* def randomemail =
  	"""
  		function(s){
  		var email="";
  		var pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  		for(var i=0;i<s;i++)
  			email = email + pattern.charAt(Math.floor(Math.random()* pattern.length()));
  			return email;
  			}
  	"""
  	* def requestPayload =
  	"""
  		{ "name": "Test Auto User", "gender": "male", "status": "active" }
  	"""
  	* def email = randomemail(15)
  	* set requestPayload.email = email+"@gmail.com"
    Given url baseurl1
    And request requestPayload
    And header Authorization = 'Bearer '+ tokenID
    When method post
    Then status 201
    * def jsonObject = response
    * def id = jsonObject.id
 		Given url baseurl1
 		And path id
 		And header Authorization = 'Bearer '+ tokenID
 		When method GET
 		Then status 200
 		And match response.status == "active"
 		* def requestbody = 
 		"""
 			{"status":"inactive"}
 		"""
 		Given url baseurl1
 		And path id
 		And request requestbody
 		And header Authorization = 'Bearer '+ tokenID
 		When method put
 		Then status 200
 		And match response.status == 'inactive'
 	
 		