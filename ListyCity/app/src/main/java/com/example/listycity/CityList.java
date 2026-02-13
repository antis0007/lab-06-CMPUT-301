package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
    public boolean hasCity(City city){
        //When given a city, return whether or not it belongs in the list
        //TODO: Test to see whether your method is correct
        //TODO: (Read https://www.infoworld.com/article/3305792/comparing-java-objects-with-equals-and-hashcode.html)
        for (int i = 0; i<cities.size(); i++){
            if(city.equals(cities.get(i))){return true;};
        }
        return false;
    }
    public void delete(City city){

        //Check if a city is present in the list. If it does then remove it from the list, if not then **throw an exception**
        //TODO: Test to see if your method actually removes it from the list
        //TODO: Test to see if the exception is actually thrown (Read more here https://howtodoinjava.com/junit5/expected-exception-example)
        if (hasCity(city)) {
            String cityName = city.getCityName();
            if (cityName == null || cityName.isEmpty()){
                throw new IllegalArgumentException("City name not defined!");
            }
            else {
                cities.remove(cityName);
            }
        }
        else {
            throw new IllegalArgumentException("City not found in the list!");
        }

    }
    public int countCities(){
        //Return how many cities are in the list:
        //TODO:Test to see whether your method is correct
        int count = cities.size();
        return count;
    }
}