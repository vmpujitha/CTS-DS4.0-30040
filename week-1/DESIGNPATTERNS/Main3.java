package DESIGNPATTERNS;

interface Subscriber {
    void notify(String msg);
}

class User implements Subscriber {
    public void notify(String msg) {
        System.out.println("Notification: " + msg);
    }
}

class Channel {
    Subscriber s;

    public void subscribe(Subscriber s) {
        this.s = s;
    }

    public void newVideo() {
        s.notify("New video uploaded!");
    }
}

public class Main3 {
    public static void main(String[] args) {
        Channel c = new Channel();
        c.subscribe(new User());
        c.newVideo();
    }
}
