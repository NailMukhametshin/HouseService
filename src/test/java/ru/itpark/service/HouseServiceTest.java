package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.domain.House;
import ru.itpark.repository.HouseRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseServiceTest {
    private HouseService service;

    @BeforeEach
    void setUp() {
        HouseRepository repository = new HouseRepository();
        repository.addHouse(
                new House(1, 1_000_000, "Кировский"));
        repository.addHouse(
                new House(2, 1_500_000, "Авиастроительный"));
        repository.addHouse(
                new House(3, 2_000_000, "Авиастроительный"));

        service = new HouseService(repository);
    }

    @Test
    public void findByPriceWithZeroResult() {
        {
            List<House> result = service.findByPrice(0, 500_000);
            assertEquals(0, result.size());
        }

        {
            List<House> result = service.findByPrice(2_500_000, 4_000_000);
            assertEquals(0, result.size());
        }

    }

    @Test
    public void findByPriceWithOneResult() {
        {
            int minPrice = 1_200_000;
            int maxPrice = 1_700_000;
            List<House> result = service.findByPrice(minPrice, maxPrice);
            assertEquals(1, result.size());
        }
    }

    @Test
    public void findByPriceWithMultipleResult() {
        {
            int minPrice = 1_200_000;
            int maxPrice = 2_700_000;
            List<House> result = service.findByPrice(minPrice, maxPrice);
            assertEquals(2, result.size());

            for (House house : result) {
                int price = house.getPrice();
                assertTrue(price >= minPrice);
                assertTrue(price <= maxPrice);
            }
        }
    }

    @Test
    public void findByDistrictWithZeroResult() {

        List<House> result = service.findByDistrict("Московский");
        assertEquals(0, result.size());
    }

    @Test
    public void findByDistrictWithOneResult() {
        {
            List<House> result = service.findByDistrict("Кировский");
            assertEquals(1, result.size());
        }
    }

    @Test
    public void findByDistrictWithMultipleResult() {
        {
            List<House> result = service.findByDistrict("Авиастроительный");
            assertEquals(2, result.size());
        }
    }
}
