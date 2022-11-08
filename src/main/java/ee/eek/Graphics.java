package ee.eek;


import javax.swing.Timer;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Graphics extends JPanel implements ActionListener {

    static final int WIDTH = 700;
    static final int HEIGHT = 600;
    static final int UNIT_SIZE = 50;
    static final int BOARD_SIZE = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);

    private final Font font = new Font("TimesRoman", Font.BOLD, 30);

    private int[] snakePosX = new int[BOARD_SIZE];  // x coordinate of snake
    private int[] snakePosY = new int[BOARD_SIZE];  // y coordinate of snake
    private int snakeLength;

    private Food food;
    private int foodEaten;

    private char direction = 'R';    //Initially snake moves in right direction
    private boolean isMoving = false;
    private final Timer timer = new Timer(150, this); //delay of time for mov
    // Lower the number, faster the snake moves

    public Graphics() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);  // initially the window is at centre
        this.addKeyListener(new KeyAdapter() {  //Anonymous method
            @Override
            public void keyPressed(KeyEvent e) {
                if (isMoving) {  //Snake keeps moving if no key is pressed
                    switch (e.getKeyCode()) { // Snake change direction on pressing a key
                        case KeyEvent.VK_LEFT:
                            if (direction != 'R') {   //Limit the user to go only 90 degree
                                direction = 'L';
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (direction != 'L') {
                                direction = 'R';
                            }
                            break;
                        case KeyEvent.VK_UP:
                            if (direction != 'D') {
                                direction = 'U';
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            if (direction != 'U') {
                                direction = 'D';
                            }
                            break;
                    }
                } else {
                    start();
                }
            }
        });
        start();
    }

    @Override
    public final void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        if (isMoving) {
            g.setColor(Color.BLUE);       //Color of food
            g.fillOval(food.getPosX(), food.getPosY(), UNIT_SIZE, UNIT_SIZE);

            g.setColor(Color.DARK_GRAY);  //Color of Snake
            for (int i = 0; i < snakeLength; i++) {
                g.fillRect(snakePosX[i], snakePosY[i], UNIT_SIZE, UNIT_SIZE);
            }
        } else {
            String scoreText = String.format("The End... Score: %d... Press any key to play again!", foodEaten);
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString(scoreText, (WIDTH - getFontMetrics(g.getFont()).stringWidth(scoreText)) / 2, HEIGHT / 2);
        }
    }

    private void start() {
        snakePosX = new int[BOARD_SIZE];
        snakePosY = new int[BOARD_SIZE];
        snakeLength = 5;    // size of snake
        foodEaten = 0;    // for score
        direction = 'R';
        isMoving = true;   // Snake is moving initially
        spawnFood();       // spawn a food
        timer.start();     //
    }

    private void move() {
        for (int i = snakeLength; i > 0; i--) {
            snakePosX[i] = snakePosX[i - 1];
            snakePosY[i] = snakePosY[i - 1];
        }

        switch (direction) {
            case 'U' -> {
                snakePosY[0] -= UNIT_SIZE; }
            case 'D' -> {
                snakePosY[0] += UNIT_SIZE; }
            case 'L' -> {
                snakePosX[0] -= UNIT_SIZE; }
            case 'R' -> {
                snakePosX[0] += UNIT_SIZE; }
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    private void spawnFood() {
        food = new Food();
    }

    private void eatFood() {
        if (snakePosX[0] == food.getPosX() && snakePosY[0] == food.getPosY()) {
            snakeLength++;
            foodEaten++;
            spawnFood();
        }
    }

    private void collisionTest() {
        for (int i = snakeLength; i > 0; i--) {   //Check if head of snake touches it body part
            if (snakePosX[0] == snakePosX[i] && snakePosY[0] == snakePosY[i]) {
                isMoving = false; // snakePosX[0] = x coordinate of head of the snake
                break;
            }
        }

        if (snakePosX[0] < 0 || snakePosX[0] > WIDTH - UNIT_SIZE
                || snakePosY[0] < 0 || snakePosY[0] > HEIGHT - UNIT_SIZE) {
            isMoving = false;  // Collision with walls
        }

        if (!isMoving) {
            timer.stop();
        }
    }

    @Override
    public final void actionPerformed(ActionEvent e) {
        if (isMoving) {
            move();
            collisionTest();
            eatFood();
        }

        repaint();
    }
}
