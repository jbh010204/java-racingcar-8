package racingcar;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGameSimulator {
    private final static Integer INIT_ROUND_NUMBER = 1;

    public final CarMovementGenerator carMovementGenerator;

    public RacingGameSimulator(CarMovementGenerator carMovementGenerator) {
        this.carMovementGenerator = carMovementGenerator;
    }

    public List<Car> simulateRaceForRounds(Integer roundCount, List<Car> racingCars) {
        List<Car> simulatedCars = IntStream.rangeClosed(INIT_ROUND_NUMBER, roundCount)
                .boxed()
                .reduce(racingCars,
                        (cars, roundNumber) -> simulateRace(roundNumber, cars),
                        (a, b) -> b);

        Integer maxDistance = simulatedCars.stream()
                .mapToInt(Car::getTotalDistance)
                .max()
                .orElse(0);

        simulatedCars.stream()
                .filter(car -> car.getTotalDistance().equals(maxDistance))
                .forEach(Car::win);

        return simulatedCars;
    }

    private List<Car> simulateRace(Integer roundNumber, List<Car> racingCars) {
        return racingCars.stream()
                .map(car -> {
                    Integer distance = carMovementGenerator.generateDistance();
                    car.move(roundNumber, distance);
                    return car;
                })
                .toList();
    }
}
