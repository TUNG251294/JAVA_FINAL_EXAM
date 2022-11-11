package FINAL_EXAM;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProductManagementMenu {
    ProductManagement productManagement = ProductManagement.getProductManagement();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        System.out.println("Product Management");
        System.out.println("1.Display all products");
        System.out.println("2.Add a product");
        System.out.println("3.Update a product");
        System.out.println("4.Remove a product");
        System.out.println("5.Sort");
        System.out.println("6.Search the most expensive");
        System.out.println("7.Read");
        System.out.println("8.Write");

        System.out.println("9.Exit");
    }


    public void handleMenu() throws IOException {
        int choice = -1;
        do {
            menu();
            System.out.println("Input your choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    displayAll();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;

                case 5: /////////////////
                    searchID();
                    break;
                case 6://////////////////////
                    searchName();
                    break;

                case 9:
                    break;
                default:
                    break;
            }
        } while (choice != 9);
    }

    private void add() {
        System.out.println("Input product's ID");
        String id = scanner.nextLine();

        String name = "";
        String description = "";
        Double price = 0.0;
        int quantity = 0;

        if(productManagement.searchByID(id) != null){
            System.err.println("Product id da ton tai");
            add();      /*dang su dung de quy*/
            return;
        }
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input product's name");
            name = scanner.nextLine();
        } while (name.equals(""));

        boolean flag;
        do {
            flag = true;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input product's price");
            String str = scanner.nextLine();
            boolean isDouble = Pattern.matches("^[0-9]+\\.[0-9]+$",str);
            if(isDouble){
                price = Double.parseDouble(str);
            } else {
                flag = false;}

        } while (!flag);

        do {
        System.out.println("Input description:");
        description = scanner.nextLine();
        } while (description.equals(""));

        boolean flag02;
        do {
            flag02 = true;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input quantity");
            String str = scanner.nextLine();
            boolean isInt = Pattern.matches("^[0-9]+$",str);
            if(isInt){
                quantity = Integer.parseInt(str);
            } else {
                flag = false;}
        } while (!flag);

        Product newProduct = new Product(id, name, price, description, quantity);
        productManagement.add(newProduct);
    }

    private void update(){
        System.out.println("Input ID");
        String id = scanner.nextLine();
        System.out.println("Input new name");
        String name = scanner.nextLine();
        System.out.println("Input price");
        Double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Input desciption");
        String description = scanner.nextLine();
        System.out.println("Input quantity");

        int quantity = scanner.nextInt();
        scanner.nextLine();

        productManagement.update(id,name,price,description,quantity);
    }
    private void remove(){
        System.out.println("Input ID");
        String id = scanner.nextLine();
        productManagement.remove(id);
    }
    private void searchID(){
        System.out.println("Input product's ID");
        String id = scanner.nextLine();
        System.out.println(productManagement.searchByID(id));
    }

    private void searchName(){ /*BUG- cho vong for chay qua arraylist de xuong hang khi ra ket qua*/
        System.out.println("Input product's name");
        String name = scanner.nextLine();
        System.out.println(productManagement.searchByName(name));
    }

    public void displayAll(){
        System.out.println(productManagement.display());
    }
}
