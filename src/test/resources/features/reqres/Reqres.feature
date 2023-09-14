Feature: ALTA QE BATCH 12
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Get list users status code should be 200 OK
    And Response body page should be <page>
    And Validate get list users JSON schema "ListUsersSchema.json"
    Examples:
      | page |
      | 1    |
      | 2    |


  @Latihan
  Scenario: Post create a new user with valid json
    Given Create new user with valid json "User.json"
    When Send request post create new user
    Then Status code should be 201 Created
    And Response body name was "Alfian Saputra" and job was "QE Mentee"
    And Validate post create new user JSON Schema "CreateUserSchema.json"

  @Latihan
  Scenario Outline: Put update user with valid json and id
    Given Put update user with valid json "<jsonFile>" and user id <id>
    When Send put update user
    Then Put update user status code should be 200 OK
    And Response body name was "<name>" and job was "<job>"
    And Validate put update user JSON schema "UpdateUserSchema.json"
    Examples:
      | id | jsonFile         | name | job |
      | 1  | UpdateUser.json  |   Alfian Saputra   |    QE Engineer |
      | 2  | UpdateUser2.json |   Alfian 2   |  QE Engineer 2   |
      | 3  | UpdateUser3.json |   Alfian 3   |   QE Engineer 3  |

  @Latihan
  Scenario Outline: Delete a user with valid user id
    Given Delete a user with valid user id <id>
    When Send request delete user
    Then Status code delete user should 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |