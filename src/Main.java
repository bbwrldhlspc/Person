import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Record> personArrayList = new ArrayList<>();

    public static void main(String[] args) {
        commandLoop();
    }

    private static void commandLoop() {
        for (; ; ) {
            String cmd = askString("cmd> ");

            switch (cmd.toLowerCase()) {
                case "find":
                    find();
                    break;
                case "help":
                    help();
                    break;
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

    private static void help() {
        System.out.println("You've entered a person database help command.");
        System.out.println("There are following commands in this program.");
        System.out.println("");
        System.out.println("Create >");
        System.out.println("\t -person or - note (sub commands ) allows you to start creating a new persons or note.");
        System.out.println("List >");
        System.out.println("\t Prints out the list of already created people and their contact info.");
        System.out.println("Exit >");
        System.out.println("\t Allows you to either go back or terminate program.");
        System.out.println("");
    }

    private static void printList(ArrayList<Record> personArrayList) {
        for (Record p : personArrayList)
            System.out.println(p);
    }

    private static void find() {
        String part = askString("What are you looking for?");
        for (Record r : personArrayList) {
            if (r.contains(part)) {
                System.out.println(r);
            }
        }
    }

    private static void create() {
        for (; ; ) {
            String create = askString("Create ");
            switch (create.toLowerCase()) {
                case "person":
                    addRecord(new Person());
                    return;
                case "note":
                    addRecord(new Note());
                    return;
                case "exit":
                    return;
                default:
                    System.out.println("Unknown type");

            }
        }
    }

    private static void addRecord(Record record) {
        record.askUserData();
        personArrayList.add(record);
        System.out.println("Record Created!");
    }

    public static String askString(String message) {
        System.out.print(message);
        String str = scanner.next();
        if (str.startsWith("\"")) {
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            while (!str.endsWith("\"")) {
                str = scanner.next();
                list.add(str);
            }
            str = String.join(" ", list);
            str = str.substring(1, str.length() - 1);
        }
        return str;
    }
}
