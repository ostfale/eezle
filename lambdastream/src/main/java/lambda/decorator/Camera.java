package lambda.decorator;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Uwe Sauerbrei on 27.02.2018
 */
@SuppressWarnings("unchecked")
public class Camera {

    private Function<Color, Color> filter;

    private Camera() {
        // empty filter delivers the original colors
      //  setFilters();
        setFiltersWithIdentityFunction(Color::darker, Color::brighter);
    }

    public static void main(String[] args) {
        final Camera camera = new Camera();
        camera.doItWithoutFilter(camera);
    }

    private void doItWithoutFilter(Camera camera) {
        final Consumer<String> printCaptured = (filterInfo) ->
                System.out.println(String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200))));

        printCaptured.accept("darker filter");
    }

    private Color capture(final Color inputColor) {
        return  filter.apply(inputColor);
    }

    private void setFiltersWithIdentityFunction(final Function<Color, Color>... filters) {
        filter =
                Stream.of(filters)
                        .reduce(Function::compose)
                        .orElseGet(Function::identity); // static functional interface function
    }

    private void setFilters(final Function<Color, Color>... filters) {
        filter =
                Stream.of(filters)
                        .reduce((filter, next) -> filter.compose(next))
                        .orElse(color -> color);
    }
}
