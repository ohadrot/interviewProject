import cars.Car;
import cars.Honda;
import cars.Toyota;
import cars.Volvo;
import db.InventoryManager;
import persons.Employee;
import persons.Person;
import rentals.RentCard;
import rentals.RentalsManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Main {


    public static void main(String[] args) throws ParseException {
        InventoryManager inventoryManager = new InventoryManager();
        RentalsManager rentalsManager = new RentalsManager(inventoryManager);
        rentalsManager.run();


    }
}