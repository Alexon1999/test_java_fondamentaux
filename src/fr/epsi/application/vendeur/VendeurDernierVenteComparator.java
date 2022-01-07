package fr.epsi.application.vendeur;

import java.util.Comparator;

public class VendeurDernierVenteComparator implements Comparator<Vendeur> {

    @Override
    public int compare(Vendeur first, Vendeur second) {
        return first.getDerniereVente().compareTo(second.getDerniereVente());
    }
}
