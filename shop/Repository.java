package shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import static shop.Category.FOOD;

public class Repository {
    List<Product> productLists = new ArrayList<>();
    public Repository(){
        productLists.add(new Product("01","Banh doraemon 3 vi", FOOD,100,3500,57));
        productLists.add(new Product("02","Xuc sich suon non ", FOOD,150,3500,12));
        productLists.add(new Product("03","Thanh cua ", FOOD,100,500,85));
        productLists.add(new Product("04","Banh khoai mon ", FOOD,200,42000,78));
        productLists.add(new Product("05","Thia an com inox ma vang",Category.HOUSEWARE,50,8000,4));
        productLists.add(new Product("06","Bat dung gia vi",Category.HOUSEWARE,50,4000,44));
        productLists.add(new Product("07","Nuoc hoa hong ",Category.COSMETICS,100,639000,7));
        productLists.add(new Product("08","Combo goi xa",Category.COSMETICS,100,333500,57));
        productLists.add(new Product("09","Tinh chat duong am sau",Category.COSMETICS,100,249000,24));
        productLists.add(new Product("10","Kem duong the",Category.COSMETICS,55,715500,57));
        productLists.add(new Product("11","AO thun TESUN",Category.FASHTION,100,320500,57));

    }
    public void show(){
        productLists.forEach(product -> System.out.println(product));
    }
    public void sortProductByName(){
        productLists.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));

    }
    public void showProductByCategory() {
        for (Category category : Category.values()) {
            System.out.println("Products in category " + category + ":");
            for (Product pro : productLists) {
                if (pro.getCategory() == category) {
                    System.out.println(pro);
                }
            }
            System.out.println(); // Add a blank line for separation
        }
    }
    public void filterProductByPrice(){
        productLists.stream()
                .filter(product -> product.getPrice()>10000)
                .forEach(product -> System.out.println(product));
    }
    public void counProductByAmountSale(){
        long count = productLists.stream()
                .filter(product -> product.getAmountSale()>= 50)
                .count();
        System.out.println("So luong san pham duoc ban tu 50 tro len la : " + count);
    }
    public void printSortedProductsBySoldQuantity() {
        // Sắp xếp sản phẩm từ cao tới thấp
        sortBySoldQuantity(true);
        // In ra danh sách sản phẩm đã sắp xếp
        System.out.println("\n------------------------------------------\n");
        // Sắp xếp sản phẩm từ thấp tới cao
        sortBySoldQuantity(false);
        System.out.println("\n------------------------------------------\n");
    }

    public void sortBySoldQuantity(boolean descending) {
        // Sắp xếp sản phẩm theo số lượng bán được
        for (int i = 0; i < productLists.size() - 1; i++) {
            for (int j = 0; j < productLists.size() - i - 1; j++) {
                if (descending) {
                    if (productLists.get(j).getAmountSale() < productLists.get(j + 1).getAmountSale()) {
                        // Hoán đổi vị trí của hai sản phẩm
                        Product temp = productLists.get(j);
                        productLists.set(j, productLists.get(j + 1));
                        productLists.set(j + 1, temp);
                    }
                } else {
                    if (productLists.get(j).getAmountSale() > productLists.get(j + 1).getAmountSale()) {
                        // Hoán đổi vị trí của hai sản phẩm
                        Product temp = productLists.get(j);
                        productLists.set(j, productLists.get(j + 1));
                        productLists.set(j + 1, temp);
                    }
                }
            }
        }

        // Hiển thị danh sách sản phẩm đã sắp xếp
        if (descending) {
            System.out.println("Danh sách sản phẩm đã sắp xếp từ cao tới thấp theo số lượng bán được:");
        } else {
            System.out.println("Danh sách sản phẩm đã sắp xếp từ thấp tới cao theo số lượng bán được:");
        }
        for (Product product : productLists) {
            System.out.println(product);
        }
    }



    // Constructor and other methods...

    public void sortAndPrintProductByName() {
        // Sắp xếp sản phẩm từ A-Z
        sortByProductName(true);
        // In ra dòng phân tách
        System.out.println("\n------------------------------------------\n");
        // Sắp xếp sản phẩm từ Z-A
        sortByProductName(false);
    }

    private void sortByProductName(boolean ascending) {
        // Sắp xếp sản phẩm theo tên
        Collections.sort(productLists, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (ascending) {
                    return p1.getName().compareTo(p2.getName());
                } else {
                    return p2.getName().compareTo(p1.getName());
                }
            }
        });

        // Hiển thị danh sách sản phẩm đã sắp xếp
        if (ascending) {
            System.out.println("Danh sách sản phẩm đã sắp xếp từ A-Z theo tên:");
        } else {
            System.out.println("Danh sách sản phẩm đã sắp xếp từ Z-A theo tên:");
        }
        for (Product product : productLists) {
            System.out.println(product);
        }
    }
    public void findAndPrintBestSellingProduct() {
        // Sắp xếp danh sách sản phẩm theo số lượng bán từ cao xuống thấp
        Collections.sort(productLists, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Integer.compare((int) p2.getAmountSale(), (int) p1.getAmountSale());
            }
        });

        // Lấy sản phẩm đầu tiên trong danh sách đã sắp xếp
        if (!productLists.isEmpty()) {
            Product bestSellingProduct = productLists.get(0);
            System.out.println("Sản phẩm được bán nhiều nhất là:");
            System.out.println(bestSellingProduct);
        } else {
            System.out.println("Không có sản phẩm nào trong danh sách.");
        }
    }
    public void sortBySoldQuantity() {
    }
}