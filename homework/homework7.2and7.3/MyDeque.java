public class MyDeque<O> extends MyLinkedList implements Deque
{
    MyLinkedList<Object> list = new MyLinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        if (list.getFirst() == null)
            return true;
        else
            return false;
    }

    @Override
    public Object getFirst() {
        return list.getFirst();
    }

    @Override
    public Object getLast() {
        return list.getLast();
    }

    @Override
    public void addFirst(Object o) {
        list.addFirst(o);
    }

    @Override
    public void addLast(Object o) {
        list.addLast(o);
    }

    @Override
    public Object removeFirst() {
        list.removeFirst();
        return null;
    }

    @Override
    public Object removeLast() {
        list.removeLast();
        return null;
    }

    @Override
    public void clear(){
        list.clear();
    }

    @Override
    public String toString(){
        return list.toString();
    }
}
