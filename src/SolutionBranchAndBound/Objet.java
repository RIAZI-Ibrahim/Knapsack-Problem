package SolutionBranchAndBound;

public class Objet implements Comparable<Objet> {

    private int index;
    private double poids;
    private double value;
    private double ratio;

    public Objet(int index, int poids, int value) {
        this.index = index;
        this.poids = poids;
        this.value = value;
    }

    @Override
    public int compareTo(Objet objet) {
        return Double.compare(objet.ratio, ratio);
    }
    
    public int getIndex() { return index; }

    public double getPoids() { return poids; }

    public double getValue() { return value; }

    public void setRatio(double ratio) { this.ratio = ratio; }
}
