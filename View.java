import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class View extends JComponent {
    private Partie partie;
    private final static int LENGTH = 150;
    public View(Partie m){
        super();
        this.partie = m;
        setOpaque(true);
        setSize(LENGTH*3 + 10, LENGTH*3 + 10);
        this.partie = partie;
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                partie.update(e.getY(), e.getX());
                repaint();
                System.out.println(e.getX());
                partie.showPlateau();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
        
            }
            
        });
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, LENGTH*3, LENGTH*3);
        drawPlateau(g);
        drawCase(g);
        
    }

    public void drawPlateau(Graphics g){
        g.setColor(Color.BLACK);
        for(int i = 0 ; i < 3; i++){
            g.drawLine(i * LENGTH, 0, i * LENGTH, 3* LENGTH);
            
        }
        for(int i = 0 ; i < 3; i++){
            g.drawLine(0, i * LENGTH, 3* LENGTH, i * LENGTH);
            
        }
    }
    public void drawCase(Graphics g){
        for(int y = 0 ; y < 3; y++){
            for (int x = 0; x < 3; x++){
                if(this.partie.isCross(y,x)){
                    g.setColor(Color.RED);
                    g.drawLine(x*LENGTH+ 20, y*LENGTH +20, (x+1)*LENGTH -20, (y+1)*LENGTH -20);
                    g.drawLine(x*LENGTH +20, (y+1)*LENGTH -20, (x+1)*LENGTH -20, y*LENGTH +20);
                }
                if(this.partie.isCircle(y,x)){
                    g.setColor(new Color(0, 0, 255));
                    g.drawOval(x*LENGTH +10, y*LENGTH +10, 110, 110);
                }
            }
            
            
        }
        
    }


}
