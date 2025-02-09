package topKlargest;

import java.util.PriorityQueue;

public class TopKLargest {
    public static void main(String[] args) {
        TopKLargest topKLargest = new TopKLargest();
        int[] nums = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;
        int[] result = topKLargest.findKLargest(nums, k);

        System.out.print("Output: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int[] findKLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the first k elements to the minHeap
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        // Iterate through the rest of the array
        for (int i = k; i < nums.length; i++) {
            // If the current element is larger than the smallest element in the heap
            if (nums[i] > minHeap.peek()) {
                // Remove the smallest element
                minHeap.poll();
                // Add the current element to the heap
                minHeap.add(nums[i]);
            }
        }

        // Extract the elements from the minHeap to the result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}

/*
 * public static int[] topK(int[] nums, int k) {
        // Step 1: Count frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a priority queue to store elements based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);

            if (freqA != freqB) {
                return freqA - freqB; // Sort by increasing frequency
            } else {
                return b - a; // If frequencies are equal, sort by decreasing value
            }
        });

        // Step 3: Add elements to the priority queue
        for (int num : frequencyMap.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll(); // Remove element with smallest frequency
            }
        }

        // Step 4: Extract elements from priority queue into an array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 3, 3, 3};
        int k1 = 2;
        int[] result1 = topK(arr1, k1);
        System.out.println("Top " + k1 + " frequent elements: " + Arrays.toString(result1)); // Output: [3, 2]

        int[] arr2 = {1, 4, 4, 4, 7, 7};
        int k2 = 3;
        int[] result2 = topK(arr2, k2);
        System.out.println("Top " + k2 + " frequent elements: " + Arrays.toString(result2)); // Output: [4, 7, 1]
    }
}
*/

 */
 * 
