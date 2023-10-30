package org.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    public static List<Integer> readNumbersFromFile() {
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader("src/main/resources/numbers.csv"));
            String[] numbers = br.readLine().split(",");
            return Arrays.stream(numbers)
                    .map(curr -> Integer.parseInt(curr))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("There was an error reading the file");
            return Collections.emptyList();
        }
    }
}
