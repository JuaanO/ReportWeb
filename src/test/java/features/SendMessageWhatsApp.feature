Feature: As a valid and logged user do campaigns, with all possible
  status. Sending of messages of different types (Normal shipping,
  Premium shipping, Flash shipping).

  @WS
  Scenario Outline: The user do a "Fast Send" with all status
    Given a user logged to Tellit choose a <Option> option
    When the user select a template

    Examples:
      | Option | Fast Send       | Status |
      | Whatsapp    | Normal shipping | valid  |
#      | SMS    | Premium shipping | Invalid |
#      | SMS    | Flash shipping   | Valid   |


  @WS1
  Scenario Outline: The user do a "Masive campaing" with all status
    Given a user logged to Tellit choose a <Option> option
    When chooses a massive whatsapp campaign option
    And Selects and chooses recipient <source> de ws
    And selectc template
    And goes to the second step
    And input a name for campaing
    And goes to the third step en WS

    Examples:
      | Option | Fast Send       | source |
      | Whatsapp    | Normal shipping | group  |
#      | Whatsapp    | Normal shipping | file  |
#      | SMS    | Premium shipping | Invalid |
#      | SMS    | Flash shipping   | Valid   |

