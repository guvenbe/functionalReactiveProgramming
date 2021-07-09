package com.basicsstrong.Designpattern;
interface Database{
    String connect();
}
class DatabaseFactory {
    public static Database getDatabase(String dbType){
        Database dc = null;
        if ("RDBMS".equalsIgnoreCase(dbType))
            dc = new RDBMS();
        else
            dc = new DBMS();

        return dc;
    }
}

class RDBMS implements Database{

    @Override
    public String connect() {
        return "Connection successfull to RDBMS";
    }
}

class DBMS implements Database{

    @Override
    public String connect() {
        return "Connection successfull to DBMS";
    }
}

class DB{
    private String properties;
    private static final String p1 = "RDBMS properties";
    private static final String p2 = "DBMS properties";

    private DB(String type) {
        this.properties=type;
    }

    public static DB getRDBMS(){
        return new DB(p1);
    }

    public static DB getDBMS(){
        return new DB(p2);
    }
}
public class FactoryDesignPattern {
    public static void main(String[] args) {
        Database db = null;
        db = DatabaseFactory.getDatabase("RDBMS");
        System.out.println("Database : " + db.getClass().getSimpleName());
        System.out.println(db.connect());
        db = DatabaseFactory.getDatabase("DBMS");
        System.out.println("Database : " + db.getClass().getSimpleName());
        System.out.println(db.connect());
    }


}
