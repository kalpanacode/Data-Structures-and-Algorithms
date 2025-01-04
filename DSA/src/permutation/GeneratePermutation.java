package permutation;

public class GeneratePermutation {
	public GeneratePermutation() {
		super();
    }
	 private Vector<Integer> output = new Vector<>();
	    private HashSet<Integer> visited = new HashSet<>();

	    public void generatePermutation(int[] input, int n, int depth) {
	        // Base case: if depth equals n, we have a complete permutation
	        if (depth == n) {
	            printOutput();
	            return;
	        }

	        // Loop through each element in the input array
	        for (int i = 0; i < n; i++) {
	            // If the current element is not visited
	            if (!visited.contains(input[i])) {
	                // Mark the element as visited
	                visited.add(input[i]);
	                // Add the current element to the output vector
	                output.add(input[i]);
	                // Recursive call to generate permutations with increased depth
	                generatePermutation(input, n, depth + 1);
	                // Backtrack: remove the last added element and mark it as unvisited
	                output.remove(output.size() - 1);
	                visited.remove(input[i]);
	            }
	        }
	    }

	    private void printOutput() {
	        // Print the current permutation stored in output vector
	        System.out.println(output);
	    }

	    public static void main(String[] args) {
	        PermutationGenerator generator = new PermutationGenerator();
	        int[] input = {1, 2, 3}; // Example input array
	        int n = input.length;
	        generator.generatePermutation(input, n, 0);
	    }

}
