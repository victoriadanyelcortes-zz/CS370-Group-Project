import java.util.Observer;

public interface MyObservable {


    void addListener(MyObserver obs);

    void removeListener(MyObserver obs);

    void notif(int seats, Class c);
    void notifyFull(Class c);
}

