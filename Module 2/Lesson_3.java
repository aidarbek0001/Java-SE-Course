// Practice 1
// Collections and the ArrayList class. A dynamic array.


// Task 1
// Create a dynamic array from the class Players.java
// Add 10 objects from the class Players.java then find the average value of the price, and the sum of the age of the players in the array.


import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {
        ArrayList<Players> players = new ArrayList<>();
        int sumAge = 0;
        double sum = 0;

        Players p1 = new Players("Player1", 15000, 20);
        Players p2 = new Players("Player2", 16000, 21);
        Players p3 = new Players("Player3", 17000, 22);
        Players p4 = new Players("Player4", 18000, 23);
        Players p5 = new Players("Player5", 19000, 24);
        Players p6 = new Players("Player6", 14000, 25);
        Players p7 = new Players("Player7", 13000, 26);
        Players p8 = new Players("Player8", 12000, 27);
        Players p9 = new Players("Player9", 11000, 28);
        Players p10 = new Players("Player10", 10000, 29);

        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.add(p6);
        players.add(p7);
        players.add(p8);
        players.add(p9);
        players.add(p10);

        for (Players player : players) {
            sumAge += player.getAge();
            sum += player.getPrice();
        }
        double average = sum/ players.size();
        System.out.println("Sum of ages: " + sumAge);
        System.out.println("Average price: " + average);
    }
}


public class Players {
    String name;
    double price;
    int age;

    public Players() {

    }
    public Players(String name, double price, int age) {
        this.name = name;
        this.price = price;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
