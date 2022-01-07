package fr.epsi.application.exceptions;

public class VendeurLigneFormatError extends Exception{

    public VendeurLigneFormatError(Integer idx){
        super("La ligne " + idx + " est mal formaté");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
