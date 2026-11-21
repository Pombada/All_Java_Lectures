package Week7.JavaCollectionsAndGenerics;

public class GenericTypeExample<T> {
    private T element;
    private GenericTypeExample<T> next = null;
    public GenericTypeExample(T element) {
        this.element = element;
    }
    public T data() {
        return element;
    }
    static void main(String[] args) {
        GenericTypeExample<GenericTypeExample<String>> linkedList =
                new GenericTypeExample<>(new GenericTypeExample<>("shit"));
        linkedList.next = new GenericTypeExample<>(new GenericTypeExample<>("Bomba"));
    }
}
