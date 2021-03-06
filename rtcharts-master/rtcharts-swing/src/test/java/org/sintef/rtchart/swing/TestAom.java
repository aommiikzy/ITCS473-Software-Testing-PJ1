package org.sintef.rtchart.swing;

import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.thingml.rtcharts.swing.DataBuffer;
import org.thingml.rtcharts.swing.GraphBuffer;
import org.thingml.rtcharts.swing.XYGraphPanel;

import java.awt.*;
import java.math.BigDecimal;
import java.util.function.BooleanSupplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAom {

    //test DataBuffer by using interface base techniques
    @Test
    public void TestDataBuffer() {
        //test  Interface base
//        T1: (A1,B1) n Both column and row is null
        assertThrows(NullPointerException.class, () -> {
            Integer a = null;
         DataBuffer Test =  new DataBuffer(a, a);
        });
//        T2: (A2,B2) n Both column and row is positive
        assertDoesNotThrow(() -> {
            Integer a = 5;
            DataBuffer Test =  new DataBuffer(a, a);
        });
//        T3: (A3,B3) n Both column and row is zero
        assertDoesNotThrow(() -> {
            Integer a = 0;
            DataBuffer Test =  new DataBuffer(a, a);
        });
//        T4: (A4,B4) n Both column and row is negative
        assertThrows(NegativeArraySizeException.class, () -> {
            Integer a = -1;
            DataBuffer Test =  new DataBuffer(a, a);
        });

        //test  Functional  base
//        T5: (A1,B1) Y Both column and row is positive
        DataBuffer Test1 = new DataBuffer(50, 50);
        assertEquals(50,Test1.getColumns());
        assertEquals(50,Test1.getRows());

//        T2: (A2,B2) n
//        assertThrows(NegativeArraySizeException.class, () -> {
//            Integer a = -1;
//            DataBuffer Test =  new DataBuffer(a, a);
//            assertEquals(-1,Test.getColumns());
//            assertEquals(-1,Test.getRows());
//        });

    }

    //test SetData by using functional base techniques
    DataBuffer Test;
    @Before
    public void init() {
        Test = new DataBuffer(10, 10);
    }
    @Test
    public void TestSetData() {

//       T1: Row, column, data value value are zero
        Test = new DataBuffer(10, 10);
        int testRow1 = 0, testColumn1 = 0, testValue1= 0;
        assertTrue(Test.setData(testRow1, testColumn1, testValue1));
//        T2: Row, column, data value value are positive
        int testRow2 = 5, testColumn2 = 5, testValue2= 11;
        assertTrue(Test.setData(testRow2, testColumn2, testValue2));
//        T3:Row, column value is in range and data is set correctly
        int testRow3 = 5, testColumn3 = 5, testValue3= 11;
        boolean test = Test.setData(testRow3, testColumn3, testValue3);
        int[] result = Test.getColumnClone(5);
        assertEquals(11,result[5]);
        assertEquals(test,true);
//        assertEquals(4,result[1]);
//        assertEquals(11,Test.getDataClone());

//        FUNCTIONAL BASE
//        T1: (A1,B1,C1) y*
//        int testRow3 = 5, testColumn3 = 5, testValue3= 11;
//        Test.setData(testRow3, testColumn3, testValue3);
//        Test.setData(testRow2,testColumn2,testValue2);
//        assertThrows(NumberFormatException.class, () -> {
//            int testRow2 = 5; int testColumn2 = 5; int testValue2= Integer.parseInt(null);
//            Test.setData(testRow2,testColumn2,testValue2);});
//
//        int testRow3 = 5; int testColumn3 = 15; Integer testValue3; testValue3=50;
//        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
//            Test.setData(testRow3,testColumn3,testValue3);
//        });
//
//        int testRow4 = 5; int testColumn4 = 15; Integer testValue4; testValue4=null;
//        assertThrows(NullPointerException.class, () -> {
//            Test.setData(testRow4,testColumn4,testValue4);
//        });
//        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
//            int testRow5 = 15; int testColumn5 = 5; int testValue5= 50;
//            Test.setData(testRow5,testColumn5,testValue5);});
//
//        assertThrows(NumberFormatException.class, () -> {
//            int testRow6 = 15; int testColumn6 = 5; int testValue6= Integer.parseInt(null);
//            Test.setData(testRow6,testColumn6,testValue6);});
//
//        int testRow7 = 15; int testColumn7 = 15; Integer testValue7; testValue7=50;
//        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
//            Test.setData(testRow7,testColumn7,testValue7);
//        });
//
//        int testRow8 = 15; int testColumn8 = 15; Integer testValue8; testValue8=null;
//        assertThrows(NullPointerException.class, () -> {
//            Test.setData(testRow8,testColumn8,testValue8);
//        });

    }
    @After
    public void clearValue() {
        Test.resetBuffer();
    }

    @Before
    public void initTestSet() {
        Test = new DataBuffer(2, 2);

    }
    @Test
    public void TestGetColumnClone() {


        Test.setData(0,0,1);
        Test.setData(0,1,2);
        Test.setData(1,0,3);
        Test.setData(1,1,4);
//        t1 Input column value is null
        assertThrows(NullPointerException.class, () -> {
            Integer a = null;
            int[] result = Test.getColumnClone(a);

        });
//        t2 Input column value is positive

        assertDoesNotThrow( () -> {
            Integer a = 1;
            int[] result = Test.getColumnClone(a);
        });
//t3       Input column value is zero
        assertDoesNotThrow( () -> {
            Integer a = 0;
            int[] result = Test.getColumnClone(a);
        });
//        t4 Input column is negative
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Integer a = -1;
            int[] result = Test.getColumnClone(a);

        });
//      t5 All new elements array are the same with the main array column and input column is in range of main array
        int[] result = Test.getColumnClone(0);
        result = Test.getColumnClone(1);
//        System.out.println(result[0]);
//        System.out.println(result[1]);
        assertEquals(2,result[0]);
        assertEquals(4,result[1]);

    }
    @After
    public void clearValueColumnClone() {
        Test.resetBuffer();
    }

    @Before
    public void initTestSetDataColumn() {
        Test = new DataBuffer(2, 2);
    }
    @Test
    public void TestSetDataColumn() {

        Test.setData(0,0,1);
        Test.setData(0,1,2);
        Test.setData(1,0,3);
        Test.setData(1,1,4);

        //T1 Input column value is positive and all values are valid in data array
        int[] a0 =  {5,6};
        boolean test0= Test.setDataColumn(1,a0);
        assertEquals(true,test0);
//        t2 Input column value is zero and all values are valid in the data array.
        int[] a00 =  {5,6};
        boolean test1= Test.setDataColumn(0,a00);
        assertEquals(true,test1);

//        t3 Input column value is null and all values are valid in the data array
        assertThrows(NullPointerException.class, () -> {
            Integer a = null;
            int[] a000 =  {5,a};
            boolean test00= Test.setDataColumn(1,a000);
        });

        //t4 Data is changed completely
        int[] a4 =  {5,6};
        boolean test4= Test.setDataColumn(1,a4);
        assertEquals(true,test4);

        //T5 Data is not changed completely
        assertThrows(NullPointerException.class, () -> {
            int[] a2 = null;
            Test.setDataColumn(0,a2);
        });

    }
    @After
    public void clearSetDataColumn() {
        Test.resetBuffer();
    }

    @Test
    public void TestappendDataRow() {
        DataBuffer Test = new DataBuffer(2,2);
        Test.setData(0,0,1);
        Test.setData(0,1,2);
        Test.setData(1,0,3);
        Test.setData(1,1,4);
        //interface base
        //t1
        assertThrows(NullPointerException.class, () -> {
            Integer a = null;
            int[] a000 =  {5,a};
            boolean test00= Test.appendDataRow(a000);
        });

        // t2
        int[] a0 =  {5,6};
        assertEquals(true,Test.appendDataRow(a0));

        //t3
        assertThrows(NullPointerException.class, () -> {
            int[] a2 = null;
            Test.appendDataRow(a2);
        });

        //functional base
        //t4
        int[] a3 = {0, Integer.MIN_VALUE};
        assertEquals(false,Test.appendDataRow(a3));

        //t5
        int[] a00 =  {5,6};
        assertEquals(true,Test.appendDataRow(a00));
    }

    @Before
    public void initTestSetDataRow() {
        Test = new DataBuffer(2, 2);
    }
    @Test
    public void TestSetDataRow() {
        DataBuffer Test = new DataBuffer(2,2);
        Test.setData(0,0,1);
        Test.setData(0,1,2);
        Test.setData(1,0,3);
        Test.setData(1,1,4);

        // T1 Input row value is positive and all values are valid in data array
        int[] a0 =  {5,6};
        assertEquals(true,Test.setDataRow(1,a0));

        // T2 Input row value is zero and all values are valid in the data array.
        int[] a00 =  {5,6};
        assertEquals(true,Test.setDataRow(0,a00));

        // T3 Input row value is null and all values are valid in the data array.
        assertThrows(NullPointerException.class, () -> {
            Integer a = null;
            int[] a000 =  {5,a};
            boolean test00= Test.setDataRow(1,a000);
        });

        // T4 Data is changed completely
        int[] a4 =  {5,6};
        assertEquals(true,Test.setDataRow(1,a4));

        //functional base a1,b2
        // T5 Data is not changed completely
        assertThrows(NullPointerException.class, () -> {
            int[] a2 = null;
            Test.setDataRow(0,a2);
        });
    }
    @After
    public void clearSetDataRow() {
        Test.resetBuffer();
    }

}
