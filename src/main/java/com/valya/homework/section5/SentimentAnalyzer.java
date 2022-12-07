package com.valya.homework.section5;

import java.util.Arrays;

public class SentimentAnalyzer {

    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case (label continue и нижний регистр)

    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
                                          String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length]; // output

        review = review.toLowerCase();

        label1 : for(int i = 0; i < featureSet.length; i++) {

            int featureOpinion = 0;

            for(int j = 0; j < featureSet[i].length; j++) {

                featureOpinion = getOpinionOnFeature(review, featureSet[i][j], posOpinionWords, negOpinionWords);

                if(featureOpinion != 0) {
                    featureOpinions[i] = featureOpinion;
                    continue label1;
                }
            }

        }

        return featureOpinions;
    }

    // First invoke checkForWasPhrasePattern and
    // if it cannot find an opinion only then invoke checkForOpinionFirstPattern
    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int result = 0;

        result = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);

        if (result == 0) {
            result = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
       return result;
    }

    // Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
    // Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
    // You can first look for positive opinion. If not found, only then you can look for negative opinion

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";

        for (String posWord : posOpinionWords) {

            int lengthPhrase = (pattern + posWord).length();
            int index = review.indexOf(pattern + posWord);

            while (index >= 0) {
                ++opinion;
                index = review.indexOf((pattern + posWord), index + lengthPhrase);
            }
        }

        if(opinion == 0) {
            for (String negWord : negOpinionWords) {

                int lengthPhrase = (pattern + negWord).length();
                int index = review.indexOf(pattern + negWord);

                while (index >= 0) {
                    --opinion;
                    index = review.indexOf((pattern + negWord), index + lengthPhrase);
                }
            }
        }
        return opinion;
    }

    // You can first look for positive opinion. If not found, only then you can look for negative opinion

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
                                                   String[] negOpinionWords) {
        // Extract sentences as feature might appear multiple times.
        // split() takes a regular expression and "." is a special character
        // for regular expression. So, escape it to make it work!!

        review = review.replace("\\!","\\.");
        String[] sentences = review.split("\\.");

        int opinion = 0;

        label2: for (String posWord : posOpinionWords){

            for(String sentence : sentences) {

                if(sentence.indexOf(posWord + " " + feature) > 0) {
                    opinion++;
                    break label2;
                }
            }
        }

        label3: if(opinion == 0) {
            for (String negsWord : negOpinionWords){

                for(String sentence : sentences) {
                    if(sentence.indexOf(negsWord + " " + feature) > 0) {
                        opinion--;
                        break label3;
                    }
                }
            }
        }

        // your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)

        return opinion;
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
        /*Output: [0, 0, 1, 0, 1]*/
        //String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";

        //String review = "I had a wonderful evening. The cafe has great waiter. The dessert was good. Excellent ice cream. But the soup was bad. Beautiful atmosphere and nice music.";

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };

        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
                "delicious" };

        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);

//        System.out.println(checkForWasPhrasePattern(review,"food", posOpinionWords, negOpinionWords));
//
//        System.out.println(checkForOpinionFirstPattern(review.toLowerCase(),"service", posOpinionWords, negOpinionWords));
//
//        System.out.println(getOpinionOnFeature(review.toLowerCase(), "service", posOpinionWords, negOpinionWords));

        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}