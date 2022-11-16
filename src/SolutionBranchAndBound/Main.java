package SolutionBranchAndBound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Objet> objetsDisponibles = new ArrayList<>();
    public static ArrayList<Objet> objetsDisponiblesTrié = new ArrayList<>();
    public static double poidsMax = 0;
    public static int nombreObjets = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Donnez le nombre du fichier (sac) : ");
        int number = sc.nextInt();
        lireFichiers(number);
        double debut = System.nanoTime();
        Noeud node = AlgoGlouton.run();
        RelaxationFractionnaire.init();
        node = BranchAndBound.run(node);
        SacADos monSac = node.getSac();
        double fin = System.nanoTime();
        System.out.println(monSac.toString());
        System.out.println("\n Solution en : " + (fin - debut) / 1_000_000 + " MilliSeconds");
    }

    public static void lireFichiers(int nombre) {
        InputStream fichier = Main.class.getClassLoader().getResourceAsStream("resources/sac" + nombre + ".txt");
        if (fichier != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(fichier, StandardCharsets.UTF_8));
            String line;
            int cptLine = 0;
            try {
                while ((line = reader.readLine()) != null) {
                    cptLine ++;
                    if (cptLine == 1) poidsMax = Integer.parseInt(line);
                    else {
                        String[] object = line.split(" ");
                        int weight = Integer.parseInt(object[0]);
                        int value = Integer.parseInt(object[1]);
                        objetsDisponibles.add(new Objet(cptLine -2, weight, value));
                    }
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            nombreObjets = objetsDisponibles.size();
        } else {
            try {
                throw new Exception("Fichier introuvable.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
