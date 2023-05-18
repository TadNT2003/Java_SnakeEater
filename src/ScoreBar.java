import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// Setup game screen contains score bar and game panel
class ScoreBar extends JPanel{
    JPanel score_panel;
    JButton pause_button;
    JTextArea score_text;

    GamePanel game_panel;

    ScoreBar() {
        this.setLayout(new BorderLayout());

        game_panel = new GamePanel();

        // Score bar
        score_panel = new JPanel();
        score_panel.setPreferredSize(new Dimension(GameProperties.GAME_PANEL_WIDTH, GameProperties.SCORE_BAR_HEIGHT));
        score_panel.setLayout(null);

        // Pause button for the game
        pause_button = new JButton("Pause");
        pause_button.setPreferredSize(new Dimension(GameProperties.PAUSE_BUTTON_SIZE, GameProperties.PAUSE_BUTTON_SIZE));
        pause_button.setBounds(10, 10, 80, 30);
        score_panel.add(pause_button);

        // Score text
        score_text = new JTextArea("Score "+GameProperties.score);
        score_text.setBackground(Color.black);
        score_text.setForeground(Color.green);
        score_text.setFont(new Font("Serif", Font.BOLD, 20));
        score_text.setBounds(GameProperties.GAME_PANEL_WIDTH - 100, 10, 90, 30);
        score_panel.add(score_text);

        // Setup game screen properties
        this.setPreferredSize(new Dimension(GameProperties.GAME_PANEL_WIDTH, GameProperties.GAME_PANEL_HEIGHT + GameProperties.SCORE_BAR_HEIGHT));
        this.add(score_panel, BorderLayout.NORTH);
        this.add(game_panel, BorderLayout.SOUTH);
    }

    
}
