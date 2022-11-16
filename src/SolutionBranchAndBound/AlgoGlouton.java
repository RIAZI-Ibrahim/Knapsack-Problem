package SolutionBranchAndBound;

import java.util.ArrayList;
import java.util.Collections;

public class AlgoGlouton {

    public static Noeud run() {
        ArrayList<Objet> listeObjets = new ArrayList<>(Main.objetsDisponibles);
        for (Objet objet : listeObjets) objet.setRatio(objet.getValue() /objet.getPoids());
        Collections.sort(listeObjets);
        Noeud node = new Noeud(0);
        for (Objet object : listeObjets)
            node.getSac().addObjet(object.getIndex());
        return node;
    }
}
