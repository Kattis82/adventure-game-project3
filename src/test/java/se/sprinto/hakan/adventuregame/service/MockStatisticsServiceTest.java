package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.sprinto.hakan.adventuregame.dao.FakeFileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.FileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


// nedan talar om för JUnit 5 att testen använder Mockito samt att Mockito
// initialiserar mocks automatiskt
@ExtendWith(MockitoExtension.class)
public class MockStatisticsServiceTest {

    // mocka klassen: blir alltså en låtsas-version av en databasfil nu
    @Mock
    private FileStatisticsDao dao;

    // mocken: låtsas-databasfil (dao) injiceras i service
    @InjectMocks
    private StatisticsService service;

    @Test
    @DisplayName("Kontroll - lista ska sorteras")
    public void testGetSortedStatistics() {

        // arrange - skapar hårdkodad lista
        List<Statistics> stats = new ArrayList<>();
        stats.add(new Statistics("Soya",70));
        stats.add(new Statistics("Oscar",220));
        stats.add(new Statistics("Kattis",90));


        // when: mock-objektet (dao) och metoden (loadAll()) som ska simuleras specificeras
        // thenReturn: listan (stats) ska returneras efter att metoden har anropats
        Mockito.when(dao.loadAll()).thenReturn(stats);


        // act - kör metoden getSortedStatistics (returnerar lista) som ligger i
        // StatisticsService och sparar resultatet i en lista
        List<Statistics> result = service.getSortedStatistics();


        // assert - kontrollerar att den sorterade listan stämmer enligt förväntat
        assertEquals("Oscar",result.get(0).getPlayerName());
        assertEquals("Kattis",result.get(1).getPlayerName());
        assertEquals("Soya",result.get(2).getPlayerName());


        // verifiera att loadAll() har anropats 1 gång
        Mockito.verify(dao, Mockito.times(1)).loadAll();

    }


    @Test
    @DisplayName("Kontroll - lista ska sorteras")
    public void testGetSortedStatisticsMockDao() {

        // här mockas datakällan manuellt
        FileStatisticsDao mockDao = Mockito.mock(FileStatisticsDao.class);

        // arrange - skapar hårdkodad lista
        List<Statistics> stats = new ArrayList<>();
        stats.add(new Statistics("Soya",70));
        stats.add(new Statistics("Oscar",220));
        stats.add(new Statistics("Kattis",90));


        // simulering av mock (låtsas-datakällan) och metod som
        // talar om att loadAll() ska returnera listan
        Mockito.when(mockDao.loadAll()).thenReturn(stats);

        // skapar service-objektet med mockad (låtsas) datakälla
        // här görs injektionen manuellt (DI)
        StatisticsService service = new StatisticsService(mockDao);


        // act - kör metoden getSortedStatistics (returnerar lista) som ligger i
        // StatisticsService och sparar resultatet i en lista
        List<Statistics> result = service.getSortedStatistics();


        // assert - kontrollerar att den sorterade listan stämmer enligt förväntat
        assertEquals("Oscar",result.get(0).getPlayerName());
        assertEquals("Kattis",result.get(1).getPlayerName());
        assertEquals("Soya",result.get(2).getPlayerName());


        // verifiera att loadAll() har anropats 1 gång - här med låtsas-datakällan
        Mockito.verify(mockDao, Mockito.times(1)).loadAll();

    }

}
