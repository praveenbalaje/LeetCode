class NumberContainers {

    HashMap<Integer, TreeSet<Integer>> num = new HashMap<>();

    HashMap<Integer, Integer> position = new HashMap<>();

    public NumberContainers() {

    }

    public void change(int index, int number) {
        if (position.containsKey(index)) {
            int oldNumber = position.get(index);
                System.out.println(number +"   :  " + oldNumber + "  index : " + index);
            if (oldNumber != number) {
                TreeSet<Integer> oldNum = num.get(oldNumber);
                oldNum.remove(index);
                num.put(oldNumber,oldNum);
                position.put(index, number);
                addValue(num,number, index);
            }
        } else if (num.containsKey(number)) {
            position.put(index, number);
            addValue(num,number, index);
        } else {
            position.put(index, number);
            addValue(num,number, index);
        }

    }

    private static void addValue(HashMap<Integer, TreeSet<Integer>> map, int key, int value) {
        map.computeIfAbsent(key, k -> new TreeSet<>()).add(value);
    }

    public int find(int number) {
        if (num.containsKey(number)) {
             TreeSet<Integer> oldNum = num.get(number);
             if(!oldNum.isEmpty()) {
                return oldNum.first();
             } else  return -1;
        } else {
            return -1;
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */