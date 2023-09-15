Feature: Get Single Resources
  @Tugas
  @Positive-Case
    Scenario Outline: Get single resource with valid parameter id
    Given Get single resource with valid parameter id <id>
    When Send request valid id get single resource
    Then Get single resource should return status code 200 OK
    And Response body id was <id>
    And Validate get single resource JSON schema "SingleResourceSchema.json"
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @Tugas
    @Negative-Case
  Scenario Outline: Get single resource with exceed id
    Given Get single resource with exceed id <id>
    When Send request get single resource
    Then Should return status code 404 Not Found
    And Validate get single resource with exceed id JSON schema "SingleUserInvalidSchema.json"
    Examples:
      | id |
      | 23 |