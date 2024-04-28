package org.example;

import java.io.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        String scriptPath = "src/main/resources/test.sh";

        Process process = Runtime.getRuntime().exec(scriptPath);
        process.waitFor();
        InputStream inputStream = process.getInputStream();
        String result = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
        System.out.println("result:"+result);
        int exitValue = process.exitValue();
        if (exitValue == 0) {
            System.out.println("Script executed successfully");
        } else {
            System.out.println("Script failed with exit value: " + exitValue);
        }
    }
}