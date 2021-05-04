package dk.sdu.swe.views.modals.programmes;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import dk.sdu.swe.domain.models.Company;
import dk.sdu.swe.domain.models.User;
import dk.sdu.swe.views.partials.UserListItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class UserAdministrationDialog extends Dialog<Boolean> {

    @FXML
    private JFXButton closeBtn;

    @FXML
    private GaussianBlur backgroundEffect;

    @FXML
    private Company company;

    @FXML
    private Label companyName;

    @FXML
    private JFXListView usersListView;

    public UserAdministrationDialog(Window window, Company company) {
        this.company = company;

        this.initOwner(window);
        this.initModality(Modality.APPLICATION_MODAL);
        this.initStyle(StageStyle.UNDECORATED);

        backgroundEffect = new GaussianBlur(10);
        window.getScene().getRoot().setEffect(backgroundEffect);

        setOnCloseRequest((event) -> {
            getOwner().getScene().getRoot().setEffect(null);
        });

        FXMLLoader fxmlLoader = new FXMLLoader(
            Objects.requireNonNull(
                getClass().getClassLoader().getResource("dk/sdu/swe/ui/programmes/UserAdministration.fxml")));
        fxmlLoader.setController(this);

        try {
            getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        /*
        companyName.setText(company.getName());

        List<User> users = null;
        try {
            users = User.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        users.stream().filter(user -> user.getCompanyId() == company.getId()).forEach(
            user -> {
                usersListView.getItems().add(new UserListItem(user));
            }
        );*/
    }

    @FXML
    private void handleClose(ActionEvent event) {
        setResult(false);
        hide();
    }
}