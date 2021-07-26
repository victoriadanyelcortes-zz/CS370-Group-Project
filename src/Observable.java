public interface Observable {
    void addListener(Observer obs);
    void removeListener(Observer obs);
    void notif(boolean available);
}

