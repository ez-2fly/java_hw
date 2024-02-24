import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<Integer, String> ramCategories = new HashMap<>();
        ramCategories.put(1, "4GB"); ramCategories.put(2, "8GB"); ramCategories.put(3, "16GB"); ramCategories.put(4, "32GB");

        Map<Integer, String> hdCategories = new HashMap<>();
        hdCategories.put(1, "128GB"); hdCategories.put(2, "256GB"); hdCategories.put(3, "512GB"); hdCategories.put(4, "1024GB");

        Map<Integer, String> osCategories = new HashMap<>();
        osCategories.put(1, "Windows"); osCategories.put(2, "Linux"); osCategories.put(3, "MacOS");

        Map<Integer, String> venCategories = new HashMap<>();
        venCategories.put(1, "Apple"); venCategories.put(2, "HP"); venCategories.put(3, "Sony"); venCategories.put(4, "Asus");

        Map<Integer, Map<Integer, String>> generalMap = new HashMap<>();
        generalMap.put(1, ramCategories); generalMap.put(2, hdCategories); generalMap.put(3, osCategories); generalMap.put(4, venCategories);

        Laptop lap1 = new Laptop();
        lap1.ram = "16GB"; lap1.hd = "1024GB"; lap1.os = "Linux"; lap1.vendor = "HP";

        Laptop lap2 = new Laptop();
        lap2.ram = "4GB"; lap2.hd = "512GB"; lap2.os = "Windows"; lap2.vendor = "Asus";

        Laptop lap3 = new Laptop();
        lap3.ram = "8GB"; lap3.hd = "256GB"; lap3.os = "Windows"; lap3.vendor = "Sony";

        Laptop lap4 = new Laptop();
        lap4.ram = "16GB"; lap4.hd = "128GB"; lap4.os = "MacOS"; lap4.vendor = "Apple";

        Laptop lap5 = new Laptop();
        lap5.ram = "32GB"; lap5.hd = "1024GB"; lap5.os = "Linux"; lap5.vendor = "HP";

        Set<Laptop> laps = new HashSet<>();
        laps.add(lap1); laps.add(lap2); laps.add(lap3); laps.add(lap4); laps.add(lap5);

        String title = "1 - Объем ОЗУ\n2 - Объем ЖД\n3 - Операционная система\n4 - Производитель\n5 - Поиск";
        ArrayList<Integer> res = new ArrayList<>();
        boolean work = true;

        while (work){
            System.out.println(title);
            int key = scan();
            if (key == -1){
                System.out.println("Ошибка! Введено некорректное значение.");
            } else {
                if (key == 5) work = false;
                else {
                    res.add(key);
                    printMap(generalMap.get(key));
                    res.add(scan());
                }
            }
            if (res.size() == 8) work = false;
        }

        filter(res, generalMap, laps);
    }

    static Integer scan(){
        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();
        if (res <= 5 && res >= 1){
            return res;
        }
        else {
            return -1;
        }
    }

    static void printMap(Map<Integer, String> map){
        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    static void filter(ArrayList<Integer> array, Map<Integer, Map<Integer, String>> map, Set<Laptop> set){
        if (array.size() < 2) System.out.println("Не введено ни одного параматра поиска. Работа программы завершена.");
        else {
            Set<Laptop> reSet = new HashSet<>();
            String ram = "", hd = "", os = "", ven = "";
            boolean ramB = true, hdB = true, osB = true, venB = true;

            for (int i = 0; i < array.size(); i+=2) {
                if (array.get(i) == 5) break;
                String temp = map.get(array.get(i)).get(array.get(i+1));
                switch (array.get(i)){
                    case 1: ram = temp; break;
                    case 2: hd = temp; break;
                    case 3: os = temp; break;
                    case 4: ven = temp; break;
                }
            }
            for (Laptop item : set){
                if (!ram.isEmpty()) ramB = item.getRam().equals(ram);
                if (!hd.isEmpty()) hdB = item.getHd().equals(hd);
                if (!os.isEmpty()) osB = item.getOs().equals(os);
                if (!ven.isEmpty()) venB = item.getVendor().equals(ven);
                if (ramB && hdB && osB && venB) reSet.add(item);
            }
            if (reSet.isEmpty()) System.out.println("По заданным параметрам не нашлось ни одной модели");
            else {
                for (Laptop item : reSet){
                    System.out.println(item.toString());
                }
            }
        }
    }
}