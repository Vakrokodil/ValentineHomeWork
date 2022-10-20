package com.valya.homework.section7;
//import com.google.common.base.CharMatcher;

public class APIResponseParser {

    private final static String EMPTY_STRING = "";
    private final static String CHAR_TO_REMOVE = ",";

    /**
     * Parses the input text and returns a Book instance containing
     * the parsed data.
     * @param response text to be parsed
     * @return Book instance containing parsed data
     */

    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";

        String[] startRules = {"<title>", "<name>", "<original_publication_year type=\"integer\">",
                "<average_rating>", "<ratings_count type=\"integer\">", "<image_url>"};

        for (String startRule : startRules) {

            String result = parse(response, startRule, endRule);

            if (!result.equals("")) {
                switch (startRule) {
                    case "<title>" -> book.setTitle(result);
                    case "<name>" -> book.setAuthor(result);
                    case "<original_publication_year type=\"integer\">" -> book.setPublicationYear(Integer.parseInt(result));
                    case "<average_rating>" -> book.setAverageRating(Double.parseDouble(result));
                    case "<ratings_count type=\"integer\">" -> book.setRatingsCount(Integer.parseInt(result.replace(CHAR_TO_REMOVE, EMPTY_STRING)));
                    case "<image_url>" -> book.setImageUrl(result);
                }
            }
        }

//        System.out.println(book.getTitle());
//        System.out.println(book.getAuthor());
//        System.out.println(book.getPublicationYear());
//        System.out.println(book.getAverageRating());
//        System.out.println(book.getRatingsCount());
//        System.out.println(book.getImageUrl());

        return book;
    }

    // write overloaded parse method with the 3 parameters response, startRule, endRule

    public static String parse(String response, String startRule, String endRule) {

        if (response.contains(startRule)) {

            int startIndex = response.indexOf(startRule) + startRule.length();
            int endIndex = response.indexOf(endRule, startIndex);
            return response.substring(startIndex,endIndex);

        } else {
            return EMPTY_STRING;
        }
    }

    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";

        String response2 = "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";

        APIResponseParser.parse(response2);
    }
}