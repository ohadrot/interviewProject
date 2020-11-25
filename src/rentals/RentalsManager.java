package rentals;

import cars.Car;
import db.InventoryManager;
import utils.DateUtils;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RentalsManager {

    private InventoryManager inventoryManager;

    public void run() throws ParseException {
        int choose = 0;
        String job,name;
        Scanner myObj = new Scanner(System.in);
        Scanner myObj1 = new Scanner(System.in);
        while (true){
        printMenu();
        choose = myObj.nextInt();
        switch (choose) {
            case 1:
                inventoryManager.printAllClient();
                break;
            case 2:
               inventoryManager.checkWorkerByJOb();
               break;
            case 3:
                inventoryManager.viewDescreopionOfAllCar();
                break;
            case 4:
                addRentCard();
                break;
            case 5:
                inventoryManager.printAllRentedCard();
                break;
            case 6:
                selectCarToReturn();
                break;
            case 7:
                inventoryManager.addNewClient();
                break;
            case 8:
                inventoryManager.viewAllTheLateReturn();
                break;
        }



        }
    }

    public RentalsManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void printMenu(){
        System.out.println("\n"+"\n");
        System.out.println("today is: "+ DateUtils.dateOfToday()+ "\nhello, program are working.\nwhat do you want to do?" +"\n");
        System.out.println("1. print all the Clients");
        System.out.println("2. print all the Employees by job");
        System.out.println("3. View description of all the car");
        System.out.println("4. add a new rent card");
        System.out.println("5. print all the rented card");
        System.out.println("6. return car");
        System.out.println("7. add new client");
        System.out.println("8. view all the late return client");
    }

    public void addRentCard() throws ParseException {
        String pickDate = "", returnDate = "again";
        int Price, DaysSum;
        List<Integer> numberOfClientWitheThisName;
        int NumberOfCar = 0, numberOfClient;

        do {
            numberOfClientWitheThisName = selectClaintName();
        } while (numberOfClientWitheThisName.size() == 0 || numberOfClientWitheThisName ==null);

        do {
            numberOfClient = selectClaintByNumber(numberOfClientWitheThisName);
        } while (numberOfClient < 0);
        inventoryManager.printAllTheCars();
        int maxCarNum = inventoryManager.getAmountOfCarModels();
        do {
            NumberOfCar = selectCarNumber(maxCarNum);
        } while (NumberOfCar < 0);

        do{
            returnDate = selectDateToReturn();
        }while (returnDate.equals("again"));
        pickDate = DateUtils.dateOfToday();
        DaysSum = DateUtils.CalculateDaysOfRent(pickDate, returnDate);
        Car car = inventoryManager.getCarByNumber(NumberOfCar);
        Price = DaysSum * car.getPricePerADay();
        RentCard card = new RentCard(inventoryManager.getClientByNumber(numberOfClient), car, pickDate, returnDate, DaysSum, Price);
        inventoryManager.addRentalCard(card);
        car.reduceAmount();

    }

    public int carReturn(String name){
        String answer,rentName;
        for(int i=0; i<inventoryManager.getRentals().size();i++)
        {
            rentName = inventoryManager.getRentals().get(i).getClient().getName();
            if(rentName.equals(name))
            {
                System.out.println("if this is the car (y/n) ? ->  "+inventoryManager.getRentals().get(i).getRentCar().getModel());
                Scanner myObj = new Scanner(System.in);
                answer = myObj.nextLine();
                if(answer.equals("y") || answer.equals("Y"))
                {
                    inventoryManager.getRentals().remove(i);
                    return 1;
                }
                if(answer.equals("n") || answer.equals("N"))
                    continue;


            }
        }
        return -1;
    }

    public void selectCarToReturn(){
        String name;
        int answer;
        boolean succses=false;
        Scanner myObj = new Scanner(System.in);
        do {
            System.out.println("name of the client:  (press '0' to exit)");
            name = myObj.nextLine();
            if(name.equals("0"))
                return;
            answer = carReturn(name);
            if (answer == 1 ) {
                System.out.println("the card is remove");
                return;
            }
            if(answer ==0)
            {
                System.out.println("cancel the return");
                return;
            }
            System.out.println("wrong name");
        }while (answer== -1);
    }

    public int selectCarNumber(int maxCarNum) {
        System.out.println("which car number will you want to rent:");
        int NumberOfCar = -1;
        Scanner myObj = new Scanner(System.in);
        try {
            NumberOfCar = myObj.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("invalid input, dont enter letters, please enter number between 0-" + (maxCarNum-1));
            return -1;
        }
        if (NumberOfCar > maxCarNum || NumberOfCar < 0) {
            System.out.println("invalid input, please enter number between 0-" + (maxCarNum-1));
            return -1;
        }
        if (!inventoryManager.ifThereIsCarOnStock(NumberOfCar)) {
            System.out.println("there is out of stock, please choose another car");
            return -1;
        }
        return NumberOfCar;
    }// check if the car number is fine

    public List<Integer> selectClaintName() { ////check if the claint name is fine
        Scanner myObj = new Scanner(System.in);
        String name = "";
        List<Integer> numberOfnames = null;
        System.out.println("enter first client name:");
        try {
            name = myObj.nextLine();
        } catch (Exception e) {
            System.out.println("invalid input, please enter letters");
            return numberOfnames;
        }
        if (name.isEmpty()) {
            numberOfnames = inventoryManager.numberOfThisClientName(name);
            System.out.println("empty string, enter a name please");
            return numberOfnames;
        }
        numberOfnames = inventoryManager.numberOfThisClientName(name);
        if (numberOfnames.size() == 0) {
            System.out.println("there is no client: " + "'" + name + " '" + ", please try again");
            return numberOfnames;
        }

        inventoryManager.SearchClientByName(name);
        return numberOfnames;
    }

    public int selectClaintByNumber(List<Integer> numberOfpossibleClaint) {
        Scanner myObj = new Scanner(System.in);
        int numberOfClient;
        try {
            System.out.println("choose number of rent's client");
            numberOfClient = myObj.nextInt();
        } catch (Exception e) {
            System.out.println("invalid input, dont enter letters, please enter one of this numbers:" + numberOfpossibleClaint);
            return -1;
        }
        for (int i = 0; i < numberOfpossibleClaint.size(); i++) {
            if (numberOfClient == numberOfpossibleClaint.get(i))
                return numberOfClient;
        }
        System.out.println("wrong number, please enter one of this numbers:" + numberOfpossibleClaint);
        return -1;
    }

    public String selectDateToReturn() throws ParseException {
        int[] daysInMonthe={0,31,28,31,30,31,30,31,31,30,31,30,31};
        String returnDate;
        Scanner myObj = new Scanner(System.in);
        try {
            System.out.println("date of return: (Format: dd.mm.yy)");
            returnDate = myObj.nextLine();
        }
        catch (NoSuchElementException e){
            System.out.println("there is no text, enter the date again: ");
            return "again";
        }
        char[] charArray = stringToCharArray(returnDate);
        for(int i=0; i<charArray.length;i++)
            if(!Character.isDigit(charArray[i]))
            {
                System.out.println("tou enter a letters, please enter just numbers");
                return "again";
            }
        if(!DateUtils.CheckTheDateFormat(returnDate))
        {
            System.out.println("incorrect format, type again:" );
            return "again";
        }
        if(DateUtils.CalculateDaysOfRent(DateUtils.dateOfToday(),returnDate) <0)
        {
            System.out.println("this date are pass, enter correct date please");
            return "again";
        }
        int numDays =(daysInMonthe[Integer.parseInt(returnDate.substring(3,5))] );
        if(Integer.parseInt(returnDate.substring(0,2))>numDays) {
            System.out.println("in this month there is just :" + numDays +" days, try again");
            return "again";
        }
        return returnDate;

    }

    public char[] stringToCharArray(String date){
        char[] array = new char[date.length()];
        for(int i=0;i<date.length();i++) {
            if(i==2 || i==5)
                array[i]='2';
            else
            array[i] = date.charAt(i);
        }
        return array;
    }
}








