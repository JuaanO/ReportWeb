Feature: Sending of messages of different types (failed, and successful)
  I wanna do a "Fast send" campaigns of type"SMS", with all possible status

  @SendMessage
  Scenario Outline: Send a message with all possible statuses
    Given a user logged to Tellit choose a <Option> option
    When the user do a <Status> campain
    Examples:
      | Option | Status  |
      | SMS    | valid   |
      | SMS    | Invalid |

  @SendMessage  @SendMessageMassive
  Scenario Outline: realizar una camapana masiva
    Given a user logged to Tellit choose a <Option> option
    When el usuario escoge realizar una campana masiva de sms
#      Paso 1
    And le usuario selecciona la <fuente> de destinatario
    And le usuario selecciona <tipo> de mensaje
    And escoge el grupo
    And carga el grupo
    And presiona siguiente
##      Paso 2
    And el usuario ingresa un nombre de campana
    And el usuario ingresa <los datos> del paso 2
    And el usuario presiona siguiente
##      Paso 3
#    Then el suaurio puede verificar los datos ingresados son correctos
    Examples:
      | Option | fuente | tipo         | archivo | los datos | fuente2 |
      | SMS    | grupos | Normal SMS   |         |           |         |
      | SMS    | grupos | Flash SMS    |         |           |         |
#      | SMS    | grupos | Attached Doc |         |           |         |
      | SMS    | grupos | Premium SMS  |         |           |         |


#  @grupos
#  Scenario Outline: realizar una camapana masiva
#    Given a user logged to Tellit choose a <option> option
#    When el usuario escoge realizar una campana masiva de sms
##      Paso 1
#    And le usuario selecciona la <fuente> de destinatario
#    And le usuario selecciona <tipo> de mensaje
#    And el usuario carga el archivo
#    And el usuario selecciona la columna con los numenros
##      Paso 2
#    And el usuario ingresa un nombre de campana
#    And el usuario ingresa un mensaje
#    And el usuario avanza al paso 3
##      Paso 3
#    Then el suaurio puede verificar los datos ingresados son correctos
#
#    Examples:
#      | option | fuente  | tipo | archivo |
#      | SMS    | grupo | SMS Normal | archivo |
#      | SMS    | grupo   | SMS Flash | archivo |



#  @MassiveCampaignGroup
#  Scenario Outline: realizar una camapana masiva
#    Given a user logged to Tellit choose a <Option> option
#    When el usuario escoge realizar una campana masiva de sms
##      Paso 1
#    And le usuario selecciona la <fuente> de destinatario
#    And le usuario selecciona <tipo> de mensaje
##    And el usuario carga el <archivo>
##    And el usuario selecciona selecciona llena los datos
##    And el usuario presiona siguiente
##    And el usuario ingresa los datos del paso 1 con
###      Paso 2
##    And el usuario ingresa un nombre de campana
##    And el usuario ingresa <los datos> del paso 2
##    And el usuario presiona siguiente
###      Paso 3
##    Then el suaurio puede verificar los datos ingresados son correctos
#    Examples:
#      | Option | fuente  | tipo | archivo  | los datos | fuente2  |
#      |    SMS    |   grupos      |   Normal SMS     |         |        |         |