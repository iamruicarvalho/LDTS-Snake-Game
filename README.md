# L03Gr08 - PROJECT SnakeGameLDTS

### GAME DESCRIPTION

> The Snake Game is a classic game in which the objective is to capture as much fruit as possible with a snake. Each time the snake eats fruit, its size increases by one, making the game progressively more difficult. In the version we have created, there are three levels of difficulty.
> This project was developed by Cristiano Rocha (up202108183@fe.up.pt), Rui Carvalho (up202108807@fe.up.pt) and Guilherme Ribeiro (up202108731@fe.up.pt) in the context of a practical work on the subject of LDTS at FEUP (Faculdade de Engenharia da Universidade do Porto).


### IMPLEMENTED FEATURES

> KEYBOARD CONTROLS – Functionality of each Button:  
ArrowUp -> Change snake direction to Up / Move Up Menu  
ArrowDown -> Change snake direction to Down / Move Down Menu  
ArrowRight -> Change snake direction to Right  
ArrowLeft -> Change snake direction to Left
Q -> Quit game
Enter -> Select option

> MENUS:  
> The user can select between a GUI mainMenu by using ArrowUp, ArrowDown and ENTER to select the desired option. Presented possible actions START, CONTROLS, SCOREBOARD and EXIT. LeaderBoard keeps the highest score.
> In the mainMenu:  
> Selected the START option, a DIFFICULTY menu pops up, where the player can select between EASY, MEDIUM and HARD difficulty.    
> If the player needs to check the controls, it must be selected the CONTROLS option, where a controls' guide pops up on the screen, allowing the player to see which controls to use in order to perform any move in the game.    
> To see the best score ever achieved in one try, the player must select the SCOREBOARD option.  
> Selected any of the options listed above, the player can also decide to go BACK to the mainMenu or EXIT the game.  
> To EXIT the game, the last option must be selected.

> When the player lose, it is shown a GAME OVER menu. In that menu, the player can see the score obtained in his most recent try, and select between RESTART, to play again, MENU, to go back to the mainMenu or EXIT, to exit the game.

> SnakeSize - Everytime the snake eats a fruit, its size is increased by 1.  

> Score - Unlike the snake size, the score does not increase linearly. Instead, its growth depends on the fruit eaten by the snake: if the snake eats a spawn, the score increases by 1; if a banana was eaten, the score increases by 2; finally, if the snake eats a cherry, the current score is multiplied by a factor of 1.5 .    

> Fruit's Appearance Chances - The fruits used in the game (spawn, banana and cherry) have different chances of appearing in the Arena: the chance of appearing a spawn is nearly 100%; however, a banana has 25% of chance to appear while a cherry has just 5%.  

> Fruit – A single fruit (spawn,banana or cherry) appears in a random position on the Arena (except in the ones previously occupied by the snake's body and in the most recent position the last fruit has been randomly generated) and disappears when the snake eats it.  
> Another single fruit appears in a different random position immediately after the previous one has been eaten.  

> Collision Detection - The snake detects that she can’t go out of the Arena she is in nor collide with herself.

  
# Screenshots:
## Gameplay:
![GamePlay](/Images_Source/GamePlay.gif "GamePlay")

## MainMenu:
![MainMenu](/Images_Source/mainMenu.PNG "MainMenu")
  
## ControlsMenu:
![ControlsMenu](/Images_Source/controlsMenu.PNG "ControlsMenu")
  
## ScoreboardMenu:
![ScoreboardMenu](/Images_Source/scoreboardMenu.PNG "ScoreBoardMenu")
  
## DifficultyMenu:
![DifficultyMenu](/Images_Source/difficultyMenu.PNG "DifficultyMenu")
  
## SnakeInGame:
![SnakeInPlay](/Images_Source/Game.PNG "Snake") 
  
## GameOverMenu
![GameOver](/Images_Source/gameOverMenu.PNG "GameOver")
  
### PLANNED FEATURES
>We considered adding a multiplayer mode to allow for competition between two players and a pause menu with options to resume or return to the main menu. However, we were unable to implement these features due to time constraints.

## 1.
## DESIGN
### Problem in Context
One of the main challenges we faced was finding a way to effectively organize and structure the code in a manner that would be easy to maintain and expand upon.

### The Pattern
The MVC (Model-View-Controller) design pattern is the main architectural pattern that we use. This pattern helps to separate an application into three main groups of components: Models, Views, and Controllers. 
The purpose of this separation is to create a more organized and structured codebase.
It allows for a clear separation of concerns between the data and logic of the application (Model), the user interface (View), and the interaction between the two (Controller). 

### Implementation
![Model-View-Controller design](/Images_Source/MVC.png "MVC")
Top -> Controllers  
Bottom -> Models  
Right -> Viewers  
The Controller interface and Viewer interface are also part of the MVC implementation

## Consequences

##### The use of the MVC in the current design allows the following benefits:

• Improved maintainability by dividing the code into distinct components, it can be easier to modify and maintain each component independently.  

• The MVC pattern helps to separate the different aspects of an application into distinct components


## 2.
## DESIGN

### Problem in Context
In order to define multiple menus and a gameplay state,
each with their own unique behavior and state, we decided to implement the state pattern.

### The Pattern
The state pattern is a design pattern that allows for the encapsulation of behavior
and state within individual objects. This allows us to centralize the logic for each menu or gameplay state in a single place, making it easier to manage the different states of the game and the transitions between them.


### Implementation
![State Pattern](/Images_Source/State.png "State Pattern")

### Consequences
• Improves readability of the code, as it allows for the logic for each state to be self-contained within the corresponding object.  

• Improved maintainability by centralizing the logic for each state in a single place, the state pattern can make it easier to modify and maintain the code.


## 3.
## DESIGN

### Problem in Context
In order to store and access the highScore and lastScore from any class in our application, we decided to implement the singleton pattern.
### The Pattern
The singleton pattern is a design pattern that ensures that a class has only one instance, and provides a global access point to that instance.
### Implementation
![Singleton Pattern](/Images_Source/Singleton.png "Singleton Pattern")
Singleton is being used by other class's, as visible in the UML diagram.

### Consequences
•  By ensuring that there is only one instance of a class, the singleton pattern allows for a centralized management of shared state and resources.  
•  The singleton pattern can improve the readability of the code, as it allows for the logic for managing shared state and resources to be self-contained within the singleton class.


## 4.
## DESIGN

### Problem in Context
To create different types of fruit for the snake game, we utilized the Factory Pattern.
We used the Factory Pattern to create different types of fruit for the snake game. By defining an interface for creating fruit and implementing concrete classes for each type of fruit, we were able to create a variety of fruit objects without having to specify their concrete classes
### The Pattern
The Factory Pattern is a design pattern that provides an interface for creating objects
in a super class, but allows subclasses to alter the type of objects that will be created.
This allows for the creation of different types of objects without specifying their concrete classes.

### Implementation
![Factory Pattern](/Images_Source/Factory.png "Factory Pattern")

### Consequences
• The Factory Pattern allows for the creation of different types of objects without specifying their concrete classes, improving the flexibility
• The Factory Pattern can improve the readability of the code, as it allows for the logic for creating objects to be self-contained within the factory class in our case the FruitFactory


# DATA CLASS

## UML DIAGRAM
![UML](/Images_Source/UML1.png "UML")

# Refactoring suggestions and Code Smells

## 1.
### Long Method
* During the code review, we noticed that some functions in our codebase were quite large. Upon closer inspection using the liveRef tool, we discovered that these large functions were a code smell, indicating a lack of modularity in the code.  
As a result, we decided to refactor these large functions by dividing them into smaller and more focused ones, having each one of them a single responsibility or task. The refactoring improved the overall readability and maintainability of the code.  
For example, we noticed that the function moveBody() in the class SnakeController() had the responsibility of checking if the snake could move to a specific position and verifying if that position was occupied by an apple, a snake body, or a wall.
We decided to create a new function called checkCollision(), which was solely responsible for checking if the snake was moving to an empty spot.
If not, the function would change the Lost flag to true.  

* Additionally, we noticed that the function isFruit() in the Arena class had the same code smell. We refactored this function by dividing it into a new function called moveFruit(), which was responsible for generating a random fruit position and setting it as the fruit inside the arena.  
This helped to improve the modularity and readability of the code.

* We also discovered that the highscore was being set by functions that shouldn't have had that responsibility. To solve this issue, we implemented the Singleton Design Pattern to manage the highscore. This not only improved the overall readability of the code, but it also helped to remove unnecessary private fields from classes that shouldn't have had them, such as the score that was inside the GameOverMenu() class.  
Previously, the only way to access this score was through the GameOverMenuViewer() class, which was responsible for displaying the score obtained.

## 2.
### Dead Code
* We also noticed the presence of some dead code in our codebase. One example of dead code we identified was the number of getter methods that were no longer being used. While we could have simply removed this dead code, we decided to leave it in place for the time being. This was because we wanted to maintain the ability to easily introduce new tests in the future, and we believed that the presence of these getter methods could be useful for this purpose.

## 3.
### Duplicated Code
* Another code smell we noticed was the presence of repeated code in multiple parts of the codebase.  
While it is generally considered a code smell to have code that is unnecessarily duplicated, in this case we decided to leave the repeated code in place. One reason for this decision was that the repeated code was used to implement the Model-View-Controller (MVC) design pattern.  
Besides that, by keeping the repeated code, we were able to demonstrate more clearly the separation of these components and improve the overall readability and understanding of the MVC pattern in our codebase.

## Conclusion
Overall, our goal during the code review and refactoring process was to adhere as closely as possible to the SOLID principles of object-oriented design.   
While we believe that we made significant progress in applying these principles and improving the overall design of our codebase, we recognize that there may still be some areas for further improvement. In particular, the classes SnakeController and Arena were identified as having somewhat complex functionality and potentially being in violation of the Single Responsibility Principle.  

Ultimately, our goal is to create a codebase that is both easy to understand and maintain, and we believe that adhering to the SOLID principles is the key to achieving this goal.


# TESTING
## Mockito/JUnit
* #### Inside the main test folder:

![MainTestFolder](/Images_Source/MainTestFolder.png "MainTestFolder")

* #### Inside /Controller:
![ControllerTestFolder](/Images_Source/ControllerTestFolder.png "ControllerTestFolder")

* #### Inside /gui:
![guiTestFolder](/Images_Source/guiTestFolder.png "guiTestFolder")

* #### Inside /model:
![modelTestFolder](/Images_Source/modelTestFolder.png "modelTestFolder")

* #### Inside /ScoreBoard:
![ScoreBoardTestFolder](/Images_Source/ScoreBoardTestFolder.png "ScoreBoardTestFolder")

* #### Inside /states:
![statesTestFolder](/Images_Source/statesTestFolder.png "statesTestFolder")

* #### Inside /viewer:
![viewerTestFolder](/Images_Source/viewerTestFolder.png "viewerTestFolder")

## PITest

As part of our project, we are using mutation testing to ensure the quality and effectiveness of our group of tests. We are using PITest to perform mutation testing on our Java code. By creating mutants of our code and running our group of tests, we can determine whether the group of tests is able to detect the mutants and identify any potential defects in the code. This helps us improve the coverage and thoroughness of our group of tests, leading to a more robust and reliable final product.

### Coverage Report
![coverageReportPITest](/Images_Source/PITest.png "coverageReportPITest")

### Mutant Killing

While using PITest for mutation testing on our Java code, we were able to identify a number of mutants and "kill" them. This process resulted in a more durable and trustworthy final product.

#### Here are the befores and afters of the Mutants we found:
* #### 1.
![Mutant1](/Images_Source/Mutant1.png "Mutant1")

This Mutant was created signaling that if this code was removed our tests would not account for that change:

![Mutant1Errors](/Images_Source/Mutant1%20Errors.png "Mutant1 Errors")

Now while resolving this issue and killing this mutant we created some new tests and changed other ones and interestingly found something we could improve in our code as well, so this was one of the benefits of implementing PITests into project.
Here is the code and the Mutant after the changes:

![Mutant1Resolved](/Images_Source/Mutant1Resolved.png "Mutant1Resolved")

![Mutant1ErrorsResolved](/Images_Source/Mutant1ErrorsResolved.png "Mutant1ErrorsResolved")

* #### 2.

Before:

![Mutant2](/Images_Source/Mutant2.png "Mutant2")

![Mutant2Error](/Images_Source/Mutant2Error.png "Mutant2Error")

After:

![Mutant2Resolved](/Images_Source/Mutant2Resolved.png "Mutant2Resolved")

![Mutant2ErrorResolved](/Images_Source/Mutant2ErrorResolved.png "Mutant2ErrorResolved")

* #### 3.

Before:

![Mutant3](/Images_Source/Mutant3.png "Mutant3")

![Mutant3Error](/Images_Source/Mutant3Error.png "Mutant3Error")

After:

![Mutant3Resolved](/Images_Source/Mutant3Resolved.png "Mutant3Resolved")

![Mutant3ErrorResolved](/Images_Source/Mutant3ErrorResolved.png "Mutant3ErrorResolved")


# SELF-EVALUATION
Cristiano Rocha up202108813 40%  
Rui Carvalho up202108807 30%  
Guilherme Ribeiro up202108731 30%  
