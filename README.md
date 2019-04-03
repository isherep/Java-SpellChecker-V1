# Java-SpellCheker-V1

## Spell Checking for bad casing and invalid character duplication ##


----------------------------------------------------------------------------------------------------------
PROJECT TITLE:SpellChecker

## PURPOSE OF PROJECT: Correct the spelling errors such as bad casing and invalid character duplication. ##
## Correct words such as _'appPPplllLleeeeE' to _'apple'_, _'Millk'_ to _'milk'_ ## 

VERSION or DATE: 03/16/2019

AUTHORS: Iryna Sherepot


### USER INSTRUCTIONS: To use a spellCheck function, please create a new object SpellChecker passing the dictionary file you ### would like to check words against.
### After dictionary was created, you can spell check word by calling the SpellChecker instance method checkWord(String ### wordToCheck). ###

The checkWord() function will  perform two types of corrections on the incoming word and then return the corrected word:
It fixes bad casing:
“england” → “England”

It removes invalid repeating characters:
“tabble” → “table”

* If the incoming word is already correct, the function returns the original word. * 
* If no correction can be found, the function returns the string “No Correction Found”. *

Tests are provided is the  SpellTest.java. 

The project assumes the following:
- any number of character duplication can be made
- duplication can occur more than once, 
- bad casing can occur more than one time in the word at any letter, 
- word can have both casing and duplication errors at the same time
- If the two possible correct spellings of the word is possible, the function picks first one.


