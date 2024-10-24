package firmaCurierat.livrari;

import firmaCurierat.curieri.Curier;

public class Livrare {
    private String destinatar;
    private double greutate;
    private String cartier;
    private Curier curier;
    private String awb;
    private String status;

    public Livrare(String destinatar, double greutate, String cartier, Curier curier, String awb) {
        this.destinatar = destinatar;
        this.greutate = greutate;
        this.cartier = cartier;
        this.curier = curier;
        this.awb = awb;
        this.status = "in depozit";
    }

    public String getDestinatar() {
        return destinatar;
    }

    public double getGreutate() {
        return greutate;
    }

    public String getCartier() {
        return cartier;
    }

    public Curier getCurier() {
        return curier;
    }


    public String getAwb() {
        return awb;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Livrare{" +
                "destinatar='" + destinatar + '\'' +
                ", greutate=" + greutate +
                ", cartier='" + cartier + '\'' +
                ", awb='" + awb + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
