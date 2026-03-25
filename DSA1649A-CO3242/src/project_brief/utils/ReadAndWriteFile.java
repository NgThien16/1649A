package project_brief.utils;


import project_brief.library.ArrayListADT;

import java.io.*;

public class ReadAndWriteFile {
    // ghi file
    public static void writeListStringToCSV(String filePath, ArrayListADT<String> list, boolean append) throws IOException {
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file,append);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < list.size(); i++) {
            String line = list.get(i);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();
    }
    // đọc file
    public static ArrayListADT<String> readFileCSV(String filePath) throws IOException {
        ArrayListADT<String> stringList = new ArrayListADT<>();
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;

        while ((line= bufferedReader.readLine())!=null){
            stringList.add(line);
        }

        bufferedReader.close();
        fileReader.close();
        return  stringList;
    }

}

