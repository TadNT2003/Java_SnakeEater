import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GameOver extends JPanel{
    JButton menu_button;
    JButton try_again;
    JButton quit_button;

    GameOver() {
        // Set game over panel properties
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(30, 0, 70, 0);

        // Set background and size
        this.setPreferredSize(new Dimension(GameProperties.GAME_PANEL_WIDTH, GameProperties.GAME_PANEL_HEIGHT));
        this.setBackground(Color.black);

        // Add game name
        JLabel game_name = new JLabel("Game Over!");
        game_name.setFont(new Font("Serif", Font.BOLD, 70));
        game_name.setForeground(Color.green);
        
        // Add each buttons
        menu_button = new JButton("Menu");
        menu_button.setPreferredSize(new Dimension(GameProperties.BUTTON_WIDTH, GameProperties.BUTTON_HEIGHT));

        try_again = new JButton("Try again");
        try_again.setPreferredSize(new Dimension(GameProperties.BUTTON_WIDTH, GameProperties.BUTTON_HEIGHT));

        quit_button = new JButton("Quit");
        quit_button.setPreferredSize(new Dimension(GameProperties.BUTTON_WIDTH, GameProperties.BUTTON_HEIGHT));

        // Configure grid bag layout setting
        this.add(game_name, gbc);
        gbc.insets = new Insets(5, 0, 5, 0);
        this.add(try_again, gbc);
        this.add(menu_button, gbc);
        this.add(quit_button, gbc);
    }
}
