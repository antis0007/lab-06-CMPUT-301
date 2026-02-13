package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// The following JavaDocstrings have been reformatted with ChatGPT 5.2 for more consistent stylization and string formatting:
// 2026-02-12
// Javadoc comments reviewed and revised by Andrew Tischenko
/**
 * Holds an ArrayList of City objects
 * <p>
 * Provides operations to add, remove, count, search, and retrieve cities. All cities are sorted via Collections.sort(...) on each getCities(...) call.
 * </p>
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a city to the list if it does not already exist.
     * @param city This is a candidate city to add
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Returns a sorted list of cities (sorted by City.compareTo()).
     * @return The sorted list of cities
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether the given city exists in the list.
     * @param city The city to check for
     * @return True if the city exists in the list, otherwise false
     */
    public boolean hasCity(City city){
        //When given a city, return whether or not it belongs in the list
        //COMPLETE: Test to see whether your method is correct
        //COMPLETE: (Read https://www.infoworld.com/article/3305792/comparing-java-objects-with-equals-and-hashcode.html)
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list.
     * @param city The city to delete
     * @throws IllegalArgumentException if the city does not exist in the list
     */
    public void delete(City city){

        //Check if a city is present in the list. If it does then remove it from the list, if not then **throw an exception**
        //COMPLETE: Test to see if your method actually removes it from the list
        //COMPLETE: Test to see if the exception is actually thrown (Read more here https://howtodoinjava.com/junit5/expected-exception-example)
        if (!hasCity(city)) {
            throw new IllegalArgumentException("City not found in the list!");
        }
        cities.remove(city);
    }

    /**
     * Counts how many cities are currently in the list.
     * @return The number of cities in the list
     */
    public int countCities(){
        //Return how many cities are in the list:
        //COMPLETE: Test to see whether your method is correct
        return cities.size();
    }
}
