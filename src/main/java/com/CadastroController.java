package com;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class CadastroController {
    private Buscador buscador;
    private List<Cliente> listaClientes;
    
    @FXML
    private TextField textRua; 
    
    @FXML
    private TextField textEstado;
    
    @FXML
    private TextField textCidade;
    
    @FXML
    private TextField textNumero;
    
    @FXML
    private TextField textCEP;
    
    @FXML
    private TextField textNome;
    
    @FXML
    private TextField textTelefone;
    
    private void setEndrecosFields(String rua, String cidade, String estado, String numero){
        textRua.setText(rua);
        textCidade.setText(cidade);
        textEstado.setText(estado);
        textNumero.setText(numero);
    }
    
    @FXML
    private  void initialize(){
        buscador = new Buscador();
        listaClientes = new ArrayList<>();
        limpar();
    }
    
    @FXML
    private void buscarCEP(){
        Endereco endereco = null;
        try{
            endereco = buscador.buscar(textCEP.getText());
            setEndrecosFields(endereco.getRua(), endereco.getCidade(), endereco.getEstado(), endereco.getNumero());
        }catch(Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText(e.getMessage());
            alerta.show();
        }
    }
    
    @FXML
    private void cadastrar(){
        Cliente cliente = new Cliente(textNome.getText(), textTelefone.getText(), 
                new Endereco(textCEP.getText(), textRua.getText(), textNumero.getText(), textCidade.getText(), textEstado.getText()));
        listaClientes.add(cliente);
    }

    @FXML
    public void limpar(){
        setEndrecosFields("", "", "", "");
        textCEP.setText("");
        textNome.setText("");
        textTelefone.setText("");
    }
    
}
