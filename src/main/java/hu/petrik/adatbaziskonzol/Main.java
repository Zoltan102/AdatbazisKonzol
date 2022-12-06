package hu.petrik.adatbaziskonzol;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            DagDB dawg = new DagDB();
            List<Dog> dogs = dawg.getDogs();
            for (Dog d:dogs) {
                System.out.println(d);
            }
        } catch (SQLException e) {
            System.err.println("Baj van tesó! Az dog.");
        }
    }

}
