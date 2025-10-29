package se.sprinto.hakan.adventuregame.dao;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

// klassen använder hårkodad fake-data istället för att hämta något på riktigt

public class FakeFileStatisticsDao implements StatisticsDao {

    public void save(Statistics statistics) {
        // denna kan vara tom, ska inte spara något i testet
    }

    public List<Statistics> loadAll() {
        // returnera hårdkodade Statistics-objekt i en lista
        List<Statistics> stats = new ArrayList<>();
                stats.add(new Statistics("Soya",70));
                stats.add(new Statistics("Oscar",220));
                stats.add(new Statistics("Kattis",90));

                return stats;
    }
}