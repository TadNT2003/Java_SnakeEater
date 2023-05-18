import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

// Handle running the game, user's control and action handler
public class GamePanel extends JPanel implements ActionListener{

    // Game timer
    Timer timer; 
    
    // Setup key binding
    Action up_action;
    Action down_action;
    Action right_action;
    Action left_action;

    // Setup background and size for the game, call StartGame
    GamePanel() {
        this.setPreferredSize(new Dimension(GameProperties.GAME_PANEL_WIDTH, GameProperties.GAME_PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);

        up_action = new UpAction();
        down_action = new DownAction();
        right_action = new RightAction();
        left_action = new LeftAction();

        // Initialize all elements of x, y to -1
    }

    // Start game process
    void StartGame() {
        // Set initial position of Snake (center)
        Snake.y[0] = Math.round(GameProperties.NO_UNITS_HEIGHT/2 * GameProperties.UNIT_SIZE);

        // Set input-action map
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "up_action");
        this.getActionMap().put("up_action", up_action);

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "down_action");
        this.getActionMap().put("down_action", down_action);

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right_action");
        this.getActionMap().put("right_action", right_action);

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left_action");
        this.getActionMap().put("left_action", left_action);

        // Set game running and game timer
        GameProperties.isRunning = true;
        Apple.Appear();
        timer = new Timer(GameProperties.DELAY, this);
        timer.start();

    }

    // Procedure for painting components on the Panel properly
    // Inherite from JPanel so public access modifilers
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    // Draw all the components (aka Snake, Apple, grid,...) onto the Panel
    private void draw(Graphics g) {
        // Draw grid along height
        for (int i = 0; i < GameProperties.NO_UNITS_WIDTH; i++){
            int i_alignment = i * GameProperties.UNIT_SIZE;
            g.drawLine(i_alignment, 0, i_alignment, GameProperties.GAME_PANEL_HEIGHT);
        }
        // Draw grid along width
        for (int j = 0; j < GameProperties.NO_UNITS_HEIGHT; j++) {
            int j_alignment = j * GameProperties.UNIT_SIZE;
            g.drawLine(0, j_alignment, GameProperties.GAME_PANEL_WIDTH, j_alignment);
        }

        // Draw the Apple
        g.setColor(Color.red);
        g.fillOval(Apple.AppleX, Apple.AppleY, GameProperties.UNIT_SIZE, GameProperties.UNIT_SIZE);

        // Draw the Snake's head
        g.setColor(Color.green);
        g.fillRect(Snake.x[0], Snake.y[0], GameProperties.UNIT_SIZE, GameProperties.UNIT_SIZE);
        // Draw the Snake's body
        for (int i = 1; i < Snake.Body_parts; i++) {
            g.setColor(new Color(90, 180, 50));
            g.fillRect(Snake.x[i], Snake.y[i], GameProperties.UNIT_SIZE, GameProperties.UNIT_SIZE);
        }
    }

    // Action for timer to perform
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (GameProperties.isRunning) {
                Snake.move();
                Snake.CheckCollision();
                Apple.AppleEaten();
            }
            repaint();
        }
        catch (Exception error) {
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
    }

    // Handle user's key control
    class UpAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Snake.direction != 'D') Snake.direction = 'U';
            //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }

    }
    class DownAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Snake.direction != 'U') Snake.direction = 'D';
            //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
        
    }
    class RightAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Snake.direction != 'L') Snake.direction = 'R';
            //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
        
    }
    class LeftAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Snake.direction != 'R') Snake.direction = 'L';
            //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
        
    }
}
