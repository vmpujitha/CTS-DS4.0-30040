package DESIGNPATTERNS;

interface TravelMode {
    void go();
}

class Bike implements TravelMode {
    public void go() {
        System.out.println("Going by Bike");
    }
}

class Train implements TravelMode {
    public void go() {
        System.out.println("Going by Train");
    }
}

class Navigator {
    TravelMode mode;

    void setMode(TravelMode m) {
        mode = m;
    }

    void start() {
        mode.go();
    }
}

public class Main4 {
    public static void main(String[] args) {
        Navigator n = new Navigator();
        n.setMode(new Train());
        n.start();
    }
}
