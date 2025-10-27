package racingcar;

import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        DependencyContainer container = new DependencyContainer();
        RacingGameController controller = container.get(RacingGameController.class);

        controller.run();
    }
}