import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener{

    GamePanel() {
        this.setPreferredSize(new Dimension(900, 900));
        this.setBackground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
