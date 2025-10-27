package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.validator.InputValidator;

public class RacingGameView {

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public Integer inputRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void printRoundResult(List<Car> cars, Integer roundNumber) {
        for (Car car : cars) {
            String distance = "-".repeat(car.getDistanceForRound(roundNumber));
            System.out.println(car.getName() + " : " + distance);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(winners.stream()
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse(""));
    }
}
