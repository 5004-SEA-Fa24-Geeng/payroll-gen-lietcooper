# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for? 
   
- Comma Separated Value

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?

- To specify the relations between superclass and subclass and force the subclass to follow the contract of superclass,
3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?

- has-a

4. Can you provide an example of a has-a relationship in your code (if one exists)?

- Not in my code this time.

5. Can you provide an example of an is-a relationship in your code (if one exists)?

- Both `HourlyEmployee` and `SalaryEmployee` are `Employee`.

6. What is the difference between an interface and an abstract class?

- Interface provides a contract to obey while abstract has fields and can implements methods.

7. What is the advantage of using an interface over an abstract class?

- A class can implements many interfaces but can only extend one abstract class.

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 

- It's not valid because generics need a Object but int is not; instead, Integer should be used,

9. Which class/method is described as the "driver" for your application? 

- The class containing `main()` method is the driver and initiates the entire program.

10. How do you create a temporary folder for JUnit Testing? 

- Use @TempDir



## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 

>To ensure fair pay through the payroll system, several changes would be necessary. First, additional data points such as gender, race, years of experience, education level, and job role should be stored in employee records to facilitate salary comparisons. This data would allow for an analysis of pay disparities across different demographics while maintaining compliance with privacy regulations. Additionally, the payroll system should integrate an automated fairness audit at key stages—such as salary determination during hiring, annual raises, and promotions—to flag discrepancies before they are finalized. Since pre-tax benefits can affect take-home pay, the analysis should focus on base salary and total compensation rather than net pay. Regular reports should be generated to help HR and leadership address any disparities proactively. These changes would enable the company to maintain equitable pay practices while leveraging payroll data as a tool for fairness and compliance.