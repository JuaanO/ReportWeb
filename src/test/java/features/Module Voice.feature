@Voz
Feature: As a valid and logged user I want to send massive Voice
  campaigns with files and groups, and fast Voice campaigns with
  a TTS.

  @fastCampaign
  Scenario Outline: The user do a Voice "Fast Campaign" with ..
    Given a user logged to Tellit choose a <option>
    When the user do a voice fast camping with a <attached>

    Examples:
      | option | attached                        |
      | Voice  | file record                     |
      | Voice  | Texto que se convertira, en voz |
#      | Voice  | record a audio |

  @massiveCampaign
  Scenario Outline: The user do a Voice "Massive Campaign" with ..
    Given a user logged to Tellit choose a <option>
    When the user choose a <source> and select <type> of campaign
    And the user upload a <message>
    Then verify data of campaign

    Examples:
      | option | source | type        | message            |
      | Voice  | file   | Informativa | file record        |
      | Voice  | groups | interactive | esto prueba cambia |
