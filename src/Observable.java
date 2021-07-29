public interface Observable {
    void addListener(Observer obs);
    void removeListener(Observer obs);
    void notif(int seats, Class c);
}

