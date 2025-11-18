public class Main {
    public static void main(String[] args) {
        // Humans
        Human programmer = new Programmer("David");
        Human doctor = new Doctor("Diana");
        programmer.breathe();
        programmer.grow();
        programmer.speak();
        doctor.breathe();
        doctor.grow();
        doctor.speak();

        // Animals
        Animal dog = new Dog("Roscoe");
        Animal bird = new Bird("Tweety");
        dog.breathe();
        dog.grow();
        dog.move();
        bird.breathe();
        bird.grow();
        bird.move();

        // Plants
        Plant rose = new FloweringPlant("Rose");
        Plant fern = new NonFloweringPlant("Fern");
        rose.breathe();
        rose.grow();
        rose.photosynthesize();
        fern.breathe();
        fern.grow();
        fern.photosynthesize();
    }
}