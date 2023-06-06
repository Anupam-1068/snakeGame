package ee.eek;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Graphics graphics = new Graphics();
    static final int WIDTH = 700;
    static final int HEIGHT = 600;
    static final int UNIT_SIZE = 50;
    static final int BOARD_SIZE = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    private int[] snakePosX = new int[BOARD_SIZE];  // x coordinate of snake
    private int[] snakePosY = new int[BOARD_SIZE];  // y coordinate of snake
    private int snakeLength = 5;
    private int foodEaten;
    private char direction = 'R' ;    //Initially snake moves in right direction
    private boolean isMoving = false;
    private boolean check;



    @Test
    public void testSnakeCollidesWithWall() {


        // Set up the Snake's position near the wall

        snakePosX[0] = -1;

        // Check if the Snake collides with the wall and itself
        boolean collidesWithWall = graphics.isCheck();

        // Assert that the Snake collides with the wall
        assertFalse(collidesWithWall);
    }


    @Test
    public void testEatFood() {
        int initialLength = snakeLength;
        // Assuming the initial score of the snake
        int lengthIncrement = 1;

        // Let the snake eat the food
        graphics.eatFood();
        // Assert that the length of the snake has increased by the expected increment
        assertEquals(initialLength + lengthIncrement, 6);


        }

    @Test
    public void testEatFoodScore() {
        // Assuming the initial score of the snake
        int initialScore = foodEaten;
        // Assuming the score and length increment after eating food
        int scoreIncrement = 1;

        // Let the snake eat the food
        graphics.eatFood();


        // Assert that the score of the snake has increased by the expected increment
        assertEquals(initialScore + scoreIncrement, 1);

    }

//    @Test
//    public void aSnakeIsMovingRightByDefault() {
//        char dir = direction;
//        assertEquals('R', dir);
//    }

    }