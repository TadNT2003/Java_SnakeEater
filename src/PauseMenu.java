import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// Pause menu setting
class PauseMenu extends JFrame{
    JLabel pause_message;

    JButton menu_button;
    JButton continue_button;

    PauseMenu() {
        // Pause menu layout
        this.setLayout(null);
        this.setSize(new Dimension(400, 375));

        // Setup menu button
        menu_button = new JButton("Menu");
        menu_button.setPreferredSize(new Dimension(200, 100));
        menu_button.setBounds(100, 75, 200, 100);
        
        // Setup continue button
        continue_button = new JButton("Continue");
        continue_button.setPreferredSize(new Dimension(100, 50));
        continue_button.setBounds(100, 200, 200, 100);

        this.add(menu_button);
        this.add(continue_button);

        this.setVisible(false);
        this.setLocationRelativeTo(null);
    }
    
}
