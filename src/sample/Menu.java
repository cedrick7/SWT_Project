package sample;

import java.io.Serializable;

public class Menu implements Serializable {

    int menuIndex;
    String weekday;
    String menuTitle;
    String menuContent;
    double menuPrice;
    String menuFoodType;

    public Menu(int menuIndex, String weekday, String menuTitle, String menuContent, Double menuPrice, String menuFoodType) {
        this.menuIndex = menuIndex;
        this.weekday = weekday;
        this.menuTitle = menuTitle;
        this.menuContent = menuContent;
        this.menuPrice = menuPrice;
        this.menuFoodType = menuFoodType;
    }

    public int getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(int menuIndex) {
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

    public String getMenuFoodType() {
        return menuFoodType;
    }

    public void setMenuFoodType(String foodType) {
        this.menuFoodType = foodType;
    }
}