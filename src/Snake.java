// Because only one Snake in the game, so the entire class presents the inctances, hence the static keywords
// Use default access
class Snake {
    // Snake's attributes
    static int x[] = new int[GameProperties.NO_UNITS_TOTAL];
    static int y[] = new int[GameProperties.NO_UNITS_TOTAL];
    static int Body_parts;
    static char direction;

    // Actraction the move of the Snake
    static void move() {
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

    // Check wall and body collision
    static void CheckCollision() {
        if (x[0] < 0) x[0] = GameProperties.GAME_PANEL_WIDTH - GameProperties.UNIT_SIZE;
        else if (x[0] >= GameProperties.GAME_PANEL_WIDTH) x[0] = 0;
        if (y[0] < 0) y[0] = GameProperties.GAME_PANEL_HEIGHT - GameProperties.UNIT_SIZE;
        else if (y[0] >= GameProperties.GAME_PANEL_HEIGHT) y[0] = 0;

        for (int i = 1; i < Body_parts; i++) {
            if ((x[i] == x[0]) && (y[i] == y[0])) {
                GameProperties.isCollision = true;
                break;
            }
        }
    }
}
