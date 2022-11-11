package FINAL_EXAM;

import java.io.*;
import java.util.ArrayList;

public class ProductManagement{
    private ArrayList<Product> products;
    private final String PATH = "FINAL_EXAM/productList.csv";
    private static ProductManagement productManagement = new ProductManagement(); /*static chi new 1 lan khi chay ung dung*/

    public static ProductManagement getProductManagement() {
        return productManagement;
    }

    public ProductManagement() {
        products = new ArrayList<>();
        readFromFile();

        Product p1 = new Product("vina01", "Vinamilk", 35000, "ngon", 100);    /*add cung*/
        Product p2 = new Product("vina02", "Vinamilk", 37000, "bo", 200);
        Product p3 = new Product("milo01", "Milo", 28000, "re", 150);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        saveToFile();

    }

    public void add(Product p) { /*BUG- do xem id da ton tai chua*/
        products.add(p);
        saveToFile();
    }

    public void remove(String id) {
        Product productSearch = searchByID(id);
        if (productSearch != null) {
            products.remove(productSearch);
            saveToFile();
        }
    }

    public void update(String id, String name, double price, String description, int quantity) {
        Product productSearch = searchByID(id);
        if (productSearch != null) {
            productSearch.setId(id);
            productSearch.setName(name);
            productSearch.setPrice(price);
            productSearch.setDescription(description);
            productSearch.setQuantity(quantity);
            saveToFile();
        }
    }


    public ArrayList<Product> searchByName(String name) {    /*Neu Map thi dung Set<Product> keys = products.keySet(); de duyet phan tu*/
        ArrayList<Product> arrList = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().equals(name)) {
                arrList.add(p);
            }
        }
        return arrList;
    }

    public Product searchByID(String id) {
        for (Product p : products) {    /*Neu Map thi dung for (Map.Entry<Product,Integer> p: products.entrySet()) de duyet*/
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void saveToFile() {
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            BufferedWriter cache = new BufferedWriter(fileWriter);
            for (Product p : products) {
                cache.write(p.toString());  //Neu dung Map thi co them 1 dau phay va 1 gia tri value nên se them cache.write(",");
                cache.newLine();            //cache.write(p.getValue().toString());
            }
            cache.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        products.clear();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader cache02 = new BufferedReader(fileReader);

            String line = "";
            Product p;
            while ((line = cache02.readLine()) != null) {
                p = handLine(line);
                products.add(p);
            }
            cache02.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product handLine(String line) {
        String[] str = line.split(",");
        Product newProduct = new Product(str[0],str[1],Double.parseDouble(str[2]), str[3] ,Integer.parseInt(str[4]));
        return newProduct;
    }

        public String display() {
            String productList = "";
            for (Product p : products) {
                productList += p.toString() + "\n";
            }
            return productList;
        }

}
