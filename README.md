# ITCS473-Software-Quality-Assurance-Testing-Project 1


## Method 1: &nbsp; testInsertData()
- __Goal:__ To test whether the data is inserted into the array
- __Testable Function:__
  - insertData()
- __Parameters:__
  - int value
- __Return type:__
  - int Array
- __Return Value:__
  - int Array with inserted value  
  
  
|  | b1 | b2 |
|-|:-:|:-:|
| C1: int value is null | True | False |
| C2: Input format is int | True | False |
| C3: Occurrence of value in the data array | 0 (c1) | Equal or more than 1 (c2) |

- __PWC__<br/>
[T, T], ~~[T, F]~~, ~~[F, T]~~, [F, F],   
[T, c1], [T, c2], ~~[F, c1]~~, [F, c2],   
[T, c1], ~~[T, c2]~~, [F, c1], [F, c2]

- __Valid values:__<br/>
[T, F, c1], [F, T, c2]  

- __Derived test values__

|  | Value | Expected |
|-|:-:|:-:|
| T1: Invalid input | null | NullPointer Exception |
| T2: Valid input | -87 | [.., -87, ..] |  

-----------------------------------------------------------------------------------------------------

## Method 2:&nbsp; testSetData()
- __Goal:__ To set the data in the main array
- __Testable Function:__
  - setData()
- __Parameters:__
  - int row, column, data value
- __Return type:__
  - Boolean
- __Return Value:__
  - True, False  
- __ECC Interface base__  

|  | b1 | b2 | b3 | b4 |
|-|:-:|:-:|:-:|:-:|
| C1: Row value | Negative(A1) | Zero(A2) | Positive(A3) | null(A4) |
| C2: column value | Negative(B1) | Zero(B2) | Positive(B3) | null(B4) |
| C3: data value | Negative(C1) | Zero(C2) | Positive(C3) | null(C4) |  

T1: (A1,B1,C1)  
T2: (A2,B2,C2)  
T3: (A3,B3,C3)  
T4: (A4,B4,C4) 
- __Valid values:__  
(A2,B2,C2), (A3,B3,C3)  

- __ECC Functional base__  

|  | b1 | b2 |
|-|:-:|:-:|
| C1: Row value is in range | Yes(A1) | No(A2) |
| C2: column value is in range | Yes(B1) | No(B2) |
| C3: data is set correctly | Yes(C1) | No(C2) |  

T1: (A1,B1,C1) 
T2: (A2,B2,C2) 

- __Valid values:__  
(A1,B1,C1)  
- __Derived test values__  

|  | Value | Expected |
|-|:-:|:-:|
| T1: Row, column, data value value are zero | setData(0, 0, 0) | true |
| T2: Row, column, data value value are positive | setData(1, 1, 1) | true |
| T3: Row, column value is in range and data is set correctly | setData(1, 1, 1) | true |  

-----------------------------------------------------------------------------------------------------

## Method 3:&nbsp; TestAppendDataRow() 
- __Goal:__ To append array input into the back of an existing data array, shift to the right if the existing data array is full.
- __Testable Function:__
  - appendDataRow()
- __Parameters:__
  - int array
- __Return type:__
  - Boolean
- __Return Value:__
  - True, False  
- __Interface base:__  

|  | b1 | b2 | b3 |
|-|:-:|:-:|:-:|
| C1: Array value | Contains null value in some position | All value in the array is int | Empty array |  


- __Valid values:__  
c1b1, c1b2, c1b3  

- __Functional base: PWC__  

|  | b1 | b2 |
|-|:-:|:-:|
| T1: New data is appended correctly | True | False |
| T2: Return false if new data contains int.MIN_VALUE | True | False |
| T3: Shift if array is full | True | False |  

[T1b1, T2b1], [T1b1, T2b2], [T1b2, T2b1], [T1b2, T2b2],  
[T2b1, T3b1], [T2b1, T3b2], [T2b2, T3b1], [T2b2, T3b2]

__Eliminate redundant tests and infeasible tests:__  
[T1b1, T2b1, T3b2], [T1b1, T2b2, T3b2]  

-__Derived test values:__  

|  | Value | Expected |
|-|:-:|:-:|
| T1: Array contains null value | [1,null] | NullPointer Exception |
| T2: All array elements are int | [1,2] | true |
| T3: null array | [] | NullPointer Exception |
| T4: Array element contains int.MIN_VALUE | [int.min_value] | false |
| T5: arbitrary array input | [1,2] | true |  

-----------------------------------------------------------------------------------------------------

## Method 4:&nbsp; testResetBuffer() 
- __Goal:__ Reset the main array to its initial state.
- __Testable Function:__
  - ResetBuffer()
- __Parameters (Not directly):__
  - data [][]
- __Return type:__
  - -
- __Return Value:__
  - -  
- __Exceptional behavior__  
  - -
- __Interface base:__  

|  | b1 | b2 |
|-|:-:|:-:|
| C1: Array element value | All valid (a1) | Contain null value (a2) |
| C2: Array is empty | True | False |  

- __ACoC:__  
[a1, T], [a1, F], [a2, T], [a2, T]  

- __Valid values:__  
[a1, F], [a2, F]  

- __Functional base:__  

|  | b1 | b2 |
|-|:-:|:-:|
| C1: Array element after reset | All default value (-2147483648) | Contain Invalid value |  

- __ACoC:__  
[b1], [b2]   

- __Valid values:__  
[b1]  

-__Derived test values:__  

|  | Array | Expected |
|-|:-:|:-:|
| T1: Array is reset successfully  | [1, 5, 3, 6, 8, ...] | [-2147483648, -2147483648, -2147483648, ...] |
| T2: Array cannot reset | [] | [] |  




-----------------------------------------------------------------------------------------------------

## Method 5:&nbsp; TestsetDataRow()
- __Goal:__ To set data in column of the main array.
- __Testable Function:__
  - setDataRow()  
- __Parameters:__
  - int column, array data
- __Return type:__
  - Boolean
- __Return Value:__
  - True    
- __Interface base BCC:__  
Base = (A2,B3)  

|  | b1 | b2 | b3 | b4 |
|-|:-:|:-:|:-:|:-:|
| C1: rowvalue | Null(A1) | Positive(A2) | Zero(A3) | Negative(A4) |
| C2: data array value | Empty(B1) | Contain some null values(B2) | All values are valid (B3) |  |  

T1: (A2,B3)  
T2: (A1,B3)   
T3: (A4,B3)   
T4: (A2,B1)   
T5: (A2,B2)   
T6: (A3,B3)  

__Eliminate redundant tests and infeasible tests__  
- __Interface base:__  
(A2,B3),(A3,B3), (A1,B3)  
- __Functional base:__  
(A1), (A2)  
- __BCC Functional base:__  
Base choice = (A1)  

|  | b1 | b2 |
|-|:-:|:-:|
| C1: Data is changed completely | Yes(A1) | No(A2) |  

T1: (A1)  
T2: (A2)  
- __Derived test values__  

|  | Value | Expected |
|-|:-:|:-:|
| T1: Input row value is positive and all values are valid in data array | setDataRow(1,data) | true |
| T2:Input row value is zero and all values are valid in the data array. | setDataRow(0,data) | true |
| T3: Input row value is null and all values are valid in the data array. | setDataRow(null ,data) | NullPointer Exception |
| T4: Data is changed completely | setDataRow(0,data) | true |
| T5: Data is not changed completely | setDataRow(0,null) | NullPointer Exception |  

T1: (A1,B1)   
T2: (A1,B2)   
T3: (A2,B1)  

-----------------------------------------------------------------------------------------------------

## Method 6:&nbsp; testDataBuffer()
- __Goal:__ To assign value of column and rows in dataBuffer class
- __Testable Function:__
  - DataBuffer()
- __Parameters:__
  - int row, column
- __Return type:__
  - -
- __Return Value:__
  - -  
- __ECC Interface base:__  

|  | b1 | b2 | b3 | b4 |
|-|:-:|:-:|:-:|:-:|
| C1: Column value | Null(A1) | Positive(A2) | Zero(A3) | Negative(A4) |
| C2: Rows value | Null(B1) | Positive(B2) | Zero(B3) | Negative(B4) |  

T1: (A1,B1)  
T2: (A2,B2)  
T3: (A3,B3)  
T4: (A4,B4)  

- __ECC Functionalbase:__  

|  | b1 | b2 |
|-|:-:|:-:|
| C1: Column value is assigned correctly | True(A1) | False(A2) |
| C1: Rows value is assigned correctly | True(B1) | False(B2) |  

T1: (A1,B1)   
T2: (A2,B2)  

- __Valid values:__  

- __Interface base:__  
(A1,B1), (A2,B2), (A3,B3) ,(A4,B4)  

-__Functional base:__  
 (A1,B1)  
 
 - __Derived test values__  
 
 |  | Value | Expected |
|-|:-:|:-:|
| T1: Both column and row is null | DataBuffer(null, null) | NullPointer Exception |
| T2: Both column and row is positive | DataBuffer(5,5) | Not error |
| T3: Both column and row is zero | DataBuffer(0,0) | Not error |
| T4: Both column and row is negative | DataBuffer(-1,-1) | NegativeArraySize Exception |
| T5: Column value is assigned correctly and rows value is assigned correctly | DataBuffer(5,5) | getColumns = 5 <br>getRows = 5 |  

-----------------------------------------------------------------------------------------------------

## Method 7:&nbsp; testGetColumnClone()
- __Goal:__ To clone the value in the main array
- __Testable Function:__
  - getColumnClone()
- __Parameters:__
  - int column
- __Return type:__
  - array
- __Return Value:__
  - The value is assigned in the new array.  
  
- __Interface base ACoC:__  

|  | b1 | b2 | b3 | b4 |
|-|:-:|:-:|:-:|:-:|
| C1: column value | Null(A1) | Positive(A2) | Zero(A3) | Negative(A4) |  

T1: (A1)   
T2: (A2)   
T3: (A3)   
T4: (A4)  

- __Functional base ACoC:__  

|  | b1 | b2 |
|-|:-:|:-:|
| C1 : All new elements array are the same with the main array column. | True(A1) | False(A2) |
| C2 : Input column is in range of main array | True(B1) | False(B2) |  

T1: (A1,B1)  
T2: (A1,B2)  
T3: (A2,B1)  
T4: (A2,B2)  

__Eliminate redundant tests and infeasible tests__  
- __Interface base:__  
(A1), (A2), (A3), (A4)    
- __Functional base:__  
(A1,B1)  

- __Derived test values__  

|  | Value | Expected |
|-|:-:|:-:|
| T1: Input column value is null | getColumnClone(null) | NullPointer Exception |
| T2:Input column value is positive | getColumnClone(1)  | It will return the array element of column 1 |
| T3: Input column value is zero | getColumnClone(0) | It will return the array element of column 0 |
| T4: Input column is negative | getColumnClone(-1) | NegativeArraySize Exception |
| T5:All new elements array are the same with the main array column and input column is in range of main array | getColumnClone(1) | All returned element is identical to the original array |  

-----------------------------------------------------------------------------------------------------

## Method 8:&nbsp; testSetDataColumn()
- __Goal:__ To set data in column of the main array  
- __Testable Function:__
  - setDataColumn())
- __Parameters:__
  - int column, array data
- __Return type:__
  - Boolean
- __Return Value:__
  - True  
  
- __Interface base BCC:__  
Base = (A2, B3)  

|  | b1 | b2 | b3 | b4 |
|-|:-:|:-:|:-:|:-:|
| C1: column value | Null(A1) | Positive(A2) | Zero(A3) | Negative(A4) |
| C2: data array value | Empty(B1) | Contain some null values(B2) | All values are valid (B3) |  |  

T1: (A2,B3)   
T2: (A1,B3)   
T3: (A4,B3)   
T4: (A2,B1)   
T5: (A2,B2)   
T6: (A3,B3)  

- __Functional base BCC:__  
Base = (A1)  

|  | b1 | b2 |
|-|:-:|:-:|
| C1: Data is changed completely | Yes(A1) | No(A2) |  

T1: (A1)   
T2: (A2)  

__Eliminate redundant tests and infeasible tests__  
- __Interface base:__  
(A2,B3),(A3,B3), (A1,B3)    
- __Functional base:__  
(A1), (A2)   

- __Derived test values__  

|  | Value | Expected |
|-|:-:|:-:|
| T1: Input column value is positive and all values are valid in data array | setDataColumn(1,data) | true |
| T2:Input column value is zero and all values are valid in the data array. | setDataColumn(0,data) | true |
| T3: Input column value is null and all values are valid in the data array. | setDataColumn(null ,data) | NullPointer Exception |
| T4: Data is changed completely | setDataColumn(0,data) | true |
| T5: Data is not changed completely | setDataColumn(0,null) | NullPointer Exception |  

-----------------------------------------------------------------------------------------------------

## Method 9:&nbsp; testBarGraphPanel()  
- __Goal:__ To plot and show a bar graph model based on the input value
- __Testable Function:__
  - BarGraphPanel()
- __Parameters (Not directly):__
  - object GraphBuffer, String graphName, int yMin, int yMax, int yMinor, Color.class
- __Return type:__
  - -
- __Return Value:__
  - -  
- __Exceptional behavior__  
  - yMin/yMax can be both negative and positive  
- __Interface base:__

|  | b1 | b2 | b3 | b4 |
|-|:-:|:-:|:-:|:-:|
| C1: object graphBuffer is valid | True | False | - | - |
| C2: Graph name is valid | True | False | - | - |
| C3: yMin is int | True | False | - | - |
| C4: yMax is int | True | False | - | - |
| C5: yMinor int value | Zero (c1) | More than or equal to 1 (c2) | Negative (c3) | Null (c4) |
| C6: Color value is valid | True | False | - | - |  

- __MBCC__  
Base Choce: [T, T, T, T, c2, T], [T, T, T, T, c1, T]  
no. of tests = 2 + (2*(2-1)) + (2*(2-1)) + (2*(2-1)) + (2*(2-1)) + (2*(4-2)) + (2*(2-1)) = 16 tests  
  - [T, T, T, T, c2, T]  
    - [F, T, T, T, c2, T], [T, F, T, T, c2, T], [T, T, F, T, c2, T], [T, T, T, F, c2, T], [T, T, T, T, c2, F], [T, T, T, T, c4, T], [T, T, T, T, c3, T]  
  - [T, T, T, T, c1, T]  
    - [F, T, T, T, c1, T], [T, F, T, T, c1, T], [T, T, F, T, c1, T], [T, T, T, F, c1, T], [T, T, T, T, c1, F]  

- __Valid values:__  
[T, T, T, T, c2, T], [F, T, T, T, c2, T], [T, T, F, T, c2, T], [T, T, T, F, c2, T], [T, T, T, T, c2, F], [T, T, T, T, c4, T], [T, T, T, T, c3, T], [T, T, T, T, c1, T], [T, T, T, T, c1, T], [F, T, T, T, c1, T], [T, T, F, T, c1, T], [T, T, T, F, c1, T], [T, T, T, T, c1, F]  

- __Functional base__  

|  | b1 | b2 |
|-|:-:|:-:|
| C1: Constructor is created | True | False |
| C2: Data of constructor after created | All data is valid (b1) | Contain invalid data (b2) |  

- __MBCC__  
Base Choice = [T, b1], [T, b2]  
no. of test = 2 + (2*(2-1)) + (2*(2-2)) = 4 tests  
- [T, b1]  
  - [F, b1]  
- [T, b2]  
  - [F, b2]  
- __Valid values:__  
[T, b1], [F, b2]  

- __Derived test values__  

|  | Graph<br>Buffer | name | ymin | ymax | yminor | color | Expected result |
|-|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
| T1: Invalid input (GraphBuffer) | -5 | “First Graph” | -100 | 150 | 25 | Color.CYAN | NegativeArraySizeException |
| T2: Invalid input (ymin) | 100 | “First Graph” | null | 100 | 25 | Color.RED | NullPointerException |
| T3: Invalid input (ymax) | 100 | “First Graph” | -100 | null | 25 | Color.RED | NullPointerException |
| T4: Invalid input (yminor) | 100 | “First Graph” | -100 | 100 | null | Color.RED | NullPointerException |
| T5: Invalid input (color) | 100 | “First Graph” | -100 | 150 | 30 | 125,256,125 | Color parameter outside of expected range: Green |
| T6: Valid input (yminor = 0) | 100 | “First Graph” | -100 | 100 | 0 | Color.RED | BarGraphPanel has been created |
| T7: Valid input (yminor<0) | 100 | “First Graph” | -100 | 100 | -25 | Color.RED | BarGraphPanel has been created |
| T8: Valid input  | 100 | “First Graph” | -100 | 100 | 25 | Color.RED | BarGraphPanel has been created |  

-----------------------------------------------------------------------------------------------------

## Method 10:&nbsp; TestLineGraphPanel()  
- __Goal:__ To plot and show a sin function model based on the input value
- __Testable Function:__
  - LineGraphPanel(GraphBuffer buffer, String name, int ymin, int ymax, int yminor, int xminor, Color color)
- __Parameters (Not directly):__
  - object GraphBuffer, String name,  int ymin, int ymax, int yminor, int xminor, Color color  
- __Return type:__
  - -
- __Return Value:__
  - -  
- __Exceptional behavior__  
  - -  
- __Interface base:__


|  | b1 | b2 | b3 | b4 |
|-|:-:|:-:|:-:|:-:|
| C1: object graphBuffer value | Valid(A1) | Invalid(A2) | - | - |
| C2: name  value | Null(B1) | NotNull(B2) | - | - |
| C3: ymin value | Null(C1) | Positive(C2) | Zero(C3) | Negative(C4) |
| C4: ymax  value | Null(E1) | Positive(E2) | Zero(E3) | Negative(E4) |
| C5: yminor  value | Null(F1) | Positive(F2) | Zero(F3) | Negative(F4) |
| C6: xminor  value | Null(G1) | Positive(G2) | Zero(G3) | Negative(G4) |
| C7: Color value | valid(D1) | invalid(D2) | - | - |  

- __Functional base:__  

|  | b1 | b2 |
|-|:-:|:-:|
| C1: LineGraphPanel has been created | True | False |
| C2: correct assigned variable | every variable | some variables are incorrect |  

- __MBCC__  
  - (True, NotNull, Null,Null,Null,Null, invalid)  
    - (True, NotNull, Zero,Null,Null,Null, invalid), (True, NotNull, Null,Negative,Null,Null, invalid), (True, NotNull, Null, Zero,Null,Null, invalid), (True, NotNull, Null,Negative,Null,Null, invalid), (True, NotNull, Null,Null,Zero,Null, invalid), (True, NotNull, Null,Null,Negative,Null, invalid), (True, NotNull, Null,Null,Null, Zero, invalid), (True, NotNull, Null,Null,Null,Negative, invalid), (False, NotNull, Null,Null,Null,Null, invalid), (True, Null, Null,Null,Null,Null, invalid)  
  - (True, NotNull, Positive, Positive, Positive,Positive, Valid)  
    - (True, NotNull, Zero, Positive, Positive,Positive, Valid), (True, NotNull, Negative, Positive, Positive,Positive, Valid), (True, NotNull, Positive, Zero, Positive,Positive, Valid), (True, NotNull, Positive, Negative, Positive,Positive, Valid), (True, NotNull, Positive, Positive, Zero,Positive, Valid), (True, NotNull, Positive, Positive, Negative,Positive, Valid), (True, NotNull, Positive, Positive, Positive, Zero, Valid),
(True, NotNull, Positive, Positive, Positive, Negative, Valid), (False, NotNull, Positive, Positive, Positive,Positive, Valid), (True, Null, Positive, Positive, Positive,Positive, Valid)  

- __MBCC__  
  - (True, every variable)  
  - (False,  every variable)  
    - there is no test case that falls into this characteristic.  
  - (True, some variables are incorrect)  
    -  there is no test case that falls into this characteristic.  
  - (False, some variables are incorrect)  
  
- __Valid values:__  
  - (True, NotNull, Zero,Null,Null,Null, invalid), (True, NotNull, Null,Negative,Null,Null, invalid), (True, NotNull, Null, Zero,Null,Null, invalid), (True, NotNull, Null,Negative,Null,Null, invalid), (True, NotNull, Null,Null,Zero,Null, invalid), (True, NotNull, Null,Null,Negative,Null, invalid), (True, NotNull, Null,Null,Null, Zero, invalid), (True, NotNull, Null,Null,Null,Negative, invalid), (False, NotNull, Null,Null,Null,Null, invalid), (True, Null, Null,Null,Null,Null, invalid), (True, NotNull, Positive, Positive, Positive,Positive, Valid), (True, NotNull, Zero, Positive, Positive,Positive, Valid), (True, NotNull, Negative, Positive, Positive,Positive, Valid), (True, NotNull, Positive, Zero, Positive,Positive, Valid), (True, NotNull, Positive, Negative, Positive,Positive, Valid), (True, NotNull, Positive, Positive, Zero,Positive, Valid), (True, NotNull, Positive, Positive, Negative,Positive, Valid), (True, NotNull, Positive, Positive, Positive, Zero, Valid), (True, NotNull, Positive, Positive, Positive, Negative, Valid), (True, every variable), (False, some variables are incorrect)  
  
- __Derived test values__  

|  | Graph<br>Buffer | name | ymin | ymax | yminor | xminor | color | Expected result |
|-|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
| T1: Invalid input (GraphBuffer) | -1 | “Test” | 0 | null | null | null | 127,255,127 | NegativeArraySizeException |
| T2: Invalid input (null) | 100 | “Test” | null | null | null | null | 127,255,127 | NullPointerException |
| T3: Invalid input (color) | 100 | “Test” | 1 | 1 | 1 | 1 | 127,256,127 | Color parameter outside of expected range: Green |
| T4: Valid input  | 100 | “Test” | 1 | 1 | 1 | 1 | 127,255,127 | LineGraphPanel has been created |  

-----------------------------------------------------------------------------------------------------



  
  





