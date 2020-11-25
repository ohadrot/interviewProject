package cars;

import cars.Car;

public class Toyota extends Car {
    private String Model;
    private Boolean CruiseControl;

    public Boolean getCruiseControl() {
        return CruiseControl;
    }

    public Toyota(int number, String color, int doorsNumber, boolean emobilaizer, int amount, int price, String model, Boolean cruiseControl, int PriceDay) {
        super(number, color, doorsNumber, emobilaizer, amount, price,PriceDay);
        Model = model;
        CruiseControl = cruiseControl;
    }

    @Override
    public String getModel() {
        return Model;
    }

    @Override
    public boolean isSunroof() {
        return false;
    }

    @Override
    public boolean gethybrid() {
        return false;
    }
}

