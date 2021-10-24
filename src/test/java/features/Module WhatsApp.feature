Feature: As a valid and logged user do campaigns, with all possible
  status. Sending of messages of different types (Normal shipping,
  Premium shipping, Flash shipping).

  @WS
  Scenario Outline: The user do a WhatsApp "Fast Campaign" with ..
    Given a user logged to Tellit choose a <option>
    When the user select a <template>

    Examples:
      | option      | template      |
      | Whatsapp    | que plantilla |
#      | SMS    | Premium shipping | Invalid |
#      | SMS    | Flash shipping   | Valid   |


  @WS1
  Scenario Outline: The user do a WhatsApp "Masive campaing" with ..
    Given a user logged to Tellit choose a <Option>
    When chooses a massive whatsapp campaign option
    And selectc template
    And Selects and chooses recipient <source> de ws
    And goes to the second step
    And input a name for campaing
    And goes to the third step en WS

    Examples:
      | Option | Fast Send       | source |
      | Whatsapp    | Normal shipping | file  |
      | Whatsapp    | Normal shipping | group  |
#      | Whatsapp    | Normal shipping | file  |
#      | Whatsapp    | Normal shipping | file  |
#      | SMS    | Premium shipping | Invalid |
#      | SMS    | Flash shipping   | Valid   |

