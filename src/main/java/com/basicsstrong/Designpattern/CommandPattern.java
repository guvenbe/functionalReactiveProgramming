package com.basicsstrong.Designpattern;

interface ICommandAC {
    public void execute();
}

class AC {
    public void turnOn() {
        System.out.println("AC is on");
    }

    public void turnOff() {
        System.out.println("AC is off");
    }

    public void decTemp() {
        System.out.println("Decreasing Temperature by 1");
    }

    public void incTemp() {
        System.out.println("Increasing Temperature by 1");
    }
}

class StartACCommand implements ICommandAC{
    AC ac;

    public StartACCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        System.out.println("Turning on the AC");
        ac.turnOn();
    }
}

class StopACCommand implements ICommandAC{
    AC ac;

    public StopACCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        System.out.println("Turning off the AC");
        ac.turnOff();
    }
}

class IncTempCommand implements ICommandAC{
    AC ac;

    public IncTempCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        System.out.println("Increase Temperature by one");
        ac.incTemp();
    }
}

class DecTempCommand implements ICommandAC{
    AC ac;

    public DecTempCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        System.out.println("Decrease Temperature by one");
        ac.decTemp();
    }
}
//Invoker
class ACAutomationRemote{
    ICommandAC command;

    public void setCommand(ICommandAC command) {
        this.command = command;
    }

    public void buttonPressed(){
        command.execute();
    }
}
public class CommandPattern {
    public static void main(String[] args) {
        AC acRoomOne = new AC();
        AC acRoomTwo = new AC();

        ACAutomationRemote remote = new ACAutomationRemote();
        remote.setCommand(new StartACCommand(acRoomOne));
        remote.buttonPressed();
        remote.setCommand(new StartACCommand(acRoomTwo));
        remote.buttonPressed();
        remote.setCommand(new IncTempCommand(acRoomTwo));
        remote.buttonPressed();
    }
}