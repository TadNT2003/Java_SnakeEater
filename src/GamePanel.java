import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

// Handle running the game, user's control and action handler
class GamePanel extends JPanel{
 
    
    // Setup key binding
    Action up_action;
    Action down_action;
    Action right_action;
    Action left_action;

    // Setup background and size for the game, initialize action for key binding
    GamePanel() {
        this.setPreferredSize(new Dimension(GameProperties.GAME_PANEL_WIDTH, GameProperties.GAME_PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);

        up_action = new UpAction();
        down_action = new DownAction();
        right_action = new RightAction();
        left_action = new LeftAction();
    }

    // Procedure for painting components on the Panel properly
    // Inherite from JPanel so public access modifilers
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    // Draw all the components (aka Snake, Apple, grid,...) onto the Panel
    private void draw(Graphics g) {
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

    // Handle user's key control
    class UpAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Snake.direction != 'D') Snake.direction = 'U';
        }

    }
    class DownAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Snake.direction != 'U') Snake.direction = 'D';
        }
        
    }
    class RightAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Snake.direction != 'L') Snake.direction = 'R';
        }
        
    }
    class LeftAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Snake.direction != 'R') Snake.direction = 'L';
        }
        
    }
}
