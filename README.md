## L03Gr08 - <PROJECT SnakeGameLDTS>

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
(IMAGE)  
  
   
  
    
  
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      

### -Consequences  

The use of the State Pattern in the current design allows the following benefits:  

• Modification Don’t Affect The Entire Model  
• Faster Development Process  
• Faster Development Process  





 


# DATA CLASS  
  
(IMAGE DO UML DE CLASSES)  
  
# TESTING  
Not yet implemented.  
(…)  
  

# SELF-EVALUATION
(…)
