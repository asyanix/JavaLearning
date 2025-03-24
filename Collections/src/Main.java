public class Main {
    public static void main(String[] args) {
        UniqueChars uniqueChars = new UniqueChars();
    
        String text = "In the vast Universe, Scientists Explore the Unknown. " +
                          "NASA, ESA, and Other Agencies Study Space Phenomena. " +
                          "BLACK Holes, SUPERNOVAE, and GALAXIES are Their Focus. " +
                          "AI and Machine Learning Assist in Data Analysis.";

        uniqueChars.setText(text);
        uniqueChars.calculate();
        System.out.println(uniqueChars);
    }
}
