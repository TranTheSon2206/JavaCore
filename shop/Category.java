
package shop;

public enum Category {
    FOOD ("Thuc Pham"),HOUSEWARE ("DO GIA DUNG"), COSMETICS ("MY PHAM"), FASHTION ("THOI TRANG");
    private String value;
    private Category(String value){
        this.value =  value;
    }
    public String getValue(){
        return value;
    }
}