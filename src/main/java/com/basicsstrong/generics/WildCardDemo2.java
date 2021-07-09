package com.basicsstrong.generics;

//Upper bound wild card: ? extends A <-- Extends it's objetc type There is another object involvved here
//Lower bound wild card: ? super B

class DataNode<E>{
    private E data;
    private DataNode<? extends Number> next;

    public DataNode(E data, DataNode<? extends Number> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public DataNode<? extends Number> getNext() {
        return next;
    }

    public void setNext(DataNode<? extends Number> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DataNode{");
        sb.append("data=").append(data);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}

