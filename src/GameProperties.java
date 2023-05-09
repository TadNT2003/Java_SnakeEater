public class GameProperties {
    // Game constant attributes
    static final int GAME_PANEL_WIDTH = 1200;
    static final int GAME_PANEL_HEIGHT = 750;
    static final int UNIT_SIZE = 25;
    static final int NO_UNITS_WIDTH = GAME_PANEL_WIDTH/UNIT_SIZE;
    static final int NO_UNITS_HEIGHT = GAME_PANEL_HEIGHT/UNIT_SIZE;
    static final int NO_UNITS_TOTAL = NO_UNITS_WIDTH*NO_UNITS_HEIGHT;
    static final int DELAY = 100;

    // Game dynamic attributes
    static boolean isRunning = false;
}
