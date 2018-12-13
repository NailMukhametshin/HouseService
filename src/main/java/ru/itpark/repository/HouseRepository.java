package ru.itpark.repository;

import ru.itpark.domain.House;

import java.util.ArrayList;
import java.util.List;

public class HouseRepository {

    List<House> houses = new ArrayList<>();

    public List<House> getHouse() {
        return houses;
    }

    public void addHouse(House house) {
        houses.add(house);
    }
}
