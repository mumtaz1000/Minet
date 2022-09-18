package com.minet.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;
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

    public void readFromFile(String filename){
        try {
            File fileObj = new File(filename);
            Scanner myReader = new Scanner(fileObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading data from file.");
            e.printStackTrace();
        }
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
    public void updateFile(String searchData,String updatedString, String filename) throws IOException {
        String temporaryFilePath = "src/assets/TemporaryFile.txt";
        RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw");
        File temporaryFile = new File(temporaryFilePath);
        RandomAccessFile temporaryRandomAccessFile = new RandomAccessFile(temporaryFile,"rw");
        String nameNumberString;

        randomAccessFile.seek(0);
        while(randomAccessFile.getFilePointer() < randomAccessFile.length()){
            nameNumberString = randomAccessFile.readLine();

            if(Objects.equals(searchData,nameNumberString)){
                System.out.println("Required data found to update!!");
                nameNumberString = updatedString;
            }
            temporaryRandomAccessFile.writeBytes(nameNumberString);
            temporaryRandomAccessFile.writeBytes(System.lineSeparator());
        }
        randomAccessFile.seek(0);
        temporaryRandomAccessFile.seek(0);
        while(temporaryRandomAccessFile.getFilePointer() < temporaryRandomAccessFile.length()) {
            randomAccessFile.writeBytes(temporaryRandomAccessFile.readLine());
            randomAccessFile.writeBytes(System.lineSeparator());
        }
        randomAccessFile.setLength(temporaryRandomAccessFile.length());
        temporaryRandomAccessFile.close();
        randomAccessFile.close();
        temporaryFile.delete();
        System.out.println("Data is update!!!");
    }
    public List<String> singleUserData(String listOfUsers, int startIndex) {
        List<String> requiredData = new ArrayList<>();
        String[] parts = listOfUsers.split(",");
        for(int index = startIndex; index<parts.length; index++){
            requiredData.add(parts[index]);
        }
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
