package cars;

import cars.Car;

public class Volvo extends Car {
    private String model;
    private boolean hybrid;

    public Volvo(int number, String color, int doorsNumber, boolean emobilaizer,String model, boolean hybrid,int amount,int price, int PriceDay) {
        super(number, color, doorsNumber, emobilaizer, amount, price, PriceDay);
        this.model = model;
        this.hybrid = hybrid;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean isSunroof() {
        return false;
    }

    @Override
    public boolean gethybrid() {
        return false;
    }

    @Override
    public Boolean getCruiseControl() {
        return null;
    }

    public boolean isHybrid() {
        return hybrid;
    }
}
