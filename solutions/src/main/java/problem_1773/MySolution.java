package problem_1773;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://codeforces.com/problemset/problem/1373/B
 * this class can run the iumplementation solver that solve the 1373B problem.
 * check the definition of the solve method in the following interface {@link ISolve1373B}
 *
 */
public class MySolution {
    private static Scanner scanner = new Scanner(System.in);
    private ISolve1373B solver;

    public MySolution( ISolve1373B solver ) {
        this.solver = solver;
    }

    public static void main( String[] args) {
        MySolution solution = new MySolution(new Solver());
        final int numberOfCases = scanner.nextInt();
        final String[] sequences = new String[numberOfCases];
        solution.populateArray(sequences);
        Arrays.stream(sequences)
              .forEach(s ->  {
                  String winner = solution.solve(s, "Alice", "Bob");
                  System.out.println(winner);
              });
    }

    public String solve(String seq, String firstPlayer, String secondPlayer){
        return this.solver.solveSequence(seq, firstPlayer, secondPlayer);
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
}
