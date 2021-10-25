@Voz
Feature: As a valid and logged user do a SMS campaigns, with all possible
  status. Sending of messages of different types (Normal shipping,
  Premium shipping, Flash shipping).

  @FastCampaign
  Scenario Outline: The user do a Voice "Fast Campaign" with ..
    Given a user logged to Tellit choose a <option>
    When the user do a voice fast camping with a <attached>

#  Wheen the user do a sms fast

    Examples:
      | option | attached        |
      | Voice  | file record    |
      | Voice  | Texto que se convertira, en voz |
#      | Voice  | record a audio |
