package dk.sdu.swe.views;

import dk.sdu.swe.views.partials.Navbar;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class AppViewController {

    @FXML
    private Pane navbarPane;

    @FXML
    private Pane contentPane;

    @FXML
    public void initialize() {
        navbarPane.getChildren().setAll(new Navbar(new Router(contentPane)));
    }
}
