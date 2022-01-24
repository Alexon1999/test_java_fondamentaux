package fr.epsi.application.utils;

import fr.epsi.application.vendeur.Vendeur;
import fr.epsi.application.vendeur.VendeurDernierVenteComparator;
import fr.epsi.application.vendeur.VendeurMontantTotalComparator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utilitaire {
    /**
     * lire un fichier
     * @param path
     * @return une liste avec les lignes
     */
    public static List<String> ReadFile(String path){
        Path filePath = null;
        try{
            filePath = Path.of(path);
            return Files.readAllLines(filePath);
        }catch (Exception err){
            // err.printStackTrace();
            System.out.println("Le chemin du fichier entré est introuvable par le programme : " + path);
            System.exit(1);
            return null;
        }
    }

    /*
    * @returns un nouveau liste trié par le montant du vendeur
    * */
    public static List<Vendeur> trierVendeurParMontant(List<Vendeur> lesVendeurs){
        // Trier les vendeurs par le montant total en ordre décroissant grâce à Un Comparator
        // https://www.baeldung.com/java-comparator-comparable

        // copier la liste sans la référence, donc modifie pas la liste de vendeur entrés
        List<Vendeur> sortedList = lesVendeurs.stream()
                .collect(Collectors.toList());
        VendeurMontantTotalComparator vendeurMTComparator = new VendeurMontantTotalComparator();
        Collections.sort(sortedList, vendeurMTComparator);
        Collections.reverse(sortedList);

        return sortedList;
    }

    /*
     * @returns un nouveau liste trié par la date de dernière vente
     * */
    public static List<Vendeur> trierVendeurParDateDerniereVente(List<Vendeur> lesVendeurs){
        // Trier les vendeurs par date de dernière vente
        List<Vendeur> sortedList = lesVendeurs.stream()
                .collect(Collectors.toList());
        VendeurDernierVenteComparator vendeurDVComparator = new VendeurDernierVenteComparator();
        Collections.sort(sortedList, vendeurDVComparator);
        Collections.reverse(sortedList);

        return sortedList;
    }

}
