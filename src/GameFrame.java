import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

//Setup the frame for the game, use default access
class GameFrame extends JFrame implements ActionListener{

    GamePanel game_panel;
    StartMenu start_menu;

    CardLayout card;

    GameFrame() {
        start_menu = new StartMenu();
        start_menu.start_button.addActionListener(this);
        start_menu.quit_button.addActionListener(this);

        game_panel = new GamePanel();

        card = new CardLayout();
        this.setLayout(card);

        this.add("a", start_menu);
        this.add("b", game_panel);
        
        this.setTitle("Snake Eater in Java");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();        
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start_menu.start_button) {
            card.show(this.getContentPane(), "b");
            game_panel.StartGame();
        }
        else if (e.getSource() == start_menu.quit_button) {
            this.dispose();
        }
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
