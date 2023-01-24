import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TransferQueue;

public class Main {
    public static void main(String[] args) {
        boolean flag = true, flag1 = true;
        Scanner input = new Scanner(System.in);

        Client client1 = new Client("Otabek", "Shadimatov", "berl1n", "9192649");
        Client client3 = new Client("Azamat", "Musagaliyev", "azabraza", "12345678");
        Client client2 = new Client("Kanye", "West", "hitlerlover", "1452356");

        ArrayList<Client> clients = new ArrayList<Client>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);

    while (flag1) {
            System.out.println("==========================");
            System.out.println(" ----=== AITU BANK ===----");
            System.out.println("==========================");
            System.out.println("Welcome! Choose one of the options: ");
            System.out.println("1. Login as a Client");
            System.out.println("2. Login as a Employee");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choose = input.nextInt();
            input.nextLine();


            switch (choose) {
                case 1:
                    System.out.print("Enter a login: ");
                    String userName = input.nextLine();
                    System.out.print("Enter a password: ");
                    String userPassword = input.nextLine();
                    if(!userName.isEmpty()){
                        flag = true;
                    }
                    while (flag) {
                        if (Client.login(clients, userName, userPassword)) {
                            System.out.println("Welcome " + Client.loggedClient.getName() + "! Choose one of the options: ");
                            System.out.println("1. Check balance");
                            System.out.println("2. Add deposit");
                            System.out.println("3. Make transaction");
                            System.out.println("4. Log out from the account");
                            int choose1 = input.nextInt();
                            input.nextLine();
                            switch (choose1) {
                                case 1:
                                    System.out.printf("Your balance are equal to: " + Client.loggedClient.checkBalance());
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.print("How much money you want to deposit: ");
                                    int cash = input.nextInt();
                                    input.nextLine();
                                    Client.loggedClient.addDeposit(cash);
                                    break;
                                case 3:
                                    System.out.print("Enter a name of the receiver: ");
                                    String receiverName = input.nextLine();

                                    System.out.print("Enter a surname of the receiver: ");
                                    String receiverSurname = input.nextLine();
                                    if (Client.findOut(clients, receiverName, receiverSurname)) {
                                        System.out.print("How much money you want to send: ");
                                        int sendMoney = input.nextInt();
                                        input.nextLine();
                                        Client.loggedClient.makeTransaction(Client.reciverClient, sendMoney);
                                    } else {
                                        System.out.println("The Client do not exist!");
                                    }
                                    break;
                                case 4:
                                    flag = false;
                                    break;
                                }
                            }
                        }
                    break;
                case 3:
                    flag1 = false;
            }
    }
                }
}

