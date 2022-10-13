package com.valya.homework.section5;

public class IRUtil {

    public static void main(String[] args) {
        String doc = "Every time there is a new COVID wave, a few medicines become popular. " +
                "The desperation to save family members or avoid severe forms of the infection makes hapless people opt for the ‘promising’ drugs." +
                " Currently, people are made aware of one such drug called ‘Monoclonal Antibodies Cocktail’, which costs around ₹60,000. " +
                "However, several doctors from Telangana have underscored that the antibodies cocktail," +
                " available in India, are not effective against the Omicron variant. " +
                "They have also stressed that 93% to 95% of the current COVID cases are of Omicron variant. " +
                "Even if it is Delta variant, the drug cocktail has to be given within seven days of onset of the infection," +
                " and it is ineffective if the patient is in a severe stage of infection. Doctors said Remdesivir is suggested for patients with Omicron, " +
                "after examining infection severity, presence of co-morbidities, immunity levels, and other factors.";

        System.out.println(termFrequency("infection", doc));
        System.out.println(termFrequency("covid", doc));

        System.out.println(getFrequencyCount("infection", doc));
        System.out.println(getFrequencyCount("covid", doc));
    }

    public static int getFrequencyCount(String term, String doc) {

        //Step 1: Convert both term & doc into lower-case

        term = term.toLowerCase();
        doc = doc.toLowerCase();

//        Step 2: Initialize variable frequencyCount to 0
        int frequencyCount = 0;
        int lengthTerm = term.length();

//        Step 3: Initialize variable index with the index position of term in doc. Hint: Use indexOf() method
        int index = doc.indexOf(term);

//        Step 4: If index >= 0 (i.e.., term appears in doc), then go to next step. Else go to last step.

        while (index >= 0) {
            ++frequencyCount;
            index = doc.indexOf(term,index + lengthTerm); //ищем слово (term) в документе (doc). Метод вернет номер индекса с которого это слово есть.
            // Далее прибавляем к этому индексу длину искомого слова и опять ищем. Если слово не нашлось или индекса нет уже, то метод выдаст -1.
        }
        return frequencyCount;

//        Step 5: Increment frequencyCount
//
//        Step 6: Re-compute doc with the string appearing after term till end of doc. Hint: You can use substring() & length() methods
//
//        Step 7: Re-compute index with index position of term in the re-computed doc. Go to step 4 to continue processing.

//        Step 8: Return frequencyCount

    }

    public static double termFrequency(String term, String doc) {

//        Step 1: int frequencyCount = getFrequencyCount(term, doc);
        int frequencyCount = getFrequencyCount(term, doc);
//
//        Step 2: Create variable totalTermCount to hold the total number of terms appearing in doc. Hint: You can use split() with white-space " " as delimiter
        String[] allTermDoc = doc.split(" ");
        int totalTermCount = allTermDoc.length;
//
//        Step 3: return frequencyCount / totalTermCount. This is the tf formula.
        return (double) frequencyCount / totalTermCount;
    }

}