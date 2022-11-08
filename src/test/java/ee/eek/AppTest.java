package ee.eek;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@Test
//public void aSnakeIs5UnitsLongByDefault() {
//        assertEquals("Hello".length(), 5);
//        Graphics graphics = new Graphics();
//        int length = graphics.snakeLength;
//        assertEquals(5, length);
//        }
//@Test
//public void aSnakeIsMovingRightByDefault() {
//        Graphics graphics = new Graphics();
//        char direction = graphics.direction;
//        assertEquals('R', direction);
//        }

public class AppTest {

    int WIDTH = 700;
    int HEIGHT = 600;
    int UNIT_SIZE = 50;
    int BOARD_SIZE = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    int MIN_SNAKE_LENGTH = 5;
    char START_DIRECTION = 'R';
    Graphics graphics = new Graphics();


    @Test
    public void testSnakeWillHitWall() {

    }

    @Test
    /*
     * Tests whether the game will end when snake hits the wall Part of this
     * code is directly copied from the GameLogic code that tests whether the
     * game has ended
     */
    public void testGameWillEndHitWall() {

    }

    /*
     * Tests whether the game will end when snake eats itself Part of this code
     * is directly copied from the GameLogic code that tests whether the game
     * has ended
     */
    @Test
    public void testGameWillEndEatBody() {

    }

    @Test
    public void testMoveSnake() {

        }

        // moves the objects on the board to the next location
        // directly copied from GameLogic
//        for (int i = snakeToMove.size() - 1; i >= 0; i--) {
//            Snake s = snakeToMove.get(i);
//            s.move();
//            snakeToMove.set(i, s);
//        }
//
//        // updates the board
//        board.resetBoard();
//        for (int i = snakeToMove.size() - 1; i >= 0; i--) {
//            Snake s = snakeToMove.get(i);
//            board.setObject(s);
//        }
//
//        boolean moves = false;
//        for (int i = 0; i < snake.size(); i++) {
//            int x = (int) snake.get(i).nextLocation().getX();
//            int y = (int) snake.get(i).nextLocation().getY();
//            moves = board.getObject(x, y).equals(snakeToMove.get(i));
//        }
//
//        assertTrue("snake moves properly", moves);
//    }

    @Test
    public void testEatFood() {

        }

    }