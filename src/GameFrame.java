import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

// Setup the frame for the game, use default access
class GameFrame extends JFrame implements ActionListener{

    StartMenu start_menu;
    ScoreBar game_screen;
    //GamePanel game_screen;

    CardLayout card;

    GameFrame() {
        // Setup start menu
        start_menu = new StartMenu();
        start_menu.start_button.addActionListener(this);
        start_menu.quit_button.addActionListener(this);

        // Setup game screen
        game_screen = new ScoreBar();
        //game_screen = new GamePanel();

        // Setup card layout
        card = new CardLayout();
        this.setLayout(card);

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

    // Action perform when click button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start_menu.start_button) {
            card.show(this.getContentPane(), "b");
            game_screen.game_panel.StartGame();
        }
        else if (e.getSource() == start_menu.quit_button) {
            this.dispose();
        }
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
