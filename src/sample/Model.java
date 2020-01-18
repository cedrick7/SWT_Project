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

        return "Nicht initialisiert";
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

        return "Nicht initialisiert";
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

        return "Nicht initialisiert";
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

        return "Nicht initialisiert";
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

