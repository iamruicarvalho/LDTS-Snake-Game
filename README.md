# L03Gr08 - PROJECT SnakeGameLDTS

### GAME DESCRIPTION

> The SnakeGame is a basic classic game, where the goal is to be able to capture as much food as you can for the snake and every time the snake eats it, its size grows by one, making the game harder and harder as the game progresses. In the version we 've created, there are 3 levels of difficulty in the single player mode.  
> This project was developed by Cristiano Rocha (up202108183@fe.up.pt), Rui Carvalho (up202108807@fe.up.pt) and Guilherme Ribeiro (up202108731@fe.up.pt) in the context of a practical work on the subject of LDTS at FEUP (Faculdade de Engenharia da Universidade do Porto).

### IMPLEMENTED FEATURES

> KEYBOARD CONTROLS – Functionality of each Button:  
ArrowUp -> Change snake direction to Up / Move Up Menu  
ArrowDown -> Change snake direction to Down / Move Down Menu  
ArrowRight -> Change snake direction to Right  
ArrowLeft -> Change snake direction to Left

> MENUS:  
> The user can select between a GUI mainMenu by using ArrowUp, ArrowDown and ENTER to select the desired option. Presented possible actions START, CONTROLS, SCOREBOARD and EXIT. LeaderBoard keeps the highest score.
>
> In the mainMenu:  
> Selected the START option, a DIFFICULTY menu pops up, where the player can select between EASY, MEDIUM and HARD difficulty.    
> If the player needs to check the controls, it must be selected the CONTROLS option, where a controls' guide pops up on the screen, allowing the player to see which controls to use in order to perform any move in the game.    
> To see the best score ever achieved in one try, the player must select the SCOREBOARD option.  
> Selected any of the options listed above, the player can also decide to go BACK to the mainMenu or EXIT the game.  
> To EXIT the game, the last option must be selected.

> When the player lose, it is shown a GAMEOVER menu. In that menu, the player can see the score obtained in his most recent try, and select between RESTART, to play again, MENU, to go back to the mainMenu or EXIT, to exit the game.

> SnakeSize - Everytime the snake eats a fruit, its size is increased by 1.  

> Score - Unlike the snake size, the score does not increase linearly. Instead, its growth depends on the fruit eaten by the snake: if the snake eats a spawn, the score increases by 1; if a banana was eaten, the score increases by 2; finally, if the snake eats a cherry, the current score is multiplied by a factor of 1.5 .    

> Fruit Chances - The fruits used in the game (spawn, banana and cherry) have different chances of appearing in the Arena: the chance of appearing a spawn is nearly 100%; however, a banana has 25% of chance to appear while a cherry has just 5%.  

> Collision Detection - the snake detects that she can’t go out of the Arena she is in nor collide with herself.

> Fruit – A single fruit (spawn,banana or cherry) appears in a random position on the Arena (except in the ones previously occupied by the snake's body and in the most recent position the last fruit has been randomly generated) and disappears when the snake eats it.  
> Another single fruit appears in a different random position immediately after the previous one has been eaten.
  
# Screenshots:
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
![GAMEOVER](/Images_Source/gameOverMenu.PNG "GAMEOVER")
  
### PLANNED FEATURES

> We thought of implementing a multiplayer mode, in order to have a battle between 2 different players, and a pauseMenu for pausing the game, with options to resume or to go back to the mainMenu.
Unfortunately, none of these features were implemented because we were running out of time.

# 1.
##  DESIGN

### Problem in Context
The main problem we faced was to find a way to structure the classes so that it would be easier to read and understand the code.  

### The Pattern
The main pattern we use as our architectural pattern was the MVC PATTERN (model-view-control pattern). This pattern is used to separate an application into three main groups of components: Models, Views, and Controllers (creating a more organized structure). Widely used for developing GUI and web applications.


### Implementation
![Model-View-Controller design](/Images_Source/what-is-mvc-design-pattern_cleanup.jpg "MVC")

### Consequences

The use of the State Pattern in the current design allows the following benefits:

• Modifications Do Not Affect The Entire Model  
• Faster Development Process


# 2.
##  DESIGN

### Problem in Context
We needed to use the same methods in different states, both of the game and the mainMenu, needing them to be using the same structure of algorithm.


### The Pattern
The TEMPLATE PATTERN is used to define an algorithm as a skeleton of operations and leave the details to be implemented by the classes that use them. The overall structure and sequence of the algorithm are preserved by the core skeleton.


### Implementation
![Template Pattern](/Images_Source/LDTS_4.png "Template Pattern")

### Consequences
• Allows for the possibility of reusing the same algorithm in different instances of the program making only slight changes to fit the context in which we needed it.


# 3.
##  DESIGN

### Problem in Context
As we thought in the beginning of the project, we will try to have different states, such as game state, mainMenu state and controlsMenu state.

### The Pattern
The second pattern we decided to use was the STATE PATTERN. This is a behavioral design pattern that lets an object alter its behavior depending on its state.

### Implementation
<<falta implementar isto e colocar no uml>>

### Consequences
• A better organization of the different screens the player will be seeing, providing an easier way of modifying a view (screen) if needed.  
• Single Responsibility Principle. The code related to each state are in separate classes   
• Open/Closed Principle. We can introduce new states without changing existing state classes


# 4.
##  DESIGN

### Problem in Context
For us to design different objects in our game that had very similar characteristics, we needed a way to create new ones that share those same characteristics.


### The Pattern
We used the FACTORY PATTERN, which is a creation design pattern that provides an interface to create objects in a superclass, so that subclasses can alter the characteristics of the new object.

### Implementation
![Factory Pattern](/Images_Source/factory.png "Factory Pattern")
é melhor rever esta imagem. nao sei se está certo.

### Consequences
• It is now much easier to add different objects or elements to the game. For example, if we want to add new food, using the same characteristics as the previous ones, the process will be simpler.


# DATA CLASS

## UML DIAGRAM
![UML](/Images_Source/UML.png "UML")  
Current UML state with exception to the class food that isn't implemented yet.
temos de rever o UML e colocar tudo interligado entre si. o stor queixou se disso na apresentação.




# TESTING
### Mockito/JUnit
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

* #### Inside /viewer:
![viewerTestFolder](/Images_Source/viewerTestFolder.png "viewerTestFolder")

# SELF-EVALUATION
Cristiano Rocha up202108813 100%  
Rui Carvalho up202108807 100%  
Guilherme Ribeiro up202108731 100%  
