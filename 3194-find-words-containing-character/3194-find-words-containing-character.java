class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> rs = new ArrayList<>();
        String find = ""+x;
        for(int i=0;i<words.length;i++) {
            if(words[i].contains(find)) {
                rs.add(i);
            }
        }
        return rs;
    }
}