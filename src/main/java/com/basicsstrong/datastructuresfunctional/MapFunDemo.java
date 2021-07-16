package com.basicsstrong.datastructuresfunctional;

class Entry{
    Object key;
    Object value;
    Entry next;

    public Entry() {
        this.next = null;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Entry{");
        sb.append("key=").append(key);
        sb.append(", value=").append(value);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}

class MapFun<K, V>{
    private Entry[] entries;
    private int size;

    public MapFun(int size){
        this.size=size;
        this.entries = new Entry[size];

        for (int i = 0; i < size; i++) {
            this.entries[i] = new Entry();
        }
    }
    public Integer getHash(K key){
        return key.hashCode()%size;
    }
}

public class MapFunDemo {
    public static void main(String[] args) {

    }
}
