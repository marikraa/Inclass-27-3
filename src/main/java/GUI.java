import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HelloController controller = new HelloController();
        controller.start(stage);
    }
}