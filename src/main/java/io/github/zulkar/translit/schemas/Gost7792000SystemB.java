package io.github.zulkar.translit.schemas;

public class Gost7792000SystemB implements Schema {
    public static final Gost7792000SystemB INSTANCE = new Gost7792000SystemB();
    private static final String[] TRANSLIT_TABLE_UPPER_CASE = {
            "A",
            "B",
            "V",
            "G",
            "D",
            "E",
            "Zh",
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
            "X",
            null, //Ц - special case
            "Ch",
            "Sh",
            "Shh",
            "``",
            "Y`",
            "`",
            "E`",
            "Yu",
            "Ya",
    };
    private static final String[] TRANSLIT_TABLE_LOWER_CASE = {
            "a",
            "b",
            "v",
            "g",
            "d",
            "e",
            "zh",
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
            "x",
            null, //ц - special case
            "ch",
            "sh",
            "shh",
            "``",
            "y`",
            "`",
            "e`",
            "yu",
            "ya",
    };

    @Override
    public String translit(CharSequence s) {
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 1040 && c <= 1071) {
                if (c == 1062) {
                    char next = i < s.length() - 1 ? s.charAt(i + 1) : 0;
                    if (isEIY(next)) {
                        builder.append("C");
                    } else {
                        builder.append("Cz");
                    }
                } else {
                    builder.append(TRANSLIT_TABLE_UPPER_CASE[c - 1040]);
                }
                continue;
            }
            if (c >= 1072 && c <= 1103) {
                if (c == 1094) {
                    char next = i < s.length() - 1 ? s.charAt(i + 1) : 0;
                    if (next == 1077 || next == 1080 || next == 1081 || next == 1099) {
                        builder.append("c");
                    } else {
                        builder.append("cz");
                    }
                } else {
                    builder.append(TRANSLIT_TABLE_LOWER_CASE[c - 1072]);
                }
                continue;
            }
            if (c == 1105) {
                builder.append("yo");
                continue;
            }
            if (c == 1025) {
                builder.append("Yo");
                continue;
            }
            builder.append(c);
        }
        return builder.toString();
    }

    private static boolean isEIY(char next) {
        return next == 1077 || next == 1080 || next == 1081 || next == 1099
                || next == 1045 || next == 1048 || next == 1049 || next == 1067;
    }
}
