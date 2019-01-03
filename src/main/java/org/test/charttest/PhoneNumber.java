package org.test.charttest;

public class PhoneNumber {

    private String description;
    private String countryCode;
    private String number;

    public PhoneNumber(String description, String countryCode, String number) {
        this.description = description;
        this.countryCode = countryCode;
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "description='" + description + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
