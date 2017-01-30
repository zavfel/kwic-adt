# CS3219 Assignment 1 Report: Keyword in Context (KWIC) - ADT

Code Repository URL:
[ADT design](https://github.com/zavfel/kwic-adt)
[Pipe and Filter design](https://github.com/kfwong/cs3219-kwic)

Author: Chew Zhi Jiang (A0124797R)

## Introduction
KWIC (Key Word In Context) index system provides a search mechanism for
information in a long list of lines, such as movie titles. Our team explored
**Pipe & Filter** implemented by Kang Fei and 
**Abstract Data Type (ADT)** implemented by Zhi Jiang in our program.

## Requirements
### Functional
- The program should be able to display a list of KWIC to user.
- The program is able to perform circular shifting and sorting of entries.
- The program should display the average response time upon displaying result.
- The program should exclude duplicate entries in the result.

### Non-Functional
#### Interface
- The primary input and output should be done within a command-line interface.
- The interface should not display debug or exception details to the user.
(i.e. NullPointerException)
- The program allows input from keyboard or text files.

#### Performance & Reliability
- Given a list of 500 entries (maximum of 3 phrases per entries), the program
should be able to calculate result and display to user within 2 seconds on an
Intel i7 CPU.
- The program should handle data buffering internally without interrupting user
interaction (i.e. Blocking I/O).

#### Portability
- The program should be implemented in Java language (version 8 or above).
- The program should run on platform with Java JVM installed. (eg: Windows,
Linux, MacOS)

#### Usability
- The program should provide intruction guide upon startup.
- The program should notify the user with message when exiting.

#### Maintainability
- Each module should be unit-testable.

## Architectural Design

### Abstract Data Type (ADT)
In ADT the data and operations are encapsulated in an object or instance and they interact 
with each other through procedure or function calls. Each instance also ensures the integrity 
of its data and that its hidden from other instances.

*(Figure 4 - Module Diagram)*

![Module-diagram](https://github.com/zavfel/kwic-adt/png/Module_diagram.png)

This Architecture consists of 5 main modules: 
**Input**, **Characters**, **CircularShift**, **AlphabeticShift** and **Output**. 
Each module interact with each other through function calls without knowing how its stored or represented inside. 
The algorithm and data structure can be changed inside each module without it affecting other modules.

*(Figure 5 - ADT Class Diagram)*
![class-diagram](https://github.com/zavfel/kwic-adt/png/adt_class_diagram.png)

**ADTMaster** acts as a main control that control the sequencing of other modules.

**Input** reads data lines from the input source and stores them in **Characters**.

**Characters** acts as a container to store relavant data for use in other modules.

**CircularShift** generates a list of indexes, which indicates the position of the first character of each circular shift.

**AlphabeticShift** makes use of the data generated from **CircularShift** and **Characters** and outputs a KWIC index.

**Output** uses the list generated from **AlphabeticShift** and write into the output source

## Limitation & Benefits of Selected Designs
### Flexibility
The ADT design hides the data and only other modules to access data through function calls. 
This design allows developers to specify their own algorithm and data representation 
in the individual modules. Similar to the above design, it allows improved flexibility 
in designing the algorithm or data representation.

However, for ADT one must know the identity of the module to interact with them, 
Pipe & Filter can still interact without knowing the identity.

### Extensibility
The modules in this architecture is implemented as an Interface, which allows 
developers to create new classes and implement those interface to extend its functionality.

### Modularity
ADT is more integrated such that if you need to add new functions, one must modify 
exisiting modules. If a method changes, other modules that uses that particular 
method have to change as well.

### Testing
The modules are designed to be unit-testable due to the encapsulation.
