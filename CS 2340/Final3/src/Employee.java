import java.util.ArrayList;
import java.util.Iterator;

public class Employee {
    private String name;
    private String position;
    private String department;
    private int salary;
    private String gender;
    private boolean hasDependents;

    private ArrayList<Employee> oversees = new ArrayList<Employee>();

    public Employee(String name, String position, String department, int salary, String gender,
                    boolean hasDependents) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.salary = salary;
        this.gender = gender;
        this.hasDependents = hasDependents;
    }

    public void print1() {
        System.out.print(name + ", ");
        System.out.print(position + ", ");
        System.out.print(department + ", ");
        System.out.print("$" + salary + ", ");
        System.out.print(gender + ", ");
        System.out.println(hasDependents);

        Iterator<Employee> iterator = oversees.iterator();
        while (iterator.hasNext()) {
            ((Employee) iterator.next()).print1();
        }
    }

    public void print2() {
        if (gender.equals("male") && hasDependents) {
            System.out.print(name + ", ");
            System.out.print(position + ", ");
            System.out.print(department + ", ");
            System.out.print("$" + salary + ", ");
            System.out.print(gender + ", ");
            System.out.println(hasDependents);
        }

        Iterator<Employee> iterator = oversees.iterator();
        while (iterator.hasNext()) {
            ((Employee) iterator.next()).print2();
        }
    }

    public void print3() {
        if (gender.equals("female")) {
            System.out.print(name + ", ");
            System.out.print(position + ", ");
            System.out.print(department + ", ");
            System.out.print("$" + salary + ", ");
            System.out.print(gender + ", ");
            System.out.println(hasDependents);
        }

        Iterator<Employee> iterator = oversees.iterator();
        while (iterator.hasNext()) {
            ((Employee) iterator.next()).print3();
        }
    }

    private int[] averageIncome() {
        int[] vals = new int[2];  //total, count
        for (Employee e : oversees) {
            if (e.getDepartment().equals(department)) {
                int[] rVal = e.averageIncome();
                vals[0] += rVal[0];
                vals[1] += rVal[1];
            }
        }
        vals[0] += salary;
        vals[1]++;
        return vals;
    }

    public void print4() {
        int[] result = averageIncome();
        double avg = (double) result[0] / result[1];
        System.out.println(department + ": $" + avg);

        Iterator<Employee> iterator = oversees.iterator();
        while (iterator.hasNext()) {
            Employee e = (Employee) iterator.next();
            if (e.getDepartment().equals(department)) {
                continue;
            } else {
                e.print4();
            }
        }
    }

    public void addOverseen(Employee employee) {
        oversees.add(employee);
    }

    public void removeOverseen(Employee employee) {
        oversees.remove(employee);
    }

    public Employee getOverseen(int index) {
        return oversees.get(index);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isHasDependents() {
        return this.hasDependents;
    }

    public void setHasDependents(boolean hasDependents) {
        this.hasDependents = hasDependents;
    }
}