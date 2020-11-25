package cars;

import cars.Car;

public class Honda extends Car {
    private boolean Sunroof;
    private String Model;

    public Honda(int number, String color, int doorsNumber, boolean emobilaizer, boolean sunroof, String model,int amount,int price,int PriceDay) {
        super(number, color, doorsNumber, emobilaizer, amount, price,PriceDay);
        Sunroof = sunroof;
        Model = model;
    }

    public boolean isSunroof() {
        return Sunroof;
    }

    @Override
    public boolean gethybrid() {
        return false;
    }

    @Override
    public Boolean getCruiseControl() {
        return null;
    }

    public String getModel() {
        return Model;
    }


}

