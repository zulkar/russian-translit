package io.github.zulkar.translit.schemas;

public class IcaoDoc9303 implements Schema {
    public static final IcaoDoc9303 INSTANCE = new IcaoDoc9303();
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
            "I",
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
            "Kh",
            "Ts",
            "Ch",
            "Sh",
            "Shsh",
            "Ie",
            "Y",
            null,
            "E",
            "Iu",
            "Ia",
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
            "i",
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
            "kh",
            "ts",
            "ch",
            "sh",
            "shch",
            "ie",
            "y",
            null,
            "e",
            "iu",
            "ia",
    };

    @Override
    public String translit(CharSequence s) {
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 1040 && c <= 1071) {
                if (c != 1068) {
                    builder.append(TRANSLIT_TABLE_UPPER_CASE[c - 1040]);
                }
                continue;
            }
            if (c >= 1072 && c <= 1103) {
                if (c != 1100) {
                    builder.append(TRANSLIT_TABLE_LOWER_CASE[c - 1072]);
                }
                continue;
            }
            if (c == 1105) {
                builder.append('e');
                continue;
            }
            if (c == 1025) {
                builder.append('E');
                continue;
            }
            builder.append(c);
        }
        return builder.toString();
    }


}
