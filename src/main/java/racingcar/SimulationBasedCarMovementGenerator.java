package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class SimulationBasedCarMovementGenerator implements CarMovementGenerator {
    private static final Integer START_RANDOM_BOUND = 1;
    private static final Integer END_RANDOM_BOUND = 9;
    private static final Integer MOVE_THRESHOLD = 4;
    private static final int MOVE_DISTANCE = 1;
    private static final int STOP_DISTANCE = 0;

    @Override
    public Integer generateDistance() {
        int randomNumber = generateRandomNumber();

        if (isMovable(randomNumber)) {
            return MOVE_DISTANCE;
        }

        return STOP_DISTANCE;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_BOUND, END_RANDOM_BOUND);
    }


    private boolean isMovable(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }
}
