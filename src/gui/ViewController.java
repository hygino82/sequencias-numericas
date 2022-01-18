package gui;

import java.net.URL;
import java.util.ResourceBundle;

import entities.PA;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {

	@FXML
	private ChoiceBox<String> cbProgressao;

	private String[] tipo = { "ARITMETICA", "GEOMETRICA" };

	private String opcao;

	@FXML
	private TextArea txtLista;

	@FXML
	private Button btCalcula;

	@FXML
	private Label label1;

	@FXML
	private Label label2;

	@FXML
	private Label label3;

	@FXML
	private Label label4;

	@FXML
	private Label label5;

	@FXML
	private TextField txtSp1;

	@FXML
	private TextField txtSp2;

	@FXML
	private TextField txtV1;

	@FXML
	private TextField txtV2;

	@FXML
	private TextField txtV3;

	@FXML
	private RadioButton rbElementoRazao;

	@FXML
	private RadioButton rbDoisElementos;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		label3.setVisible(true);
		txtV2.setVisible(true);
		label4.setVisible(false);
		label5.setVisible(false);
		txtV3.setVisible(false);
		txtSp2.setVisible(false);

		cbProgressao.getItems().addAll(tipo);
		cbProgressao.setOnAction(this::getTipo);
	}

	public void getTipo(ActionEvent event) {
		opcao = cbProgressao.getValue();
	}

	@FXML
	public void getEscolha(ActionEvent event) {
		if (rbElementoRazao.isSelected()) {
			label3.setVisible(true);
			txtV2.setVisible(true);
			label4.setVisible(false);
			label5.setVisible(false);
			txtV3.setVisible(false);
			txtSp2.setVisible(false);
		} else if (rbDoisElementos.isSelected()) {
			label3.setVisible(false);
			txtV2.setVisible(false);
			label4.setVisible(true);
			label5.setVisible(true);
			txtV3.setVisible(true);
			txtSp2.setVisible(true);
		}
	}

	@FXML
	public void btCalculaAction() {
		txtLista.clear();
		int m = Integer.parseInt(txtSp1.getText());
		double am = Double.parseDouble(txtV1.getText());

		if (rbElementoRazao.isSelected()) {
			double razao = Double.parseDouble(txtV2.getText());

			if (opcao == "ARITMETICA") {
				double a1 = am - (m - 1) * razao;
				PA progressao = new PA(a1, razao);
				txtLista.appendText(progressao.toString());
				txtLista.appendText("\nOs primeiros 20 elementos são:\n");
				for (int i = 1; i <= 20; i++) {
					txtLista.appendText("A[" + i + "] = " + progressao.An(i) + "\n");
				}
			} else if (cbProgressao.getValue() == "GEOMETRICA") {
				System.out.println("NÃO IMPLEMENTADO AINDA");
			}
		} else {// quando são informados dois elementos
			int n = Integer.parseInt(txtSp2.getText());
			double an = Double.parseDouble(txtV3.getText());
			if (opcao == "ARITMETICA") {
				PA progressao = new PA(an, n, am, m);
				txtLista.appendText(progressao.toString());
				txtLista.appendText("\nOs primeiros 20 elementos são:\n");
				for (int i = 1; i <= 20; i++) {
					txtLista.appendText("A[" + i + "] = " + progressao.An(i) + "\n");
				}
			} else if (cbProgressao.getValue() == "GEOMETRICA") {
				System.out.println("NÃO IMPLEMENTADO AINDA");
			}
		}
	}

}
