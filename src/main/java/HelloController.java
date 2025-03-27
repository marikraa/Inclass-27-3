import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.text.MessageFormat;
import java.util.*;

public class HelloController {
    @FXML
    private Label lblDistance, lblFuel, lblResult;
    @FXML
    private TextField tfDistance, tfFuel;
    @FXML
    private Button btnCalculate;

    private ResourceBundle rb;

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello-view.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        stage.setTitle("Fuel Consumption Calculator");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }

    private void setLanguage(Locale locale) {
        lblResult.setText("");
        try {
            rb = ResourceBundle.getBundle("messages", locale);
            lblDistance.setText(rb.getString("distance"));
            lblFuel.setText(rb.getString("fuel"));
            btnCalculate.setText(rb.getString("calculate"));
        } catch (MissingResourceException e) {
            lblResult.setText("Error loading resources");
        }
    }

    @FXML
    public void onCalculateClick(ActionEvent actionEvent) {
        try {
            double distance = Double.parseDouble(tfDistance.getText());
            double fuel = Double.parseDouble(tfFuel.getText());
            double consumption = (fuel / distance) * 100;
            lblResult.setText(MessageFormat.format(rb.getString("result"), consumption));
        } catch (NumberFormatException e) {
            lblResult.setText(rb.getString("invalid"));
        }
    }
    public void onENClick(ActionEvent actionEvent) {
        setLanguage(new Locale("en", "US"));
    }

    public void onFAClick(ActionEvent actionEvent) {
        setLanguage(new Locale("fa", "IR"));
    }

    public void onFRClick(ActionEvent actionEvent) {
        setLanguage(new Locale("fr", "FR"));
    }

    public void onJAClick(ActionEvent actionEvent) {
        setLanguage(new Locale("ja", "JP"));
    }
}