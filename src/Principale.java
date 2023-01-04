import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Principale {

    public static JFrame FENETRE;

    public static void main(String[] args) {
        FENETRE = new JFrame("jeu lumière");
        FENETRE.setSize(new Dimension(200, 200));
        FENETRE.setVisible(true);
        ModelGrille m = new ModelGrille();
        Commande cmd = new Commande(m);
        ControleurGrille c = new ControleurGrille (m);
        Grille droite = new Grille(m,c);
        m.addObserver(droite);
        m.addObserver(cmd);
        droite.setPreferredSize(new Dimension(250, 250));
        m.setEtat(0, 0);
        FENETRE.setLayout(new BorderLayout());
        FENETRE.add(cmd, BorderLayout.WEST);
        FENETRE.add(droite, BorderLayout.CENTER);
        FENETRE.pack();
        FENETRE.setResizable(false);


    }
}
