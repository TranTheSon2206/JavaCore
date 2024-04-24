package shop;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Exception {
        Repository repositoty = new Repository();
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        Menu.mainMenu();
        int choise = scanner.nextInt();
        switch (choise){
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("Danh sach san pham ");
                repositoty.show();
                break;
            case 2:
                System.out.println("Cac san pham co gia tren 10.000");
                repositoty.filterProductByPrice();
                break;
            case 3:
                System.out.println("Cac san pham co tren 50 luot ban");
                repositoty.counProductByAmountSale();
                break;
            case 4:
                repositoty.showProductByCategory();
                break;
            case 5:
                repositoty.printSortedProductsBySoldQuantity();
                break;
            case 6:
                repositoty.findAndPrintBestSellingProduct();
                break;
            case 7:

                System.out.println("San pham sau khi sap sep : ");
                repositoty.sortAndPrintProductByName();
                break;
        }

    }
}