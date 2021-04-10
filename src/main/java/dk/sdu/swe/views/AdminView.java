package dk.sdu.swe.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class AdminView extends BorderPane {

    public AdminView() {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResource("dk/sdu/swe/ui/admin/admin.fxml")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
