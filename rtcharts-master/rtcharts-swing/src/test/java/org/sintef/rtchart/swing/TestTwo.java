package org.sintef.rtchart.swing;

import org.junit.Test;
import org.thingml.rtcharts.swing.BarGraphPanel;
import org.thingml.rtcharts.swing.GraphBuffer;
import org.thingml.rtcharts.swing.GraphPanel;

import java.awt.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestTwo {
    @Test
    public void testInsertData() {
        // Interface-based
        GraphBuffer graphNull = new GraphBuffer();
        Integer nullVal = null;
        assertThrows(NullPointerException.class, () -> {
            graphNull.insertData(nullVal);
        });

        // Functionality-based
        GraphBuffer graph = new GraphBuffer();
        double angle = -Math.PI;
        int v = 0;
        for (int i = 0; i < graph.getSize(); i++) {
            angle += Math.PI / 50;
            if (angle > Math.PI)
                angle = -Math.PI;

            v = (int) (Math.sin(angle) * 100.0);

            graph.insertData(v);
        }
//        System.out.println(graph.getGraphData()[1]);
//        System.out.println(Arrays.toString(graph.getGraphData()));

        boolean changesValCheck = false;
        for (int i : graph.getGraphData()) {
            if (i == -87) {
                changesValCheck = true;
                break;
            }
        }
        assertTrue(changesValCheck);

//        int a = graph.getGraphData()[1];
//        System.out.println(a);
    }

    @Test
    public void testBarGraphPanel() {
        // Interface-based
        // Test GraphBuffer object with *Invalid Value*
        Integer nullVal = null;
        assertThrows(NegativeArraySizeException.class, () -> {
            GraphPanel graph_panel = new BarGraphPanel(new GraphBuffer(-5), "First Graph",
                    -100, 100, 25, Color.RED);});

        // Test yMin = null
        assertThrows(NullPointerException.class, () -> {
            GraphPanel graph_panel = new BarGraphPanel(new GraphBuffer(500), "First Graph",
                    nullVal, 100, 25, Color.RED);});

        // Test yMax = null
        assertThrows(NullPointerException.class, () -> {
            GraphPanel graph_panel = new BarGraphPanel(new GraphBuffer(500), "First Graph",
                    -100, nullVal, 25, Color.RED);});

        // Test yMinor = null
        assertThrows(NullPointerException.class, () -> {
            GraphPanel graph_panel = new BarGraphPanel(new GraphBuffer(500), "First Graph",
                    -100, 100, nullVal, Color.RED);});

        // Test Color is invalid value
        assertThrows(IllegalArgumentException.class, () -> {
            GraphPanel graph_panel = new BarGraphPanel(new GraphBuffer(500), "First Graph",
                    -100, 100, 25, new Color(125, 256, 125));});

        // Functionality-based
        GraphBuffer graph_buffer = new GraphBuffer(500);
        assertNotNull(graph_buffer);

        // Test yMinor = negative value
        GraphPanel graph_panel2 = new BarGraphPanel(graph_buffer, "First Graph",
                -100, 100, -25, Color.RED);
        assertNotNull(graph_panel2);
        assertEquals(-25, graph_panel2.getYminor());
        assertEquals(-100, graph_panel2.getYmin());
        assertEquals(100, graph_panel2.getYmax());
        assertEquals(Color.RED, graph_panel2.getColor());

        // Test yMinor = zero
        GraphPanel graph_panel3 = new BarGraphPanel(graph_buffer, "First Graph",
                -100, 100, 0, Color.RED);
        assertNotNull(graph_panel3);
        assertEquals(0, graph_panel3.getYminor());
        assertEquals(-100, graph_panel3.getYmin());
        assertEquals(100, graph_panel3.getYmax());
        assertEquals(Color.RED, graph_panel3.getColor());

        // Test Valid Inputs
        GraphPanel graph_panel = new BarGraphPanel(graph_buffer, "First Graph",
                -100, 100, 25, Color.RED);
        assertNotNull(graph_panel);
        assertEquals(25, graph_panel.getYminor());
        assertEquals(-100, graph_panel.getYmin());
        assertEquals(100, graph_panel.getYmax());
        assertEquals(Color.RED, graph_panel.getColor());
    }

    @Test
    public void testResetBuffer() {
        GraphBuffer graph = new GraphBuffer();
        double angle = -Math.PI;
        int v = 0;

        for (int i = 0; i < graph.getSize(); i++) {
            angle += Math.PI / 50;
            if (angle > Math.PI)
                angle = -Math.PI;

            v = (int) (Math.sin(angle) * 100.0);

            graph.insertData(v);
        }

        assertNotNull(graph.getGraphData());

        graph.resetBuffer();

        boolean checkReset = true;
        for (int i : graph.getGraphData()) {
            if (i != graph.getInvalidNumber()) {
                checkReset = false;
            }
            assertEquals(graph.getInvalidNumber(), i);
        }
//        System.out.println(graph.getInvalidNumber());
        assertTrue(checkReset);

        GraphBuffer graph2 = new GraphBuffer();
        int a[]={};

        graph2.setGraphData(a);
//        System.out.println(Arrays.toString(graph2.getGraphData()));
        graph2.resetBuffer();
//        System.out.println(Arrays.toString(graph2.getGraphData()));
    }
}
