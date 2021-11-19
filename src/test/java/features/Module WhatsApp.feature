@WhatsApp
Feature: As a valid and logged user I want to send massive WhatsApp
  campaigns with files and groups, and fast WhatsApp campaigns with
  a template.

  @fastCampaignWhatsApp
  Scenario Outline: The user do a WhatsApp "Fast Campaign" with ..
    Given a user logged to Tellit choose a <option>
    When the user do a whatsapp fast campaign with a <template>

    Examples:
      | option   | template                  |
      | whatsapp | Template SeleniumWhatsApp |
#      | SMS    | Premium shipping | Invalid |
#      | SMS    | Flash shipping   | Valid   |

  @massiveCampaignWhatsApp
  Scenario Outline: The user do a WhatsApp "Masive campaing" with ..
    Given a user logged to Tellit choose a <Option>
    And the user choose a <template> and select a <source>
    And the user fill up the necessary <data> in second step
    Then verify data of campaign

    Examples:
      | Option   | source | template                                 | data         |
      | Whatsapp | file   | Template SeleniumWhatsApp with Parameter | with tags    |
      | Whatsapp | file   | Template SeleniumWhatsApp                | without tags |
      | Whatsapp | group  | Template SeleniumWhatsApp                | without tags |