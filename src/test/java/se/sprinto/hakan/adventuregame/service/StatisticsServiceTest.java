package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.dao.FakeFileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsServiceTest {

    @Test
    @DisplayName("Kontroll - lista ska sorteras")
    void testGetSortedStatistics() {

        // arrange - typ är en datakälla, men objektet är ett fejk-objekt (databasfil)
        // som används för att kunna komma åt att läsa listan med hårdkodade värden

        StatisticsDao fakeDao = new FakeFileStatisticsDao();


        // objektet service hämtar spelresultat (Statistics - kommer via fakeDao)
        // dao kommer in via konstruktorn
        // mha DI: fake-datakällan hämtar statistiken som är hårdkodad lista

        StatisticsService service = new StatisticsService(fakeDao);


        // act - kör metoden som sparar ner resultatet i en lista med spelresultat
        // i getSortedStatistics används dao för att anropa loadAll()

        List<Statistics> result = service.getSortedStatistics();


        // assert - kolla att listan har rätt antal element, förväntar mig 3 st

        assertEquals(3,result.size());


        // kontrollera ordningen, Oscar borde ligga först (index 0), poängen 220
        // borde ligga först (index 0)

        assertEquals("Oscar",result.get(0).getPlayerName());
        assertEquals(220, result.get(0).getScore());


        // kontrollera att ordningen stämmer enligt väntat resultat
        // först jämförs om högst upp (index 0) har högre score än den som ligger
        // på plats 2 (index 1) och samma jämförelse med plats 2 och 3 i listan

        assertTrue(result.get(0).getScore() >= result.get(1).getScore());
        assertTrue(result.get(1).getScore() >= result.get(2).getScore());

    }
}