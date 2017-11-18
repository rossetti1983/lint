package array;

import java.util.Arrays;

/**
 * Created by zhizha on 8/10/17.
 */
public class MedianoftwoSortedArrays65 {

    public static void main(String[] arg) {
        MedianoftwoSortedArrays65 medianoftwoSortedArrays65 = new MedianoftwoSortedArrays65();
        medianoftwoSortedArrays65.findMedianSortedArrays(new int[]{6,7,8,9,10,11,12}, new int[]{2,3,4,9});
    }

    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     * <p>
     * <p>
     * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
     * <p>
     * Have you met this question in a real interview? Yes
     * Example
     * Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
     * <p>
     * Given A=[1,2,3] and B=[4,5], the median is 3.
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;
        boolean isOneMedian = false;
        if (len % 2 == 1) {
            isOneMedian = true;
        }

        return findMedian(A, B, (len - 1) / 2, isOneMedian);
    }

    private double findMedian(int[] A, int[] B, int remain, boolean isOneMedian) {
        if (A.length == 0) {
            if (isOneMedian) {
                return B[remain];
            } else {
                return (double) (B[remain] + B[remain + 1]) / 2;
            }

        } else if (B.length == 0) {
            if (isOneMedian) {
                return A[remain];
            } else {
                return (double) (A[remain] + A[remain + 1]) / 2;
            }
        }
        if (remain == 0) {
            if (isOneMedian) {
                return Math.min(A[0], B[0]);
            } else {
                if (A[0] < B[0]) {
                    if (A.length>1 && A[1] < B[0]) {
                        return (double) (A[0] + A[1]) / 2;
                    } else {
                        return (double) (A[0] + B[0]) / 2;
                    }
                } else {
                    if (B.length>1 && B[1] < A[0]) {
                        return (double) (B[0] + B[1]) / 2;
                    } else {
                        return (double) (B[0] + A[0]) / 2;
                    }
                }
            }
        }
        int midA = (A.length - 1) / 2;
        int midB = (B.length - 1) / 2;
        int indexA = 0;
        int indexB = 0;
        if (A[midA] > B[midB]) {
            while (indexB <= midB) {
                if (B[indexB] > A[indexA]) {
                    indexA++;
                    remain--;
                    if (remain == 0) {
                        break;
                    }
                } else if (B[indexB] <= B[midB]) {
                    indexB++;
                    remain--;
                    if (remain == 0) {
                        break;
                    }
                }
            }
        } else {
            while (indexA <= midA) {
                if (A[indexA] > B[indexB]) {
                    indexB++;
                    remain--;
                    if (remain == 0) {
                        break;
                    }
                } else if (A[indexA] <= A[midA]) {
                    indexA++;
                    remain--;
                    if (remain == 0) {
                        break;
                    }
                }

            }
        }


        if (A[midA] > B[midB]) {
            return findMedian(Arrays.copyOfRange(A, indexA, A.length),
                    Arrays.copyOfRange(B, indexB, B.length), remain, isOneMedian);
        } else {
            return findMedian(Arrays.copyOfRange(A, indexA, A.length),
                    Arrays.copyOfRange(B, indexB, B.length), remain, isOneMedian);
        }
    }
}
