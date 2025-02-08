class NumberContainers {

    HashMap<Integer, TreeSet<Integer>> num = new HashMap<>();

    HashMap<Integer, Integer> position = new HashMap<>();

    public NumberContainers() {

    }

    public void change(int index, int number) {
        if (position.containsKey(index)) {
            int oldNumber = position.get(index);
            if (oldNumber != number) {
                TreeSet<Integer> oldNum = num.get(oldNumber);
                oldNum.remove(index);
                if (oldNum.isEmpty()) {
                    num.remove(oldNumber);
                } else {
                    num.put(oldNumber, oldNum);
                }
            }
        }
        position.put(index, number);
        addValue(num, number, index);
    }

    private static void addValue(HashMap<Integer, TreeSet<Integer>> map, int key, int value) {
        map.computeIfAbsent(key, k -> new TreeSet<>()).add(value);
    }

    public int find(int number) {
        if (num.containsKey(number)) {
            return num.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */