import java.util.HashSet;
import java.util.Set;

public class Solver implements ISolve1373B {


    @Override
    public String solveSequence( String sequence, String firstPlayer, String secondPlayer ) {
        solveSequence(sequence, firstPlayer, firstPlayer);
        return null;
    }

    private boolean solve( String sequence, String firstPlayer, String currentPlayer) {
        System.out.println("sequence = " + sequence);
        System.out.println("player = " + currentPlayer);
        boolean aliceWin = false;
        String[] childSequences = extractSequences(sequence);
        if(childSequences==null){
            aliceWin = "firstPlayer".equals(currentPlayer)?false:true;
            return aliceWin;
        }
        for (String childSequence : childSequences) {
            String theOtherPlayer = "Alice".equals(currentPlayer)?"Bob":"Alice";
            if(!solve(childSequence, theOtherPlayer, theOtherPlayer))
                aliceWin = !firstPlayer.equals(currentPlayer)?true:false;
        }
        return aliceWin;
    }

    private String extractSequence( String sequence, int firstIndex) throws Exception {
        if(firstIndex >= sequence.length()) {
            throw new Exception("the index should be between 0 and " + (sequence.length()-1));
        }
        return sequence.substring(0, firstIndex-1)+
                sequence.substring(firstIndex+1);
    }

    private String[] extractSequences( String sequence) {
        int firstIndex =0;
        int secondIndex =1;
        Set<String> listOfChilds = new HashSet<>();
        while (secondIndex<sequence.length())
        {
            if (sequence.charAt(firstIndex)!=sequence.charAt(secondIndex)){
                String newChild = null;
                try {
                    newChild = extractSequence(sequence, firstIndex);
                } catch (Exception e) {
                    System.out.println("something wrong with indices");
                    System.out.println(e.getMessage());
                }
                listOfChilds.add(newChild);
            }
        }
        return null;
    }
}
