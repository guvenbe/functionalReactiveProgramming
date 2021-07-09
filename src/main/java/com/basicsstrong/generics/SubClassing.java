package com.basicsstrong.generics;

interface Iinterface<T>{}

interface Iinterface2{}


public class SubClassing implements Iinterface<Integer> {}

class SubClassing2 implements Iinterface<Iinterface2>{}

class class2{}
class Class1<T>  extends class2 implements  Iinterface{

}

///////////////////////////////////////////////////////////////////
interface Iinterface3<T>{}
class class4<T> implements Iinterface3<T>{}
//class class3<T> extends class4<T> implements Iinterface3<T>{}
class class3<T> extends class4<Integer> implements Iinterface3<Integer>{}
