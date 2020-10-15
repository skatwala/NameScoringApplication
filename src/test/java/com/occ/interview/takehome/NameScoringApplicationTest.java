package com.occ.interview.takehome;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class NameScoringApplicationTest {

    NameScoringApplication nameScoringApplication = new NameScoringApplication();
    @Before
    public void before() {
        nameScoringApplication.setAlphabetMap();
    }


    @Test
    public void test_getScoreForLinda(){
        int score = nameScoringApplication.calculateIndividualScore("LINDA");
        assertEquals(40, score);
    }

    @Test
    public void test_getTotalScore(){
        List<String> list = Arrays.asList("MARY","PATRICIA","LINDA","BARBARA","VINCENZO","SHON","LYNWOOD","JERE","HAI");
        int totalScore=nameScoringApplication.calculateTotalScore(list);
        assertEquals(3194, totalScore);
    }

    @Test
    public void test_convertFileToList() throws IOException {
        String text = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"";
        InputStream inputFileStream = new ByteArrayInputStream(text.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(inputFileStream, "UTF-8"));
        List<String> list = nameScoringApplication.convertFileToList(br);
        assertEquals(9, list.size());
    }

    @Test
    public void test_alphabetMapPopulated(){
        Map<Character, Integer> alphabetMap = nameScoringApplication.getAlphabetMap();
        assertEquals( new Integer(1), alphabetMap.get('A'));
    }
}
