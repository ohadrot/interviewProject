package rentals;

import cars.Car;
import persons.Person;

public class RentCard {
    private Person client;
    private Car RentCar;
    private String RentDate;
    private String DateOfReturn;
    private int NumberOfRentDay;
    private int PriceOfAllPeriod;

    public RentCard(Person client, Car rentCar, String rentDate, String dateOfReturn,int numberOfRentDay, int priceOfAllPeriod) {
        this.client = client;
        RentCar = rentCar;
        RentDate = rentDate;
        DateOfReturn = dateOfReturn;
        PriceOfAllPeriod = priceOfAllPeriod;
        NumberOfRentDay = numberOfRentDay;
    }

    public Person getClient() {
        return client;
    }

    public Car getRentCar() {
        return RentCar;
    }

    public String getRentDate() {
        return RentDate;
    }

    public String getDateOfReturn() {
        return DateOfReturn;
    }

    public int getPriceOfAllPeriod() {
        return PriceOfAllPeriod;
    }

    public int getNumberOfRentDay() {
        return NumberOfRentDay;
    }

}
