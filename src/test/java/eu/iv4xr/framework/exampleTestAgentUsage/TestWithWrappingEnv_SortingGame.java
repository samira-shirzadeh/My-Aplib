package eu.iv4xr.framework.exampleTestAgentUsage;

import eu.iv4xr.framework.mainConcepts.*;
import nl.uu.cs.aplib.Logging;
import nl.uu.cs.aplib.agents.StateWithMessenger;
import nl.uu.cs.aplib.mainConcepts.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static nl.uu.cs.aplib.AplibEDSL.*;
import static eu.iv4xr.framework.Iv4xrEDSL.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestWithWrappingEnv_SortingGame {

    /**
     * Define an Environment to provide an interface between the test agent and the
     * program-under-test. Here, we will choose to simply wrap the environment over
     * the program-under-test.
     */
    static class SortingEnv extends Environment {
        /**
         * The instance of sortingGame that is to be tested, wrapped inside this
         * Environment.
         */
        SortingGame sortingGameUnderTest;
        SortingEnv(SortingGame sortingGame) {
            sortingGameUnderTest = sortingGame;
        }
    }
    /**
     * Define a new state-structure for the agent.
     */
    static class MyState extends StateWithMessenger {
        MyState() { super(); }
        int[] indexOfArray = new int[0];
        @Override
        public SortingEnv env() { return (SortingEnv) super.env(); }
    }

    // Construct a tactic to auto-drive the player to goal's array:
    Tactic arrayToBeSorted(int[] MyArray) {
        Action swap = action("action_swap").do1((MyState S) -> {
            S.env().sortingGameUnderTest.swap(S.env().sortingGameUnderTest.pointerToElementOfArray,S.indexOfArray);
            Logging.getAPLIBlogger().info("swap. New state: " + Arrays.toString(S.env().sortingGameUnderTest.getMyArray()) +"pointer :  "+ S.env().sortingGameUnderTest.pointerToElementOfArray);
            return S;
        });

        Action navigate = action("action_navigate").do1((MyState S) -> {
            S.indexOfArray = S.env().sortingGameUnderTest.add(S.indexOfArray, S.env().sortingGameUnderTest.pointerToElementOfArray);
            S.env().sortingGameUnderTest.pointer(S.env().sortingGameUnderTest.pointerToElementOfArray);
            Logging.getAPLIBlogger().info("navigation to new element. New state: " +  Arrays.toString(S.env().sortingGameUnderTest.getMyArray())+"pointer : "+ S.env().sortingGameUnderTest.pointerToElementOfArray);
            return S;
        });

        return FIRSTof(
                swap.on_((MyState S) -> S.env().sortingGameUnderTest.myArray[S.env().sortingGameUnderTest.pointerToElementOfArray] > MyArray[S.env().sortingGameUnderTest.pointerToElementOfArray] ||
                        S.env().sortingGameUnderTest.myArray[S.env().sortingGameUnderTest.pointerToElementOfArray]< MyArray[S.env().sortingGameUnderTest.pointerToElementOfArray]).lift(),
                navigate.on_((MyState S) -> S.env().sortingGameUnderTest.myArray[S.env().sortingGameUnderTest.pointerToElementOfArray] ==  MyArray[S.env().sortingGameUnderTest.pointerToElementOfArray]).lift()
        );
    }
    public void parameterizedSortingGameTest(int[] MyArray, boolean expectedWinConclusion){
        // (1) Create a new SortingGame that is to be tested:
        var game = new SortingGame();
        Logging.getAPLIBlogger().info("STARTING a new test. Initial state: (" + Arrays.toString(game.getMyArray()) + ")");

        // (2) Create a fresh state + environment for the test agent; attach the game to the env:
        var state = (MyState) (new MyState().setEnvironment(new SortingEnv(game)));

        // (3) Create your test agent; attach the just created state to it:
        var agent = new TestAgent().attachState(state);

        var info = "test sorting(" + MyArray + ")";

        // (4) Define what is the testing task as a goal (to be solved by the agent):
        var topGoal = testgoal("tg")
                // the goal is to drive the game to get it to sorted array:
                . toSolve((MyState S) -> Arrays.equals(S.env().sortingGameUnderTest.myArray , MyArray))
                // specify the tactic to solve the above goal:
                . withTactic(arrayToBeSorted(MyArray))
                // assert the correctness property that must hold on the state where the goal is solved;
                // we will check that the win() have correct values:
                . oracle(agent, (MyState S) ->
                        assertTrue_("",info,
                                S.env().sortingGameUnderTest.win() == expectedWinConclusion))
                // finally we lift the goal to become a GoalStructure, for technical reason.
                . lift();

        // (5) Attach the goal created above to your test-agent; well, and the test-agent also need
        // a data-collector:
        var dataCollector = new TestDataCollector();
        agent. setTestDataCollector(dataCollector)
                . setGoal(topGoal);

        // (6) now we can run the agent to do the test:
        while (!topGoal.getStatus().success()) {
            agent.update();
        }
        // (7) And finally we verify that the agent didn't see anything wrong:
        assertTrue(dataCollector.getNumberOfFailVerdictsSeen() == 0);
        assertTrue(dataCollector.getNumberOfPassVerdictsSeen() == 1);
        Logging.getAPLIBlogger().info("TEST END.");

    }

    @Test
    /**
     * OK, let's now run a bunch of tests!
     */
    public void tests() {
        parameterizedSortingGameTest(new int[] {1,2,3,4,5},true ) ;
        parameterizedSortingGameTest(new int[] {2,4,1,3,5},false ) ;
        Logging.getAPLIBlogger().setUseParentHandlers(true);
    }
}
