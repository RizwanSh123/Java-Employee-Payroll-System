
import java.util.ArrayList;


abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
     this.name = name;
     this.id = id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculatesalary();

    @Override

    public String toString(){
        return "Employee[name="+name+", id="+id+", salary="+calculatesalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private  double monthlysalary;

    public FullTimeEmployee(String name, int id, double monthlysalary){
        super(name, id);
        this.monthlysalary = monthlysalary;
    }

    @Override
     public double calculatesalary(){
        return monthlysalary;
     }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyrate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyrate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyrate = hourlyrate;
    }

    @Override
    public double calculatesalary(){
        return hoursWorked * hourlyrate;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
      employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
           if(employee.getId()==id){
            employeeToRemove = employee;
            break;
           }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}

public class Main{
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Rizwan", 1, 70000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Mahesh", 2, 40, 100);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.err.println("Intial Employee Details ");
        payrollSystem.displayEmployee();
        System.err.println("Remove Employee ");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployee();
    }
}