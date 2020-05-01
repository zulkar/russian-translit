package io.github.zulkar.translit;

import io.github.zulkar.translit.schemas.Gost7792000SystemB;
import io.github.zulkar.translit.schemas.IcaoDoc9303;
import io.github.zulkar.translit.schemas.Iso9;
import io.github.zulkar.translit.schemas.Schema;


public final class Translit {

    public static Schema iso9() {
        return Iso9.INSTANCE;
    }

    public static Schema icaoDoc9309() {
        return IcaoDoc9303.INSTANCE;
    }

    public static Schema gost7_79_2000_B() {
        return Gost7792000SystemB.INSTANCE;
    }

    public static Schema gost7_79_2000_A() {
        return Iso9.INSTANCE;
    }

    public static String toLatin(CharSequence input) {
        return toLatin(input, icaoDoc9309());
    }

    public static String toLatin(CharSequence input, Schema schema) {
        if (input == null) {
            return null;
        }
        return schema.translit(input);
    }
}
