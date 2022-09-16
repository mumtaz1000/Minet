package com.minet.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class FileHandler {
    public void createFile(String filename) {
        File file = new File(filename);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void writeToFile(String dataToWrite, String fileName) throws IOException {
        FileHandler fileHandlerObject = new FileHandler();
        List<String> idList = new ArrayList<>();
        String dataString, id;
        RandomAccessFile randomAccessFileObj = new RandomAccessFile(fileName, "rw");

        fileHandlerObject.createFile(fileName);
        while (randomAccessFileObj.getFilePointer() < randomAccessFileObj.length()) {
            dataString = randomAccessFileObj.readLine();
            idList.add(PrintHandler.splitFileString(Collections.singletonList(dataString), 0));
        }
        id = fileHandlerObject.createId(idList);
        System.out.println("write to file " + dataToWrite);
        dataString = id + "," + dataToWrite;
        randomAccessFileObj.writeBytes(dataString);
        randomAccessFileObj.writeBytes(System.lineSeparator());
        randomAccessFileObj.close();
        System.out.println("Data is successfully entered in text file " + fileName + ".");
    }

    public boolean searchDataFromFile(String searchQuery, int index, String filename) throws IOException {
        List<String> nameList = new ArrayList<>();
        String nameNumberString;
        boolean found = false;

        try {
            RandomAccessFile randomAccessObj = new RandomAccessFile(filename, "rw");
            while (randomAccessObj.getFilePointer() < randomAccessObj.length()) {
                nameNumberString = randomAccessObj.readLine();
                nameList.add(PrintHandler.splitFileString(Collections.singletonList(nameNumberString), index));
            }
            found = dataExist(nameList, searchQuery);
            randomAccessObj.close();
        } catch (IOException exception) {
            System.out.println("Error " + exception);
        }
        return found;
    }

    public String readFile(String filename, String searchName) {
        String requiredUserData = null;

        try {
            File myFileObj = new File(filename);
            Scanner myReadObj = new Scanner(myFileObj);

            while (myReadObj.hasNextLine()) {
                String data = myReadObj.nextLine();
                if (data.contains(searchName)) {
                    requiredUserData = data;
                }
            }
            myReadObj.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred while reading a file. " + e);
            e.printStackTrace();
        }

        return requiredUserData;
    }

    public List<String> singleUserData(String listOfUsers) {
        List<String> requiredData = new ArrayList<>();
        String[] parts = listOfUsers.split(",");
        requiredData.add(parts[1]);
        requiredData.add(parts[2]);
        requiredData.add(parts[3]);
        requiredData.add(parts[4]);
        return requiredData;
    }

    public boolean dataExist(List<String> inputList, String search) {
        boolean found = false;

        for (String name : inputList) {
            if (Objects.equals(name, search)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public String createId(List<String> inputList) {
        if (inputList.isEmpty()) {
            return "0";
        } else {
            return String.valueOf(inputList.size());
        }
    }
}
