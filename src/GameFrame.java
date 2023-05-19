import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.Timer;

// Setup the frame for the game, use default access
class GameFrame extends JFrame implements ActionListener{

    StartMenu start_menu;
    ScoreBar game_screen;

    PauseMenu pause_menu;

    // Game timer
    Timer timer;

    static CardLayout card;

    GameFrame() {
        // Set timer
        timer = new Timer(GameProperties.DELAY, new TimeAction());

        // Setup start menu
        start_menu = new StartMenu();
        start_menu.start_button.addActionListener(this);
        start_menu.quit_button.addActionListener(this);

        // Setup game screen
        game_screen = new ScoreBar();

        // Setup card layout
        card = new CardLayout();
        this.setLayout(card);

        // Setup pause menu
        pause_menu = new PauseMenu();
        pause_menu.menu_button.addActionListener(this);
        pause_menu.continue_button.addActionListener(this);

        // Add to card layout
        this.add("a", start_menu);
        this.add("b", game_screen);
        
        // Setup frame
        this.setTitle("Snake Eater in Java");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();        
        this.setLocationRelativeTo(null);
    }

    // Start game process
    void StartGame() {
        // Set initial properties of Snake (center)
        Snake.y[0] = Math.round(GameProperties.NO_UNITS_HEIGHT/2 * GameProperties.UNIT_SIZE);
        Snake.x[0] = 0;
        Snake.Body_parts = 6;
        for (int i = 1; i < GameProperties.NO_UNITS_TOTAL; i++) {
            Snake.x[i] = 0;
            Snake.y[i] = 0;
        }
        Snake.direction = 'R';
        // Reset score
        game_screen.score = 0;
        game_screen.score_text.setText(" Score: "+game_screen.score);
        // Enable pause button
        game_screen.pause_button.setEnabled(true);

        // Set input-action map for game panel
        game_screen.game_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "up_action");
        game_screen.game_panel.getActionMap().put("up_action", game_screen.game_panel.up_action);

        game_screen.game_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "down_action");
        game_screen.game_panel.getActionMap().put("down_action", game_screen.game_panel.down_action);

        game_screen.game_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right_action");
        game_screen.game_panel.getActionMap().put("right_action", game_screen.game_panel.right_action);

        game_screen.game_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left_action");
        game_screen.game_panel.getActionMap().put("left_action", game_screen.game_panel.left_action);

        // Set game running and game timer
        GameProperties.isRunning = true;
        Apple.Appear();
        timer.start();
    }

    // Action for timer to do
    class TimeAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if (GameProperties.isRunning) { // When the game is running
                    Snake.move();
                    Snake.CheckCollision();
                    Apple.AppleEaten();
                }
                else {  // When the game is paused
                    timer.stop();
                    pause_menu.setVisible(true);
                }
                if (GameProperties.isEaten) { // When the apple is eaten
                    game_screen.score += 1000;
                    game_screen.score_text.setText(" Score: "+game_screen.score);
                    GameProperties.isEaten = false;
                }
                repaint();
            }
            catch (Exception error) {
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }            
        }
        
    }

    // Action perform when click button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start_menu.start_button) {
            card.show(this.getContentPane(), "b");
            StartGame();
        }
        else if (e.getSource() == start_menu.quit_button) {
            this.dispose();
        }
        else if (e.getSource() == pause_menu.menu_button) {
            pause_menu.setVisible(false);
            card.show(this.getContentPane(), "a");
        }
        else if (e.getSource() == pause_menu.continue_button) {
            pause_menu.setVisible(false);
            timer.start();
            GameProperties.isRunning = true;
            game_screen.pause_button.setEnabled(true);
        }
    }
}
