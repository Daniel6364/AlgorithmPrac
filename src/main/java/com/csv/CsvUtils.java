package com.csv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtils {

    private static Log logger = LogFactory.getLog(CsvUtils.class);

    public static List<List<String>> readToList(String path) {

        List<List<String>> list = new ArrayList<>();
        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(file));
//            Charset.forName("UTF-8");
            String line = "";
//            Charset.forName("UTF-8");
            while((line = bufferedReader.readLine()) != null) {
                String[] token = line.split(",");
                List<String> tmpList = new ArrayList<>(Arrays.asList(token));
                list.add(tmpList);
            }
        } catch (Exception e) {
            logger.error(e);
        }


        return list;
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\iamsu\\Documents\\test file\\daniel_test.csv";

        List<List<String>> list = CsvUtils.readToList(path);
        for (List<String> l : list) {
            System.out.println(Arrays.toString(l.toArray()));
        }

    }
}


