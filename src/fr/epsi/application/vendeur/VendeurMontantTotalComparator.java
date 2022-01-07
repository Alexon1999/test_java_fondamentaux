package fr.epsi.application.vendeur;

import java.util.Comparator;

public class VendeurMontantTotalComparator implements Comparator<Vendeur> {

    @Override
    public int compare(Vendeur first, Vendeur second) {
        return Integer.compare(first.getMontantTotal(),second.getMontantTotal() );
    }
}
