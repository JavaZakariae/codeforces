package problem_1773;

import java.util.HashSet;
import java.util.Set;

public class Solver implements ISolve1373B {

    /*all the childes generated sequences, the set will help to make prunning opration on the generated tree*/
    static Set<String> generatedChildes = new HashSet<>();
    /*first and second player names*/
    static String first, second;

    @Override
    public String solveSequence( String sequence, String firstPlayer, String secondPlayer ) {
        first=firstPlayer;
        second=secondPlayer;
        boolean firstPlayerWin = solve(sequence, firstPlayer);
        return  firstPlayerWin == true ?"DA":"NET";
    }

    /**
     *
     * @return true if the current player can win the game defined by the given sequence
     */
    private boolean solve( String sequence, String currentPlayer) {
        if (sequence.equals("") || sequence.length()==1)
            return false;
        String[] childSequences = extractSequences(sequence);
        if(childSequences==null){
            return false;
        }
        if(childSequences[0].equals("") ||childSequences[0].length()==1){
            return true;
        }
        String theOtherPlayer = currentPlayer.equals(first)?second:first;
        boolean theOtherPlayerWin=false;
        for (String childSequence : childSequences) {
            if (generatedChildes.contains(childSequence))
                continue;
            generatedChildes.add(childSequence);
            if (!theOtherPlayerWin){
                theOtherPlayerWin=solve(childSequence, theOtherPlayer);
                return !theOtherPlayerWin;
            }
        }
        return !theOtherPlayerWin;
    }


    /**
     * This method implement all possible moves of one player.
     * the full explanation on https://codeforces.com/problemset/problem/1373/B
     * Example can be found on that link.
     * If there is no possible move, we return null.
     */
    private String[] extractSequences( String sequence) {
        int firstIndex =0;
        int secondIndex =1;
        Set<String> setOfChilds = new HashSet<>();
        while (firstIndex<sequence.length()-1)
        {
            if (sequence.charAt(firstIndex)!=sequence.charAt(secondIndex)){
                String newChild ;
                try {
                    newChild = extractSequence(sequence, firstIndex);
                } catch (Exception e) {
                    System.out.println("something wrong with indices for "+sequence);
                    continue;
                }
                setOfChilds.add(newChild);
            }
            firstIndex++;secondIndex++;
        }
        if (setOfChilds.isEmpty())
            return null;
        return setOfChilds.toArray(new String[0]);
    }


    /**
     * This method will remove the characters at [firstIndex; firstIndex+1]
     * the given index should be between 0 and sequence.length()-2.
     * the returned sequence will have 2 characters Less:
     * the character at index firstIndex and the character at index firstIndex+1.
     */
    private String extractSequence( String sequence, int firstIndex) throws Exception {
        if(sequence.length()<2)
            throw new Exception("the sequence should have at least 2 characters ");
        if(firstIndex >= sequence.length()-1 || firstIndex < 0) {
            throw new Exception("the index should be between 0 and " + (sequence.length()-2));
        }
        return sequence.substring(0, firstIndex)+
                sequence.substring(firstIndex+2);
    }
}
