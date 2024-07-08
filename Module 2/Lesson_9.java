// Practice 1
// JDBC - database


// Task 1
// Create a mini-application in which we add data to the list of products via the console.
// Our product class:
//         Items.java
//         - Long id;
//         - String name;
//         - int price;
// The console menu of our application:
//         PRESS [1] TO ADD ITEMS
//               Insert name:
//               Insert price:
//         PRESS [2] TO LIST ITEMS
//         PRESS [3] TO DELETE ITEMS
//               Insert ID:
//         PRESS [0] TO EXIT
// Our program must use a MySQL database, via the JDBC Driver.




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Connection conn;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Items> items = new ArrayList<>();
        connectToDB();
        while (true){
            System.out.println("[1] TO ADD ITEM");
            System.out.println("[2] TO LIST ITEMS");
            System.out.println("[3] TO DELETE ITEM");
            System.out.println("[0] TO EXIT");
            int choice = in.nextInt();
            if(choice == 1){
                System.out.println("Insert name:");
                String name = in.next();
                System.out.println("Insert price:");
                int price = in.nextInt();
                Items i = new Items(null, name, price);
                addItem(i);
            } else if (choice == 2) {
                items = getAllItems();
                for (Items i:items){
                    System.out.println(i);
                }
            } else if (choice == 3) {
                System.out.println("Insert id of item for delete:");
                int id = in.nextInt();
                deleteItem(id);
            } else if (choice == 0) {
                disconnectFromDB();
                break;
            }
        }
    }
    public static void connectToDB () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?useUnicode=true$serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void disconnectFromDB(){
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Items> getAllItems(){
        ArrayList<Items> items = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("select * from items");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                items.add(new Items(id, name, price));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public static void addItem(Items i){
        try {
            PreparedStatement st = conn.prepareStatement("insert into items(name, price) values(?,?)");
            st.setString(1,i.getName());
            st.setInt(2, i.getPrice());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteItem(int id){
        try {
            PreparedStatement st = conn.prepareStatement("delete from items where id=?");
            st.setInt(1, id);
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
