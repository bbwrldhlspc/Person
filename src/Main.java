import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Person> personArrayList = new ArrayList<>();

    public static void main(String[] args) {
        commandLoop();
    }

    private static void commandLoop() {
        for (; ; ) {
            String cmd = askString("cmd> ");

            switch (cmd.toLowerCase()) {
                case "exit":
                    return;
                case "create":
                    create();
                    break;
                case "list":
                    printList(personArrayList);
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    private static void printList(ArrayList<Person> personArrayList) {
        for (Person p : personArrayList)
        System.out.println(p);
    }

    private static void create() {
        for (; ; ) {
            String create = askString("Create ");

            switch (create.toLowerCase()) {
                case "person":
                    createPerson();
                    return;
                case "exit":
                    return;
                default:
                    System.out.println("Unknown type");

            }
        }


    }

    private static void createPerson() {
        Person person = new Person();
        String firstname = askString("First Name: ");
        String lastname = askString("Last Name: ");
        String phone = askString("Phone Number: ");

        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setPhone(phone);

        personArrayList.add(person);
    }

    private static String askString (String message) {
        System.out.print(message);
        return scanner.next();
    }
}
