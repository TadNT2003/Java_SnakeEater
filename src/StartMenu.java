import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Setup the start menu for the game
class StartMenu extends JPanel{
    JButton start_button;
    JButton score_button;
    JButton quit_button;

    StartMenu() {
        // Set grid bag layout properties
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(30, 0, 70, 0);

        // Set background and size
        this.setPreferredSize(new Dimension(GameProperties.GAME_PANEL_WIDTH, GameProperties.GAME_PANEL_HEIGHT));
        this.setBackground(Color.black);

        // Add game name
        JLabel game_name = new JLabel("Snake Eater");
        game_name.setFont(new Font("Serif", Font.BOLD, 70));
        game_name.setForeground(Color.green);
        
        // Add each buttons
        start_button = new JButton("Start");
        start_button.setPreferredSize(new Dimension(GameProperties.BUTTON_WIDTH, GameProperties.BUTTON_HEIGHT));

        score_button = new JButton("Score");
        score_button.setPreferredSize(new Dimension(GameProperties.BUTTON_WIDTH, GameProperties.BUTTON_HEIGHT));

        quit_button = new JButton("Quit");
        quit_button.setPreferredSize(new Dimension(GameProperties.BUTTON_WIDTH, GameProperties.BUTTON_HEIGHT));

        // Configure grid bag layout setting
        this.add(game_name, gbc);
        gbc.insets = new Insets(5, 0, 5, 0);
        this.add(start_button, gbc);
        this.add(score_button, gbc);
        this.add(quit_button, gbc);
    }
}
