Feature: ALTA QE BATCH 12
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Get list users status code should be 200 OK
    Examples:
      | page |
      | 1    |
      | 2    |

  @Latihan
  Scenario: Post create a new user with valid json
    Given Create new user with valid json "User.json"
    When Send request post create new user
    Then Status code should be 201 Created

  @Latihan
  Scenario Outline: Put update user with valid and id
    Given Put update user with valid id <id>
    When Send put update user
    Then Put update user status code should be 200 OK
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |