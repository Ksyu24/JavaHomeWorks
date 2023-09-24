//        6.Реализуйте структуру телефонной книги с помощью HashMap.
//        Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами, 
//        их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию 
//        числа телефонов.

package HomeWork_5_6;

import java.security.Key;
import java.util.*;

public class Directory {
    private static Map<Man,List<String>> directory=new HashMap<>();
    public static void main(String[] args) {

        Man man1, man2, man3, man4;
        man1=new Man(1,"Иванов Иван Иванович", 27, "г. Москва, ул. Ленина, д.2");
        man2=new Man(2,"Чан Филипп Петрович", 57, "г. Москва, ул. Мира, д.33");
        man3=new Man(3,"Петров Илья Иванович", 53, "г. Москва, ул. Мира, д.39");
        man4=new Man(4,"Нестерова Анна Игоревна", 17, "г. Москва, ул. Заречная, д.13, к.11");

        addPhoneNumber( man1, "+7(985)099-34-20");
        addPhoneNumber( man1, "+7(989)099-34-50");
        addPhoneNumber( man1, "+7(985)123-34-60");
        addPhoneNumber( man2, "+7(989)059-34-20");
        addPhoneNumber( man2, "+7(989)139-34-20");
        addPhoneNumber( man3, "+7(985)051-34-20");
        addPhoneNumber( man4, "+7(985)991-34-29");
        addPhoneNumber( man1, "+7(985)099-34-20");


        printDirectory(directory);

    }

    private static void addPhoneNumber(Man man, String phone)
    {
        if(directory.containsKey(man))
        {
            List<String> phoneNumbers=directory.get(man);
            if(!phoneNumbers.contains(phone))
            {
                phoneNumbers.add(phone);
            }
        }
        else {
            List<String> phoneNumbers=new ArrayList<>();
            phoneNumbers.add(phone);
            directory.put(man, phoneNumbers);
        }
    }

    private static Map<Man,List<String>> sortDir(Map<Man,List<String>> oldDir)
    {
        int maxPhoneCount=0;
        int phoneCount=0;
        Man manForSortDir=null;
        List<String> phonesForSortDir=null;
        Map<Man,List<String>> sortDir=new LinkedHashMap<>();

        for (Map.Entry<Man,List<String>> entry1:oldDir.entrySet()) {
            for (Map.Entry<Man, List<String>> entry : oldDir.entrySet()) {
                phoneCount = entry.getValue().size();
                if (!sortDir.containsKey(entry.getKey())&&phoneCount > maxPhoneCount) {
                    maxPhoneCount = phoneCount;
                    manForSortDir=entry.getKey();
                    phonesForSortDir=entry.getValue();
                }
            }
            sortDir.put(manForSortDir,phonesForSortDir);
            maxPhoneCount=0;
            phoneCount=0;
        }
        return sortDir;
    }
    private static void printDirectory(Map<Man,List<String>> oldDir)
    {
        Map<Man,List<String>> sortDirectory=sortDir(oldDir);
        int count=1;
        System.out.println("Телефонный справочник");
        for (Map.Entry<Man, List<String>> entry : sortDirectory.entrySet()) {
            System.out.println(count+".\t"+entry.getKey());
            for (String number:entry.getValue())
            {
                System.out.println("\t"+number);
            }
            count++;
        }
    }




}
