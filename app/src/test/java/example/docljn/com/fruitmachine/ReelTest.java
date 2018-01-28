package example.docljn.com.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import example.docljn.com.fruitmachine.JavaLogic.Reel;
import example.docljn.com.fruitmachine.JavaLogic.Symbol;

import static org.junit.Assert.assertEquals;

/**
 * Created by lornanoble on 27/01/2018.
 */

public class ReelTest {

    Reel reel;
    ArrayList<Symbol> setup;
    ArrayList<Symbol> alternativeSetup;

    @Before
    public void before(){
        setup = new ArrayList<>();
        setup.add(Symbol.CLUB);
        setup.add(Symbol.DIAMOND);
        setup.add(Symbol.HEART);
        setup.add(Symbol.SPADE);
        setup.add(Symbol.CLUB);
        setup.add(Symbol.DIAMOND);
        setup.add(Symbol.HEART);
        setup.add(Symbol.HEART);
        reel = new Reel(setup);

        //TODO: work out how returnLevel will affect game (or even if you will implement it)
    }

    @Test
    public void getsNumberOfStopsFromSetup(){
        assertEquals(8, reel.getNumberOfStops());
    }

    @Test
    public void getsHeldStatusFalseAtStart(){
        assertEquals(false, reel.getHeld());
    }

    @Test
    public void setsReelSetup(){
        reel.setSetup(alternativeSetup);
        assertEquals(alternativeSetup, reel.getSetup());
    }

    @Test
    public void getsVisibleStopWhichStartsAtZero(){
        assertEquals(0, reel.getVisibleStop());
    }

    @Test
    public void setsVisibleStop(){
        reel.setVisibleStop(3);
        assertEquals(3, reel.getVisibleStop());
    }

    @Test
    public void stopBeforeFromVisibleStop(){
        reel.setVisibleStop(3);
        assertEquals(2, reel.getStopBefore());
    }

    @Test
    public void stopAfterFromVisibleStop(){
        reel.setVisibleStop(3);
        assertEquals(4, reel.getStopAfter());
    }

    @Test
    public void stopCountIsCircularDownwards(){
        reel.setVisibleStop(0);
        assertEquals(7, reel.getStopBefore());
    }

    @Test
    public void stopCountIsCircularUpwards(){
        reel.setVisibleStop(7);
        assertEquals(0, reel.getStopAfter());
    }

    @Test
    public void reelCanOnlyBeHeldIfHoldableTrue(){
        reel.setHeld(true);
        assertEquals(false, reel.getHeld());
    }

    @Test
    public void setsHeldStatus(){
        reel.setHoldable(true);
        reel.setHeld(true);
        assertEquals(true, reel.getHeld());
    }

    @Test
    public void setVisibleStopIsCircular(){
        reel.setVisibleStop(24);
        assertEquals(0, reel.getVisibleStop());
    }

    @Test
    public void setVisibleStopCopesWithNegatives(){
        reel.setVisibleStop(-1);
        assertEquals(7, reel.getVisibleStop());
    }

    @Test
    public void reelStartsNotNudgeable(){
        assertEquals(false, reel.getNudgeable());
    }

    @Test
    public void setsNudgeable(){
        reel.setNudgeable(true);
        assertEquals(true, reel.getNudgeable());
    }

    @Test
    public void nudgeMovesOneStopOn(){
        reel.nudge();
        assertEquals(0, reel.getVisibleStop());
    }


    @Test
    public void nudgeRequiresNudgeableTrue(){
        reel.setNudgeable(true);
        reel.nudge();
        assertEquals(1, reel.getVisibleStop());
    }

    @Test
    public void spinSetsRandomVisibleStop(){
        //TODO: how to test a random method?
        reel.spin();
        System.out.println(reel.getVisibleStop());
    }

    @Test
    public void spinDoesNotMoveReelIfHeldIsTrue(){
        reel.setHoldable(true);
        reel.setHeld(true);
        reel.spin();
        assertEquals(0, reel.getVisibleStop());
    }

    @Test
    public void stopCanReturnSymbol(){
        assertEquals(Symbol.CLUB, reel.getSymbol(0));
    }

}


