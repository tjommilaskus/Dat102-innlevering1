package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start(){
        filmarkiv.leggTilFilm(new Film(1, "Palm", "Film One", 1992, Sjanger.ACTION, "YOLOinc"));
        filmarkiv.leggTilFilm(new Film(2, "Palm", "Film Two", 1987, Sjanger.SIFI, "Company B"));
        filmarkiv.leggTilFilm(new Film(3, "Palm", "Another Film", 2002, Sjanger.COMEDY, "Company A"));
        filmarkiv.leggTilFilm(new Film(4, "Warner Bros", "The Matrix", "1999", "SCIFI", "Warner Bros"));
        filmarkiv.leggTilFilm(new Film(5, "Warner Bros", "Inception", "2010", "DRAMA", "Warner Bros"));
        filmarkiv.leggTilFilm(new Film(3, "Paramount", "Interstellar", "2014", "SCIFI", "Paramount"));
    }
}
