@SMS
Feature: As a valid and logged user I want to send massive SMS
  campaigns with files and groups, and fast SMS campaigns
  of different types (Normal shipping, Premium shipping and
  Flash shipping).

  @fastCampaignSMS
  Scenario Outline: The user do a SMS "Fast Campaign" with ..
    Given a user logged to Tellit choose a <option>
    When the user do a <fast campaign> with a <status>

    Examples:
      | option | fast campaign | status  |
      | sms    | normal shipping   | valid   |
      | sms    | premium shipping  | valid   |
      | sms    | flash shipping    | invalid |

  @massiveCampaignSMS
  Scenario Outline: The user do a SMS "Massive Campaign" with .. <option>
    Given a user logged to Tellit choose a <option>
    When chooses a massive sms campaign option
    And selects and chooses recipient <source>
    And selects a message <type>
    Then enters name and message for the campaign
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