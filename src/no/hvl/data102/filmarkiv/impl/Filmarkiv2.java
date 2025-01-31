package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.LinearNode;

import java.util.ArrayList;

public class Filmarkiv2 implements FilmarkivADT {
    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        start = null;
        antall = 0;
    }

    @Override
    public Film[] finnFilm(int nr) {
        LinearNode<Film> currentNode = start;
        while (currentNode != null) {
            if (currentNode.data.getFilmNr() == nr) {
                return new Film[] { currentNode.data };
            }
            currentNode = currentNode.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> newNode = new LinearNode<>(nyFilm);
        if (start == null) {
            start = newNode;
        } else {
            LinearNode<Film> currentNode = start;
            while (currentNode.neste != null) {
                currentNode = currentNode.neste;
            }
            currentNode.neste = newNode;
        }
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (start == null) {
            return false;
        }

        if (start.data.getFilmNr() == filmnr) {
            start = start.neste;
            antall--;
            return true;
        }

        LinearNode<Film> currentNode = start;
        while (currentNode.neste != null) {
            if (currentNode.neste.data.getFilmNr() == filmnr) {
                currentNode.neste = currentNode.neste.neste;
                antall--;
                return true;
            }
            currentNode = currentNode.neste;
        }

        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        ArrayList<Film> treff = new ArrayList<>();
        LinearNode<Film> currentNode = start;
        while (currentNode != null) {
            if (currentNode.data.getFilmTitle().toLowerCase().contains(delstreng.toLowerCase())) {
                treff.add(currentNode.data);
            }
            currentNode = currentNode.neste;
        }
        return treff.toArray(new Film[0]);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        ArrayList<Film> treff = new ArrayList<>();
        LinearNode<Film> currentNode = start;
        while (currentNode != null) {
            if (currentNode.data.getFilmSelskap().toLowerCase().contains(delstreng.toLowerCase())) {
                treff.add(currentNode.data);
            }
            currentNode = currentNode.neste;
        }
        return treff.toArray(new Film[0]);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        LinearNode<Film> currentNode = start;
        while (currentNode != null) {
            if (currentNode.data.getFilmGenre().equals(sjanger)) {
                teller++;
            }
            currentNode = currentNode.neste;
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }
}
