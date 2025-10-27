package racingcar;

import java.util.List;

public class RacingGameService {
    private final RacingGameSimulator racingGameSimulator;

    public RacingGameService(RacingGameSimulator racingGameSimulator) {
        this.racingGameSimulator = racingGameSimulator;
    }

    public List<Car> raceForRounds(List<String> carNames, Integer roundCount) {
        List<Car> racingCars = carNames.stream()
                .map(Car::create)
                .toList();

        return racingGameSimulator.simulateRaceForRounds(roundCount, racingCars);
    }
}
