package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import no.hvl.data102.filmarkiv.impl.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    class FilmarkivTest {

        private Filmarkiv filmarkiv;
        private Film film1, film2, film3;

        @BeforeEach
        void setUp() {
            // Assuming Film constructor takes (int filmNr, String title, String selskap, Sjanger genre)
            filmarkiv = new Filmarkiv(10);
            film1 = new Film(1, "Palm", "Film One", 1992, Sjanger.ACTION, "YOLOinc");
            film2 = new Film(2, "Palm", "Film Two", 1987, Sjanger.SIFI, "Company B");
            film3 = new Film(3, "Palm", "Another Film", 2002, Sjanger.COMEDY, "Company A");

            // Adding films to the Filmarkiv
            filmarkiv.leggTilFilm(film1);
            filmarkiv.leggTilFilm(film2);
            filmarkiv.leggTilFilm(film3);
        }

        @Test
        void testFinnFilm() {
            Film[] foundFilm = filmarkiv.finnFilm(1);
            assertNotNull(foundFilm);
            assertEquals(film1, foundFilm[0]);

            Film[] notFoundFilm = filmarkiv.finnFilm(99);
            assertNull(notFoundFilm);
        }

        @Test
        void testLeggTilFilm() {
            assertEquals(3, filmarkiv.antall());

            Film newFilm = new Film(4, "Palm", "Film Four", 2004, Sjanger.HISTORY, "Company Z");
            filmarkiv.leggTilFilm(newFilm);
            assertEquals(4, filmarkiv.antall());
        }

        @Test
        void testSlettFilm() {
            assertTrue(filmarkiv.slettFilm(2));
            assertEquals(2, filmarkiv.antall());
            assertFalse(filmarkiv.slettFilm(99)); // Trying to delete a non-existent film
        }

        @Test
        void testSoekTittel() {
            Film[] result = filmarkiv.soekTittel("Film");
            assertEquals(3, result.length);

            Film[] resultNoMatch = filmarkiv.soekTittel("Nonexistent");
            assertEquals(0, resultNoMatch.length);
        }

        @Test
        void testSoekProdusent() {
            Film[] result = filmarkiv.soekProdusent("Company A");
            assertEquals(2, result.length); // film1 and film3

            Film[] resultNoMatch = filmarkiv.soekProdusent("Nonexistent");
            assertEquals(0, resultNoMatch.length);
        }

        @Test
        void testAntallSjanger() {
            int actionCount = filmarkiv.antall(Sjanger.ACTION);
            assertEquals(2, actionCount); // film1 and film3

            int dramaCount = filmarkiv.antall(Sjanger.DRAMA);
            assertEquals(1, dramaCount); // film2

            int comedyCount = filmarkiv.antall(Sjanger.COMEDY);
            assertEquals(0, comedyCount); // No comedy films in the list
        }

        @Test
        void testAntall() {
            assertEquals(3, filmarkiv.antall());
        }
    }

