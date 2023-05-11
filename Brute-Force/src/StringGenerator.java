public class StringGenerator {
    private String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789";
    public StringGenerator() {
    }
    public String generateString(int num) {

        StringBuilder result = new StringBuilder();

        while (num >= 0) {
            result.append(allowedChars.charAt(num % allowedChars.length()));
            num = (num / allowedChars.length()) - 1;
        }
        return result.reverse().toString();
    }

}
