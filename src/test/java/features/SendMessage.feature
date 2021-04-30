Feature: As a valid and logged user do campaigns, with all possible
  status. Sending of messages of different types (Normal shipping,
  Premium shipping, Flash shipping).

  @SendMessage
  Scenario Outline: The user do a "Fast Send" with all status
    Given a user logged to Tellit choose a <Option> option
    When the user do a <Fast Send> with <Status> status

    Examples:
      | Option | Fast Send        | Status  |
      | SMS    | Normal shipping  | valid   |
      | SMS    | Premium shipping | Invalid |
      | SMS    | Flash shipping   | Valid   |


  @SendMessage  @SendMessageMassive
  Scenario Outline: The user do a "Massive Campaign" with all status
    Given a user logged to Tellit choose a <Option> option
    When the user chooses a massive sms campaign option
#      Step 1
    And the user selects recipient <Source>
    And the user selects message <Type>
    And the user chooses group
    And the user goes to the second step
##      Paso 2
    And the user enter values of second step
    And the user goes to the third step
##      Paso 3
    Then the user verify data of campaign

    Examples:
      | Option | Source | Type         | archivo | los datos | fuente2 |
      | SMS    | grupos | Normal SMS   |         |           |         |
      | SMS    | grupos | Flash SMS    |         |           |         |
      | SMS    | grupos | Premium SMS  |         |           |         |
#      | SMS    | grupos | Attached Doc |         |           |         |


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