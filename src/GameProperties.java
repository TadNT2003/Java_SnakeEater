// Use default access
class GameProperties {
    
    // Game constant attributes
    static final int GAME_PANEL_WIDTH = 800;
    static final int GAME_PANEL_HEIGHT = 600;
    static final int UNIT_SIZE = 20;
    static final int DELAY = 100;
    static final int BUTTON_WIDTH = 200;
    static final int BUTTON_HEIGHT = 90;
    static final int SCORE_BAR_HEIGHT = 50;

    static final int NO_UNITS_WIDTH = GAME_PANEL_WIDTH/UNIT_SIZE;
    static final int NO_UNITS_HEIGHT = GAME_PANEL_HEIGHT/UNIT_SIZE;
    static final int NO_UNITS_TOTAL = NO_UNITS_WIDTH*NO_UNITS_HEIGHT;
    static final int PAUSE_BUTTON_SIZE = SCORE_BAR_HEIGHT*4/5;

    // Game dynamic attributes
    static boolean isRunning = false;
    static Integer score = 0;
}
