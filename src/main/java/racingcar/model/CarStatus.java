package racingcar.model;

public record CarStatus(Integer roundNumber, Integer distance) {

    public static CarStatus of(Integer roundNumber, Integer distance) {
        return new CarStatus(roundNumber, distance);
    }
}
