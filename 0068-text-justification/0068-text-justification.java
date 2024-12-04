import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;

            while (last < words.length) {
                if (count + words[last].length() + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            int gaps = last - index - 1;

            if (last == words.length || gaps == 0) {
                // Last line or single word line
                for (int i = index + 1; i < last; i++) {
                    builder.append(" ").append(words[i]);
                }
                while (builder.length() < maxWidth) {
                    builder.append(" ");
                }
            } else {
                // Fully justified line
                int spaces = (maxWidth - count) / gaps;
                int extraSpaces = (maxWidth - count) % gaps;

                for (int i = index + 1; i < last; i++) {
                    for (int s = 0; s <= spaces + (i - index <= extraSpaces ? 1 : 0); s++) {
                        builder.append(" ");
                    }
                    builder.append(words[i]);
                }
            }

            result.add(builder.toString());
            index = last;
        }

        return result;
    }
}
