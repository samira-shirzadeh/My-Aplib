package nl.uu.cs.aplib.exampleUsages;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.* ;


class SortingTest {

    @Test
    public void win() {
        boolean ans = true;
        boolean val;
        Sorting tester = new Sorting();
        int[] data={2,5,10};
        tester.setMyArray(data);
        val = tester.win();
        assertTrue(val);
    }

}