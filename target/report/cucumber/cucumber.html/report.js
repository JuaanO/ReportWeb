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
      "name": "@FastCampaign1"
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
      "name": "@FastCampaign1"
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
formatter.scenarioOutline({
  "name": "The user do a WhatsApp \"Masive campaing\" with ..",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@massiveCampaign"
    }
  ]
});
formatter.step({
  "name": "a user logged to Tellit choose a \u003cOption\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "the user choose a \u003ctemplate\u003e and select a \u003csource\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "the user fill up the necessary \u003cdata\u003e in second step",
  "keyword": "And "
});
formatter.step({
  "name": "goes to the third step en WS",
  "keyword": "And "
});
formatter.step({
  "name": "verify data of campaign",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Option",
        "source",
        "template",
        "data"
      ]
    },
    {
      "cells": [
        "Whatsapp",
        "file",
        "Template SeleniumWhatsApp with Parameter",
        "with tags"
      ]
    },
    {
      "cells": [
        "Whatsapp",
        "file",
        "Template SeleniumWhatsApp",
        "without tags"
      ]
    },
    {
      "cells": [
        "Whatsapp",
        "group",
        "Template SeleniumWhatsApp",
        "without tags"
      ]
    }
  ]
});
formatter.scenario({
  "name": "The user do a WhatsApp \"Masive campaing\" with ..",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@WhatsApp"
    },
    {
      "name": "@massiveCampaign"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "a user logged to Tellit choose a Whatsapp",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.Mashup.mashUp.aUserLoggedToTellitChooseAnOption(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user choose a Template SeleniumWhatsApp with Parameter and select a file",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.MassiveCampaign.theUserSelectsRecipientSource(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fill up the necessary with tags in second step",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.MassiveCampaign.dataNecesary(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "goes to the third step en WS",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.MassiveCampaign.iratercer()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify data of campaign",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.Sms.MassiveCampaign.theUserVerifyDataCampaign()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "The user do a WhatsApp \"Masive campaing\" with ..",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@WhatsApp"
    },
    {
      "name": "@massiveCampaign"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "a user logged to Tellit choose a Whatsapp",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.Mashup.mashUp.aUserLoggedToTellitChooseAnOption(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user choose a Template SeleniumWhatsApp and select a file",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.MassiveCampaign.theUserSelectsRecipientSource(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fill up the necessary without tags in second step",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.MassiveCampaign.dataNecesary(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "goes to the third step en WS",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.MassiveCampaign.iratercer()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify data of campaign",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.Sms.MassiveCampaign.theUserVerifyDataCampaign()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "The user do a WhatsApp \"Masive campaing\" with ..",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@WhatsApp"
    },
    {
      "name": "@massiveCampaign"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "a user logged to Tellit choose a Whatsapp",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.Mashup.mashUp.aUserLoggedToTellitChooseAnOption(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user choose a Template SeleniumWhatsApp and select a group",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.MassiveCampaign.theUserSelectsRecipientSource(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fill up the necessary without tags in second step",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.MassiveCampaign.dataNecesary(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "goes to the third step en WS",
  "keyword": "And "
});
formatter.match({
  "location": "steps.WhatsApp.MassiveCampaign.iratercer()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify data of campaign",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.Sms.MassiveCampaign.theUserVerifyDataCampaign()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});