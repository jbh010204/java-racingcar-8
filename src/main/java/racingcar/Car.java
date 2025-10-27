package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private final List<CarStatus> statuses = new ArrayList<>();
    private Boolean isWinner = false;

    private Car(String name) {
        this.name = name;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public void move(Integer roundNumber, Integer distance) {
        CarStatus carStatus = CarStatus.of(roundNumber, distance);
        this.renewStatus(carStatus);
    }

    public Integer getDistanceForRound(Integer roundNumber) {
        return statuses.stream()
                .filter(status -> status.roundNumber() <= roundNumber)
                .mapToInt(CarStatus::distance)
                .sum();
    }

    public Integer getTotalDistance() {
        return statuses.stream()
                .mapToInt(CarStatus::distance)
                .sum();
    }

    public String getName() {
        return name;
    }

    public void win() {
        this.isWinner = true;
    }

    private void renewStatus(CarStatus carStatus) {
        statuses.add(carStatus);
    }

    public boolean isWin() {
        return isWinner;
    }
}
