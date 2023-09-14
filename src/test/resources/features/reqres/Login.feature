Feature: Login User
  @Tugas
  @Positive-Case
    Scenario: User login with valid email and password
      Given User login with valid email and password "LoginValid.json"
      When Send request post login user
      Then Should return status code 200 OK
      And Responses body token was "QpwL5tke4Pnpja7X4"
      And Validate success post login user JSON schema "LoginSuccessSchema.json"

  @Tugas
  @Negative-Case
    Scenario: User login with valid email and blank password
      Given User login with valid email and blank password "LoginBlankPass.json"
      When Send request post login user
      Then Should return status code 400 Bad Request
      And Responses body error was "Missing password"
      And Validate Unsuccess post register users JSON schema "RegisterUnsuccessUserSchema.json"
