package Arrays;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 */
public class IsomorphicStrings {
    /**
     * We can define a map which tracks the char-char mappings. If a value is already mapped, it can not be mapped again.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic1(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map1.containsKey(c1)){
                if(c2!=map1.get(c1)){
                    return false;
                }
            }else{
                if(map2.containsKey(c2)){
                    return false;
                }

                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }

        return true;
    }

    /**
     * We can also simply check if a value is mapped twice by checking the number of unique elements.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }

        HashSet<Character> set = new HashSet<>(map.values());
        if (set.size() == map.values().size()) {
            return true;
        }

        return false;
    }
}
