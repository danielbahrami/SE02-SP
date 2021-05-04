package dk.sdu.swe.views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import dk.sdu.swe.views.modals.persons.AddPersonModal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.util.Objects;

public class PersonsViewController extends VBox {

    @FXML
    private JFXListView peopleListView;
    @FXML
    private JFXButton fabBtn;

    public PersonsViewController() {
        FXMLLoader fxmlLoader = new FXMLLoader(
            Objects.requireNonNull(
                getClass().getClassLoader().getResource("dk/sdu/swe/ui/persons/persons.fxml")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {/*
        List<Person> people = null;
        try {
            people = FacadeDB.getInstance().getPeople();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Person person : people) {
            peopleListView.getItems().add(new PersonListItem(person));
        }*/
    }
   @FXML
    void addPersonModal(ActionEvent event) {
    Dialog<Boolean> addPerson = new AddPersonModal(getScene().getWindow());
    addPerson.show();
    }



}
