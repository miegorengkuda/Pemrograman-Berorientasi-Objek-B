public class Programmer extends Human {
    public Programmer(String name) {
        super(name);
    }

    @Override
    public void grow() {
        System.out.println(getName() + " is finishing new projects.");
    }

    @Override
    public void speak() {
        System.out.println(getName() + " is explaining coding concepts.");
    }
}