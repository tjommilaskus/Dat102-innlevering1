package no.hvl.data102.filmarkiv.klient;

import java.util.Arrays;
import java.util.Scanner;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
    private Scanner scanner = new Scanner(System.in);

    public Film lesFilm() {
        System.out.print("FilmNummer: ");
        int filmNr = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Produsent: ");
        String produsent = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Tittel: ");
        String tittel = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Lanseringsår: ");
        String lanserings = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Sjanger: ");
        String sjanger = scanner.nextLine();
        scanner.nextLine();

        System.out.print("FilmSelskap: ");
        String filmSelskap = scanner.nextLine();
        scanner.nextLine();

        return new Film(filmNr, produsent, tittel, lanserings, sjanger, filmSelskap);
    }

    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        System.out.println("FilmNummer: " + film.getFilmNr());
        System.out.println("Produsent: " + film.getFilmSkaper());
        System.out.println("Tittel: " + film.getFilmTitle());
        System.out.println("Lanseringsår: " + film.getFilmYear());
        System.out.println("Sjanger: " + film.getFilmGenre());
        System.out.println("Filmselskap: " + film.getFilmSelskap());

// TODO
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
       Film[] matchingFilm = arkiv.soekTittel(delstreng);
        for(int i = 0; i < matchingFilm.length; i++) {
            skrivUtFilm(matchingFilm[i]);
        }
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] matchingProdusent = arkiv.soekProdusent(delstreng);
            for(int i = 0; i < matchingProdusent.length; i++) {
                skrivUtFilm(matchingProdusent[i]);
            }
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
// og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Antall filmer: " + arkiv.antall());
            Sjanger[] sjangere = Sjanger.values();
             for(int i = 0; i < sjangere.length; i++) {
                 System.out.println("Sjanger: " + sjangere[i] + "Filmer: " + arkiv.antall(sjangere[i]));
             }
    }
// osv ... andre metoder
}