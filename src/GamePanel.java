import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener{

    GamePanel() {
        this.setPreferredSize(new Dimension(GameProperties.GAME_PANEL_WIDTH, GameProperties.GAME_PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
