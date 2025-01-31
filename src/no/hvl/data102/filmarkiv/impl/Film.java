package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
    private int filmNr;
    private String filmSkaper;
    private String filmTitle;
    private int filmYear;
    private Sjanger filmGenre;
    private String filmSelskap;

    public Film (int filmNr, String produsent, String tittel, String lanserings, String sjanger, String filmSelskap) {

    }
    public Film(int filmNr, String filmSkaper, String filmTitle, int filmYear, Sjanger filmGenre, String filmSelskap) {
        this.filmNr = filmNr;
        this.filmSkaper = filmSkaper;
        this.filmTitle = filmTitle;
        this.filmYear = filmYear;
        this.filmGenre = filmGenre;
        this.filmSelskap = filmSelskap;
    }


    public int getFilmNr() {
        return filmNr;
    }

    public void setFilmNr(int filmNr) {
        this.filmNr = filmNr;
    }

    public String getFilmSkaper() {
        return filmSkaper;
    }

    public void setFilmSkaper(String filmSkaper) {
        this.filmSkaper = filmSkaper;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public int getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(int filmYear) {
        this.filmYear = filmYear;
    }

    public Sjanger getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(Sjanger filmGenre) {
        this.filmGenre = filmGenre;
    }

    public String getFilmSelskap() {
        return filmSelskap;
    }

    public void setFilmSelskap(String filmSelskap) {
        this.filmSelskap = filmSelskap;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmNr == film.filmNr && filmYear == film.filmYear && Objects.equals(filmSkaper, film.filmSkaper) && Objects.equals(filmTitle, film.filmTitle) && Objects.equals(filmGenre, film.filmGenre) && Objects.equals(filmSelskap, film.filmSelskap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmNr, filmSkaper, filmTitle, filmYear, filmGenre, filmSelskap);
    }
}
