import java.util.Observable;

public class ModelGrille extends Observable {
    private boolean[][] grille;

    public ModelGrille() {
        grille = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            for (int y = 0; y < 5; y++) {
                grille[i][y] = false;
            }
        }
    }

    public boolean getEtat(int i, int y) {
        boolean res = true;
        if (((i <= 5) && (i >= 0)) || ((y <= 5) && (y >= 0))) {
            res = grille[i][y];
        }
        return res;
    }

    public void setEtat(int i, int y) {
        if ((i<5 && i>=0)&&(y<5 && y>=0)) {
            grille[i][y] = !grille[i][y];
            setChanged();
            notifyObservers();
        }
    }

    public void randomGrille() {
        for (int i = 0; i < 7; i++) {
            int x = (int) (Math.random() * 5);
            int y = (int) (Math.random() * 5);
            this.setEtat(x, y);
        }
    }

    public boolean finDeJeu() {
        boolean res = true;
        int i = 0;
        int y = 0;
        while ((res == true) && (i<5) && (y<5)){
            if(getEtat(i,y)==false){
                res=false;
            }else {
                i++;
                y++;
            }
        }
        return res;
    }

}
