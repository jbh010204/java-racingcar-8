package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 유효한_자동차_이름들은_검증을_통과한다() {
        List<String> validNames = List.of("pobi", "jun", "alice");
        assertDoesNotThrow(() -> InputValidator.validateCarNames(validNames));
    }

    @Test
    void 자동차_이름이_5자를_초과하면_예외가_발생한다() {
        List<String> longNames = List.of("toolong");
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNames(longNames));
    }

    @Test
    void 영문이_아닌_자동차_이름은_예외가_발생한다() {
        List<String> invalidNames = List.of("pobi1");
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNames(invalidNames));
    }

    @Test
    void 유효한_시도_횟수는_검증을_통과한다() {
        assertDoesNotThrow(() -> InputValidator.validateRoundCount("5"));
    }

    @Test
    void 숫자가_아닌_시도_횟수는_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateRoundCount("abc"));
    }

    @Test
    void 음수_시도_횟수는_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateRoundCount("-1"));
    }
}