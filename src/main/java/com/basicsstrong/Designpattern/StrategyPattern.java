package com.basicsstrong.Designpattern;

interface Strategy {
    public void compressfile(String fileName);
}

class  CompressedToRar implements Strategy{

    @Override
    public void compressfile(String fileName) {
        System.out.println(fileName + " has been converted to .rar file");
    }
}

class  CompressedToZip implements Strategy{

    @Override
    public void compressfile(String fileName) {
        System.out.println(fileName + " has been converted to .zip file");
    }
}

class Context{
    Strategy compressionStrategy;

    public void setCompressionStrategy(Strategy compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }

    public void generateFile(String file){
        compressionStrategy.compressfile(file);
    }
}

public class StrategyPattern {

    public static void main(String[] args) {
        Context con = new Context();
        con.setCompressionStrategy(new CompressedToRar());
        con.generateFile("abc");

        con.setCompressionStrategy(new CompressedToZip());
        con.generateFile("abc");

    }
}
