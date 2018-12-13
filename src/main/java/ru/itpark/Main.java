package ru.itpark;

import ru.itpark.domain.House;
import ru.itpark.repository.HouseRepository;
import ru.itpark.service.HouseService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HouseService houseService = new HouseService(new HouseRepository());

        houseService.add(new House(1, 2_000_000, "Московский"));
        houseService.add(new House(2, 2_500_000, "Кировский"));
        houseService.add(new House(3, 3_000_000, "Советский"));
        houseService.add(new House(4, 3_500_000, "Советский"));
        houseService.add(new House(5, 4_000_000, "Ново-Савиновский"));
        houseService.add(new House(6, 4_500_000, "Приволжский"));
        houseService.add(new House(7, 5_000_000, "Вахитовский"));
        houseService.add(new House(8, 5_500_000, "Кировский"));
        houseService.add(new House(9, 6_000_000, "Советский"));

        List<House> findByName = houseService.findByDistrict("Кировский", "Вахитовский");
        System.out.println(findByName);

        List<House> findByPrice = houseService.findByPrice(4_000_000, 5_000_000);
        System.out.println(findByPrice);
    }
}
