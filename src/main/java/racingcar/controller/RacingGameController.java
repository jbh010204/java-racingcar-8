package racingcar.controller;

import java.util.List;
import racingcar.RacingGameService;
import racingcar.model.Car;
import racingcar.view.RacingGameView;

public class RacingGameController {
    private final RacingGameView view;
    private final RacingGameService service;

    public RacingGameController(RacingGameView view, RacingGameService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        try {
            List<String> carNames = view.inputCarNames();
            Integer roundCount = view.inputRoundCount();

            List<Car> cars = service.raceForRounds(carNames, roundCount);

            printAllRounds(cars, roundCount);

            List<Car> winners = service.getWinners(cars);
            view.printWinners(winners);
        } catch (Exception e) {
            throw e;
        }
    }

    private void printAllRounds(List<Car> cars, Integer roundCount) {
        for (int roundNumber = 1; roundNumber <= roundCount; roundNumber++) {
            view.printRoundResult(cars, roundNumber);
        }
    }
}
