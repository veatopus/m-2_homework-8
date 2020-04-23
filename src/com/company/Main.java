package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String[]> miniDictionary = new HashMap<>();


        miniDictionary.put("ложь", new String[]{"неправда", "вранье", "враки", "вздор", "лганье", "обман", "заблуждение",
                "измышления", "дезинформация", "вымысел", "жульничество", "уловка", "хитрость", "брехня",
                "выдумка", "треп"});

        miniDictionary.put("радость", new String[]{"восторг", "упоение", "отрада", "веселье", "ликование",
                "жизнерадостность", "забава", "потеха", "утеха", "развлечение", "увеселение", "веселость", "услада",
                "беспечалие", "радостность", "праздник", "торжество", "просвет"});

        miniDictionary.put("ум", new String[]{"разум", "рассудительность", "рассудок", "сметка", "гений",
                "интеллект", "интеллектуальность", "голова", "толк", "разумение", "трезвость"});

        miniDictionary.put("песня", new String[]{"песенка", "песнопения", "песнь", "ода", "рапсодия", "романс",
                "кантата", "кантата", "ария"});

        miniDictionary.put("имя", new String[]{"название", "наименование", "кличка", "псевдоним", "прозвище",
                "идентификация", "звание", "известность", "признание", "популярность"});

        Set<String> setKey = miniDictionary.keySet();
        List<String> arrayListOfSynonyms = new ArrayList<>();
        Map<String, String[]> dictionary = new HashMap<>();

        for (String key : setKey) {
            Collections.addAll(arrayListOfSynonyms, miniDictionary.get(key));
            for (int i = 0; i < arrayListOfSynonyms.size(); i++) {
                String newKey = arrayListOfSynonyms.get(i);
                arrayListOfSynonyms.remove(i);
                arrayListOfSynonyms.add(key);

                Object[] o = arrayListOfSynonyms.toArray();
                String[] s = new String[o.length];
                for (int j = 0; j < s.length - 1; j++) {
                    s[j] = (String) o[j];
                }

                dictionary.put(newKey, s);
                arrayListOfSynonyms.clear();
                Collections.addAll(arrayListOfSynonyms, miniDictionary.get(key));
            }
        }
        dictionary.putAll(miniDictionary);

        do {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            System.out.println("введите слово, синоним к которому вам нужен");
            String[] strings = dictionary.get(scanner.nextLine());
            if (strings != null)
                System.out.println(strings[random.nextInt(strings.length - 1)]);
            else
                System.out.println("такого слова не существует");

        } while (true);
    }
}