package inheritance;

public class Lion extends Animal implements WildAnimal {
    Lion(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Lion " + getName() + " says: 'Roar'.");
    }

    @Override
    public void hunting() {
        System.out.println("Lion " + getName() + " goes hunting.");
    }
}
