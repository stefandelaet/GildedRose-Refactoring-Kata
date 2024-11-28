# GildedRose-Refactoring-Kata
Result for Java Refactoring Kata from https://github.com/emilybache/GildedRose-Refactoring-Kata


### Steps 
* Refactored by Encapsulating the itemquality behaviour into Item subclasses of Categorized Items.
* Added Factory for auto creation of correct Item subclass.
* Factory uses Category enum with values to do the correct subclass Assignment
* Didnt touch the Item class as required, instead subclassed into abstract CategorizedItem class and their real subclasses
* Added various override entrypoints into the CategorizedItem class. 
* Added logic for correcting out of bound (0-50) quality cases that existed, also in the item constructors.
* Renamed GildedRose entrypoint method, and encapsulated the sellIn logic to its own method.     
* Added Comments with business logic
* Used JUnit testing framework to add internal functionality tests and e2e tests.
* Testing is integrated into maven build.

* 28/11/2024 Stefan De Laet