package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();

        // Initialization
        a.addLast(4);
        b.addLast(4);
        a.addLast(5);
        b.addLast(5);
        a.addLast(6);
        b.addLast(6);

        assertEquals(a.getLast(),b.getLast());

        a.removeLast();
        b.removeLast();
        assertEquals(a.getLast(),b.getLast());

        a.removeLast();
        b.removeLast();
        assertEquals(a.getLast(),b.getLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = B.size();
                assertEquals(size1,size2);
            } else if (operationNumber == 2) {
                // getLast
                if(L.size() == 0 || B.size() == 0){
                    continue;
                }

                int output1 = L.getLast();
                int output2 = B.getLast();
                assertEquals(output1,output2);

            } else if (operationNumber == 3) {
                // removeLast

                if(L.size() == 0){
                    continue;
                }

                if(B.size() ==0){
                    continue;
                }

                int Last1 = L.removeLast();
                int Last2 = B.removeLast();
                assertEquals(Last1,Last2);
            }
        }
    }
}
