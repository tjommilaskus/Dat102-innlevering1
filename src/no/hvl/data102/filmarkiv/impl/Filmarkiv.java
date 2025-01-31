package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.ArrayList;

public class Filmarkiv implements FilmarkivADT {
    private Film[] filmArkiv;
    private int antall;

    public Filmarkiv(int maxFilmer) {
        filmArkiv = new Film[maxFilmer];
        antall = 0;
    }

    @Override
    public Film[] finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmArkiv[i].getFilmNr() == nr) {
                return filmArkiv;
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        filmArkiv[antall] = nyFilm;
        antall++;

    }

    @Override
    public boolean slettFilm(int filmnr) {
        for(int i = 0; i < antall; i++) {
            if(filmArkiv[i].getFilmNr() == filmnr) {
                filmArkiv[i] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        ArrayList<Film> treff = new ArrayList<>();
        for (int i = 0; i < antall; i++) {
            if (filmArkiv[i].getFilmTitle().toLowerCase().contains(delstreng.toLowerCase())) {
                treff.add(filmArkiv[i]);
            }
        }
        return treff.toArray(new Film[0]);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        ArrayList<Film> treff = new ArrayList<>();
        for (int i = 0; i < antall; i++) {
            if (filmArkiv[i].getFilmSelskap().toLowerCase().contains(delstreng.toLowerCase())) {
                treff.add(filmArkiv[i]);
            }
        }
        return treff.toArray(new Film[0]);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        for (int i = 0; i < antall; i++) {
            if (filmArkiv[i].getFilmGenre().equals(sjanger)) {
                teller++;
            }
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }
}