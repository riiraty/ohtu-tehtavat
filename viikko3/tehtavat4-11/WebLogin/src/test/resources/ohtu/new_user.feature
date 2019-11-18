Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  a valid username "liisa" and password "salainen1" and matching password confirmation are entered
        Then  a new user is created

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When a too short username "op" and valid password "omapiha1234" are entered
        Then user is not created and short username error "username should have at least 3 characters" is reported

    Scenario: creation fails with correct username and too short password
        Given command new user is selected
        When a valid username "mikko" and a too short password "abc1234" are entered
        Then user is not created and short password error "password should have at least 8 characters" is reported  

    Scenario: creation fails when password and password confirmation do not match
        Given command new user is selected
        When  a valid username "maijakoo" and valid password "kukkaruukku1234" and nonmatching confirmation "kikkaruukku1234" are entered
        Then user is not created and confirmation error "password and password confirmation do not match" is reported 
