Feature: Post Register User
    @Tugas
    @Positive-Case
    Scenario: Post register with valid json
        Given Register new user with valid json "RegisterUser.json"
        When Send request post register user
        Then Status code should be 200 OK

    @Tugas
    @Negative-Case
    Scenario: User register with valid email and blank password
        Given User register with valid email and blank password "RegisterUserBlankPass.json"
        When Send request post register user
        Then Status code should be 400 Bad Request