package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차가_생성되면_이름을_가진다() {
        Car car = Car.create("pobi");
        assertEquals("pobi", car.getName());
    }

    @Test
    void 자동차가_이동하면_거리가_누적된다() {
        Car car = Car.create("pobi");
        car.move(1, 1);
        car.move(2, 1);

        assertEquals(1, car.getDistanceForRound(1));
        assertEquals(2, car.getDistanceForRound(2));
    }

    @Test
    void 우승자_설정이_정상_작동한다() {
        Car car = Car.create("pobi");
        car.win();
        assertTrue(car.isWin());
    }
}