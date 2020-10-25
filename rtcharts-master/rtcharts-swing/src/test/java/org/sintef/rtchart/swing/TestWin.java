package org.sintef.rtchart.swing;

import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.thingml.rtcharts.swing.*;

import java.awt.*;
import java.math.BigDecimal;
import java.util.function.BooleanSupplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestWin {

    //test DataBuffer by using interface base techniques
    @Test
    public void TestLineGraphPanel() {
        // interface-based test
        // Base-Choice (True, NotNull, Null,Null,Null,Null, invalid)
        assertThrows(IllegalArgumentException.class, () -> {
            GraphBuffer bufferB1 = new GraphBuffer(100);
            String nameB1 = "test";
            Integer yminB1 = null;
            Integer ymaxB1 = null;
            Integer yminorB1 = null;
            Integer xminorB1 = null;
            Color colorB1 = new Color(127, 256, 127);
            GraphPanel TestB1 = new LineGraphPanel(bufferB1, nameB1, yminB1, ymaxB1, yminorB1, xminorB1, colorB1);
        });

        // (True, NotNull, Zero,Null,Null,Null, invalid)
        assertThrows(IllegalArgumentException.class, () -> {
            GraphBuffer buffer = new GraphBuffer(100);
            String name = "test";
            int ymin = 0;
            Integer ymax = null;
            Integer yminor = null;
            Integer xminor = null;
            Color color = new Color(127, 256, 127);
            GraphPanel Test = new LineGraphPanel(buffer, name, ymin, ymax, yminor, xminor, color);
        });

        // (False, NotNull, Null,Null,Null,Null, invalid)
        assertThrows(NegativeArraySizeException.class, () -> {
            GraphBuffer bufferF = new GraphBuffer(-1);
            String nameF = "test";
            int yminF = 0;
            Integer ymaxF = null;
            Integer yminorF = null;
            Integer xminorF = null;
            Color colorF = new Color(127, 255, 127);
            GraphPanel TestF = new LineGraphPanel(bufferF, nameF, yminF, ymaxF, yminorF, xminorF, colorF);
        });

        // (True, Null, Null,Null,Null,Null, invalid)
        // If variable 'color' is invalid (<0 or >255), the color will be detected before other variable
        assertThrows(IllegalArgumentException.class, () -> {
            GraphBuffer bufferN = new GraphBuffer(100);
            String nameN = null;
            int yminN = 0;
            Integer ymaxN = null;
            Integer yminorN = null;
            Integer xminorN = null;
            Color colorN = new Color(127, 256, 127);
            GraphPanel TestN = new LineGraphPanel(bufferN, nameN, yminN, ymaxN, yminorN, xminorN, colorN);
        });

        // Base-Choice (True, NotNull, Positive, Positive, Positive,Positive, Valid)
        GraphBuffer bufferB2 = new GraphBuffer(100);
        String nameB2 = "test";
        int yminB2 = 1;
        int ymaxB2 = 1;
        int yminorB2 = 1;
        int xminorB2 = 1;
        Color colorB2 = new Color(127, 255, 127);
        GraphPanel TestB2 = new LineGraphPanel(bufferB2, nameB2, yminB2, ymaxB2, yminorB2, xminorB2, colorB2);
        assertNotNull(TestB2);

        // (True, NotNull, Zero, Positive, Positive,Positive, Valid)
        GraphBuffer buffer2 = new GraphBuffer(100);
        String name2 = "test";
        int ymin2 = 0;
        int ymax2 = 1;
        int yminor2 = 1;
        int xminor2 = 1;
        Color color2 = new Color(127, 255, 127);
        GraphPanel Test2 = new LineGraphPanel(buffer2, name2, ymin2, ymax2, yminor2, xminor2, color2);
        assertNotNull(Test2);

        // (True, NotNull, Negative, Positive, Positive,Positive, Valid)
        GraphBuffer buffer3 = new GraphBuffer(100);
        String name3 = "test";
        int ymin3 = -1;
        int ymax3 = 1;
        int yminor3 = 1;
        int xminor3 = 1;
        Color color3 = new Color(127, 255, 127);
        GraphPanel Test3 = new LineGraphPanel(buffer3, name3, ymin3, ymax3, yminor3, xminor3, color3);
        assertNotNull(Test3);

        // (True, NotNull, Positive, Zero, Positive,Positive, Valid)
        GraphBuffer buffer4 = new GraphBuffer(100);
        String name4 = "test";
        int ymin4 = 1;
        int ymax4 = 0;
        int yminor4 = 1;
        int xminor4 = 1;
        Color color4 = new Color(127, 255, 127);
        GraphPanel Test4 = new LineGraphPanel(buffer4, name4, ymin4, ymax4, yminor4, xminor4, color4);
        assertNotNull(Test4);

        // (True, NotNull, Positive, Negative, Positive,Positive, Valid)
        GraphBuffer buffer5 = new GraphBuffer(100);
        String name5 = "test";
        int ymin5 = 1;
        int ymax5 = -1;
        int yminor5 = 1;
        int xminor5 = 1;
        Color color5 = new Color(127, 255, 127);
        GraphPanel Test5 = new LineGraphPanel(buffer5, name5, ymin5, ymax5, yminor5, xminor5, color5);
        assertNotNull(Test5);

        // (True, NotNull, Positive, Positive, Zero,Positive, Valid)
        GraphBuffer buffer6 = new GraphBuffer(100);
        String name6 = "test";
        int ymin6 = 1;
        int ymax6 = 1;
        int yminor6 = 0;
        int xminor6 = 1;
        Color color6 = new Color(127, 255, 127);
        GraphPanel Test6 = new LineGraphPanel(buffer6, name6, ymin6, ymax6, yminor6, xminor6, color6);
        assertNotNull(Test6);

        // (True, NotNull, Positive, Positive, Negative,Positive, Valid)
        GraphBuffer buffer7 = new GraphBuffer(100);
        String name7 = "test";
        int ymin7 = 1;
        int ymax7 = 1;
        int yminor7 = -1;
        int xminor7 = 1;
        Color color7 = new Color(127, 255, 127);
        GraphPanel Test7 = new LineGraphPanel(buffer7, name7, ymin7, ymax7, yminor7, xminor7, color7);
        assertNotNull(Test7);

        // (True, NotNull, Positive, Positive, Positive, Zero, Valid)
        GraphBuffer buffer8 = new GraphBuffer(100);
        String name8 = "test";
        int ymin8 = 1;
        int ymax8 = 1;
        int yminor8 = 1;
        int xminor8 = 0;
        Color color8 = new Color(127, 255, 127);
        GraphPanel Test8 = new LineGraphPanel(buffer8, name8, ymin8, ymax8, yminor8, xminor8, color8);
        assertNotNull(Test8);

        // (True, NotNull, Positive, Positive, Positive, Negative, Valid)
        GraphBuffer buffer9 = new GraphBuffer(100);
        String name9 = "test";
        int ymin9 = 1;
        int ymax9 = 1;
        int yminor9 = 1;
        int xminor9 = 0;
        Color color9 = new Color(127, 255, 127);
        GraphPanel Test9 = new LineGraphPanel(buffer9, name9, ymin9, ymax9, yminor9, xminor9, color9);
        assertNotNull(Test9);

        // (False, NotNull, Positive, Positive, Positive,Positive, Valid)
        assertThrows(NegativeArraySizeException.class, () -> {
            GraphBuffer buffer10 = new GraphBuffer(-1);
            String name10 = "test";
            int ymin10 = 1;
            int ymax10 = 1;
            int yminor10 = 1;
            int xminor10 = 1;
            Color color10 = new Color(127, 255, 127);
            GraphPanel Test10 = new LineGraphPanel(buffer10, name10, ymin10, ymax10, yminor10, xminor10, color10);
        });

        // (True, Null, Positive, Positive, Positive,Positive, Valid)
        // Variable 'name' can be null
        GraphBuffer buffer11 = new GraphBuffer(100);
        String name11 = null;
        int ymin11 = 1;
        int ymax11 = 1;
        int yminor11 = 1;
        int xminor11 = 0;
        Color color11 = new Color(127, 255, 127);
        GraphPanel Test11 = new LineGraphPanel(buffer11, name11, ymin11, ymax11, yminor11, xminor11, color11);
        assertNotNull(Test11);

        // Functionality-based test
        // Base-choice (True, every variable)
        GraphBuffer buffer12 = new GraphBuffer(99);
        String name12 = "This is the test name for functionality-based test: True";
        int ymin12 = 99999999;
        int ymax12 = -999999;
        int yminor12 = 999999;
        int xminor12 = 9999999;
        Color color12 = new Color(127, 255, 127);
        GraphPanel Test12 = new LineGraphPanel(buffer12, name12, ymin12, ymax12, yminor12, xminor12, color12);
        assertEquals(99999999, ymin12);
        assertEquals(-999999, ymax12);
        assertEquals(999999, yminor12);
        assertEquals(9999999, xminor12);
        assertEquals(new Color(127, 255, 127), color12);

        // (False, some variables are incorrect)
        assertThrows(NullPointerException.class, () -> {
            GraphBuffer buffer13 = new GraphBuffer(99);
            String name13 = "This is the test name for functionality-based test: True";
            int ymin13 = 99999999;
            Integer ymax13 = null;
            int yminor13 = 999999;
            int xminor13 = 9999999;
            Color color13 = new Color(127, 255, 127);
            GraphPanel Test13 = new LineGraphPanel(buffer13, name13, ymin13, ymax13, yminor13, xminor13, color13);
            assertEquals(99999999, ymin13);
            assertEquals(-999999, ymax13);
            assertEquals(999999, yminor13);
            assertEquals(9999999, xminor13);
            assertEquals(new Color(127, 255, 127), color13);
        });
    }
}
