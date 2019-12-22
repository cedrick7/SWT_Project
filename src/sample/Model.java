package sample;

import java.util.ArrayList;


public class Model {

    // init class variables
    public static ArrayList<Menu> arrayList = new ArrayList<>();

    public static void initAL(){
        arrayList.add(0, new Menu(0, "nothing here", "nothing here", "nothing here", 0.00, "nothing here"));
        arrayList.add(1, new Menu(1, "nothing here", "nothing here", "nothing here", 0.00, "nothing here"));
        arrayList.add(2, new Menu(2, "nothing here", "nothing here", "nothing here", 0.00, "nothing here"));
        arrayList.add(3, new Menu(3, "nothing here", "nothing here", "nothing here", 0.00, "nothing here"));
        arrayList.add(4, new Menu(4, "nothing here", "nothing here", "nothing here", 0.00, "nothing here"));
    }

    public static void changeMenu(int index, Menu menu) {
        arrayList.set(index, menu);
    }

    public static ArrayList<Menu> getMenuList() {
        return arrayList;
    }

    public static Menu getElement(int index) {
        return arrayList.get(index);
    }

    public static void test() {
        arrayList.add(0, new Menu(0, "Test", "Test", "Test", 2.00, "Test"));
    }

}

