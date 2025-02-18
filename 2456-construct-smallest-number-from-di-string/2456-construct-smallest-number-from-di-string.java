class Solution {
    public String smallestNumber(String pattern) {
        int ic = 0;
        int dc = 0;
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I')
                ic += 1;
            else
                dc += 1;
        }

        String res = "";
        boolean add = false;

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I') {
                res += list.remove(0) + "";
                ic -= 1;
                if (ic == 0 && dc == 0 && !add) {
                    add = true;
                    res += list.remove(0) + "";
                }
            } else {
                if (ic == 0) {
                    if (!add) {
                        dc = dc + 1;
                        res += list.get(dc - 1);
                        dc -= 1;
                        add = true;
                    }
                    res += list.get(dc - 1);
                    dc -= 1;
                } else {
                    int j = i;
                    while (pattern.charAt(j) == 'D') {
                        j++;
                    }
                    res += list.remove(j - i);
                    dc -= 1;
                }
            }
        }

        return res;
    }
}