// Because only one Snake in the game, so the entire class presents the inctances, hence the static keywords
public class Snake {
    // Snake's attributes
    static int x[] = new int[GameProperties.NO_UNITS_TOTAL];
    static int y[] = new int[GameProperties.NO_UNITS_TOTAL];
    static int Body_parts = 6;
    static char direction = 'R';

    // Actraction the move of the Snake
    static public void move() {
        // Countinue to move the body to the previous direction
        for (int i = Body_parts; i>0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        // Change the direction of the head
        switch(direction) {
            case 'R':
                x[0] += GameProperties.UNIT_SIZE;
                break;
            case 'L':
                x[0] -= GameProperties.UNIT_SIZE;
                break;
            case 'U':
                y[0] -= GameProperties.UNIT_SIZE;
                break;
            case 'D':
                y[0] += GameProperties.UNIT_SIZE;
                break;
        }

    }
}
