import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame {

    JLabel lbImie, lbNazwisko, lbWzrost, lbWaga, wynik;
    JTextField tfImie, tfNazwisko, tfWzrost, tfWaga;
    JButton bZatwierdz;
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

        listener();
    }

    private void listener(){
        bZatwierdz.addActionListener(e -> {
            dodajOsobe();
            revalidate();
            repaint();
        });
    }

    private void dodajOsobe(){
        try{
            Osoba o1 = new Osoba(tfImie.getText(), tfNazwisko.getText(), Integer.parseInt(tfWzrost.getText()),
                    Integer.parseInt(tfWaga.getText()));
            wynik = new JLabel(o1.wypiszDane());
            JOptionPane.showMessageDialog(null, o1.wypiszDane());
            add(wynik);
        } catch (NumberFormatException exp){
            System.out.println("Błąd: " + exp);
        }
    }
}
