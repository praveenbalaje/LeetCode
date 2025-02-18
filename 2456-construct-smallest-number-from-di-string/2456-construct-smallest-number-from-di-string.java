import java.util.ArrayList;
import java.util.List;

class Solution {
    public String smallestNumber(String pattern) {
        int ic = 0, dc = 0;
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        StringBuilder res = new StringBuilder();
        boolean addedLast = false;

        // Count 'I' and 'D' occurrences
        for (char ch : pattern.toCharArray()) {
            if (ch == 'I') ic++;
            else dc++;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (ch == 'I') {
                res.append(list.remove(0));
                ic--;

                if (ic == 0 && dc == 0 && !addedLast) {
                    addedLast = true;
                    res.append(list.remove(0));
                }
            } else { // 'D' case
                if (ic == 0) {
                    if (!addedLast) {
                        dc++;
                        res.append(list.get(dc - 1));
                        dc--;
                        addedLast = true;
                    }
                    res.append(list.get(dc - 1));
                    dc--;
                } else {
                    int j = i;
                    while (j < pattern.length() && pattern.charAt(j) == 'D') {
                        j++;
                    }
                    res.append(list.remove(j - i));
                    dc--;
                }
            }
        }

        return res.toString();
    }
}
