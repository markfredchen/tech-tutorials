package tech.markfredchen.core.java;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author markfredchen
 * @since 2019/12/17
 */
class NumberTextTest {
    @Test
    void testNumberFormatWithoutLocale() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setParseIntegerOnly(true);
        assertThat(numberFormat.format(123456.78901)).isEqualTo("123456");

    }
}
