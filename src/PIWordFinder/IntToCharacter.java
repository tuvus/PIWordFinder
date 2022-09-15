package PIWordFinder;

public class IntToCharacter {
    String conversion;
    public IntToCharacter(String conversion) {
        this.conversion = conversion;
    }

    public char getCharFromInt(int num) {
        return conversion.charAt(num % conversion.length());
    }
}
