package dk.sdu.swe.views.partials;

import dk.sdu.swe.data.DB;
import dk.sdu.swe.domain.models.Category;
import dk.sdu.swe.domain.models.Programme;
import dk.sdu.swe.views.modals.CreditListModal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import org.hibernate.Session;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProgrammeListItem extends AnchorPane {

    @FXML
    private Label nameLbl, releaseYearLbl, categoryLbl;

    private Programme programme;

    @FXML
    private FlowPane channelsPane;

    public ProgrammeListItem(Programme programme) {
        this.programme = programme;

        FXMLLoader fxmlLoader = new FXMLLoader(
            Objects.requireNonNull(
                getClass().getClassLoader().getResource("dk/sdu/swe/ui/programmes/ProgrammeListItem.fxml")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        nameLbl.setText(programme.getTitle());
        categoryLbl.setText(programme.getCategories().stream()
            .map(Category::getCategoryTitle)
            .collect(Collectors.joining(", ")));
        releaseYearLbl.setText(String.valueOf(programme.getProdYear()));
    }

    @FXML
    private void showCredits() {
        Dialog creditListModal = new CreditListModal(getScene().getWindow(), programme);
        creditListModal.show();
    }

}
