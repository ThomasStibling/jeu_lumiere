import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Commande extends JPanel implements Observer {

    public static int nbr;
    private ModelGrille grille;
    JButton config;
    JButton alea;
    JButton jou;
    JButton quitter;
    JLabel dep;

    public Commande(ModelGrille m) {
        this.grille = m;
        JPanel gauche = new JPanel();

        this.nbr = 0;
        this.setLayout(new BorderLayout());

        // création des elements dans le JPannel gauche
        this.config = new JButton("configurer");
        this.alea = new JButton("aleatoire");
        this.jou = new JButton("jouer");
        this.dep = new JLabel();
        this.quitter = new JButton("quitter");

        // mise en place des elecements en flowlayout et définitions des tailles
        this.config.setPreferredSize(new Dimension(150, 40));
        this.alea.setPreferredSize(new Dimension(150, 40));
        jou.setPreferredSize(new Dimension(150, 40));
        dep.setPreferredSize(new Dimension(160, 40));
        quitter.setPreferredSize(new Dimension(150, 40));

        // ajout bouton dans le JPannel
        gauche.add(config);
        gauche.add(alea);
        gauche.add(jou);
        gauche.add(dep);
        gauche.add(quitter);

        gauche.setPreferredSize(new Dimension(190, 190));
        ControleurCommande cj = new ControleurCommande(this, grille);

        quitter.addActionListener(cj);
        alea.addActionListener(cj);
        config.addActionListener(cj);
        jou.addActionListener(cj);

        this.add(gauche);

    }

    @Override
    public void update(Observable o, Object arg) {
        this.dep.setText("    déplacement : " + nbr);
    }

}
