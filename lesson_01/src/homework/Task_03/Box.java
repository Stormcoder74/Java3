package homework.Task_03;

import java.util.ArrayList;

class Box<T extends Fruit> {
    ArrayList<T> arr;

    public Box() {
        arr = new ArrayList<>();
    }

    void add(T obj){
        arr.add(obj);
    }

    T remove(){
        if(arr.size() > 0) return arr.remove(0);
        return null;
    }

    float getWeight(){
        if(arr.size() > 0) return arr.get(0).getWeight() * arr.size();
        return 0f;
    }

    boolean compare(Box<?> box){
        return this.getWeight() == box.getWeight();
    }

    void pourout(Box<T> box){
        while (getWeight() > 0)
            box.add(remove());
    }
}
