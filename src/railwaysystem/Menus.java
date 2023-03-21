package railwaysystem;

import java.util.Scanner;

public class Menus {

    static Scanner input = new Scanner(System.in);
    static RailwayManage railManger = new RailwayManage();

    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        while (true) {
            System.out.println("============== Welcome To the Railway System ==============");
            System.out.println("1- Add Passanger ");
            System.out.println("2- Remove A Passanger ");
            System.out.println("3- Update A Passanger ");
            System.out.println("4- Display Passanger's List ");
            System.out.println("5- Search for a Passanger ");
            System.out.println("6- Sort Passanger's List ");
            System.out.println("7- Exit ");

            int menuChoice = tryInt("Choose from the menu above:");
            switch (menuChoice) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    sort();
                    break;
                case 7:
                    exit();
                    break;
                default:
                    System.out.println("You enterd a wrong choice");
                    break;
            }
        }
    }

    public static void add() {

        String fName = tryString("Enter your First name: ");
        String lName = tryString("Enter your Last name: ");
        String phone = tryString("Enter your Phone: ");
        String city = tryString("Enter your City: ");
        String address = tryString("Enter your Address: ");
        String sex = "";
        while (sex.equals("")) {
            System.out.println("Choose your sex: ");
            System.out.println("1- Male");
            System.out.println("2- Female ");
            int menuChoice = tryInt("Choose from the menu above:");
            switch (menuChoice) {
                case 1:
                    sex = "Male";
                    break;
                case 2:
                    sex = "Female";
                    break;
                default:
                    System.out.println("You enterd a wrong choice");
                    break;
            }
        }
        String email = tryString("Enter your email: ");
        String seat = "";
        while (seat.equals("")) {
            System.out.println("Choose your Seat Class: ");
            System.out.println("1- Economy");
            System.out.println("2- Business ");
            int menuChoice = tryInt("Choose from the menu above:");
            switch (menuChoice) {
                case 1:
                    seat = "Economy";
                    break;
                case 2:
                    seat = "Business";
                    break;
                default:
                    System.out.println("You enterd a wrong choice");
                    break;
            }
        }

        Passanger newPass = new Passanger(fName, lName, phone, city, address, sex, email, seat);
        railManger.AddPasanger(newPass);
    }

    public static void remove() {
        String ticketNo = tryString("Enter The ticket number that you want to remove: ");
        boolean isAvaliable = railManger.DisplayTicket(ticketNo);
        if (isAvaliable) {
            String sure = tryString("Are You sure you want to remove this ticket ? (Y for Yes)");
            if (sure.startsWith("Y") || sure.startsWith("y")) {
                railManger.DeleteTicket(ticketNo);
                System.out.println("Deleted Successfully");
            } else {
                System.out.println("Nothing Deleted");
            }
        } else {
            System.out.println("There is no ticket with the number you entered");
        }

    }

    public static void update() {
        String ticketNo = tryString("Enter The ticket number of the passanger you want to Update: ");
        boolean isAvaliable = railManger.DisplayTicket(ticketNo);
        if (!isAvaliable) {
            System.out.println("There is no ticket with the number you entered");
        } else {
            //Update Info
        }
    }

    public static void display() {
        railManger.DisplayTicket();
    }

    public static void search() {
        String ticketNo = tryString("Enter The ticket number that you want to Search for: ");
        boolean isAvaliable = railManger.DisplayTicket(ticketNo);
        if (!isAvaliable) {
            System.out.println("There is no ticket with the number you entered");
        }
    }

    public static void sort() {
        railManger.SortTickets();
        railManger.DisplayTicket();
    }

    public static void exit() {
        System.out.println("Bey");
        System.exit(0);
    }

    public static String tryString(String msg) {
        String value = "";
        boolean isNull = true;
        do {
            System.out.print(msg);
            value = input.nextLine();

            if (!value.equals("")) {
                isNull = false;
            } else {
                System.out.println("You cannot leave it empty, please type something");
            }

        } while (isNull);
        return value;
    }

    public static int tryInt(String msg) {
        int value = 0;
        while (true) {
            try {
                //Show passed Message 
                System.out.print(msg);
                String stValue = input.nextLine();

                if (stValue.equals("")) {
                    System.out.println("You cannot leave it empty, please type something");
                } else {
                    value = Integer.parseInt(stValue);
                }

                //Allow only Positive 
                if (value > 0) {
                    return value;
                } else {
                    if (!stValue.equals("")) {
                        System.out.println("Positive Numbers only and no zeros");
                    }
                }

            } catch (Exception ex) {
                System.out.println("Input Numbers only");
            }
        }
    }
}
