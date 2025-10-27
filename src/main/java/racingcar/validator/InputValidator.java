package racingcar.validator;

import java.util.List;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 최소 1개 이상 입력해야 합니다.");
        }

        for (String name : carNames) {
            validateCarName(name.trim());
        }
    }

    private static void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }

        if (!name.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("자동차 이름은 영문 대소문자만 가능합니다.");
        }
    }

    public static void validateRoundCount(String input) {
        try {
            int roundCount = Integer.parseInt(input);
            if (roundCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

    }
}