package nl.uu.cs.aplib.exampleUsages;

import eu.iv4xr.framework.exampleTestAgentUsage.SortingGame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.* ;


class SortingTest {

    @Test
    public void win() {
        boolean ans = true;
        boolean val;
        SortingGame tester = new SortingGame();
        int[] data={2,5,10};
        //tester.setMyArray(data);
        val = tester.win();
        assertTrue(val);
    }

}