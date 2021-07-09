package com.basicsstrong.Designpattern;

class Mobile{
    private String memory;
    private String battery;
    private String wireless;
    private String screen;
    private String metalCase;

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getWireless() {
        return wireless;
    }

    public void setWireless(String wireless) {
        this.wireless = wireless;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getMetalCase() {
        return metalCase;
    }

    public void setMetalCase(String metalCase) {
        this.metalCase = metalCase;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Mobile{");
        sb.append("memory='").append(memory).append('\'');
        sb.append(", batery='").append(battery).append('\'');
        sb.append(", wireless='").append(wireless).append('\'');
        sb.append(", screen='").append(screen).append('\'');
        sb.append(", metalCase='").append(metalCase).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

abstract class MobileBuilder{
    private Mobile mobile;

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public abstract void createMemory();
    public abstract void createBattery();
    public abstract void createWireLess();
    public abstract void createScreen();
    public abstract void createMetalCase();

    public final Mobile buildMobile(){
        Mobile mobile = new Mobile();
        setMobile(mobile);

        createMemory();
        createBattery();
        createWireLess();
        createScreen();
        createMetalCase();
        return mobile;
    }
}

class MobileConcreteBuilder extends MobileBuilder {

    @Override
    public void createMemory() {
        getMobile().setMemory("32 Gb");
        System.out.println("Memory created and installed");
    }

    @Override
    public void createBattery() {
        getMobile().setBattery("4500 mAh");
        System.out.println("Battery created and installed");

    }

    @Override
    public void createWireLess() {
        getMobile().setWireless("Bluetooth and Wifi");
        System.out.println("Created wireless and features installed");
    }

    @Override
    public void createScreen() {
        getMobile().setScreen("Amolded");
        System.out.println("Screen created and installed");
    }

    @Override
    public void createMetalCase() {
        getMobile().setMetalCase("Aluminum");
        System.out.println("Metal case created and pluged everything in it");

    }
}

 //Director
class Manufacturer{
    public static Mobile createCompleteObject(){
        MobileBuilder mobileBuilder = new MobileConcreteBuilder();
        return mobileBuilder.buildMobile();

    }
}
public class BuilderDesignPattern {
    public static void main(String[] args) {
        Mobile mobile =Manufacturer.createCompleteObject();
        System.out.println(mobile);
    }
}
