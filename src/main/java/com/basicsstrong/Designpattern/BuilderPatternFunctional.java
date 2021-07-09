package com.basicsstrong.Designpattern;

import java.util.function.Consumer;

class MobileF{
    private final int ram, storage;
    private final int battery;
    private final int camera;
    private final String processor;
    private final double screenSize;

    public MobileF(MobileBuilderF builder) {
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.battery = builder.battery;
        this.camera = builder.camera;
        this.processor = builder.processor;
        this.screenSize = builder.screenSize;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public int getBattery() {
        return battery;
    }

    public int getCamera() {
        return camera;
    }

    public String getProcessor() {
        return processor;
    }

    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MobileF{");
        sb.append("ram=").append(ram);
        sb.append(", storage=").append(storage);
        sb.append(", battery=").append(battery);
        sb.append(", camera=").append(camera);
        sb.append(", processor='").append(processor).append('\'');
        sb.append(", screenSize=").append(screenSize);
        sb.append('}');
        return sb.toString();
    }
}

class MobileBuilderF {
    public int ram, storage;
    public int battery;
    public int camera;
    public String processor;
    public double screenSize;

    public MobileBuilderF with(Consumer<MobileBuilderF> buildfields){
        buildfields.accept(this);
        return this;
    }

    public MobileF createMobile(){
        return new MobileF(this);
    }
}

public class BuilderPatternFunctional {
    public static void main(String[] args) {

        MobileBuilderF builderF = new MobileBuilderF();
        MobileF myMobile = builderF.with(myBuilder -> {
            myBuilder.ram = 4;
            myBuilder.battery = 4000;
            myBuilder.processor = "A12 Bionic";

        }).createMobile();
        System.out.println(myMobile);
    }
}
