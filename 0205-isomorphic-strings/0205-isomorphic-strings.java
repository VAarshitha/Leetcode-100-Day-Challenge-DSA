import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Map for mapping characters from s to t
        HashMap<Character, Character> mapS = new HashMap<>();
        // Set for storing characters already mapped in t
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if charS is already mapped to some character in t
            if (mapS.containsKey(charS)) {
                if (mapS.get(charS) != charT) {
                    return false; // Mismatch in mapping
                }
            } else {
                // Check if charT is already mapped to another character
                if (mapT.containsKey(charT)) {
                    return false; // charT already mapped
                }

                // Add mapping
                mapS.put(charS, charT);
                mapT.put(charT, charS);
            }
        }

        return true;
    }
}
