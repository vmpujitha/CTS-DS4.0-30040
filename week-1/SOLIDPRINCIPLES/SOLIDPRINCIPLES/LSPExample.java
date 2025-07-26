package SOLIDPRINCIPLES;

class Bird {
    void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends Bird {
    void fly() {
        System.out.println("Sparrow flies fast");
    }
}

public class LSPExample {
    public static void main(String[] args) {
        Bird bird = new Sparrow(); // Substitution
        bird.fly();
    }
}
