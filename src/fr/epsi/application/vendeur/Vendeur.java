package fr.epsi.application.vendeur;

import fr.epsi.application.exceptions.VendeurLigneFormatError;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Vendeur {

    private String nom;
    private LocalDate derniereVente;
    private Integer montantTotal;

    public Vendeur() {
    }

    public Vendeur(String nom, LocalDate dernierVente, Integer montantTotal) {
        this.nom = nom;
        this.derniereVente = dernierVente;
        this.montantTotal = montantTotal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDerniereVente() {
        return derniereVente;
    }

    public void setDerniereVente(LocalDate dernierVente) {
        this.derniereVente = dernierVente;
    }

    public Integer getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Integer montantTotal) {
        this.montantTotal = montantTotal;
    }

    @Override
    public String toString(){
        String str = "%s a vendu pour %s € en date du %s";
        return String.format(str, nom, montantTotal , derniereVente.getDayOfMonth() + " " + derniereVente.getMonth().name() +  " " + derniereVente.getYear());
    }

    public static Vendeur formatLine(String line, Integer idx) throws VendeurLigneFormatError {
        try {
            String nom = line.substring(0, line.indexOf(":"));
            line = line.substring(line.indexOf(":") + 1);
            String derniereVente = line.substring(0, line.indexOf(":"));
            String ventesAsString = line.substring(line.indexOf(":") + 1);
            String[] ventesAsArray = ventesAsString.split(";");

            //System.out.println(nom);
            //System.out.println(LocalDate.parse(derniereVente, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            //System.out.println(Arrays.toString(ventesAsArray));

            int montantTotal = 0;
            for (String venteAsString : ventesAsArray) {
                montantTotal += Integer.parseInt(venteAsString);
            }
            return new Vendeur(nom, LocalDate.parse(derniereVente, DateTimeFormatter.ofPattern("dd/MM/yyyy")), montantTotal);
        } catch (Exception err){
            throw new VendeurLigneFormatError(idx);
        }
    }
}
