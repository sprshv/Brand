package com.codedotorg;

public class Brand {
    
    /** The name of a brand or designer */
    private String name;

    /**
     * Constructor for the Brand class.
     *
     * @param name The name of the brand.
     */
    public Brand(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the brand.
     * @return String Returns the name of the brand.
     */
    public String getName() {
        return name;
    }

}
