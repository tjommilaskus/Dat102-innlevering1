package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilmarkivTest {
    private FilmarkivADT filmArchive;
    private Film film1, film2, film3;

    @BeforeEach
    void setUp() {
        filmArchive = new Filmarkiv(10);

        // Using the second constructor with parsed year and Sjanger enum
        film1 = new Film(1, "Warner Bros", "The Matrix", 1999, Sjanger.SCIFI, "Warner Bros");
        film2 = new Film(2, "Warner Bros", "Inception", 2010, Sjanger.DRAMA, "Warner Bros");
        film3 = new Film(3, "Paramount", "Interstellar", 2014, Sjanger.SCIFI, "Paramount");
    }

    @Test
    void testLeggTilFilm() {
        filmArchive.leggTilFilm(film1);
        assertEquals(1, filmArchive.antall());

        filmArchive.leggTilFilm(film2);
        assertEquals(2, filmArchive.antall());
    }

    @Test
    void testFinnFilm() {
        filmArchive.leggTilFilm(film1);
        filmArchive.leggTilFilm(film2);

        Film[] resultat = filmArchive.finnFilm(1);
        assertNotNull(resultat);
        assertEquals(1, resultat[0].getFilmNr());

        resultat = filmArchive.finnFilm(99);
        assertNull(resultat);
    }

    @Test
    void testSlettFilm() {
        filmArchive.leggTilFilm(film1);
        filmArchive.leggTilFilm(film2);

        assertTrue(filmArchive.slettFilm(1));
        assertEquals(1, filmArchive.antall());

        assertFalse(filmArchive.slettFilm(99));
    }

    @Test
    void testSoekTittel() {
        filmArchive.leggTilFilm(film1);
        filmArchive.leggTilFilm(film2);
        filmArchive.leggTilFilm(film3);

        Film[] resultat = filmArchive.soekTittel("matrix");
        assertEquals(1, resultat.length);
        assertEquals("The Matrix", resultat[0].getFilmTitle());

        resultat = filmArchive.soekTittel("inter");
        assertEquals(1, resultat.length);
        assertEquals("Interstellar", resultat[0].getFilmTitle());
    }

    @Test
    void testSoekProdusent() {
        filmArchive.leggTilFilm(film1);
        filmArchive.leggTilFilm(film2);
        filmArchive.leggTilFilm(film3);

        Film[] resultat = filmArchive.soekProdusent("warner");
        assertEquals(2, resultat.length);

        resultat = filmArchive.soekProdusent("paramount");
        assertEquals(1, resultat.length);
        assertEquals("Interstellar", resultat[0].getFilmTitle());
    }

    @Test
    void testAntallSjanger() {
        filmArchive.leggTilFilm(film1);
        filmArchive.leggTilFilm(film2);
        filmArchive.leggTilFilm(film3);

        assertEquals(2, filmArchive.antall(Sjanger.SCIFI));
        assertEquals(1, filmArchive.antall(Sjanger.DRAMA));
        assertEquals(0, filmArchive.antall(Sjanger.ACTION));
    }

    @Test
    void testTotalAntall() {
        filmArchive.leggTilFilm(film1);
        filmArchive.leggTilFilm(film2);

        assertEquals(2, filmArchive.antall());
    }
}