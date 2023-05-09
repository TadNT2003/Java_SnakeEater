import javax.swing.JFrame;

//Setup the frame for the game, use default access
class GameFrame extends JFrame {

    GameFrame() {
        this.add(new GamePanel());
        
        this.setTitle("Snake Eater in Java");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();        
        this.setLocationRelativeTo(null);
    }
}
