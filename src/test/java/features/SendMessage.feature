@SMS
Feature: As a valid and logged user do campaigns, with all possible
  status. Sending of messages of different types (Normal shipping,
  Premium shipping, Flash shipping).

  @highProprity @SendFastCampaign
  Scenario Outline: The user do a "Fast Send" with all status
    Given a user logged to Tellit choose a <option> option
    When do a <fast send> with <status> status

    Examples:
      | option | fast send        | status  |
      | sMs    | normal shipping  | VaLiD   |
#      | Sms    | PREMIUM shipping | VaLiD |
#      | SMS    | Flash shipping   | INvalid |

  @lowPriority @SendMassiveCampaign
  Scenario Outline: The user do a "Massive Campaign" with all posibles status
    Given a user logged to Tellit choose a <option> option
    When chooses a massive sms campaign option
    And selects and chooses recipient <source>
    And selects a message <type>
    And goes to the second step
    Then enters name and message for the campaign
    And goes to the third step
    Then verify data of campaign
    And send a sample campaign

    Examples:
      | option | source  | type        |
      | Sms    | groUps  | Normal SMS  |
      | Sms    | FilE | FLASH sms   |
      | sms    | FILE | FLASH sms   |
      | smS    | grouP | PreMiuM SMS |
      | smS    | grouPs | PreMiuM SMS |
      | SMS    | grupos | Attached Doc |
      | SMS    | grupos  | rCs         |
