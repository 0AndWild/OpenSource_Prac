package io.github._0AndWild;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Nested
    class validateSpecialCharacters {
        @Test
        @DisplayName("특수문자 형식 검사 성공 케이스")
        void successCase() {

            String s = "Hello Wor#ld. This is! Test+&";
            String isOkPattern = "[!+&%:,^@#.]";

            boolean check = Validator.validateSpecialCharacters(s,isOkPattern);

            Assertions.assertThat(check).isEqualTo(true);
        }

        @Test
        @DisplayName("특수문자 형식 검사 실패 케이스")
        void failCase() {

            String s = "Hello Wor#ld. This is! Test+&";
            String isOkPattern = "[#.!+]";

            boolean check = Validator.validateSpecialCharacters(s,isOkPattern);

            Assertions.assertThat(check).isEqualTo(false);
        }
    }
}
