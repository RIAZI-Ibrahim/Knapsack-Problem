package SolutionBranchAndBound;

import java.util.ArrayList;
import java.util.Collections;


public class RelaxationFractionnaire {

    private static int[] solution = new int[Main.nombreObjets];

    public static void init() {
        ArrayList<Objet> listeObjets = new ArrayList<>(Main.objetsDisponibles);
        Collections.sort(listeObjets);
        for (int i = 0; i < listeObjets.size(); i++) solution[i] = listeObjets.get(i).getIndex();
    }

    public static double calculMaxValue(Noeud node) {
        Noeud nodeClone = new Noeud(node);
        for (int object : solution)
            if (object >= nodeClone.getIndex())
                if (!nodeClone.getSac().addObjet(object))
                    return nodeClone.getValue() + getFraction(nodeClone, object);
        return nodeClone.getValue();
    }

    private static double getFraction(Noeud node, int indexObjet) {
        Objet objet = Main.objetsDisponibles.get(indexObjet);
        double poidsRestant = Main.poidsMax - node.getWeight();
        return objet.getValue() * poidsRestant / objet.getPoids();
    }
}
