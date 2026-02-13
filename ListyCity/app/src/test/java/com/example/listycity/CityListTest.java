package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City cityOne = new City("Regina", "Saskatchewan");
        cityList.add(cityOne);
        City cityTwo = new City("Regina", "Saskatchewan");
        boolean cityCheck = cityList.hasCity(cityTwo);
        assertTrue(cityCheck);
    }

    @Test
    void testDelete(){
        CityList cityList = mockCityList();
        City cityOne = new City("Regina", "Saskatchewan");
        cityList.add(cityOne);
        cityList.delete(cityOne);
        assertFalse(cityList.getCities().contains(cityOne), "List should not contain removed city");
        assertEquals(1, cityList.countCities());
    }

    @Test
    void testDeleteException(){
        CityList cityList = mockCityList();
        City notInList = new City("Regina", "Saskatchewan");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(notInList);
        });
    }

    @Test
    void testCountCities(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Regina", "Saskatchewan"));
        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(3, cityList.countCities());
    }
}
