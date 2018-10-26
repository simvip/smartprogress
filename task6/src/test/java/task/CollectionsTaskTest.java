package task;


import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Ivan Sliusar on 17.10.2018.
 * Red Line Soft corp.
 */
public class CollectionsTaskTest {
    private CollectionsTask task;

    @Before
    public void initialTest() {
        this.task = new CollectionsTask();
    }

    @Test
    public void checkingMassiveForAllValuesEqualsOne() throws Exception {
        assertTrue(task.checkingMassiveForAllValuesEqualsOne(
                new int[]{1, 1})
        );
        assertFalse(task.checkingMassiveForAllValuesEqualsOne(
                new int[]{1, 0})
        );
    }

    @Test
    public void checkingMassiveOnSequence() throws Exception {
        assertTrue(
                task.checkingMassiveOnSequence(new int[]{1, 1, 0, 1, 1, 1, 0, 1,})
        );
        assertFalse(
                task.checkingMassiveOnSequence(new int[]{1, 1, 0, 1, 0, 1, 0, 1,})
        );
    }

    @Test
    public void checkingMassiveOnSimilarValues() throws Exception {
        assertTrue(task.checkingMassiveOnSimilarValues(
                new int[]{1, 1, 1})
        );
        assertFalse(task.checkingMassiveOnSimilarValues(
                new int[]{1, 0, 1})
        );
    }

    @Test
    public void reversString() throws Exception {
        assertTrue(task.reversString("программируй и зарабатывай").equals("зарабатывай и программируй"));
    }

    @Test
    public void ringShift() throws Exception {
        assertArrayEquals(task.ringShift(new int[]{1, 2, 3, 4, 5}, 2), new int[]{4, 5, 1, 2, 3});
    }

    @Test
    public void tickTackGame() throws Exception {
        int[][] input = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        assertTrue(task.tickTackGame(input));
        int[][] input2 = {
                {1, 1, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        assertTrue(task.tickTackGame(input2));
        int[][] input3 = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        assertFalse(task.tickTackGame(input3));
    }

    @Test
    public void makingChange() throws Exception {
        int banknotes[] = new int[]{1, 2, 3};
        int numOfbanknotes = banknotes.length;
        int amount = 4;
        assertThat(task.makingChange(banknotes, numOfbanknotes, amount), is(4));
    }

    @Test
    public void defineMaxSetSize() throws Exception {
        int[][] input = {
                {1, 0, 0},
                {0, 1, 1},
                {0, 1, 1}
        };
        assertThat(task.defineMaxSetSize(input), is(4));

    }

    @Test
    public void definePath() throws Exception {
        int[][] input = {
                {1, 0, 1, 1},
                {1, 1, 1, 0},
                {1, 1, 1, 1}
        };
        assertThat(task.definePath(new Peak(0, 0), new Peak(2, 3), input), is(5));

    }

    @Test
    public void heapPermutation() throws Exception {
        List<String> rsl = new LinkedList<>();
        int[] input = {1, 2};
        task.permutation(rsl, "ABC", 0, input.length);
        assertThat(rsl.size(), is(6));

    }
}