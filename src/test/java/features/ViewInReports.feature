Feature: Review the differents types of campaigns (failed, and successful)
  with the differents filters in the report module.

#  @ViewReport
#  Scenario: Review a detailed report of type message with Valid status
#    Given a user logged to Tellit choose a "Reports" option
#    When the user select a "SMS" report option
#    And the user fill the form with: "estrella", "Fast Send" & "SMS"
#    And press the button of search report
#    Then the user only can see records of type "SMS" with status "send" in the reports table
#
#  @ViewReport
#  Scenario: Review a detailed report of type message with Invalid status
#    Given a user logged to Tellit choose a "Reports" option
#    When the user select a "SMS" report option
#    And the user fill the form with: "estrella", "Fast Send" & "SMS"
#    And press the button of search report
#    Then the user only can see records of type "SMS" with status "failed" in the reports table
#
#  @ViewReport
#  Scenario: Review a detailed report of type message with Invalid status
#    Given a user logged to Tellit choose a "Reports" option
#    When the user select a "SMS" report option
#    And the user fill the form with: "estrella", "Fast Send" & "Flash"
#    And press the button of search report
#    Then the user only can see records of type "Flash" with status "failed" in the reports table


#  @ViewReport
#  Scenario: Review a detailed report of type message with Valid status
#    Given a user logged to Tellit choose a "Reports" option
#    When the user select a "SMS" report option
#    And the user fill the form with: estrella, Fast Send & SMS
#    And press the button of search report
#    Then the user only can see records of type "SMS" with status "send" in the reports table


  @ViewReport
  Scenario Outline: Review a detailed report of type message with Valid status
    Given a user logged to Tellit choose a <option> option
    When the user select a <optionmenu> report option
    And the user fill the form with: <user>, <reference> & <type>
    And press the button of search report
    Then the user only can see records of type <type2> with status <status> in the reports table

    Examples:
      | option  | optionmenu | user     | reference | type  | type2 | status |
#      | Reports | SMS        | juan.estrella | Fast Send | SMS   | SMS   | send   |
      | Reports | SMS        | juan.estrella | Fast Send | SMS   | Flash   | send   |
#