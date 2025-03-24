import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UniqueChars {

    private final Map<Character, Integer> map = new HashMap<>();
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void calculate() {
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c) && Character.isUpperCase(c)) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Entry<Character, Integer> entry : map.entrySet()) {
            result += "char: " + entry.getKey() +
                "; count: " + entry.getValue() + "\n";
        }
        return result;
    }
}