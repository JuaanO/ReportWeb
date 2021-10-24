Feature: As a valid and logged user do a SMS campaigns, with all possible
  status. Sending of messages of different types (Normal shipping,
  Premium shipping, Flash shipping).

  @Voz
  Scenario Outline: The user do a Voice "Fast Campaign" with ..
    Given a user logged to Tellit choose a <option>
    When the user do a voice camping with <adjunto>

#  Wheen the user do a sms fast

    Examples:
      | option | adjunto        |
      | Voice  | file record    |
#      | Voice  | text to speach |
#      | Voice  | record a audio |

