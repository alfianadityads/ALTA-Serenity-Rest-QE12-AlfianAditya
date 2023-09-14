Feature: Login User
  @Tugas
  @Positive-Case
    Scenario: User login with valid email and password
      Given User login with valid email and password "LoginValid.json"
      When Send request post login user
      Then Should return status code 200 OK

  @Tugas
  @Negative-Case
    Scenario: User login with valid email and blank password
      Given User login with valid email and blank password "LoginBlankPass.json"
      When Send request post login user
      Then Should return status code 400 Bad Request
