package racingcar;

import java.util.HashMap;
import java.util.Map;
import racingcar.controller.RacingGameController;
import racingcar.model.CarMovementGenerator;
import racingcar.model.SimulationBasedCarMovementGenerator;
import racingcar.view.RacingGameView;

public class DependencyContainer {
    public Map<Class<?>, Object> containerMap = new HashMap<>();

    public DependencyContainer() {
        containerMap.put(CarMovementGenerator.class, carMovementGenerator());
        containerMap.put(RacingGameSimulator.class, racingGameSimulator());
        containerMap.put(RacingGameService.class, racingGameService());
        containerMap.put(RacingGameView.class, racingGameView());
        containerMap.put(RacingGameController.class, racingGameController());
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Class<?> clazz) {
        return (T) containerMap.get(clazz);
    }

    private CarMovementGenerator carMovementGenerator() {
        return new SimulationBasedCarMovementGenerator();
    }

    private RacingGameSimulator racingGameSimulator() {
        return new RacingGameSimulator(carMovementGenerator());
    }

    private RacingGameService racingGameService() {
        return new RacingGameService(racingGameSimulator());
    }

    private RacingGameView racingGameView() {
        return new RacingGameView();
    }

    private RacingGameController racingGameController() {
        return new RacingGameController(racingGameView(), racingGameService());
    }
}