package cos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosineTest {
        @ParameterizedTest(name = "cos({0})")
        @DisplayName("Check PI dots")
        @ValueSource(doubles = {-2 * Math.PI, -1.5 * Math.PI, -Math.PI, -0.5 * Math.PI, 0, 0.5 * Math.PI, Math.PI, 1.5 * Math.PI, 2 * Math.PI})
        void checkPiValues(double param) {
            assertAll(
                    () -> assertEquals(Math.cos(param), Cosine.cos(param, 100), 0.0001)
            );
        }

        @ParameterizedTest(name = "cos({0})")
        @DisplayName("Check Border dots")
        @ValueSource(doubles = {-2.1 * Math.PI, -1.9 * Math.PI, -1.6 * Math.PI,
                -1.4 * Math.PI, -0.6 * Math.PI, -0.4 * Math.PI, -0.1, 0.1, 0.4 * Math.PI,
                0.6 * Math.PI, 0.9 * Math.PI,  1.1 * Math.PI, 1.4 * Math.PI, 1.6 * Math.PI, 1.9 * Math.PI, 2.1 * Math.PI})
        void checkBorderValues(double param) {
            assertAll(
                    () -> assertEquals(Math.cos(param), Cosine.cos(param, 100), 0.0001)
            );
        }
}
