**Snake Game**
This is a Snake game implemented using object-oriented programming (OOP) in Java. The game consists of four classes: App, Game, Graphic, and Food.

**How to Play**
Compile and run the SnakeGame.java file to start the game.
Use the arrow keys (up, down, left, right) to control the movement of the snake.
The objective is to eat the food (represented by a dot) that appears randomly on the screen.
Each time the snake eats the food, it grows longer.
The game ends if the snake collides with the boundary of the screen or with itself.
**Classes**

**App Class**
The App class is responsible for initializing the game window and handling user input. It creates an instance of the Game class and updates the game state.

**Methods**
main(String[] args): The entry point of the game. Creates an instance of the App class and calls the run() method.

run(): Runs the game loop and updates the game state.

**Game Class**
The Game class manages the game logic and state. It handles the movement of the snake, collision detection, and updating the score.

**Attributes**
width: Width of the game window.
height: Height of the game window.
snake: Instance of the Graphic class representing the snake.
food: Instance of the Food class representing the food.
score: Current score of the player.

**Methods**
init(): Initializes the game window with the specified width and height.
update(): Updates the game state, including the movement of the snake and checking for collisions.
draw(Graphics g): Draws the current game state on the screen.
Graphic Class
The Graphic class represents the snake in the game. It keeps track of the snake's position, size, and movement.

**Attributes**
x: X-coordinate of the snake's head.
y: Y-coordinate of the snake's head.
size: Size of the snake.
direction: Current direction of the snake's movement.

**Methods**
move(): Moves the snake in the current direction.
changeDirection(int newDirection): Changes the direction of the snake's movement.
Food Class
The Food class represents the food that the snake needs to eat. It appears randomly on the screen and is consumed by the snake.

**Attributes**
x: X-coordinate of the food.
y: Y-coordinate of the food.

**Methods**
generateNewFood(int width, int height): Generates a new food at a random position on the screen.
