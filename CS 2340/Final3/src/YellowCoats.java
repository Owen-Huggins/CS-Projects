public class YellowCoats {
    private Employee employees;

    public YellowCoats(Employee employees) {
        this.employees = employees;
    }

    public void generateReport1() {
        employees.print1();
    }

    public void generateReport2() {
        employees.print2();
    }

    public void generateReport3() {
        employees.print3();
    }

    public void generateReport4() {
        employees.print4();
    }

    public void addEmployee(Employee hired, Employee overseer) {
        overseer.addOverseen(hired);
    }

    public static void main(String args[]) {
        Employee james = new Employee("James Borg", "CEO", "Headquarters", 220000, "male", false);
        Employee jennifer = new Employee("Jennifer Wallace", "CFO", "Administration", 172000, "female", true);
        Employee franklin = new Employee("Franklin Wong", "CRADO", "R&D", 160000, "male", true);
        Employee alicia = new Employee("Alicia Zelaya", "Office Manager", "Administration", 75000, "female", false);
        Employee ahmad = new Employee("Ahmad Jabar", "Admin", "Administration", 100000, "male", false);
        Employee john = new Employee("John Smith", "Research Assistant", "R&D", 120000, "male", true);
        Employee ramesh = new Employee("Ramesh Narayan", "Data Scientist", "R&D", 120000, "male", false);
        Employee joyce = new Employee("Joyce English", "ML English", "R&D", 140000, "female", false);

        james.addOverseen(jennifer);
        james.addOverseen(franklin);
        jennifer.addOverseen(alicia);
        jennifer.addOverseen(ahmad);
        franklin.addOverseen(john);
        franklin.addOverseen(ramesh);

        YellowCoats company = new YellowCoats(james);

        //Generate 4 reports
        company.generateReport1();
        System.out.println();

        company.generateReport2();
        System.out.println();

        company.generateReport3();
        System.out.println();

        company.generateReport4();
        System.out.println();

        //Add Joyce
        company.addEmployee(joyce, ramesh);

        //Regenerate Reports
        company.generateReport1();
        System.out.println();

        company.generateReport2();
        System.out.println();

        company.generateReport3();
        System.out.println();

        company.generateReport4();
        System.out.println();
    }
}
