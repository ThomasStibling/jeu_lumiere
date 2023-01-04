import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Grille extends JPanel implements Observer {

    public static final int T = 50;
    private ModelGrille mo;
    private ControleurGrille cg;

    public Grille(ModelGrille m, ControleurGrille cgc) {
        mo = m;
        this.cg = cgc;
        this.addMouseListener(cg);
    }

    public void paintComponent(Graphics arg0) {
        super.paintComponent(arg0);

        for (int i = 0; i < 5; i++) {
            for (int y = 0; y < 5; y++) {
                if (mo.getEtat(i, y)) {
                    arg0.setColor(new Color(70, 243, 0));

                } else {
                    arg0.setColor(new Color(35, 123, 0));

                }

                arg0.fillRect(i * T, y * T, T, T);
            }
        }

        arg0.setColor(Color.BLACK);
        for (int i = 0; i < 6; i++) {
            // horizontale
            arg0.drawLine(0, i * T, 5 * T, i * T);
            // verticale
            arg0.drawLine(i * T, 0, i * T, 5 * T);
        }


    }

    @Override
    public void update(Observable o, Object arg) {
        mo = (ModelGrille) (o);
        repaint();
        if(mo.finDeJeu()==true){
            this.removeMouseListener(cg);
        }
    }

}
