package com.occ.interview.takehome;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NameScoringApplication implements FileScore {
    static Logger log = Logger.getLogger(NameScoringApplication.class.getName());

    private Map<Character, Integer> alphabetMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            log.info("please provide path of input file containing the names as command line argument");
            return;
        }
        NameScoringApplication nameScoringApplication = new NameScoringApplication();
        nameScoringApplication.setAlphabetMap();
        BufferedReader br = nameScoringApplication.readFile(args[0]);
        List<String> fileData = nameScoringApplication.convertFileToList(br);
        log.info("File Score" + nameScoringApplication.calculateTotalScore(fileData));

    }



    public void setAlphabetMap() {
        char[] alphabetArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        alphabetMap =
                IntStream.range(0, alphabetArray.length).mapToObj(i -> new AbstractMap.SimpleImmutableEntry<>(alphabetArray[i], i + 1))
                        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

    }

    public Map<Character, Integer> getAlphabetMap() {
        return alphabetMap;
    }

    BufferedReader readFile(String filePath) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        return br;
    }

    List<String> convertFileToList(BufferedReader br) throws IOException {
        List<String> records = new ArrayList();
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            for (String s : values) {
                records.add(s);
            }
        }
        return records;
    }

    @Override
    public int calculateTotalScore(List<String> records) {
        int totalScore = 0;
        Collections.sort(records);
        int counter = 1;
        for (String s : records) {
            totalScore += counter * (calculateIndividualScore(s));
            counter++;
        }
        return totalScore;
    }

    int calculateIndividualScore(String individualString) {
        int score = 0;
        individualString = individualString.replace("\"", "");
        char[] individualCharArray = individualString.toCharArray();
        for (int i = 0; i <= individualCharArray.length - 1; i++) {
            score += alphabetMap.get(individualCharArray[i]);
        }
        return score;
    }
}
