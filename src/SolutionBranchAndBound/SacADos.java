package SolutionBranchAndBound;

import java.util.ArrayList;
import java.util.Arrays;

public class SacADos {

    private boolean[] contenu;

    public SacADos() {
        this.contenu = new boolean[Main.nombreObjets];
        Arrays.fill(contenu, false);
    }

    public SacADos(boolean[] contenu) {
        this.contenu = contenu;
    }

    public boolean addObjet(int index) {
        double nouveauPoids = getPoidsTotal() + Main.objetsDisponibles.get(index).getPoids();
        contenu[index] = nouveauPoids <= Main.poidsMax;
        return contenu[index];
    }

    public int getPoidsTotal() {
        int total_weight = 0;
        for (int i = 0; i < contenu.length; i++)
            if (contenu[i]) total_weight += Main.objetsDisponibles.get(i).getPoids();
        return total_weight;
    }

    public int getValeurTotale() {
        int valeurTotale = 0;
        for (int i = 0; i < contenu.length; i++)
            if (contenu[i]) valeurTotale += Main.objetsDisponibles.get(i).getValue();
        return valeurTotale;
    }

    public ArrayList<Integer> getContenuObjets() {
        ArrayList<Integer> indexObjets = new ArrayList<>();
        for (int i = 0; i < contenu.length; i++)
            if (contenu[i]) indexObjets.add(Main.objetsDisponibles.get(i).getIndex());
        return indexObjets;
    }

    @Override
    public String toString() {
        return "Sac à dos (capacité maximale " + Main.poidsMax + "):" +
            "\n-> poids total:  " + getPoidsTotal() +
            "\n-> valeur total: " + getValeurTotale() +
            "\n-> objets contenus: " + getContenuObjets();
    }

    public boolean[] getContenu() { return contenu; }
}
