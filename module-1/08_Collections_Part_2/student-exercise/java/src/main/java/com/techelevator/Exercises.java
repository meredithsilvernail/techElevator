package com.techelevator;

import java.lang.reflect.Array;
import java.util.*;

public class Exercises {

    /*
     * Map Exercises
     */

    /*
     * Given the name of an animal, return the name of a group of that animal
     * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
     *
     * The animal name should be case insensitive so "elephant", "Elephant", and
     * "ELEPHANT" should all return "herd".
     *
     * If the name of the animal is not found, null, or empty, return "unknown".
     *
     * Rhino -> Crash
     * Giraffe -> Tower
     * Elephant -> Herd
     * Lion -> Pride
     * Crow -> Murder
     * Pigeon -> Kit
     * Flamingo -> Pat
     * Deer -> Herd
     * Dog -> Pack
     * Crocodile -> Float
     *
     * animalGroupName("giraffe") → "Tower"
     * animalGroupName("") -> "unknown"
     * animalGroupName("walrus") -> "unknown"
     *
     */
    public String animalGroupName(String animalName) {

        Map<String, String> animalGroup = new HashMap<>();
        animalGroup.put("rhino", "Crash");
        animalGroup.put("giraffe", "Tower");
        animalGroup.put("elephant", "Herd");
        animalGroup.put("lion", "Pride");
        animalGroup.put("crow", "Murder");
        animalGroup.put("pigeon", "Kit");
        animalGroup.put("flamingo", "Pat");
        animalGroup.put("deer", "Herd");
        animalGroup.put("dog", "Pack");
        animalGroup.put("crocodile", "Float");

        if (animalGroup.containsKey(animalName.toLowerCase())) {
            return animalGroup.get(animalName.toLowerCase());
        }
        return "unknown";
    }

    /*
     * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
     * If the item is not on sale, return 0.00.
     *
     * If the item number is empty or null, return 0.00.
     *
     * "KITCHEN4001" -> 0.20
     * "GARAGE1070" -> 0.15
     * "LIVINGROOM"	-> 0.10
     * "KITCHEN6073" -> 0.40
     * "BEDROOM3434" -> 0.60
     * "BATH0073" -> 0.15
     *
     * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
     * should all return 0.20.
     *
     * isItOnSale("kitchen4001") → 0.20
     * isItOnSale("") → 0.00
     * isItOnSale("GARAGE1070") → 0.15
     * isItOnSale("dungeon9999") → 0.00
     *
     */
    public Double isItOnSale(String itemNumber) {
        Map<String, Double> saleItems = new HashMap<>();
        saleItems.put("KITCHEN4001", 0.20);
        saleItems.put("GARAGE1070", 0.15);
        saleItems.put("LIVINGROOM", 0.10);
        saleItems.put("KITCHEN6073", 0.40);
        saleItems.put("BEDROOM3434", 0.60);
        saleItems.put("BATH0073", 0.15);

        if (saleItems.containsKey(itemNumber.toUpperCase())) {
            return saleItems.get(itemNumber.toUpperCase());
        }
        return 0.00;
    }

    /*
     * Modify and return the given map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
     * but only if Paul has less than $10s.
     *
     * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
     *
     * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
     * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
     *
     */
    public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
        //create new hashmap from map passed in
        Map<String, Integer> peterPaulMap = new HashMap<>(peterPaul);
        //create integers to represent peter's money and paul's money
        Integer peterMoney = peterPaulMap.get("Peter");
        Integer paulMoney = peterPaulMap.get("Paul");

        //if peter has more than 0 and paul has less than 1000, give half peter's money to paul
        if (peterMoney > 0 && paulMoney < 1000) {
            //create variable to hold amount 1/2 of peter's money as int
            Integer movedMoney = (peterMoney / 2);

            //replace peter's money with half of original money - get as double and round up
            peterPaulMap.replace("Peter", (int) Math.ceil(peterMoney / 2.0));

            //add half of peter's money to paul's existing money - using original math that rounds down
            peterPaulMap.replace("Paul", paulMoney + movedMoney);
        }
        //return new map
        return peterPaulMap;
    }

    /*
     * Modify and return the given map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
     * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
     * current worth.
     *
     * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
     *
     * peterPaulPartnership({"Peter": 5000, "Paul": 10000}) → {"Peter": 3750, "Paul": 7500, "PeterPaulPartnership": 3750}
     * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
     *
     */
    public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
        //create new map to hold passed in map
        Map<String, Integer> peterPaulPartnership = new HashMap<>(peterPaul);
        //create variables to hold petermoney and paulmoney from map
        Integer peterMoney = peterPaulPartnership.get("Peter");
        Integer paulMoney = peterPaulPartnership.get("Paul");

        //if peter > 5000 and paul is > 10000
        if (peterMoney >= 5000 && paulMoney >= 10000) {
            //find 1/4 of each person's total
            Integer peterQuarter = peterMoney / 4;
            Integer paulQuarter = paulMoney / 4;
            //create new item equal to 1/4 of peter + 1/4 of paul
            Integer partnership = peterQuarter + paulQuarter;

            //replace peter and paul with total - 1/4, and add new partnership item
            peterPaulPartnership.replace("Peter", peterMoney - peterQuarter);
            peterPaulPartnership.replace("Paul", paulMoney - paulQuarter);
            peterPaulPartnership.put("PeterPaulPartnership", partnership);
        }
        return peterPaulPartnership;
    }

    /*
     * Given an array of non-empty strings, return a Map<String, String> where for every different string in the array,
     * there is a key of its first character with the value of its last character.
     *
     * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
     * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
     * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
     */
    public Map<String, String> beginningAndEnding(String[] words) {
        Map<String, String> diffStrings = new HashMap<>();
        for (String word : words) {
            //for each word, find first character and convert to string, find last and convert to string
            //add to map as one key-value pair
            diffStrings.put(String.valueOf(word.charAt(0)), String.valueOf(word.charAt(word.length() - 1)));
        }
        return diffStrings;
    }

    /*
     * Given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the
     * number of times that string appears in the array.
     *
     * ** A CLASSIC **
     *
     * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
     * wordCount([]) → {}
     * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
     *
     */
    public Map<String, Integer> wordCount(String[] words) {
        //create new empty map
        Map<String, Integer> countedWords = new HashMap();
        //cycle through words in array passed in
        //check if word has been added to new list (first one will not have been, so will be added with count of 1)
        //if a word comes up that has been added, find current count, and add 1, replace value with new count
        for (String word : words) {
            String tempWord = word;
            if (countedWords.containsKey(tempWord)) {
                int count = countedWords.get(tempWord);
                countedWords.replace(tempWord, count + 1);
            } else
                countedWords.put(tempWord, 1);
        }
        return countedWords;
    }

    /*
     * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
     * number of times that int appears in the array.
     *
     * ** The lesser known cousin of the the classic wordCount **
     *
     * integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 1, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
     * integerCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
     * integerCount([]) → {}
     *
     */
    public Map<Integer, Integer> integerCount(int[] ints) {
        //same as previous problem but with integers
        Map<Integer, Integer> countedInts = new HashMap();
        for (Integer num : ints) {
            Integer tempNum = num;
            if (countedInts.containsKey(tempNum)) {
                int count = countedInts.get(tempNum);
                countedInts.replace(tempNum, count + 1);
            } else
                countedInts.put(tempNum, 1);
        }
        return countedInts;

    }

    /*
     * Given an array of strings, return a Map<String, Boolean> where each different string is a key and value
     * is true only if that string appears 2 or more times in the array.
     *
     * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
     * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
     * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
     *
     */
    public Map<String, Boolean> wordMultiple(String[] words) {
        Map<String, Boolean> multiples = new HashMap<>();
        //loop through array passed in
        //for each word, check if exists already in new map, if it doesn't, add it with value false
        //if it does exist already, replace value with true
        for (String word : words) {
            if (!multiples.containsKey(word)) {
                multiples.put(word, false);
            } else {
                multiples.replace(word, true);
            }
        }
        return multiples;
    }

    /*
     * Given two maps, Map<String, Integer>, merge the two into a new map, Map<String, Integer> where keys in Map2,
     * and their Integer values, are added to the Integer values of matching keys in Map1. Return the new map.
     *
     * Unmatched keys and their Integer values in Map2 are simply added to Map1.
     *
     * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
     * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
     *
     */
    public Map<String, Integer> consolidateInventory
    (Map<String, Integer> mainWarehouse, Map<String, Integer> remoteWarehouse) {
        //create new map to hold combined key-value pairs, start by adding all of the main warehouse items
        Map<String, Integer> combinedMap = new HashMap<>(mainWarehouse);

        //create keyset of remote warehouse items
        Set<String> remoteKeys = remoteWarehouse.keySet();
        //for each item in remote keys, check if combined map already has the key
        for (String key : remoteKeys) {
            //if key found, replace value with original value plus value from remote map
            if (combinedMap.containsKey(key)) {
                combinedMap.replace(key, combinedMap.get(key) + remoteWarehouse.get(key));
            } else {
                //if it doesn't already exist, add new key and value
                combinedMap.put(key, remoteWarehouse.get(key));
            }
        }
        return combinedMap;
    }

    /*
     * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
     *
     * Given an array of strings, for each string, the count of the number of times that a substring length 2 appears
     * in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1.
     *
     * We don't count the end substring, but the substring may overlap a prior position by one.  For instance, "xxxx"
     * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
     * end substring, which we don't count.
     *
     * Return Map<String, Integer>, where the key is string from the array, and its last2 count.
     *
     * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
     *
     */
    public Map<String, Integer> last2Revisited(String[] words) {
        //create new map
        Map<String, Integer> last2Map = new HashMap<>();

        //loop through array of words and find substrings (code from objects exercise)
        for (String word : words) {
            //create counter
            int counter = 0;
            //create new string with substring of last 2 if string is 2 or more
            if (word.length() > 1) {
                String lastTwo = word.substring(word.length() - 2);

                //loop through string until length -2 and add to counter if substring found
                for (int i = 0; i < word.length() - 2; i++) {
                    if ((word.charAt(i) == lastTwo.charAt(0)) && (word.charAt(i + 1) == lastTwo.charAt(1))) {
                        counter++;
                    }
                    //after loop completes for each item, add word and counter to map
                    last2Map.put(word, counter);
                }
            } else {
                //if word was less than 2 letters, add word and count of 0
                last2Map.put(word, 0);
            }
        }
        return last2Map;
    }

    /*
     Given a list of Strings, return a list that contains the distinct values. In other words, no value is to be
     included more than once in the returned list. (Hint: Think Set)
     distinctValues( ["red", "yellow", "green", "yellow", "blue", "green", "purple"] ) -> ["red", "yellow", "green", "blue", "purple"]
     distinctValues( ["jingle", "bells", "jingle", "bells", "jingle", "all", "the", "way"] ) -> ["jingle", "bells", "all", "the", "way"]
     */
    public List<String> distinctValues(List<String> stringList) {
        //create a new list to hold new items
        List<String> distinctList = new ArrayList<>();
        //create a temporary set to test items before adding
        Set<String> testSet = new HashSet<>();

        //for each word, attempt to add to the set, if it can be added to set, add to new list
        //if it is a duplicate, it can't be added to the set, so it won't be added to the list
        for (String word : stringList) {
            if (testSet.add(word)) {
                distinctList.add(word);
            }
        }
        return distinctList;
    }

}
