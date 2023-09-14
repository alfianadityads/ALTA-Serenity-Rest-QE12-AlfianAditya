Feature: Get Single User
    @Tugas
      @Positive-Case
    Scenario Outline: Get single user with valid parameter id
      Given Get single user with valid id <id>
      When Send request valid id get single user
      Then Should return status code 200 OK
      And Responses body id was <id>
      And Validate get single user JSON schema "SingleUserSchema.json"
      Examples:
        | id |
        | 1  |
        | 2  |

    @Tugas
      @Negative-Case
    Scenario Outline: Get single user with exceed id
      Given Get single user with exceed id <id>
      When Send request exceed id get single user
      Then Should return status code 404 Not Found for exceed id
      And Validate invalid get single user JSON schema "SingleUserInvalidSchema.json"
      Examples:
        | id  |
        | 301 |
        | 452 |

    @Tugas
      @Negative-Case
    Scenario Outline: Get single user with invalid parameter
      Given Get single user with first name "<firstName>"
      When Send request invalid parameter get single user
      Then Should return status code 404 Not Found for invalid parameter
      And Validate invalid get single user JSON schema "SingleUserInvalidSchema.json"
      Examples:
        | firstName |
        | Alfian    |