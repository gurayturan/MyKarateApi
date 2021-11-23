Feature: sasasasww

  Background:
    * url 'https://reqres.in/api'
    * header Accept = 'application/json'
    * def expectedOutput = read('jsons/response1.json')
    * print expectedOutput

 # Post with response matching from file
  @gry2
  Scenario: Post demo 4
    Given path '/users'
    And request { "name": "Raghav", "job": "leader"}
    When method post
    Then status 201
    And match response == expectedOutput
    And match $ == expectedOutput

      # Read body data from file
  Scenario: Post demo 5
    Given path '/users'
    And def requestBody = read('userdata.json')
    And request requestBody
    When method post
    Then status 201

    # Read body data from file and change request values
  Scenario: Post demo 7
    Given path '/users'
    And def requestBody = read('userdata.json')
    And request requestBody
    And set requestBody.job = 'engineer'
    When method post
    Then status 201