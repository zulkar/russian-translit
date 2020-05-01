package io.github.zulkar.translit.schemas;

public class Iso9 implements Schema {
    public static final Iso9 INSTANCE = new Iso9();

    private static final String[] TRANSLIT_TABLE_UPPER_CASE = {
            "A",
            "B",
            "V",
            "G",
            "D",
            "E",
            "\u017D",//Ž - Ж
            "Z",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "O",
            "P",
            "R",
            "S",
            "T",
            "U",
            "F",
            "H",
            "C", //Ц
            "\u010C", // Č - Ч
            "Š", // Š - Ш
            "\u015C", //Ŝ  - Щ
            "\u02BA", // " 	Ъ - modifier letter double prime
            "Y",
            "\u02B9", // Ь - modifier letter  prime
            "\u00C8", //È - Э
            "\u00DB", //Û - Ю
            "\u00C2", //Â = Я
    };
    private static final String[] TRANSLIT_TABLE_LOWER_CASE = {
            "a",
            "b",
            "v",
            "g",
            "d",
            "e",
            "\u017E",//ž - ж
            "z",
            "i",
            "j",
            "k",
            "l",
            "m",
            "n",
            "o",
            "p",
            "r",
            "s",
            "t",
            "u",
            "f",
            "h",
            "c", //ц
            "\u010D", // č - ч
            "\u0161", // š - ш
            "\u015D", //ŝ - щ
            "\u02BA", // " 	ъ - modifier letter double prime
            "y", //  ы
            "\u02B9", // ь - modifier letter  prime
            "\u00E8", //è - э
            "\u00FB", //û - ю
            "\u00E2", //â = я
    };

    @Override
    public String translit(CharSequence s) {
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 1040 && c <= 1071) {
                builder.append(TRANSLIT_TABLE_UPPER_CASE[c - 1040]);
                continue;
            }
            if (c >= 1072 && c <= 1103) {
                builder.append(TRANSLIT_TABLE_LOWER_CASE[c - 1072]);
                continue;
            }
            if (c == 1105) {
                builder.append('\u00EB');
                continue;
            }
            if (c == 1025) {
                builder.append('\u00CB');
                continue;
            }
            builder.append(c);
        }
        return builder.toString();
    }
}
