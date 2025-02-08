import java.util.*;

class NumberContainers {
    // Map to store numbers and their corresponding indices in sorted order
    private HashMap<Integer, TreeSet<Integer>> numberToIndices;
    
    // Map to store index-to-number mapping
    private HashMap<Integer, Integer> indexToNumber;

    public NumberContainers() {
        numberToIndices = new HashMap<>();
        indexToNumber = new HashMap<>();
    }

    public void change(int index, int newNumber) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            if (oldNumber != newNumber) {
                TreeSet<Integer> oldIndices = numberToIndices.get(oldNumber);
                oldIndices.remove(index);
                if (oldIndices.isEmpty()) {
                    numberToIndices.remove(oldNumber);
                }
            }
        }
        indexToNumber.put(index, newNumber);
        numberToIndices.computeIfAbsent(newNumber, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        if (numberToIndices.containsKey(number)) {
            return numberToIndices.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index, number);
 * int param_2 = obj.find(number);
 */