package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
// is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
// This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
// Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    void testHasCity(){
        //When given a city, return whether or not it belongs in the list
        //TODO: Test to see whether your method is correct
        //TODO: (Read https://www.infoworld.com/article/3305792/comparing-java-objects-with-equals-and-hashcode.html)
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
        //Check if a city is present in the list. If it does then remove it from the list, if not then **throw an exception**
        //TODO: Test to see if your method actually removes it from the list
        CityList cityList = mockCityList();
        City cityOne = new City("Regina", "Saskatchewan");
        cityList.add(cityOne);
        cityList.delete(cityOne);
        assertFalse(cityList.getCities().contains(cityOne), "List should not contain removed city");
        //TODO: Test to see if the exception is actually thrown (Read more here https://howtodoinjava.com/junit5/expected-exception-example)
        
    }
    @Test
    void testCountCities(){
        //Return how many cities are in the list:
        //TODO:Test to see whether your method is correct
    }
}