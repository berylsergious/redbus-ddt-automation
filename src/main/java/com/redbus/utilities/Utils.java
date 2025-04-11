package com.redbus.utilities;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Utils {
	
//Read input file	

	public static Object[][] getTestDataFromCSV() {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\testdata\\input.csv";
        List<Object[]> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean skipHeader = true;

            while ((line = br.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String[] values = line.split(",");
                dataList.add(values);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Object[][] dataArr = new Object[dataList.size()][];
        return dataList.toArray(dataArr);
    }
	
// Write on output file	
	private static final String FILE_PATH = "src/test/testoutput/busResults.csv";
	
	//To Write header once
    public static void writeHeaderIfNotExists() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, false))) {
            writer.println("From,To,Date,Bus Count");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //To Append data
    public static void writeResultRow(String from, String to, String date, int busCount) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            writer.printf("%s,%s,%s,%s%n", from, to, date, busCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	
}
