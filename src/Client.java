import java.util.ArrayList;

public class Client {
    private static int id_gen = 1;
    private int id;
    private String name;
    private String surname;
    private String password;
    private String login;
    private int balance = 0;

    public static Client loggedClient, reciverClient;


    public Client(){
        id = id_gen++;
    }

    public Client(String name, String surname, String login, String password) {
        setName(name);
        setSurname(surname);
        setLogin(login);
        setPassword(password);
    }

    public void addDeposit(double cash){
        balance += cash;
    }

    public double checkBalance(){
        return balance;
    }
    public void makeTransaction(Client client, double cash){
        if(balance > cash){
            balance -= cash;
            client.balance += cash;
        }else{
            System.out.println("Man you don't have enough money to transfer!");
        }
    }
    public static boolean login(ArrayList<Client> clients, String username, String password){
        for(Client client: clients){
            if(client.getLogin().equals(username) && client.getPassword().equals(password)){
                loggedClient = client;
                return true;
            }
        }
        return false;
    }

    public static boolean findOut(ArrayList<Client> clients, String reciverName, String reciverSurname){
        for(Client client: clients){
            if(client.getName().equals(reciverName) && client.getSurname().equals(reciverSurname)){
                reciverClient = client;
                return true;
            }
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

