@Voz
Feature: As a valid and logged user do a SMS campaigns, with all possible
  status. Sending of messages of different types (Normal shipping,
  Premium shipping, Flash shipping).

  @fastCampaign
  Scenario Outline: The user do a Voice "Fast Campaign" with ..
    Given a user logged to Tellit choose a <option>
    When the user do a voice fast camping with a <attached>

#  Wheen the user do a sms fast

    Examples:
      | option | attached        |
      | Voice  | file record    |
      | Voice  | Texto que se convertira, en voz |
#      | Voice  | record a audio |

#  @massiveCampaign
#  Scenario Outline: The user do a Voice "Fast Campaign" with ..
#    Given a user logged to Tellit choose a <option>
#
#
#
##    And the user choose a <template> and select a <source>
#    selecciona el tipo de campana <informativa>
#    carga el archivo y selecciona las columnas
#    va a la segunda pantalla
#    ingresa un nombre para la campana
#    adjunta el <tts, audio> a la campana
#    va al siguiente paso
#    verify lo datos
#
#
##    And the user fill up the necessary <data> in second step
##    And goes to the third step en WS
##    Then verify data of campaign
#
#    Examples:
#      | option | attached        |
#      | Voice  | file record    |
#      | Voice  | Texto que se convertira, en voz |
##      | Voice  | record a audio |
