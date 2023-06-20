public class Osoba {
    private final String imie;
    private final String nazwisko;
    private final double wzrost;
    private final double waga;

    public Osoba(String imie, String nazwisko, int wzrost, int waga) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wzrost = wzrost;
        this.waga = waga;
    }

    public double bmi(){
        double wzrost;
        if (this.wzrost > 10) wzrost = this.wzrost / 100;
        else wzrost = this.wzrost;

        return waga/(Math.pow(wzrost, 2));
    }

    public String wypiszDane(){
        return "Imie: " + this.imie + "\n Nazwisko: " + this.nazwisko + "\n Wzrost: " + this.wzrost + "\n Waga: " +
            this.waga + "\n BMI: " + String.format("%.2f", bmi());
    }
}
