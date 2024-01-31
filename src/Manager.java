package src;

import io.IO;
import model.Product;
import validate.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    public List<Product> products = new ArrayList<>();
    public Validate validate = new Validate();
    Scanner scanner = new Scanner(System.in);


    // chức năng thêm mới
    public void add(Product product) {
        products.add(product);
    }

    public Product create() {
        int id = validate.validateId();
        System.out.println("enter product name");
        String name = scanner.nextLine();
        double price = validate.validatePrice();
        int quantity = validate.validateQuantity();
        System.out.println("enter description");
        String description = scanner.nextLine();
        return new Product(id, name, price, quantity, description);
    }

    public void display() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // chức năng sửa, xoá theo Id nhập vào
    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        System.out.println("id does not exist");
        return -1;
    }

    public void edit() {
        display();
        try {
            System.out.println("enter product id to edit");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);
            if (index != -1) {
                products.set(index, create());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            System.out.println("enter id to delete");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);
            if (index != -1) {
                products.remove(index);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // chức năng sắp xếp theo giá tăng dần, giảm dần
    public void sortIncrease() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < products.size() - i - 1; j++) {
                if (products.get(j).getPrice() > products.get(j + 1).getPrice()) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
    }

    public void sortDecrease() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < products.size() - i - 1; j++) {
                if (products.get(j).getPrice() < products.get(j + 1).getPrice()) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
    }

    // chức năng tìm sản phẩm giá cao nhất
    public Product findHighestPrice() {
        if (!products.isEmpty()) {
            Product max = products.get(0);
            for (Product p : products) {
                if (p.getPrice() > max.getPrice()) {
                    max = p;
                }
            }
            return max;
        } else {
            return null;
        }
    }

    // chức năng đọc ghi file
    public void read() {
        products = IO.read();
    }

    public void write() {
        IO.write(products);
    }
}

