package String;

import java.util.*;

public class StringMethods {

    public String reverse(String str){
        String temp = "";
        for (int i = str.length() - 1; i > -1; i--){
            temp = temp + str.charAt(i);
        }
        return temp;
    }

    public String recursReverse(String s){
        if (s.length() == 1)
            return s;
        else
            return s.charAt(s.length() -1) + recursReverse(s.substring(0, s.length() - 1));
    }

    public boolean isAnagram(String s1, String s2){
        if (s1.length() == s2.length()) {
            char[] ch1 = s1.toLowerCase().toCharArray();
            char[] ch2 = s2.toLowerCase().toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            return Arrays.equals(ch1, ch2);
        }else
            return false;
    }

    public boolean isUnique(String s){
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toLowerCase().toCharArray())
            if (!set.add(c))
                return false;
        return true;
    }

    public boolean isRotation(String s1, String s2){
        if (s1.length() == s2.length()){
            String s3 = s1.toLowerCase() + s1.toLowerCase();
            return s3.contains(s2.toLowerCase());
        }else
            return false;
    }
    public void duplicate(String s){
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s.toLowerCase().toCharArray())
            hash.merge(c, 1, Integer::sum);
        hash.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(o ->{
            if (o.getValue() > 1)
                System.out.println(o.getKey() + " = " + o.getValue());
        });
    }

    public Character firstNonRepeat(String s){
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (char c : s.toLowerCase().toCharArray())
            linkedHashMap.merge(c, 1, Integer::sum);
        return  linkedHashMap.entrySet()
                .stream()
                .filter(o -> o.getValue() < 2)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public Set<String> allPermutationsOfString(String s){
        Set<String> permutationSet = new HashSet<>();
        if (s.length() == 0){
            permutationSet.add("");
            return permutationSet;
        }

        char c = s.charAt(0);
        String rem = s.substring(1);

        Set<String> permutatedSetForRemainingString = allPermutationsOfString(rem);
        for (String permutatedString : permutatedSetForRemainingString){
            for(int i = 0; i <= permutatedString.length(); i++){
                String permutation = changeFirstInexPlace(permutatedString, c, i);
                permutationSet.add(permutation);
            }
        }
        return permutationSet;
    }

    public String changeFirstInexPlace(String s, char c, int index){
        return s.substring(0, index) + c + s.substring(index);
    }

    public void findAllSubString(String s){
        for (int i = 0; i < s.length(); i++)
            for (int j = i + 1; j < s.length() + 1; j++)
                System.out.println(s.substring(i,j));

    }

    public static void main(String[] args) {
        StringMethods str = new StringMethods();
        String s = "java";
        System.out.println(str.reverse(s));
        System.out.println(str.recursReverse(s));
        System.out.println(str.isAnagram("angle", "angel"));
        System.out.println(str.isUnique(s));
        System.out.println(str.isUnique("Angle"));
        System.out.println(str.isUnique("Anagle"));
        String s1 = "Java2blog";
        String s2 = "blog2java";
        String s3 = "blogjava2";
        String s4 = "logjava2b";
        System.out.println(str.isRotation(s1, s2));
        System.out.println(str.isRotation(s1, s3));
        System.out.println(str.isRotation(s1, s4));
        String name = "Hayrettin Ekmekcioğlu";
        str.duplicate(name);
        System.out.println(str.firstNonRepeat(name));
        System.out.println(str.firstNonRepeat("Anagel"));
        str.findAllSubString(s);
        Set<String> set = str.allPermutationsOfString("ABC");
        set.forEach(System.out::println);
    }
}
