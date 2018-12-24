package ru.itpark.comparator;

import ru.itpark.domain.House;

import java.io.Serializable;
import java.util.Comparator;

public class PriceComparator implements Comparator<House>, Serializable {

    @Override
    public int compare(House h1, House h2) {
        return h1.getPrice() - h2.getPrice();
    }
}
