import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControleurGrille implements MouseListener {
    private ModelGrille grille;

    public ControleurGrille (ModelGrille m)
    {
        this.grille=m;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (ControleurCommande.mode==1){
            this.grille.setEtat(e.getX()/Grille.T, e.getY()/Grille.T);
            this.grille.setEtat((e.getX()/Grille.T)+1, e.getY()/Grille.T);
            this.grille.setEtat((e.getX()/Grille.T)-1, e.getY()/Grille.T);
            this.grille.setEtat(e.getX()/Grille.T, (e.getY()/Grille.T)+1);
            this.grille.setEtat(e.getX()/Grille.T, (e.getY()/Grille.T)-1);
            Commande.nbr++;
        }
        if (ControleurCommande.mode==0){
            this.grille.setEtat(e.getX()/Grille.T, e.getY()/Grille.T);
        }



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

}
