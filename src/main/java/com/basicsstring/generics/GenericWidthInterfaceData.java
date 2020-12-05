package com.basicsstring.generics;

interface IBase<T>{}

interface IData<T> extends IBase<T>{
    public T getData();
    public void setData(T data);
}

class GenericWidthInterfaceData<T> implements IData<T>{

    //object not a good solution
    private T data;

    public GenericWidthInterfaceData(T data) {
        this.data = data;
    }
    @Override
    public T getData() {
        return data;
    }
    @Override
    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {

        return "data is :" + data;
    }
}


class Data {
    private String data;

    public Data(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Data{");
        sb.append("data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

class ObjectData {

    //object not a good solution
    private Object data;

    public ObjectData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public String toString() {

        return "data is :" + data;
    }
}
class BaseData<T>{}
class GenericData<T> extends BaseData<T> {

    //object not a good solution
    private T data;

    public GenericData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {

        return "data is :" + data;
    }
}

class Demo{
    public static void main(String[] args) {
        Data d = new Data("Hello World");
        System.out.println(d);

        ObjectData od = new ObjectData(10);
        int result = (int)(od.getData());
        System.out.println(result);

        //this one is bad
        //int resultbad = (int)(d.getData());

        GenericWidthInterfaceData<String> gwid1 = new GenericWidthInterfaceData<>("Hello Generic");
        System.out.println(gwid1.getData());

        GenericWidthInterfaceData<Integer> gwid2 = new GenericWidthInterfaceData<>(1);
        System.out.println(gwid2.getData());

        GenericData<Integer> gd1 = new GenericData<>(50);
        System.out.println(gd1.getData());
        GenericData<String> gd2 = new GenericData<>("Hello again");
        System.out.println(gd2.getData());

        GenericData<String> gd3 = new GenericData<>("Hello generic d4");
        BaseData<String> b1 =gd3;
    }


}
