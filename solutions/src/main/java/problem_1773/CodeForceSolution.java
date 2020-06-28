package problem_1773;

/**
 * The solution from the following git repo: https://github.com/charles-wangkai/codeforces
 *
 * The explanation of the algo from codeforces: If there is at least one character 0 and at least one character 1,
 * then current player can always make a move. After the move the number of character 0 decreases by one,
 * and the number of character 1 decreases by one too.
 * So the number of moves is always min(c0,c1), where c0 is the number of characters 0 in string s,
 * and c1 is the number of characters 1 in string s.
 *
 * So if min(c0,c1) is odd then Alice wins, otherwise Bob wins.
 */
public class CodeForceSolution implements ISolve1373B {
    /**
     *
     *
     */
    @Override
    public String solveSequence( String sequence, String firstPlayer, String secondPlayer ) {
        int count0 = (int) sequence.chars()
                                   .filter(ch -> ch == '0')
                                   .count();
        int count1 = sequence.length() - count0;
        boolean firstPlayerWin = Math.min(count0, count1) % 2 != 0;
        return firstPlayerWin==true?"DA":"NET";
    }
}
