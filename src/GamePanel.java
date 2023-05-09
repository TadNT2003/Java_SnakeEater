import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

// Handle the game graphics, draw components, user's control
public class GamePanel extends JPanel implements ActionListener{

    // Game timer
    Timer timer;
    

    // Setup background and size for the game, call StartGame
    GamePanel() {
        this.setPreferredSize(new Dimension(GameProperties.GAME_PANEL_WIDTH, GameProperties.GAME_PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        StartGame();
    }

    // Start game process
    private void StartGame() {
        // Set initial position of Snake (center)
        Snake.y[0] = Math.round(GameProperties.NO_UNITS_HEIGHT/2 * GameProperties.UNIT_SIZE);

        // Set game running and game timer
        GameProperties.isRunning = true;
        timer = new Timer(GameProperties.DELAY, this);
        timer.start();
    }

    // Procedure for painting components on the Panel properly
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

        // Draw the Snake's head
        g.setColor(new Color(45, 180, 0));
        g.fillRect(Snake.x[0], Snake.y[0], GameProperties.UNIT_SIZE, GameProperties.UNIT_SIZE);
        // Draw the Snake's body
        for (int i = 1; i < Snake.Body_parts; i++) {
            g.setColor(Color.green);
            g.fillRect(Snake.x[i], Snake.y[i], GameProperties.UNIT_SIZE, GameProperties.UNIT_SIZE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (GameProperties.isRunning) {
                Snake.move();
            }
            repaint();
        }
        catch (Exception error) {
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
    }

    // Handle user's key control
    private class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    if (Snake.direction != 'L') Snake.direction = 'R';
                    break;
                case KeyEvent.VK_LEFT:
                    if (Snake.direction != 'R') Snake.direction = 'L';
                    break;
                case KeyEvent.VK_UP:
                    if (Snake.direction != 'D') Snake.direction = 'U';
                    break;
                case KeyEvent.VK_DOWN:
                    if (Snake.direction != 'U') Snake.direction = 'D';
                    break; 
            }
        }
    }
    
}
