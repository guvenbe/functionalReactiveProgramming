package com.basicsstrong.Designpattern;

@FunctionalInterface
interface ICommandACFunctional{
    public void execute();
}
//Receiver
class ACFunctional {
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

class ACAutomationRemoteFunctional{
    ICommandACFunctional command;

    public void setCommand(ICommandACFunctional command) {
        this.command = command;
    }

    public void buttonPressed(){
        command.execute();
    }
}

public class CommandPatternFunctional {
    public static void main(String[] args) {
        ACFunctional ac1 = new ACFunctional();
        ACFunctional ac2 = new ACFunctional();

        ACAutomationRemoteFunctional remote = new ACAutomationRemoteFunctional();
        remote.setCommand(()-> ac2.turnOn());
        remote.buttonPressed();

    }
}
