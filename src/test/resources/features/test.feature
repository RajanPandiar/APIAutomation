Feature:Retrieve list of users

  Scenario: As a admin i should be able to retrieve a the list of users
    Given a fake api endpoint
    When i retrieve the list of users
    Then the users names are listed