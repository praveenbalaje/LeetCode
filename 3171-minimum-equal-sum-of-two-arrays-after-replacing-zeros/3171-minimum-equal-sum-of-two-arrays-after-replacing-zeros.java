class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long s1 = 0, s2 = 0;
        long z1 = 0, z2 = 0;

        for (int i = 0; i < nums1.length; i++) {
            s1 += nums1[i];
            if (nums1[i] == 0) z1++;
        }

        for (int i = 0; i < nums2.length; i++) {
            s2 += nums2[i];
            if (nums2[i] == 0) z2++;
        }

        long zeroMax = Math.max(z1, z2);

        if (s1 == s2 && z1 == 0 && z2 == 0) {
            return s1;
        } else if (s1 > s2) {
            long diff = s1 - s2;

            if (z2 == 0 || (z1 == 0 && diff < z2)) {
                return -1;
            } else if (diff < zeroMax) {
                return Math.max(s1 + z1, s2 + z2);
            } else {
                return s1 + z1;
            }

        } else {
            long diff = s2 - s1;

            if (z1 == 0 || (z2 == 0 && diff < z1)) {
                return -1;
            } else if (diff < zeroMax) {
                return Math.max(s1 + z1, s2 + z2);
            } else {
                return s2 + z2;
            }
        }
    }
}