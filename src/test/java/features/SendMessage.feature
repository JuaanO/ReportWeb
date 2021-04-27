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

#  @archivo
#  Scenario Outline: realizar una camapana masiva
#    Given a user logged to Tellit choose a <option> option
#    When el usuario escoge realizar una campana masiva de sms
##      Paso 1
#    And le usuario selecciona la <fuente> de destinatario
#    And le usuario selecciona <tipo> de mensaje
#    And el usuario carga el <archivo>
#    And el usuario selecciona selecciona llena los datos
#    And el usuario presiona siguiente
#    And el usuario ingresa los datos del paso 1 con
##      Paso 2
#    And el usuario ingresa un nombre de campana
#    And el usuario ingresa <los datos> del paso 2
#    And el usuario presiona siguiente
##      Paso 3
#    Then el suaurio puede verificar los datos ingresados son correctos
#    Examples:
#      | option | fuente  | tipo       | archivo |los datos|
#      | SMS    | archivo | SMS Normal | archivo |manualmente|
#      | SMS    | archivo | SMS Flash  | archivo |plantilla|


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