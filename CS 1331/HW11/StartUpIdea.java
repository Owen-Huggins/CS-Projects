/**
 * @author CS1331 Fall 2020 TAs
 * @version 1.0
 * This class is a wrapper over different traits of a Start-up Idea
 */
public class StartUpIdea implements Comparable<StartUpIdea> {
    private String problem;
    private String targetCustomer;
    private int customerNeed;
    private int knownPeopleWithProblem;
    private int targetMarketSize;
    private String competitors;
    private String name;
    private int time;
    private int price;
    private String help;
    private String money;
    private String helpWithProject;

    /**
     * 0-arg constructor implicitly setting all instance variables to default
     * values
     */
    public StartUpIdea() {
    }

    /**
     * 6-arg constructor
     * @param problem description
     * @param targetCustomer target customer
     * @param customerNeed 1-10 rating of need
     * @param knownPeopleWithProblem people you know with the problem
     * @param targetMarketSize number of potential customer
     * @param competitors current competitors/solutions
     * @param name the name of the project
     * @param time how long it will take to finish the project
     * @param price how much the project will cost
     * @param help how will this help others
     * @param money how will you make money from the project
     * @param helpWithProject much help it will take to finish the project
     */
    public StartUpIdea(String problem, String targetCustomer
                       , int customerNeed, int knownPeopleWithProblem
                       , int targetMarketSize, String competitors, String name
                       , int time, int price, String help, String money, String helpWithProject) {
        this.problem = problem;
        this.targetCustomer = targetCustomer;
        this.customerNeed = customerNeed;
        this.knownPeopleWithProblem = knownPeopleWithProblem;
        this.targetMarketSize = targetMarketSize;
        this.competitors = competitors;
        this.name = name;
        this.time = time;
        this.price = price;
        this.help = help;
        this.money = money;
        this.helpWithProject = helpWithProject;
    }

    /**
     * Optional for student to change
     * @return String representation of StartUpIdea
     */
    public String toString() {
        String str = "";
        str += "Name of Project: " + name + "\n";
        str += "Problem: " + problem + "\n";
        str += "Target Customer: " + targetCustomer + "\n";
        str += "Customer Need: " + customerNeed + "\n";
        str += "Known People With Problem: " + knownPeopleWithProblem + "\n";
        str += "Target Market Size: " + targetMarketSize + "\n";
        str += "Competitors: " + competitors + "\n";
        str += "How long this will take: " + time + "\n";
        str += "How much this will cost to make: " + price + "\n";
        str += "How this will help people: " + help + "\n";
        str += "How you will make money from this: " + money + "\n";
        str += "How much help you will need to complete this:" + helpWithProject + "\n";
        return str;
    }

    /**
     * This StartUpIdea is less than other StartUpIdea if it is valued higher
     * Optional for student to change
     * @param other StartUpIdea to be compared
     * @return a negative integer, zero, or a positive integer as this
     * object is less than, equal to, or greater than the specified object.
     */
    public int compareTo(StartUpIdea other) {
        int totalCustomerDesireDiff =
            (this.customerNeed * (this.targetMarketSize + this.knownPeopleWithProblem * 10000)
            - (this.price + this.time))
            - (other.customerNeed * (other.targetMarketSize + other.knownPeopleWithProblem * 10000)
            - (other.price + other.time));
        return 0 - totalCustomerDesireDiff;
    }

    /**
     * Getter for problem
     * @return problem
     */
    public String getProblem() {
        return problem;
    }

    /**
     * Setter for problem
     * @param problem to set
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * Getter for targetCustomer
     * @return targetCustomer
     */
    public String getTargetCustomer() {
        return targetCustomer;
    }

    /**
     * Setter for targetCustomer
     * @param targetCustomer to set
     */
    public void setTargetCustomer(String targetCustomer) {
        this.targetCustomer = targetCustomer;
    }

    /**
     * Getter for customerNeed
     * @return customerNeed
     */
    public int getCustomerNeed() {
        return customerNeed;
    }

    /**
     * Setter for customerNeed
     * @param customerNeed to set
     */
    public void setCustomerNeed(int customerNeed) {
        this.customerNeed = customerNeed;
    }

    /**
     * Getter for knownPeopleWithProblem
     * @return knownPeopleWithProblem
     */
    public int getKnownPeopleWithProblem() {
        return knownPeopleWithProblem;
    }

    /**
     * Setter for knownPeopleWithProblem
     * @param knownPeopleWithProblem to set
     */
    public void setKnownPeopleWithProblem(int knownPeopleWithProblem) {
        this.knownPeopleWithProblem = knownPeopleWithProblem;
    }

    /**
     * Getter for targetMarketSize
     * @return targetMarketSize
     */
    public int getTargetMarketSize() {
        return targetMarketSize;
    }

    /**
     * Setter for targetMarketSize
     * @param targetMarketSize to set
     */
    public void setTargetMarketSize(int targetMarketSize) {
        this.targetMarketSize = targetMarketSize;
    }

    /**
     * Getter for competitors
     * @return competitors
     */
    public String getCompetitors() {
        return competitors;
    }

    /**
     * Setter for competitors
     * @param competitors to set
     */
    public void setCompetitors(String competitors) {
        this.competitors = competitors;
    }
    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Setter for name
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Setter for time
     * @param time to set
     */
    public void setTime(int time) {
        this.time = time;
    }
    /**
     * Getter for time
     * @return time
     */
    public int getTime() {
        return this.time;
    }
    /**
     * Setter for price
     * @param price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * Getter for price
     * @return price
     */
    public int getPrice() {
        return this.price;
    }
    /**
     * Setter for help
     * @param help to set
     */
    public void setHelp(String help) {
        this.help = help;
    }
    /**
     * Getter for help
     * @return help
     */
    public String getHelp() {
        return this.help;
    }
    /**
     * Setter for money
     * @param money to set
     */
    public void setMoney(String money) {
        this.money = money;
    }
    /**
     * Getter for money
     * @return money
     */
    public String getMoney() {
        return this.money;
    }
    /**
     * Setter for helpWithProject
     * @param helpWithProject to money
     */
    public void setHelpWithProject(String helpWithProject) {
        this.helpWithProject = helpWithProject;
    }
    /**
     * Getter for helpWithProject
     * @return helpWithProject
     */
    public String getHelpWithProject() {
        return this.helpWithProject;
    }

}
