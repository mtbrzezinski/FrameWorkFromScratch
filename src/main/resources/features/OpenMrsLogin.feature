@smoke @regression
Feature: Testing the login functionality

 Scenario: Validating the svalid login for OpenMrs
   Given User navigates to the OpenMrs website and provides credentials
   Then User validates tittle 'Home' and url 'https://demo.openmrs.org/openmrs/referenceapplication/home.page'

    #Task
  #Do negative tests for login functionality by using SCENARION OUTLINE

  Scenario Outline: Testing the invalid login for OpenMrs
    Given User navigates to the OpenMrs website and provides credentials '<username>' and '<password>'
    Then User validates the message '<message>'

    Examples:
      | username | password | message                                      |
      | admin    | admin123 | Invalid username/password. Please try again. |
      | Admin12  | Admin123 | Invalid username/password. Please try again. |
      |          | Admin123 | Invalid username/password. Please try aga. |
      | admin    |          | Invalid username/password. Please try again. |
      |          |          | Invalid username/password. Please try again. |