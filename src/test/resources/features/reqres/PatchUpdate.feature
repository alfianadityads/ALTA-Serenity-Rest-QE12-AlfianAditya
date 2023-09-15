Feature: PATCH Update User
  @Tugas
    @Positive-Case
  Scenario Outline: Patch update user with valid json and id should success then return 200 response code
    Given Patch update user with valid json "PatchUpdate.json" and id <id>
    When Send patch update user
    Then Status code should be 200 OK
    And Response body name was "<name>" and job was "<job>"
    And Validate patch update user JSON Schema "UpdateUserSchema.json"
    Examples:
      | id | name     | job           |
      | 2  | morpheus | zion resident |

  @Tugas
    @Negative-Case
  Scenario: Patch update user with blank name and job should failed then return 400 response code
    Given Patch update user with empty name and job with id 2
    When Send patch update user
    Then Status code should be 400 Bad Request