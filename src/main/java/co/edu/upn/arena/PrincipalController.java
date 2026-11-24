package co.edu.upn.arena;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class PrincipalController {

    @FXML
    private BorderPane raiz;

    @FXML
    private StackPane contenido;

    @FXML
    private ComboBox<String> cmbModo;

    @FXML
    private Label lblEstadoModo;

    @FXML
    private void initialize() {
        if (cmbModo != null && cmbModo.getValue() == null) {
            cmbModo.setValue("Predeterminado");
        }
        aplicarModoActual();
    }

    private void aplicarModoActual() {
        String modo = "";
        if (cmbModo != null && cmbModo.getValue() != null) {
            modo = cmbModo.getValue();
        }

        if (modo.equals("Oscuro")) {
            if (!raiz.getStyleClass().contains("modo-oscuro")) {
                raiz.getStyleClass().add("modo-oscuro");
            }
            if (lblEstadoModo != null) {
                lblEstadoModo.setText("Modo: Oscuro");
            }
        } else {
            raiz.getStyleClass().remove("modo-oscuro");
            if (lblEstadoModo != null) {
                lblEstadoModo.setText("Modo: Predeterminado");
            }
        }
    }

    @FXML
    private void cambiarModo() {
        aplicarModoActual();
    }

    private void abrir(String archivo) {
        try {
            Parent vista = FXMLLoader.load(getClass().getResource(archivo));
            contenido.getChildren().setAll(vista);
            aplicarModoActual();
        } catch (Exception e) {
            Mensajes.error("No se pudo abrir " + archivo);
            e.printStackTrace();
        }
    }

    @FXML
    private void verModelos() {
        abrir("modelos.fxml");
    }

    @FXML
    private void verGrupos() {
        abrir("grupos.fxml");
    }

    @FXML
    private void verPartidos() {
        abrir("castings.fxml");
    }

    @FXML
    private void verClasificacion() {
        abrir("clasificacion.fxml");
    }
}