package db;

import cars.Car;
import cars.Honda;
import cars.Toyota;
import cars.Volvo;
import persons.Employee;
import persons.Person;
import rentals.RentCard;
import utils.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {
    private List<Person> clients;
    private List<Person> workers;
    private List<Car> carList;
    private List<RentCard> rentals;

    public InventoryManager() {
        this.clients = new ArrayList<>();
        this.workers = new ArrayList<>();
        carList = new ArrayList<>();
        rentals = new ArrayList<>();
        loadinglist();
    }

    public void loadinglist() {

        Person p = new Employee("shlomi baroc", 34, 200786518, "manager");
        Person p1 = new Employee("gidon levi", 29, 102936475, "seller");
        Person p2 = new Employee("shalom levi", 29, 200867543, "seller");
        Person p3 = new Employee("david lev", 29, 123456789, "seller");
        Person p4 = new Employee("oren shimon", 29, 132978651, "manager");
        Person p5 = new Employee("shani avraham", 21, 125394679, "secretary");
        workers.add(p);
        workers.add(p1);
        workers.add(p2);
        workers.add(p3);
        workers.add(p4);
        workers.add(p5);
        Person pe = new Person("rotem brami", 28, 200787563);
        Person pe1 = new Person("ohad rothschild", 30, 200898591);
        Person pe2 = new Person("izik cohen", 45, 348437544);
        Person pe3 = new Person("omer cohen", 45, 348471544);
        Person pe4 = new Person("omer yoav", 50, 299736541);
        clients.add(pe);
        clients.add(pe1);
        clients.add(pe2);
        clients.add(pe3);
        clients.add(pe4);
        Car temp = new Honda(2243232, "white", 4, true, true, "Civic", 0, 120000, 50);
        Car temp1 = new Honda(2213213, "black", 4, true, true, "Acord", 10, 150000, 70);
        Car temp2 = new Honda(2213213, "black", 2, true, true, "N360", 10, 170000, 85);
        Car temp3 = new Volvo(2132143, "red", 4, true, "s60", true, 7, 230000, 120);
        Car temp4 = new Volvo(2184242, "blue", 2, true, "cx40", true, 7, 230000, 140);
        Car temp5 = new Toyota(4567819, "grey", 4, false, 2, 12000, "corola", true, 100);
        carList.add(temp);
        carList.add(temp1);
        carList.add(temp2);
        carList.add(temp3);
        carList.add(temp4);
        carList.add(temp5);
        RentCard card = new RentCard(pe, temp1, "21.11.20", "23.11.20", 4, 600);
        RentCard card1 = new RentCard(pe3, temp5, "20.11.20", "20.12.20", 30, 6000);
        RentCard card2 = new RentCard(pe3, temp4, "18.11.20", "24.11.20", 6, 2300);
        rentals.add(card);
        rentals.add(card1);
        rentals.add(card2);
    }

    public void PrintClient(int num) {
        System.out.println(clients.get(num).getName());
    }

    public void printAllClient() {
        for (int x = 0; x < clients.size(); x++)
            System.out.println(clients.get(x).getName()+ ",  Id: " + clients.get(x).getId()) ;

    }

    public void printAllTheEmploid() {
        for (int x = 0; x < clients.size(); x++) {
            System.out.println("Name: " + clients.get(x).getName());
            System.out.println("Id: " + clients.get(x).getId());
            System.out.println("Age: " + clients.get(x).getAge());
            System.out.println("Job: " + clients.get(x).getJob());
            System.out.println("\n");

        }
    }

    public boolean checkWorkerByJOb(){
        String job;
        int succses=0;
        Scanner myObj = new Scanner(System.in);
        do {
            System.out.println("which category? (manager,secretary,seller), press '0' to exit");
            job = myObj.nextLine();
            if(job.equals("0"))
                return true;
            succses = printWorkerByJob(job);
        }while (succses == 0);
        return true;
    }

    public int printWorkerByJob(String job) {
        String temp;
        if(!job.contains("manager") && !job.contains("secretary") && !job.contains("seller")){
            System.out.println("there is not such job");
            return 0;
        }
        System.out.println("\n");
        for (int x = 0; x < workers.size(); x++) {
            temp = workers.get(x).getJob();
            if (temp.equals(job))
                System.out.println(workers.get(x).getName() + "  job: "+ workers.get(x).getJob() + "; Id: "+ workers.get(x).getId());
        }
        return 1;
    }

    public void printAllTheCars() {
        String temp;
        for (int x = 0; x < carList.size(); x++) {
            temp = carList.get(x).getClass().toString();
            temp = temp.substring(11);
            System.out.println("catalog number: " + x + ", company: " + temp + ", model: " + carList.get(x).getModel() + ", " + "Amount: " + carList.get(x).getAmount());
        }
    }

    public void viewDescreopionOfAllCar() {
        for (int x = 0; x < carList.size(); x++) {
            ViewDescerptionByCataloganumber(x);
            System.out.println("\n");
        }

    }

    public void ViewDescerptionByCataloganumber(int num) {
        System.out.println("company: " + carList.get(num).getClass().toString().substring(11));
        System.out.println("model: " + carList.get(num).getModel());
        System.out.println("number: " + carList.get(num).getNumber());
        System.out.println("color: " + carList.get(num).getColor());
        System.out.println("number of doors: " + carList.get(num).getDoorsNumber());
        System.out.println("as a sunroof: " + carList.get(num).isSunroof());
        System.out.println("as a emobilaizer: " + carList.get(num).isEmobilaizer());
        System.out.println("price: " + carList.get(num).getPrice());
        System.out.println("Amount: " + carList.get(num).getAmount());
        System.out.println("Price per a Day: : " + carList.get(num).getPricePerADay());
    }

    public void printAllRentedCard() throws ParseException {
        int sum = 0;
        String tempModel;
        for (int x = 0; x < rentals.size(); x++) {
            System.out.println("Name of The client: " + rentals.get(x).getClient().getName());
            tempModel = rentals.get(x).getRentCar().getClass().toString().substring(11);
            System.out.println("Car moddle: " + tempModel + "-" + rentals.get(x).getRentCar().getModel());
            System.out.println("Date: " + rentals.get(x).getRentDate());
            System.out.println("Date od the Return: " + rentals.get(x).getDateOfReturn());
            System.out.println("Numbers Of rent Days: " + rentals.get(x).getNumberOfRentDay());
            System.out.println("Price of all period: " + rentals.get(x).getPriceOfAllPeriod());
            sum = DateUtils.CalculateDaysOfRent(DateUtils.dateOfToday(), rentals.get(x).getDateOfReturn());
            if (sum < 0) {
                System.out.println(DateUtils.ANSI_RED + "This Car are late in: " + Math.abs(sum) + " days" + DateUtils.ANSI_RESET);
            }
            System.out.println("\n");
        }
    }

    public void SearchClientByName(String name) //for rentcard function
    {
        for (int x = 0; x < clients.size(); x++) {
            if (clients.get(x).getName().contains(name))
                System.out.println("number: " + x + ", " + clients.get(x).getName() + " Id: " + clients.get(x).getId());
        }
    }
    public void PrintAllTheRentCard() {
        for (int x = 0; x < rentals.size(); x++) {
            System.out.println("Name: " + rentals.get(x).getClient().getName());
            System.out.println("cars.Car: " + rentals.get(x).getRentCar().getModel());
            System.out.println("Date: " + rentals.get(x).getRentDate());
            System.out.println("Return date: " + rentals.get(x).getDateOfReturn());
        }
    }

    public Car getCarByNumber(int num) { //try and catch, return null
        return carList.get(num);
    }

    public Person getClientByNumber(int num) {
        return clients.get(num);
    }

    public void addRentalCard(RentCard card) {
        rentals.add(card);
    }

    public int getAmountOfCarModels() {
        return carList.size();
    }

    public boolean ifThereIsCarOnStock(int num) {
        return carList.get(num).getAmount() > 0;
    }

    public List<Integer> numberOfThisClientName(String name) {
        List<Integer> li = new ArrayList<>();
        for (int x = 0; x < clients.size(); x++) {
            if (clients.get(x).getName().contains(name) && !name.isEmpty()) {
                li.add(x);
            }
        }
        return li;
    }

    public List<RentCard> getRentals() {
        return rentals;
    }

    public void addNewClient() {
        Scanner myObj = new Scanner(System.in);
        String name;
        int age = 0,id = 0;
        do{
            name = selectNameOfNewClient();
            if(name != null && name.equals("exists"))
                name =null;
        }while (name == null);
        do {
            age = selectAgeOfNewClient();
        }while(age == 0);

        do {
            id = selectIdOfNewClient();
        }while(id == 0);
        Person newPerson = new Person(name,age,id);
        clients.add(newPerson);

    }

    public void viewAllTheLateReturn() throws ParseException {
        for(int x=0;x<rentals.size();x++)
        {
            if(DateUtils.CalculateDaysOfRent(DateUtils.dateOfToday(),rentals.get(x).getDateOfReturn())<0){
                int sum = 0;
                String tempModel;
                    System.out.println("Name of The client: " + rentals.get(x).getClient().getName());
                    tempModel = rentals.get(x).getRentCar().getClass().toString().substring(11);
                    System.out.println("Car moddle: " + tempModel + "-" + rentals.get(x).getRentCar().getModel());
                    System.out.println("Date: " + rentals.get(x).getRentDate());
                    System.out.println("Date od the Return: " + rentals.get(x).getDateOfReturn());
                    System.out.println("Numbers Of rent Days: " + rentals.get(x).getNumberOfRentDay());
                    System.out.println("Price of all period: " + rentals.get(x).getPriceOfAllPeriod());
                    sum = DateUtils.CalculateDaysOfRent(DateUtils.dateOfToday(), rentals.get(x).getDateOfReturn());
                    System.out.println(DateUtils.ANSI_RED + "This Car are late in: " + Math.abs(sum) + " days" + DateUtils.ANSI_RESET);
                    System.out.println("\n");
            }

        }
    }

    public String selectNameOfNewClient(){
        Scanner myObj = new Scanner(System.in);
        String name;
        char c;
        System.out.println("name of te client: ");
        name = myObj.nextLine();
        for(int x=0;x<clients.size();x++)
            if(clients.get(x).getName().contains(name) && clients.get(x).getName().length() == name.length()){
                System.out.println("this client Exists");
                return "exists";
            }

        for(int i=0;i<name.length();i++)
        {
            if(name.charAt(i)==' ')
            {
                try {
                    c= (name.charAt(i + 1));
                    if (Character.isAlphabetic(c))
                        return name;
                }
                catch (IndexOutOfBoundsException e)
                {
                    System.out.println("you dont enter a last name");
                    return null;
                }
            }
        }
        System.out.println("you dont enter a last name");
        return null;
    }

    public int selectAgeOfNewClient() {
        Scanner myObj = new Scanner(System.in);
        int age=0;
        try {
            System.out.println("the age of the client: ");
            age = myObj.nextInt();
        } catch (Exception e) {
            System.out.println("please enter just number, not letters");
            return 0;
        }
        if(age < 17 || age > 100){
            System.out.println("the age is not Makes sense, try again");
            return 0;
        }
        return age;
    }

    public int selectIdOfNewClient(){
        Scanner myObj = new Scanner(System.in);
        int id;
        try {
            System.out.println("the Id number of the client: ");
            id = myObj.nextInt();
        } catch (Exception e) {
            System.out.println("please enter just number, not letters");
            return 0;
        }
        int b=Integer.toString(id).length();
        if(b!=9){
            System.out.println("you enter " + b+ " number, please enter Exactly 9 numbers\n");
            return 0;
        }
        return id;
    }

}


