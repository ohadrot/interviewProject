package cars;

public abstract class Car {
    private int Number;
    private String color;
    private int doorsNumber;
    private boolean emobilaizer;
    private int Amount;
    private int Price;
    private int PricePerADay;

    public Car(int number, String color, int doorsNumber, boolean emobilaizer, int amount, int price,int PriceDay) {
        Number = number;
        this.color = color;
        this.doorsNumber = doorsNumber;
        this.emobilaizer = emobilaizer;
        Amount = amount;
        Price = price;
        PricePerADay = PriceDay;
    }
    public abstract String getModel();
    public abstract boolean isSunroof();
    public abstract boolean gethybrid();
    public abstract Boolean getCruiseControl();


    public int getNumber() {
        return Number;
    }

    public String getColor() {
        return color;
    }

    public int getDoorsNumber() {
        return doorsNumber;
    }

    public boolean isEmobilaizer() {
        return emobilaizer;
    }

    public int getAmount() {
        return Amount;
    }

    public int getPrice() {
        return Price;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public void reduceAmount() {
        Amount--;
    }

    public void addAmount(){Amount++;}

    public int getPricePerADay() {
        return PricePerADay;
    }
}
