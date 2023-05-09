import java.util.Random;

class Apple {
    static int AppleX;
    static int AppleY;

    static Random random;

    static void Appear() {
        if (random == null) random = new Random();
        AppleX = random.nextInt(GameProperties.NO_UNITS_WIDTH + 1) * GameProperties.UNIT_SIZE;
        AppleY = random.nextInt(GameProperties.NO_UNITS_HEIGHT + 1) * GameProperties.UNIT_SIZE;
    }

    static void AppleEaten() {
        if ((Snake.x[0] == AppleX) && (Snake.y[0] == AppleY)) {
            Snake.Body_parts += 2;
            Appear();
        }
    }
}
