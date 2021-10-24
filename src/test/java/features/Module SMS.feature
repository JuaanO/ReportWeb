@SMS
Feature: As a valid and logged user do a SMS campaigns, with all possible
  status. Sending of messages of different types (Normal shipping,
  Premium shipping, Flash shipping).

  @highProprity @SendFastCampaign
  Scenario Outline: The user do a SMS "Fast Campaign" with ..
    Given a user logged to Tellit choose a <option>
    When the user do a <fast campaign> with <status>

#  When the user do a sms fast campaign with a valid number
#  When the user do a voice fast campaign with a tts
#  When the user do a whatsapp campaign with a template
#  When the user do a sms fast campaign with a invalid number

    Examples:
      | option | fast campaign | status  |
      | sms    | normal shipping   | valid   |
      | sms    | premium shipping  | valid   |
      | sms    | flash shipping    | invalid |

  @highProprity @SendMassiveCampaign
  Scenario Outline: The user do a SMS "Massive Campaign" with ..
    Given a user logged to Tellit choose a <option>
    When chooses a massive sms campaign option
    And selects and chooses recipient <source>
    And selects a message <type>
    And goes to the second step
    Then enters name and message for the campaign
    And goes to the third step
    Then verify data of campaign
    And send a sample campaign

    Examples:
      | option | source | type        |
      | sms    | group  | normal sms  |
      | sms    | file   | flash sms   |
      | sms    | file   | flash sms   |
      | sms    | group  | premium SMS |
#      | SMS    | grupos | Attached Doc |
#      | SMS    | grupos  | rCs         |
