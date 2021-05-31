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

