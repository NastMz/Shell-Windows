package com.osproject.shell.client.core;

import com.osproject.shell.client.components.LoginFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Performance {

    private final LoginFrame loginFrame;

    public Performance(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    public Double getConsume(String item) {

        String consume = "";
        String[] response = null;

        String consumeCode = "";

        switch (item) {
            case "memory" ->
                consumeCode = "3";
            case "drive" ->
                consumeCode = "4";
            case "processor" ->
                consumeCode = "5";
            default ->
                throw new AssertionError();
        }

        try {
            this.loginFrame.getDataOutputStream().writeUTF(consumeCode);
            response = this.loginFrame.getDataInputStream().readUTF().split(":///:");
        } catch (IOException ex) {
            Logger.getLogger(Performance.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (consumeCode) {
            case "3" -> {
                consume = memoryConsume(response);
            }
            case "4" -> {
                consume = driveConsume(response);
            }
            case "5" -> {
                consume = processorConsume(response);
            }
            default -> {
                throw new AssertionError();
            }
        }

        return Double.parseDouble(consume);
    }

    public String memoryConsume(String[] dataArray) {
        int index = 0;
        int counter = 0;
        for (String data : dataArray) {
            if (data.contains("Mem:")) {
                index = counter;
                break;
            }
            counter++;
        }
        String[] strMemory = dataArray[index].split(" +");
        float totalMemory = Float.parseFloat(strMemory[1]);
        float usedMemory = Float.parseFloat(strMemory[2]);
        float percentConsumedMemory = (usedMemory / totalMemory) * 100;

        return Double.toString(Math.round(percentConsumedMemory * 100.0) / 100.0);

    }

    public String processorConsume(String[] dataArray) {

        int index = 0;
        int counter = 0;
        for (String data : dataArray) {
            if (data.contains("%Cpu(s):")) {
                index = counter;
                break;
            }
            counter++;
        }

        String[] strProcessor = dataArray[index].split(" +");

        index = 0;
        counter = 0;
        for (String data : strProcessor) {
            if (data.contains("id,")) {
                index = counter;
                break;
            }
            counter++;
        }

        String percent = strProcessor[index - 1];
        if (percent.contains("ni,")) {
            percent = percent.replace("ni,", "");
        }

        Double percentConsumedProcessor = 100.0 - Double.parseDouble(convertToDecimal(percent));

        if (percentConsumedProcessor < 0) {
            System.out.println(percent);
        }

        return Double.toString(Math.round(percentConsumedProcessor * 100.0) / 100.0);

    }

    public String driveConsume(String[] dataArray) {
        int index = 0;
        int counter = 0;
        for (String data : dataArray) {
            if (data.contains("/dev/sda")) {
                index = counter;
                break;
            }
            counter++;
        }
        String[] strDrive = dataArray[index].split(" +");
        String percent = strDrive[strDrive.length - 2];
        return percent.replace("%", "");
    }

    public String convertToDecimal(String data) {
        return data.replace(",", ".");
    }
}
