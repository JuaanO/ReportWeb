$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Module%20WhatsApp.feature");
formatter.feature({
  "name": "As a valid and logged user do campaigns, with all possible",
  "description": "  status. Sending of messages of different types (Normal shipping,\n  Premium shipping, Flash shipping).",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@WhatsApp"
    }
  ]
});
formatter.scenarioOutline({
  "name": "The user do a WhatsApp \"Fast Campaign\" with ..",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@fastCampaign1"
    }
  ]
});
formatter.step({
  "name": "a user logged to Tellit choose a \u003coption\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "the user do a whatsapp fast campaign with a \u003ctemplate\u003e",
  "keyword": "When "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "option",
        "template"
      ]
    },
    {
      "cells": [
        "whatsapp",
        "Template SeleniumWhatsApp"
      ]
    }
  ]
});
formatter.scenario({
  "name": "The user do a WhatsApp \"Fast Campaign\" with ..",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@WhatsApp"
    },
    {
      "name": "@fastCampaign1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "a user logged to Tellit choose a whatsapp",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.Mashup.mashUp.aUserLoggedToTellitChooseAnOption(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user do a whatsapp fast campaign with a Template SeleniumWhatsApp",
  "keyword": "When "
});
formatter.match({
  "location": "steps.Commons.FastCampaign.theUserDoACampaign(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});