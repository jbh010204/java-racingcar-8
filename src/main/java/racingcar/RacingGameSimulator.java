package racingcar;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarMovementGenerator;

public class RacingGameSimulator {
    private final static Integer INIT_ROUND_NUMBER = 1;
    public final CarMovementGenerator carMovementGenerator;

    public RacingGameSimulator(CarMovementGenerator carMovementGenerator) {
        this.carMovementGenerator = carMovementGenerator;
    }

    public List<Car> simulateRaceForRounds(Integer roundCount, List<Car> racingCars) {
        List<Car> cars = runRaceSimulation(roundCount, racingCars);
        determineWinners(cars);
        return cars;
    }

    public List<Car> getWinners(List<Car> cars) {
        return cars.stream()
                .filter(Car::isWin)
                .toList();
    }

    private List<Car> runRaceSimulation(Integer roundCount, List<Car> racingCars) {
        List<Car> cars = racingCars;
        for (int roundNumber = INIT_ROUND_NUMBER; roundNumber <= roundCount; roundNumber++) {
            cars = simulateRace(roundNumber, cars);
        }
        return cars;
    }

    private List<Car> simulateRace(Integer roundNumber, List<Car> racingCars) {
        return racingCars.stream()
                .map(car -> moveCarInRound(car, roundNumber))
                .toList();
    }

    private Car moveCarInRound(Car car, Integer roundNumber) {
        Integer distance = carMovementGenerator.generateDistance();
        car.move(roundNumber, distance);
        return car;
    }

    private void determineWinners(List<Car> cars) {
        Integer maxDistance = findMaxDistance(cars);
        markWinners(cars, maxDistance);
    }

    private Integer findMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getTotalDistance)
                .max()
                .orElse(0);
    }

    private void markWinners(List<Car> cars, Integer maxDistance) {
        cars.stream()
                .filter(car -> car.getTotalDistance().equals(maxDistance))
                .forEach(Car::win);
    }
}
