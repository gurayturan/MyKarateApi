Feature: fetching User Details
  #https://jsonpathfinder.com/


  @gry
  Scenario: testing the get call for User Details
    Given url 'https://reqres.in/api/users/2'
    When method GET
    Then status 200
    Then print response

  # Simple Post scenario
  @gry
  Scenario: Post demo 1
    Given url 'https://reqres.in/api/users'
    And request { "name": "Raghav", "job": "leader"}
    When method post
    Then status 201


#https://drive.google.com/file/d/13vHw1ns9rp60RlkNkf7UuaKTnESDFX3b/view?usp=sharing
