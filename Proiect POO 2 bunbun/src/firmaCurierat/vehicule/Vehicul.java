package firmaCurierat.vehicule;

public abstract class Vehicul {
    private String marca;
    private boolean disponibil;

    public Vehicul(String marca) {
        this.marca = marca;
        this.disponibil = true;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isDisponibil() {
        return disponibil;
    }

    public void setDisponibil(boolean disponibil) {
        this.disponibil = disponibil;
    }

    @Override
    public String toString() {
        return marca + " - " + (disponibil ? "Disponibil" : "Indisponibil");
    }
}
