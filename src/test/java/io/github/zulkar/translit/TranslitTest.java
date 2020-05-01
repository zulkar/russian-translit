package io.github.zulkar.translit;

import io.github.zulkar.translit.schemas.Schema;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TranslitTest {
    private Schema schema;

    @Test
    public void testIcao9303() {
        schema = Translit.icaoDoc9309();
        assertTranslit(null, null);
        assertTranslit("EZhIK", "ЁЖИК");
        assertTranslit("ABVGDEEZhZIIKLMNOPRSTUFKhTsChShShshIeYEIuIa", "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ");
        assertTranslit("abvgdeezhziiklmnoprstufkhtschshshchieyeiuia", "абвгдеёжзийклмнопрстуфхцчшщъыьэюя");
        assertTranslit("sol", "соль");
        assertTranslit("SOL", "СОЛЬ");
        assertTranslit("Iurii", "Юрий");
        assertTranslit("Ashf LShTShFUM", "Ашьф ЛШТШФУМ");
        assertTranslit("Foma Kiniaev", "Фома Киняев");
    }


    @Test
    public void testIso9() {
        schema = Translit.iso9();
        assertTranslit(null, null);
        assertTranslit("ËŽIK", "ЁЖИК");
        assertTranslit("e\u015D\u00EB", "ещё");
        assertTranslit("ABVGDEËŽZIJKLMNOPRSTUFHCČŠŜʺYʹÈÛÂ", "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ");
        assertTranslit("abvgdeëžzijklmnoprstufhcčšŝʺyʹèûâ", "абвгдеёжзийклмнопрстуфхцчшщъыьэюя");
        assertTranslit("Ûliâ", "Юлия");

        assertTranslit("Slavʹsâ, Otečestvo naše svobodnoe,\n" +
                        "Bratskih narodov soûz vekovoj,\n" +
                        "Predkami dannaâ mudrostʹ narodnaâ!\n" +
                        "Slavʹsâ, strana! My gordimsâ toboj!",
                "Славься, Отечество наше свободное,\n" +
                        "Братских народов союз вековой,\n" +
                        "Предками данная мудрость народная!\n" +
                        "Славься, страна! Мы гордимся тобой!"
        );

    }

    @Test
    public void testGostVersionB() {
        schema = Translit.gost7_79_2000_B();
        assertTranslit(null, null);
        assertTranslit("eshhyo", "ещё");
        assertTranslit("ABVGDEYoZhZIJKLMNOPRSTUFXCzChShShh``Y``E`YuYa", "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ");
        assertTranslit("abvgdeyozhzijklmnoprstufxczchshshh``y``e`yuya", "абвгдеёжзийклмнопрстуфхцчшщъыьэюя");
        assertTranslit("Payacz", "Паяц");
        assertTranslit("Payacz ", "Паяц ");
        assertTranslit("PAYaCz", "ПАЯЦ");
        assertTranslit("PAYaCz ", "ПАЯЦ ");
        assertTranslit("Cy`plenok", "Цыпленок");
        assertTranslit("CY`PLENOK", "ЦЫПЛЕНОК");
        assertTranslit("cement", "цемент");
        assertTranslit("czacza", "цаца");
    }


    private void assertTranslit(String expected, String actual) {
        assertEquals(expected, Translit.toLatin(actual, schema));
    }
}
