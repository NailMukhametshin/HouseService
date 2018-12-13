package ru.itpark.comparator;

import ru.itpark.domain.House;

import java.util.Comparator;

public class PriceComparator implements Comparator<House> {

    @Override
    public int compare(House h1, House h2) {
        return h1.toString().compareTo(h2.toString());
    }
}
