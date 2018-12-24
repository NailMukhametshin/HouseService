package ru.itpark.service;

import ru.itpark.comparator.PriceComparator;
import ru.itpark.domain.House;
import ru.itpark.repository.HouseRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseService {
    private HouseRepository repository;

    public HouseService(HouseRepository repository) {
        this.repository = repository;
    }

    public void add(House house) {
        repository.addHouse(house);
    }

    public List<House> getHouse() {
        return repository.getHouse();
    }

    public List<House> findByDistrict(String... districts) {

        List<House> result = new ArrayList<>();
        List<String> districtsList = Arrays.asList(districts);

        for (House house : repository.getHouse()) {

            if (districtsList.contains(house.getDistrict())) {
                result.add(house);
            }
        }
        result.sort(new PriceComparator());
        return result;
    }

    public List<House> findByPrice(long minPrice, long maxPrice) {

        List<House> result = new ArrayList<>();

        for (House house : repository.getHouse()) {

            if (house.getPrice() >= minPrice && house.getPrice() <= maxPrice) {
                result.add(house);
            }
        }
        result.sort(new PriceComparator());
        return result;
    }

}
