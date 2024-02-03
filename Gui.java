import javax.swing.JFrame;

public class Gui {
    private View view;

    public Gui(){
        Partie partie = new Partie();
        this.view = new View(partie);

        JFrame frame = new JFrame("Morpion");
        frame.setContentPane(view);
        frame.setSize(view.getSize());
        frame.setLocation(200, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
