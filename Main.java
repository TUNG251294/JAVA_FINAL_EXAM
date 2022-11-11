package FINAL_EXAM;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        ProductManagementMenu productManagementMenu = new ProductManagementMenu();
        try {
            productManagementMenu.handleMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
