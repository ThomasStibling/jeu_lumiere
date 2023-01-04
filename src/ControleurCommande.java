import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ControleurCommande implements ActionListener {

    private Commande cmd;
    private ModelGrille grille;
    public static int mode;

    public ControleurCommande(Commande com, ModelGrille g) {
        this.cmd = com;
        this.grille = g;
    }

    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getText().equals("quitter")) {
            Principale.FENETRE.dispose();
        }
        if (((JButton) e.getSource()).getText().equals("aleatoire")) {
            this.grille.randomGrille();
        }
        if (((JButton) e.getSource()).getText().equals("configurer")) {
            this.cmd.alea.setEnabled(false);
            this.mode=0;
        }
        if (((JButton) e.getSource()).getText().equals("jouer")) {
            this.cmd.alea.setEnabled(false);
            this.cmd.config.setEnabled(false);
            this.mode=1;
        }

    }

}
