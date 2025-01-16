class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {

          int xor1 = 0, xor2 = 0;
        
        // Compute XOR of all elements in nums1
        for (int num : nums1) {
            xor1 ^= num;
        }

        // Compute XOR of all elements in nums2
        for (int num : nums2) {
            xor2 ^= num;
        }

        int m = nums1.length, n = nums2.length;
        
        // If either m or n is even, result is 0
        if (m % 2 == 0 && n % 2 == 0) {
            return 0;
        }
        
        // If only one of them is odd, return the XOR of the corresponding array
        if (m % 2 == 0) {
            return xor1;
        }
        if (n % 2 == 0) {
            return xor2;
        }

        // If both are odd, return the XOR of xor1 and xor2
        return xor1 ^ xor2;
        
    }
}