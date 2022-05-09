package sky.pro.java.course2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StringList newStringList1 = new StringListImpl(10);
        newStringList1.add("Вставай, страна огромная!");
        newStringList1.add("Случайный вальс.");
        newStringList1.add("Нас извлекут из под обломков ...");
        newStringList1.add("Мой милый, если б не было войны ...");
        newStringList1.add("День победы!");
//        newStringList1.add(null);
        printOfResults(newStringList1);

        System.out.println();
        newStringList1.add(1, "Выходила на берег Катюша.");
//        newStringList1.add(8, "It must be mistake!");
        printOfResults(newStringList1);

        System.out.println();
        newStringList1.set(2, "От героев былых времен...");
        printOfResults(newStringList1);

        System.out.println();
        newStringList1.remove("Мой милый, если б не было войны ...");
        newStringList1.remove(0);
//        newStringList1.remove("Мой милый, если б не было войны ...");
        printOfResults(newStringList1);

        System.out.println();
        System.out.println(newStringList1.contains("День победы!"));
        System.out.println(newStringList1.contains("It must be FALSE"));

        System.out.println();
        newStringList1.add(1, "День победы!");
        System.out.println(newStringList1.indexOf("День победы!"));
        System.out.println(newStringList1.lastIndexOf("День победы!"));
        printOfResults(newStringList1);

        System.out.println();
        StringList newStringList2 = new StringListImpl(10);
        newStringList2.add("Выходила на берег Катюша.");
        newStringList2.add("День победы!");
        newStringList2.add("От героев былых времен...");
        newStringList2.add("Нас извлекут из под обломков ...");
        newStringList2.add("День победы!");
        System.out.println(newStringList1.equals(newStringList2));

        System.out.println();
        System.out.println(newStringList2.isEmpty());
        newStringList2.clear();
        System.out.println(newStringList2.isEmpty());

        System.out.println();
        String[] arrayString = newStringList1.toArray();
        System.out.println(Arrays.toString(arrayString));
    }

    public static void printOfResults(StringList stringList) {
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
    }
}
