package sample;

public class ThaiSystem {
    private double tamleung;

    public ThaiSystem() {
        this.tamleung = tamleung;
    }

    public double getTamleung() {
        return tamleung;
    }
    public void setTamleung(double tamleung) {
        this.tamleung = tamleung;
    }

    public void setFromMetricSystem(double kg) {
        this.tamleung = (kg / 1000) / 3.75 / 4 / 4;
    }

    public void setFromEnglishSystem(double lb) {
        this.tamleung = (lb * 453.59237);
    }

    public double toSlung() {
        return tamleung * 4 * 4;
    }

    public double toBath() {
        return tamleung * 4;
    }

    public double toChang() {
        return tamleung / 20;
    }

    public double toHarb() {
        return tamleung / 20 / 50;
    }
}
