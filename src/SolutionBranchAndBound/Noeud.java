package SolutionBranchAndBound;

public class Noeud implements Comparable<Noeud> {

    private SacADos sac;
    private double valeurMax = 0;
    private int index;

    public Noeud(int index) {
        this.sac = new SacADos();
        this.index = index;
    }

    public Noeud(Noeud node) {
        this.sac = new SacADos(node.sac.getContenu().clone());
        this.index = node.index;
        this.valeurMax = node.valeurMax;
    }

    public Noeud addObjet() {
        sac.getContenu()[index] = true;
        index++;
        updateValueMax();
        return this;
    }

    public Noeud addEmpty() {
        sac.getContenu()[index] = false;
        index++;
        updateValueMax();
        return this;
    }

    private void updateValueMax() {
        valeurMax = RelaxationFractionnaire.calculMaxValue(this);
    }

    @Override
    public int compareTo(Noeud node) {
        return -1;
    }

    public int getWeight() { return sac.getPoidsTotal(); }

    public int getValue() { return sac.getValeurTotale(); }

    public int getIndex() { return index; }

    public double getValueMax() { return valeurMax; }

    public SacADos getSac() { return sac; }
}
