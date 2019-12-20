package sample;

public class Menu {

    int menuIndex;
    String weekday;
    String menuTitle;
    String menuContent;
    double menuPrice;
    String foodType;

    public Menu(Integer menuIndex, String weekday, String menuTitle, String menuContent, Double menuPrice, String foodType) {
        this.menuIndex = menuIndex;
        this.weekday = weekday;
        this.menuTitle = menuTitle;
        this.menuContent = menuContent;
        this.menuPrice = menuPrice;
        this.foodType = foodType;
    }

    public int getMenuIndex() {
        return menuIndex;
    }

    public void getMenuIndex(int menuIndex) {
        this.menuIndex = menuIndex;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuContent() {
        return menuContent;
    }

    public void setMenuContent(String menuContent) {
        this.menuContent = menuContent;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(double menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
}