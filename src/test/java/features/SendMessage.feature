Feature: As a valid and logged user do campaigns, with all possible
  status. Sending of messages of different types (Normal shipping,
  Premium shipping, Flash shipping).

  @SendFastCampaign
  Scenario Outline: The user do a "Fast Send" with all status
    Given a user logged to Tellit choose a <Option> option
    When the user do a <Fast Send> with <Status> status

    Examples:
      | Option | Fast Send        | Status  |
      | sMs    | normal shipping  | VaLiD   |
      | Sms    | PREMIUM shipping | INVALID |
      | SMS    | Flash shipping   | INvalid |

  @SendMessageMassive @SendMessage  @SendMessageMassiveGroup
  Scenario Outline: The user do a "Massive Campaign" with all posibles status
    Given a user logged to Tellit choose a <Option> option
    When the user chooses a massive sms campaign option
#      Step 1
    And the user selects recipient <Source>
    And the user selects message <Type>
#    And the user chooses group
    And the user goes to the second step
##      Paso 2
    And the user enter values of second step
    And the user goes to the third step
##      Paso 3
    Then the user verify data of campaign

    Examples:
      | Option | Source  | Type       |
      | SMS    | grupos  | Normal SMS |
      | SMS    | archivo | Flash SMS  |
#      | SMS    | grupos | Premium SMS |
#      | SMS    | grupos | Attached Doc |

  @SendSample
  Scenario Outline: The user do a "Massive Campaign" with all posibles status
    Given a user logged to Tellit choose a <Option> option
    When the user chooses a massive sms campaign option
#      Step 1
    And the user selects recipient <Source>
    And the user selects message <Type>
#    And the user upload a file
    And the user chooses group
    And the user goes to the second step
###      Paso 2
    And the user enter values of second step
    And the user goes to the third step
##      Paso 3
    Then the user verify data of campaign
    And the user choose send a sample


    Examples:
      | Option | Source  | Type       |
      | SMS    | archivo | Normal SMS |
#      | SMS    | grupos | Flash SMS   |
#      | SMS    | archivo | Premium SMS |
#      | SMS    | grupos | Premium SMS |


