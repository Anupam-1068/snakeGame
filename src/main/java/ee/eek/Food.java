package ee.eek;

import java.util.Random;

public final class Food {

    private final int posX;
    private final int posY;

    public Food() {
        posX = generatePos(Graphics.WIDTH); // for x coordinate we need width
        posY = generatePos(Graphics.HEIGHT); // for y coordinate we need height
    }

    private int generatePos(int size) {
        Random random = new Random(); // Generate a random food location
        return random.nextInt(size / Graphics.UNIT_SIZE) * Graphics.UNIT_SIZE;
        // size = width and then height when method is called
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

}
