Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation succesful with correct username and password
        Given new user is selected
        When a valid unused username "mikko" and valid password "mikkom1kko" are given
        Then the user is added and a welcome message is shown

    Scenario: creation fails with too short username and valid passord
        Given new user is selected
        When a too short username "mi" and valid password "mikkom1kko" are given
        Then user is not created and error "username should have at least 3 characters" is reported   

    Scenario: creation fails with correct username and too short password
        Given new user is selected
        When a valid unused username "billybob" and a too short password "shorty" are given
        Then user is not created and error "password should have at least 8 characters" is reported   

    Scenario: creation fails with correct username and password consisting of letters
        Given new user is selected
        When a valid unused username "billybob" and a long enough password without a special character or number "shawtydontplaythat" are given
        Then user is not created and error "password can not contain only letters" is reported 

    Scenario: creation fails with already taken username and valid pasword
        Given new user is selected
        When a used correct username "jukka" and valid password "no1getshere" are given
        Then user is not created and error "username is already taken" is reported 

    Scenario: creation fails when password and password confirmation do not match
        Given new user is selected
        When a valid username "billybob" and a valid password "$$$forme" and a different confirmation "itaintright" are given
        Then user is not created and error "password and password confirmation do not match" is reported  

    Scenario: user can login with succesfully generated account
        Given user with username "liisa" with password "salainen1" is succesfully created
        And   login is selected
        When  the correct username "liisa" with correct password "salainen1" are given
        Then  the user is logged in and the main page is shown

    Scenario: user can not login with account that is not succesfully created
        Given user with username "aa" and password "bad" is unsuccesfully created
        And   login is selected
        When  the same username "aa" with same password "bad" are given
        Then  user in not logged in and an error message is shown 