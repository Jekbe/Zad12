import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Okno extends JFrame {

    JLabel lbImie, lbNazwisko, lbWzrost, lbWaga, lbwynik, lbprawidlowe;
    JTextField tfImie, tfNazwisko, tfWzrost, tfWaga;
    JButton bZatwierdz, bZamknij;
    private final List<Osoba> osoby = new ArrayList<>();
    private int prawidlowe = 0;
    public Okno(){
        setSize(650, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        generuj();

        setVisible(true);
    }

    private void generuj(){
        add(lbImie = new JLabel("Imie: "));
        add(tfImie = new JTextField(10));
        add(lbNazwisko = new JLabel("Nazwisko"));
        add(tfNazwisko = new JTextField(20));
        add(lbWzrost = new JLabel("Wzrost: "));
        add(tfWzrost = new JTextField(3));
        add(lbWaga = new JLabel("Waga:"));
        add(tfWaga = new JTextField(3));
        add(bZatwierdz = new JButton("Zatwierdź"));
        add(bZamknij = new JButton("Zamknij"));

        listener();
    }

    private void listener(){
        bZatwierdz.addActionListener(e -> {
            dodajOsobe();
            revalidate();
            repaint();
        });

        bZamknij.addActionListener(e -> System.exit(0));
    }

    private void dodajOsobe(){
        try{
            Osoba osoba = new Osoba(tfImie.getText(), tfNazwisko.getText(), Integer.parseInt(tfWzrost.getText()),
                    Integer.parseInt(tfWaga.getText()));
            osoby.add(osoba);

            if (lbwynik == null) add(lbwynik = new JLabel(osoba.wypiszDane()));
            else lbwynik.setText(osoba.wypiszDane());
            JOptionPane.showMessageDialog(null, osoba.wypiszDane());
            prawidlowe();
        } catch (NumberFormatException exp){
            JOptionPane.showMessageDialog(null, "błąd: " + exp);
        }
    }

    private void prawidlowe(){
        for (Osoba osoba : osoby) if (osoba.bmi() > 25 && osoba.bmi() < 29.9) prawidlowe++;
        if (lbprawidlowe == null) add(lbprawidlowe = new JLabel("Ile osób z poprawnym wzrostem: " + prawidlowe));
        else lbprawidlowe.setText("Ile osób z poprawnym wzrostem: " + prawidlowe);
    }
}
