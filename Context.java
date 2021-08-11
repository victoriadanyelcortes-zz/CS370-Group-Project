

// Context class that will ask from Startegy interface to execute the type of strategy.

public class Context {

    private MyStrategy strategy;

    public Context(MyStrategy strategy) {
        this.strategy = strategy;
    }

    public String executeNameStrategy(String name) {
        return strategy.getStudentInfo(name);
    }
}
