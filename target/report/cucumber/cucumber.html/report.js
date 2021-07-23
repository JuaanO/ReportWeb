$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/SendMessageWhatsApp.feature");
formatter.feature({
  "name": "As a valid and logged user do campaigns, with all possible",
  "description": "  status. Sending of messages of different types (Normal shipping,\n  Premium shipping, Flash shipping).",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "The user do a \"Masive campaing\" with all status",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@WS1"
    }
  ]
});
formatter.step({
  "name": "a user logged to Tellit choose a \u003cOption\u003e option",
  "keyword": "Given "
});
formatter.step({
  "name": "chooses a massive whatsapp campaign option",
  "keyword": "When "
});
formatter.step({
  "name": "Selects and chooses recipient \u003csource\u003e de ws",
  "keyword": "And "
});
formatter.step({
  "name": "selectc template",
  "keyword": "And "
});
formatter.step({
  "name": "goes to the second step",
  "keyword": "And "
});
formatter.step({
  "name": "input a name for campaing",
  "keyword": "And "
});
formatter.step({
  "name": "goes to the third step en WS",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Option",
        "Fast Send",
        "source"
      ]
    },
    {
      "cells": [
        "Whatsapp",
        "Normal shipping",
        "group"
      ]
    }
  ]
});
formatter.scenario({
  "name": "The user do a \"Masive campaing\" with all status",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@WS1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "a user logged to Tellit choose a Whatsapp option",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.Mashup.mashUp.aUserLoggedToTellitChooseAnOption(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "chooses a massive whatsapp campaign option",
  "keyword": "When "
});
formatter.match({
  "location": "steps.WhatsApp.SendMessage.theUserChoosesAMassiveSmsCampaignOption()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Selects and chooses recipient group de ws",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.SendMessage.theUserSelectsRecipientSource(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selectc template",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.SendMessage.selectcTemplate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "goes to the second step",
  "keyword": "And "
});
formatter.match({
  "location": "steps.Sms.SendMessage.userGoSecondStep()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "input a name for campaing",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.SendMessage.inputANameForCampaing()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "goes to the third step en WS",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.SendMessage.iratercer()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});