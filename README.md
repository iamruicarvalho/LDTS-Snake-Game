# L03Gr08 - PROJECT SnakeGameLDTS

### GAME DESCRIPTION

> The SnakeGame is basic classic game, where the objective is to be able to capture as many food as you can for the snake and every time the snake eats the size of it grows by one making the game harder and harder as the game progresses. In our Version of the game as the there are 3 levels of dificulty in single player mode. 
This project was devoloped by Cristiano Rocha (up202108183@fe.up.pt), Rui Carvalho(up202108807@fe.up.pt), Guilherme Ribeiro(up202108731@fe.up.pt) in the context of a pratical work on the subject of LDTS at FEUP(Faculdade de Engenharia da Universidade do Porto).

### IMPLEMENTED FEATURES

>Keyboard Controls – Functionality of each Botton  
  >ArrowUp -> Change snake direction to Up / Move Up Menu  
  ArrowDown -> Change snake direction to Down / Move Down Menu  
  ArrowRight -> Change snake direction to Right  
  ArrowLeft -> Change snake direction to Left  
    
  >Menus -> user can select between a GUI menu by using ArrowUp, ArrowDown and ENTER to select the desired option. Present possible actions START and EXIT. LeaderBoard   not fully complete.
 SnakeSize -> On the top of the screen it is possible to look at the current size of the snake.

# Screenshots:  
 ## MainMenu:    
 ![MainMenu](/Images_Source/menu.PNG "MainMenu")  
 
 ## SnakeInGame:  
 ![SnakeInPlay](/Images_Source/MockUp_Snake.png "Snake")  
   
### PLANNED FEATURES

>Menus -> Menu for GameOver where user can select if he wants to restart or go to main menu. Possibly add option for a multiplayer battle bettwen 2 players. Menu for pause with options to resume and or go back to main menu  
  
>Colision Detection – the snake detects that it can’t go out of the Arena she is in and also that it can’t colide with herself  
  
> Food – spawns in not ocupied random places on the Arena and respawns when the snake eats it  
  
> Game Information – during gameplay on the top of the screen it will be possible to view the amount of food the snake as eaten and also how much time as passed since start playing  
  
> ScoreBoard – in the start menu it is possible to view the highest Score(food eaten in one game) that a player was able to perform and associated with it will be the time it took him to accomplish that  
  
> Escape -> Pause the game  
  
> ENTER -> Select menu option  

# 1.  
##  DESIGN

### Problem in Context:

The main problem we encountered was to find a way to stucture the classes so that it would be easier to read and understand.  
  
### -The Pattern  
The main pattern we utilize as our architectural pattern was the MVC PATTERN (model-view-control pattern). This pattern is use to separates an application into three main groups of components: Models, Views, and Controllers(creating a more organized structure). Widely used for developing GUI and web applications.  


### -Implementation  
![Model-View-Controller design](/Images_Source/what-is-mvc-design-pattern_cleanup.jpg "MVC")  
  
### -Consequences  

The use of the State Pattern in the current design allows the following benefits:  

• Modification Don’t Affect The Entire Model  
• Faster Development Process  
• Faster Development Process  
  
  
# 2.  
##  DESIGN

### Problem in Context:  
We needed to use the same methods in different states, both of the game and the menu, needing them to be using the same structure of algorithm.  

  
### -The Pattern  
TEMPLATE PATTERN is used to define an algorithm as a skeleton of operations and leave the details to be implemented by the classes that use it. The overall structure and sequence of the algorithm are preserved by the core skeleton.  


### -Implementation  
![Template Pattern](/Images_Source/LDTS_4.png "Template Pattern")  
   
### -Consequences  
• Alows for the possibility to reuse the same algorithm in different instances of the program making only slight changes to fit the context in which we needed it. 
  
  
# 3.  
##  DESIGN

### Problem in Context:  
As we thought in the beginning of the project, we will try to have different states, such as game state, menu state and controls menu state.

  
### -The Pattern  
The second pattern we decided to use was the STATE PATTERN. This is a behavioral design pattern that lets an object alter its behavior depending on its state.    
  
### -Implementation  
We haven't implemented it yet but it will be used in order to make allow us to have multiple menus, also not implemented in the UML diagram.
   
### -Consequences  
• A better organization of the different screen the player will be seeing, providing an easier way of modifying a view (screen) if needed  
• Single Responsibility Principle. The code related to each state are in separate classes   
• Open/Closed Principle. We can introduce new states without changing existing state classes  
  
  
# 4.  
##  DESIGN

### Problem in Context:  
For us to design different objects in our game that had very similar characteristics we needed a way to create new ones that share those same characteristics.

  
### -The Pattern  
We used the FACTORY PATTERN, which is a creational design pattern that provides an interface to create objects in a superclass, so that subclasses can alter the characteristics of the new object.
  
### -Implementation  
   ![Factory Pattern](/Images_Source/factory.png "Factory Pattern")  
   
  
### -Consequences  
• It is now much easier to add different objects or elements to the game, for example, add new food, using the same characteristics as the previous ones.  
  
    
# DATA CLASS  
  
 ## UML DIAGRAM:  
 ![UML](/Images_Source/UML.png "UML")  
 Current UML state with exception of the class food that isn't implemented yet.  


  
  
# TESTING  
Not yet implemented.  
(…)  
  

# SELF-EVALUATION  
  Cristiano Rocha up202108813 100%  
  Rui Carvalho up202108807 100%  
  Guilherme Ribeiro up202108731 100%  
