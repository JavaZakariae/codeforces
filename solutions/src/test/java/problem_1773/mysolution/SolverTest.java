package problem_1773.mysolution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import problem_1773.ISolve1373B;
import problem_1773.Solver;

import java.lang.reflect.Method;
import java.util.Arrays;


class SolverTest {

    static ISolve1373B solver;

    @BeforeAll
    static void setUp() {
        solver = new Solver();
    }

    @Test
    void extractSequence() throws Exception {
        Method extractSequence = solver.getClass().getDeclaredMethod("extractSequence",String.class ,int.class);
        extractSequence.setAccessible(true);
        String result = (String) extractSequence.invoke(solver, "123456", 2);
        Assertions.assertEquals("1256", result);
    }

    @Test
    void extractSequences() throws Exception {
        Method extractSequencesMethod = solver.getClass().getDeclaredMethod("extractSequences", String.class);
        extractSequencesMethod.setAccessible(true);
        String [] result = (String[]) extractSequencesMethod.invoke(solver, "1011001");
        System.out.println("result = " + Arrays.toString(result));

        //test2
        String [] result2 = (String[]) extractSequencesMethod.invoke(solver, "01");
        System.out.println("result2 = " + Arrays.toString(result2));

        //test3
        String [] result3 = (String[]) extractSequencesMethod.invoke(solver, "1111");
        System.out.println("result3 = " + Arrays.toString(result3));

        //test4
        String [] result4 = (String[]) extractSequencesMethod.invoke(solver, "0011");
        System.out.println("result4 = " + Arrays.toString(result4));

        //test5
        String [] result5 = (String[]) extractSequencesMethod.invoke(solver, "0");
        System.out.println("result5 = " + Arrays.toString(result5));
    }

    @Test
    void solveSequence(){
        String winner = solver.solveSequence("10101000", "Alice", "Bob");
        System.out.println("winner = " + winner);
    }
}
