import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://codeforces.com/problemset/problem/1373/B
 */
public class MySolution {
    private static Scanner scanner = new Scanner(System.in);
    private Solver algo;

    public MySolution( Solver algo ) {
        this.algo = algo;
    }

    public static void main( String[] args) {
        MySolution solution = new MySolution(new Solver());
        final int numberOfCases = scanner.nextInt();
        final String[] sequences = new String[numberOfCases];
        solution.populateArray(sequences);
        Arrays.stream(sequences)
              .forEach(s ->  solution.solve(s, "Alice", "Bob"));
    }

    public void solve(String seq, String firstPlayer, String secondPlayer){
        this.algo.solveSequence(seq, firstPlayer, secondPlayer);
    }

    /**
     * using a scanner object, we populate the array of sequences.
     * The number of the entered sequences should be equal
     * to the number of predefined sequences.
     */
    private void populateArray( String[] sequences) {
        for (int i = 0; i < sequences.length; i++) {
            sequences[i]= scanner.next();
        }
    }

    public Solver getAlgo() {
        return algo;
    }

    public void setAlgo( Solver algo ) {
        this.algo = algo;
    }
}
