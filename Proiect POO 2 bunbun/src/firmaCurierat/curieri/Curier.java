package firmaCurierat.curieri;

import firmaCurierat.vehicule.Vehicul;

public class Curier {
    private String nume;
    private String telefon;
    private String cartier;
    private Vehicul vehicul;

    public Curier(String nume, String telefon, String cartier, Vehicul vehicul) {
        this.nume = nume;
        this.telefon = telefon;
        this.cartier = cartier;
        this.vehicul = vehicul;
    }

    public String getNume() {
        return nume;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getCartier() {
        return cartier;
    }

    public Vehicul getVehicul() {
        return vehicul;
    }

    @Override
    public String toString() {
        return nume + " - " + telefon + " - Cartier: " + cartier + " - Vehicul: " + vehicul.toString();
    }
}
