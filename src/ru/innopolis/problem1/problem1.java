package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();


        if (next.toUpperCase().equals("A")) {
            Assembly assembly = new Assembly();
            CarWorkshop carWorkshop = new CarWorkshop(assembly);

            carWorkshop.setWorkshop("we Should assemble it");
        } else if (next.toUpperCase().equals("D")) {
            Disassembly disassembly = new Disassembly();
            CarWorkshop carWorkshop = new CarWorkshop(disassembly);

            carWorkshop.setWorkshop("we Should disassemble it");
        }

    }

    public interface Operation {
        String operate();
    }

    public static class Assembly implements Operation {
        @Override
        public String operate() {
            return "Assembly";
        }
    }

    public static class Disassembly implements Operation{
        @Override
        public String operate() {
            return "Disassembly";
        }
    }

    public abstract static class Workshop {
        protected Operation operation;

        abstract public void setWorkshop(String msg);
    }

    public static class CarWorkshop extends Workshop {

        public CarWorkshop(Operation operation) {
            this.operation = operation;
        }

        @Override
        public void setWorkshop(String msg) {
            System.out.println(operation.operate() + " " + msg);
        }
    }
}
