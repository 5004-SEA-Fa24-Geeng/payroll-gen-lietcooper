# Payroll Generator Design Document


This document is meant to provide a tool for you to demonstrate the design process. You need to work on this before you code, and after have a finished product. That way you can compare the changes, and changes in design are normal as you work through a project. It is contrary to popular belief, but we are not perfect our first attempt. We need to iterate on our designs to make them better. This document is a tool to help you do that.


## (INITIAL DESIGN): Class Diagram

Place your class diagram below. Make sure you check the fil in the browser on github.com to make sure it is rendering correctly. If it is not, you will need to fix it. As a reminder, here is a link to tools that can help you create a class diagram: [Class Resources: Class Design Tools](https://github.com/CS5004-khoury-lionelle/Resources?tab=readme-ov-file#uml-design-tools)

```mermaid
---
title:
---
classDiagram
    direction LR
    PayrollGenerator --> Builder: use
    PayrollGenerator --> FileUtil: use
    PayrollGenerator --> IEmployee: use
    PayrollGenerator --> ITimeCard: use
    PayrollGenerator --> IPayStub: use
    IEmployee <|-- Employee: implements
    <<abstract>> Employee
    Employee <|-- SalaryEmployee: extends
    Employee <|-- HourlyEmployee: extends
    <<interface>> IEmployee
    ITimeCard <|-- TimeCard: implements
    <<interface>> ITimeCard
    IPayStub <|-- PayStub: implements
    <<interface>> IPayStub
    
    class Builder {
        -Builder()
        +buildEmployeeFromCSV(String csv)$: IEmployee
        +buildTimeCardFromCSV(String csv)$: ITimeCard
        +strToDouble(String str)$: double
    }
    class FileUtil {
        +String EMPLOYEE_HEADER$
        +String PAY_STUB_HEADER$
        -FIleUtil()
        +readFileToList(String file)$: List~String~
        +writeFile(String outFile, List~String~ lines)$: void
        +writeFile(String outFIle, List~String~ lines, boolean backup)$: void
    }
    class PayrollGenerator {
        +main(String[] args)$: void
    }
    class IEmployee{
        getName(): String
        getID(): String
        getPayRate(): double
        getEmployeeType(): String
        getYTDEarnings(): double
        getYTDTaxPaid(): double
        getPretaxDeduction(): double
        runPayroll(double hoursWorked): IPayStub
        toCSV(): String
    }
    class Employee {
        #String name
        #String ID
        #double payRate
        #String employeeType
        #double YTDEarnings
        #double YTDTaxPaid
        #double PretaxDeductions
        #calculateGrossPay(double hoursWorked): double
 }
    class HourlyEmployee {
        -double OVERTIME$
    }
    class SalaryEmployee {
        -double PAYDIVIDE$
        -double PAYCOEFFICIENT$
        
    }
    class ITimeCard {
        getEmployeeID(): String
        getHoursWorked(): double
    }
    class TimeCard {
        -String EmployeeID
        -double hoursWorked
    }
    class IPayStub {
        getPay(): double
        getTaxesPaid(): double
        toCSV(): String
    }
    class PayStub {
        -String name
        -double pay
        -double taxesPaid
        -double YTDEarnings
        -double YTDTaxesPaid
    }
```




## (INITIAL DESIGN): Tests to Write - Brainstorm

Write a test (in english) that you can picture for the class diagram you have created. This is the brainstorming stage in the TDD process. 

> [!TIP]
> As a reminder, this is the TDD process we are following:
> 1. Figure out a number of tests by brainstorming (this step)
> 2. Write **one** test
> 3. Write **just enough** code to make that test pass
> 4. Refactor/update  as you go along
> 5. Repeat steps 2-4 until you have all the tests passing/fully built program

You should feel free to number your brainstorm. 

1. Test that the `Employee` class properly returns `name` from `getName()`
2. Test that the `Employee` class properly returns `id` from `getId()`
3. Test that the `Employee` class properly returns `payRate` from `getPayRate()`
4. Test that the `Employee` class properly returns `employeeType` from `getEmployeeType()`
5. Test that the `Employee` class properly returns `YTDEarnings` from `getYTDEarnings()`
6. Test that the `Employee` class properly returns `pretaxDeductions` from `getPretacDeductions()`
7. Test that the `Employee` class properly returns CSV String from `toCSV()`
8. Test that the `TimeCard` class properly returns `employeeID` from `getEmPloyeeID()`
9. Test that the `TimeCard` class properly returns `hoursWorked` from `getHoursWorked()`
10. Test that the `Employee` class properly generates `PayStub` with correct items.
11. Test that the `PayStub` class properly construct.
12. Test that the `PayStub` class properly return a csv string from `toCSV()`
13. Test that the `Builder` class properly creates a `Employee` from `buildEmployeeFromCSV()`
14. Test that the `Builder` class properly creates a `TimeCard` from `buildTimeCardFromCSV()`
15. Test that the `Builder` class properly return `double` from a `String` from `strToDouble()`
    


## (FINAL DESIGN): Class Diagram

Go through your completed code, and update your class diagram to reflect the final design. Make sure you check the file in the browser on github.com to make sure it is rendering correctly. It is normal that the two diagrams don't match! Rarely (though possible) is your initial design perfect. 

> [!WARNING]
> If you resubmit your assignment for manual grading, this is a section that often needs updating. You should double check with every resubmit to make sure it is up to date.





## (FINAL DESIGN): Reflection/Retrospective

> [!IMPORTANT]
> The value of reflective writing has been highly researched and documented within computer science, from learning new information to showing higher salaries in the workplace. For this next part, we encourage you to take time, and truly focus on your retrospective.

Take time to reflect on how your design has changed. Write in *prose* (i.e. do not bullet point your answers - it matters in how our brain processes the information). Make sure to include what were some major changes, and why you made them. What did you learn from this process? What would you do differently next time? What was the most challenging part of this process? For most students, it will be a paragraph or two. 

One of my major changes is to create an abstract class `EMpoyee` for `HourlyEmployee` and `SalaryEmployee` and implemented a helper method as suggested. Through it, I realized the felxibility and convenience
of polymorphism to maintain and modify the functionality of classes. When we want to have several similar classes that shares some
attributes and methods, we only need to implement differently some of them in the certain classes if we use an abstract class fot them to inherit.
This is a good practice in OOP and I should keep using it. Then, instead of using BigDecimal to every double seperately, I wrote a static method `strToDouble(String str)` in `Builder`. It allows me to easily check the string before turning it to a double value without
write complicated Double and BigDecimal syntax every time. By doing so I practiced to create tools for a certain purposes.