package com.example.listycity;
// The following JavaDocstrings have been reformatted with ChatGPT 5.2 for more consistent stylization and string formatting:
// 2026-02-12
// Javadoc comments reviewed and revised by Andrew Tischenko
/**
 * Represents a City with a name and a province.
 * <p>
 * Cities are considered equal when they have the same city name and province name.
 * This enables correct behavior for list operations such as contains() and remove().
 * </p>
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructs a City using the provided name and province.
     *
     * @param city     The city name (e.g., "Edmonton")
     * @param province The province name (e.g., "Alberta")
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name.
     *
     * @return The city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Gets the province name.
     *
     * @return The province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this City to another City for sorting (by city name).
     *
     * @param o The other city to compare against
     * @return Negative if this city name comes before the other, 0 if equal,
     *         positive if after
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Checks equality based on city name and province name.
     *
     * @param obj The object to compare to
     * @return True if both objects represent the same city name and province name
     */
    @Override
    public boolean equals(Object obj) { // Required function for ease of use and simple comparisons between City objects
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;

        City other = (City) obj;

        if (this.city == null && other.city != null) return false;
        if (this.city != null && !this.city.equals(other.city)) return false;

        if (this.province == null && other.province != null) return false;
        if (this.province != null && !this.province.equals(other.province)) return false;

        return true;
    }

    /**
     * Returns a hash code consistent with equals(), based on city and province.
     *
     * @return Hash code for this City
     */
    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + (city == null ? 0 : city.hashCode());
        result = 31 * result + (province == null ? 0 : province.hashCode());

        return result;
    }
}