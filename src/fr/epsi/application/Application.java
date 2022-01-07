package fr.epsi.application;

import fr.epsi.application.exceptions.VendeurLigneFormatError;
import fr.epsi.application.utils.Utilitaire;
import fr.epsi.application.vendeur.Vendeur;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> lines = Utilitaire.ReadFile("./resources/vendeurs.txt");

        List<Vendeur> lesVendeurs = new ArrayList<>();
        int idx = 0;
        for (String line: lines){
            idx++;
            try {
                lesVendeurs.add(Vendeur.formatLine(line, idx));
            }catch (VendeurLigneFormatError err){
                System.out.println(err.getMessage());
                continue;
            }
        }

        //System.out.println(lesVendeurs);
        System.out.println("\nTrier par montant total");
        for (Vendeur v: Utilitaire.trierVendeurParMontant(lesVendeurs)){
            System.out.println(v);
        }

        System.out.println("\nTrier par la date de dernière vente");
        for (Vendeur v: Utilitaire.trierVendeurParDateDerniereVente(lesVendeurs)){
            System.out.println(v);
        }

    }
}
