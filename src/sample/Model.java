package sample;

import com.blogspot.debukkitsblog.util.FileStorage;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.*;
import java.util.ArrayList;


public class Model implements Serializable {

    // init class variables

    public static File folder = new File("menus");

    public static File file0 = new File("menus/menu0.dat");
    public static File file1 = new File("menus/menu1.dat");
    public static File file2 = new File("menus/menu2.dat");
    public static File file3 = new File("menus/menu3.dat");
    public static File file4 = new File("menus/menu4.dat");

    /*

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

     */

    public static void initFile(File file, int index) {
        Menu menu = new Menu(index, "nothing here", "nothing here", "nothing here", 0.00, "nothing here");

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(menu);
            oos.flush();
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doInitfile() {

        /*
        Model.initFile(Model.file0, 0);
        Model.initFile(Model.file1, 1);
        Model.initFile(Model.file2, 2);
        Model.initFile(Model.file3, 3);
        Model.initFile(Model.file4, 4);
        Model.initFile(Model.file5, 5);
         */

        initFile(file0, 0);
        initFile(file1, 1);
        initFile(file2, 2);
        initFile(file3, 3);
        initFile(file4, 4);

    }

    public static void deleteFile(File file) {

        // ACHTUNG!
        file.delete();

    }

    public static void createFile(File file) {

        if(!file.exists()){
            try {
                System.out.println(file.createNewFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void writeFile(File file, int menuIndex, String weekday, String menuTitle, String menuContent, Double menuPrice, String menuFoodType) {
        /* PrintWriter pfw0 = null;
        try {
            pfw0 = new PrintWriter(new FileWriter(file0));
            pfw0.write("erste Zeile");
            pfw0.write("mach was");
            pfw0.flush();
            pfw0.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

        Menu menu = new Menu(menuIndex, weekday, menuTitle, menuContent, menuPrice, menuFoodType);

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(menu);
            oos.flush();
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(File file) {
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object rawObject = ois.readObject();
            ois.close();

            if(rawObject instanceof Menu) {
                Menu readThis = (Menu) rawObject;

                System.out.println(readThis.getMenuIndex() + ", " +
                        readThis.getMenuTitle() + ", " +
                        readThis.getMenuContent() + ", " +
                        readThis.getMenuPrice() + ", " +
                        readThis.getMenuFoodType() );
            } else {
                System.err.println("Fehlermeldung: In der Datei war kein Objekt von Menu!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static int readFileGetMenuIndex(File file) {
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object rawObject = ois.readObject();
            ois.close();

            if(rawObject instanceof Menu) {

                Menu readThis = (Menu) rawObject;

                return readThis.getMenuIndex();

            } else {
                System.err.println("Fehlermeldung: In der Datei war kein Objekt von Menu!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return 99;
    }

    public static String readFileGetWeekday(File file) {
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object rawObject = ois.readObject();
            ois.close();

            if(rawObject instanceof Menu) {

                Menu readThis = (Menu) rawObject;

                return readThis.getWeekday();

            } else {
                System.err.println("Fehlermeldung: In der Datei war kein Objekt von Menu!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "Fehler";
    }

    public static String readFileGetMenuTitle(File file) {
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object rawObject = ois.readObject();
            ois.close();

            if(rawObject instanceof Menu) {

                Menu readThis = (Menu) rawObject;

                return readThis.getMenuTitle();

            } else {
                System.err.println("Fehlermeldung: In der Datei war kein Objekt von Menu!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "Fehler";
    }

    public static String readFileGetMenuContent(File file) {
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object rawObject = ois.readObject();
            ois.close();

            if(rawObject instanceof Menu) {

                Menu readThis = (Menu) rawObject;

                return readThis.getMenuContent();

            } else {
                System.err.println("Fehlermeldung: In der Datei war kein Objekt von Menu!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "Fehler";
    }

    public static double readFileGetMenuPrice(File file) {
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object rawObject = ois.readObject();
            ois.close();

            if(rawObject instanceof Menu) {

                Menu readThis = (Menu) rawObject;

                return readThis.getMenuPrice();

            } else {
                System.err.println("Fehlermeldung: In der Datei war kein Objekt von Menu!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return 00.00;
    }

    public static String readFileGetMenuFoodType(File file) {
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object rawObject = ois.readObject();
            ois.close();

            if(rawObject instanceof Menu) {

                Menu readThis = (Menu) rawObject;

                return readThis.getMenuFoodType();

            } else {
                System.err.println("Fehlermeldung: In der Datei war kein Objekt von Menu!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "Fehler";
    }

    public static void main(String[] args) {

        /*
        readFile(file0);
        readFile(file1);
        readFile(file2);
        readFile(file3);
        readFile(file4);
         */

    }
}

