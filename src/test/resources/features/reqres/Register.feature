Feature: Post Register User
    @Tugas
    @Positive-Case
    Scenario Outline: Post register with valid json
        Given Register new user with valid json "RegisterUser.json"
        When Send request post register user
        Then Status code should be 200 OK
        And Responses body id was <id> and token was "<token>"
        And Validate post register users JSON schema "RegisterValidUserSchema.json"
        Examples:
            | id | token             |
            | 4  | QpwL5tke4Pnpja7X4 |

    @Tugas
    @Negative-Case
    Scenario: User register with valid email and blank password
        Given User register with valid email and blank password "RegisterUserBlankPass.json"
        When Send request post register user
        Then Status code should be 400 Bad Request
        And Responses body error was "Missing password"
        And Validate Unsuccess post register users JSON schema "RegisterUnsuccessUserSchema.json"