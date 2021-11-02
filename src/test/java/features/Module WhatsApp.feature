@WhatsApp
Feature: As a valid and logged user do campaigns, with all possible
  status. Sending of messages of different types (Normal shipping,
  Premium shipping, Flash shipping).

  @fastCampaign1
  Scenario Outline: The user do a WhatsApp "Fast Campaign" with ..
    Given a user logged to Tellit choose a <option>
    When the user do a whatsapp fast campaign with a <template>

    Examples:
      | option   | template                  |
      | whatsapp | Template SeleniumWhatsApp |
#      | SMS    | Premium shipping | Invalid |
#      | SMS    | Flash shipping   | Valid   |

  @massiveCampaign1
  Scenario Outline: The user do a WhatsApp "Masive campaing" with ..
    Given a user logged to Tellit choose a <Option>
    And the user choose a <template> and select a <source>
    And the user fill up the necessary <data> in second step
    And goes to the third step en WS
    Then verify data of campaign

    Examples:
      | Option   | source | template                                 | data         |
      | Whatsapp | file   | Template SeleniumWhatsApp with Parameter | with tags    |
      | Whatsapp | file   | Template SeleniumWhatsApp                | without tags |
      | Whatsapp | group  | Template SeleniumWhatsApp                | without tags |