public class Osoba {
    private final String imie;
    private final String nazwisko;
    private final double wzrost;
    private final int waga;

    public Osoba(String imie, String nazwisko, int wzrost, int waga) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wzrost = wzrost;
        this.waga = waga;
    }

    private double bmi(){
        return waga/(Math.pow(this.waga, 2));
    }

    public String wypiszDane(){
        return "Imie: " + this.imie + "\n Nazwisko: " + this.nazwisko + "\n Wzrost: " + this.wzrost + "\n Waga: " +
            this.waga + "\n BMI: " + bmi();
    }
}
