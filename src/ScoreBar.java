import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// Setup game screen contains score bar and game panel
class ScoreBar extends JPanel{
    // Components for score bar
    JPanel score_panel;
    JButton pause_button;
    JTextArea score_text;
    PauseAction pause_game;

    // Game panel
    GamePanel game_panel;

    // Default score is 0
    Integer score;

    ScoreBar() {
        this.setLayout(new BorderLayout());

        game_panel = new GamePanel();

        // Score bar
        score_panel = new JPanel();
        score_panel.setPreferredSize(new Dimension(GameProperties.GAME_PANEL_WIDTH, GameProperties.SCORE_BAR_HEIGHT));
        score_panel.setLayout(null);

        // Pause button for the game
        pause_button = new JButton("Pause");
        pause_button.setPreferredSize(new Dimension(GameProperties.SCORE_BAR_COMPONENTS_HEIGHT, GameProperties.PAUSE_BUTTON_WIDTH));
        pause_button.setBounds(GameProperties.COMPONENTS_SPACING_FROM_BORDER, GameProperties.COMPONENTS_SPACING_FROM_BORDER
            , GameProperties.PAUSE_BUTTON_WIDTH, GameProperties.SCORE_BAR_COMPONENTS_HEIGHT);

        // Pause action
        pause_game = new PauseAction();
        pause_button.addActionListener(pause_game);
        score_panel.add(pause_button);

        // Score text
        score_text = new JTextArea();
        score_text.setBackground(Color.black);
        score_text.setForeground(Color.green);
        score_text.setFont(new Font("Serif", Font.BOLD, 20));
        score_text.setPreferredSize(new Dimension(GameProperties.SCORE_FIELD_WIDTH, GameProperties.SCORE_BAR_COMPONENTS_HEIGHT));
        score_text.setBounds(GameProperties.GAME_PANEL_WIDTH - GameProperties.COMPONENTS_SPACING_FROM_BORDER - GameProperties.SCORE_FIELD_WIDTH
            , GameProperties.COMPONENTS_SPACING_FROM_BORDER, GameProperties.SCORE_FIELD_WIDTH, GameProperties.SCORE_BAR_COMPONENTS_HEIGHT);
        score_panel.add(score_text);

        // Setup game screen properties
        this.setPreferredSize(new Dimension(GameProperties.GAME_PANEL_WIDTH, GameProperties.GAME_PANEL_HEIGHT + GameProperties.SCORE_BAR_HEIGHT));
        this.add(score_panel, BorderLayout.NORTH);
        this.add(game_panel, BorderLayout.SOUTH);
    }

    // For pausing the game
    class PauseAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            pause_button.setEnabled(false);
            GameProperties.isRunning = false;
        }
    }

}
