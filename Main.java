import src.Manager;

import java.util.Scanner;

public class Main {
   static Scanner scanner = new Scanner(System.in);
    static Manager manager = new Manager();
    public static void main(String[] args) {

        while (true){
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
        System.out.println("Chọn chức năng theo số để tiếp tục");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xoá");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi vào file");
        System.out.println("9. Thoát");
        System.out.println("Chọn chức năng: ");
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e){

            }
        }
        switch (choice) {
            case 1:
                System.out.println("Bạn đã chọn chức năng xem danh sách");
                manager.display();
                break;
            case 2:
                System.out.println("Ban đã chọn chức năng thêm mới sản phẩm");
                manager.add(manager.create());
                System.out.println("Them moi thanh cong");
                break;
            case 3:
                System.out.println("Bạn đã chọn chức năng cập nhật sản phẩm");
                manager.edit();
                break;
            case 4:
                System.out.println("Bạn đã chọn chức năng xoá sản phẩm");
                manager.delete();
                break;
            case 5:
                System.out.println("Bạn đã chọn chức năng sắp xếp sản phẩm");
                menuSort();
                System.out.println("Kết quả sắp xếp");
                manager.display();
                break;
            case 6:
                System.out.println("Bạn đã chọn chức năng tìm sản phẩm giá cao nhất");
                manager.findHighestPrice();
                break;
            case 7:
                System.out.println("Bạn đã chọn chức năng đọc từ file");
                manager.read();
                break;
            case 8:
                System.out.println("Bạn đã chọn chức năng ghi vào file");
                manager.write();
                break;
            case 9:
                return;


        }
        }
    }
    public static void menuSort(){
        while(true){
            System.out.println("1. Sort by Increasing Price");
            System.out.println("2. Sort by Decreasing Price");
            System.out.println("3. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    manager.sortIncrease();
                    break;
                case 2:
                    manager.sortDecrease();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("wrong choice");
            }
        }
    }
}
