package com.solvd.app.fileReader;

import com.solvd.app.functionalInterface.MReverse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileIsReader {

    private static final Logger LOGGER = LogManager.getLogger(FileIsReader.class);

    public static void countTheNumberOfUniqueWordsInAFile() {

        File file = new File("src/main/resources/FileForReader.txt");
        try {
            List<String> stringOutput = FileUtils.readLines(file);
            String result = StringUtils.join(stringOutput, " ");
            List<String> listWords = List.of(StringUtils.split(result, " "));

            //использование конвейрного stream(1)
            List<String> resultListWords = listWords.stream().distinct().collect(Collectors.toList());
            FileUtils.writeStringToFile(new File("src/main/resources/FileForWriter.txt"), String.valueOf(resultListWords.size()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void reverseReaderFile() {
        File file = new File("src/main/resources/FileForReader.txt");
        try {
            List<String> stringOutput = FileUtils.readLines(file);
            String result = StringUtils.join(stringOutput, " ");

            //использование собственного функционального интерфейса MReverse
            MReverse<String> reverseResult = (str) -> {
                String result2 = "";
                for (int i = str.length() - 1; i >= 0; i--)
                    result2 += str.charAt(i);
                return result2;
            };
            LOGGER.info("Reversed string = " + reverseResult.reverse(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

