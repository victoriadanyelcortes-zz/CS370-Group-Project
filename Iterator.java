public interface Iterator {
    // indicates if there are any more items to iterate over
    boolean hasNext();
    // returns the next element in the collection 
    Object next();
}
