package gui;

import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import entities.PA;
import entities.PG;
import entities.Sequencia;
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
	private TextField txtQuant;

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
		cbProgressao.getSelectionModel().select(0);// escolhe a seleção padrão do combo box
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
		Locale.setDefault(Locale.US);
		try {
			Sequencia progressao;
			int m = Integer.parseInt(txtSp1.getText());
			double am = Double.parseDouble(txtV1.getText());
			if (m < 0) {
				throw new IllegalArgumentException("O índice do elemento deve ser um inteiro positivo.");
			}
			if (rbElementoRazao.isSelected()) {
				double razao = Double.parseDouble(txtV2.getText());

				if (opcao == "ARITMETICA") {
					double a1 = am - (m - 1) * razao;
					progressao = new PA(a1, razao);
				} else {
					double a1 = am / Math.pow(razao, m - 1);
					progressao = new PG(a1, razao);
				}
			} else {// quando são informados dois elementos
				int n = Integer.parseInt(txtSp2.getText());
				double an = Double.parseDouble(txtV3.getText());
				if ((n == m) || (n < 0)) {
					throw new IllegalArgumentException("Os valores inseridos são inválidos.");
				}
				if (opcao == "ARITMETICA") {
					progressao = new PA(an, n, am, m);
				} else {
					progressao = new PG(an, n, am, m);
				}

			}

			int quant = Integer.parseInt(txtQuant.getText());// quantidade de elementos a gerar
			if (quant < 0) {
				throw new IllegalArgumentException("Os valor inseridos é inválido.");
			}

			List<String> lista = progressao.gerarListaDetalhada(quant);
			txtLista.appendText("PROGRESSÃO " + opcao + "\n");
			txtLista.appendText(progressao.toString() + "\n");
			for (String an : lista) {
				txtLista.appendText(an + "\n");
			}

			double soma = progressao.soma(quant);
			txtLista.appendText("A soma dos " + quant + " elementos é " + soma + "\n");

		} catch (NumberFormatException e) {
			txtLista.appendText("O formato numérico é inválido");
		} catch (IllegalArgumentException e) {
			txtLista.appendText(e.getMessage());
		}
	}

}
