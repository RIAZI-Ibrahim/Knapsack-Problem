package SolutionBranchAndBound;

import java.util.TreeSet;

public class BranchAndBound {
    private static TreeSet<Noeud> arbreBinaire = new TreeSet<>();

    private static Noeud solution = new Noeud(0);

    public static Noeud run(Noeud node) {
        expand(solution);
        solution = node;
        Noeud next;
        while ((next = arbreBinaire.pollFirst()) != null) {
            if (next.getIndex() == Main.nombreObjets)
                if (getSolution(next)) continue;
                else break;
            expand(next);
        }
        return solution;
    }

    private static void expand(Noeud next_node) {
        Noeud left_node = new Noeud(next_node), right_node = new Noeud(next_node);
        if (isValid(left_node.addEmpty())) arbreBinaire.add(left_node);
        if (isValid(right_node.addObjet())) arbreBinaire.add(right_node);
    }
    private static boolean isValid(Noeud node) {
        return node.getValueMax() >= solution.getValue()
            && node.getWeight() <= Main.poidsMax;
    }

    private static boolean getSolution(Noeud node) {
        if (node.getValue() >= solution.getValue() &&
                node.getWeight() <= Main.poidsMax)
            solution = node;
        return !arbreBinaire.isEmpty();
    }
}
