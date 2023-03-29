package com.example.reservasfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Declaraciones comunes
        Map<String,Aula> listadoAulas = new HashMap<>();
        cargarAulas(listadoAulas);
        Map<String, Reserva> listadoReservas = new HashMap<>();

        //Entorno visial(GUI)
        //Definicion y configuración de lyouts
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        HBox fila1 = new HBox();
        fila1.setSpacing(20);
        fila1.setAlignment(Pos.CENTER);

        HBox fila2 = new HBox();
        fila2.setAlignment(Pos.CENTER);
        fila2.setSpacing(20);


        //Definición y configuración de controles
        Label lblProfesor = new Label("Profesor");
        TextField txtProfesor = new TextField();
        Label lblAula = new Label("Aula");
        TextField txtAula = new TextField();
        fila1.getChildren().addAll(lblProfesor, txtProfesor, lblAula, txtAula);

        Label lblFecha = new Label("Fecha");
        TextField txtFecha = new TextField();
        Label lblHora = new Label("Hora");
        TextField txtHora = new TextField();
        fila2.getChildren().addAll(lblFecha, txtFecha, lblHora, txtHora);

        Button btnReservar = new Button("Reservar");

        //Unimos y mostramos la escena
        root.getChildren().addAll(fila1, fila2, btnReservar);
        Scene scene = new Scene(root, 480, 240);
        stage.setScene(scene);
        stage.setTitle("Gestión de reserva de aulas");
        stage.show();

        //Eventos
        btnReservar.setOnAction(
                actionEvent -> {

            reservar(listadoAulas, listadoReservas, txtProfesor.getText(),txtAula.getText(),txtFecha.getText(),txtHora.getText());  });
    }

    private void reservar(Map<String, Aula> listadoAulas, Map<String, Reserva> listadoReservas, String txtProfesor, String txtAula, String txtFecha, String txtHora ) {
        if(txtProfesor.isEmpty() || txtAula.isEmpty() || txtFecha.isEmpty() || txtHora.isEmpty()){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText("Error en la reserva");
            alert1.setTitle("Gestión de reservas");
            alert1.setContentText("Hay campos sin rellenar, por favor, rellenelos");
            alert1.showAndWait();
        }else if(!listadoAulas.containsKey(txtAula)) {
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setHeaderText("Error en la reserva");
            alert2.setTitle("Gestión de reservas");
            alert2.setContentText("El aula que ha indicado no existe");
            alert2.showAndWait();
        }else if(listadoAulas.containsKey(txtAula)){
            try{
                LocalDate.parse(txtFecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }catch (Exception ex) {
                Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
                alert3.setHeaderText("Error en la reserva");
                alert3.setTitle("Gestión de reservas");
                alert3.setContentText("El formato de fecha no es el correcto");
                alert3.showAndWait();
            }
            }else{

            Reserva reservaPosible = new Reserva(
                    listadoAulas.get(txtAula),
                    LocalDate.parse(txtFecha, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    txtHora,
                    txtProfesor);
            listadoReservas.put(reservaPosible.getAula().getNombre(), reservaPosible);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Gestión de reservas");
            alert.setTitle("Reserva realizada");
            alert.setContentText(reservaPosible.toString());
            alert.showAndWait();
        }
    }


    private void cargarAulas(Map<String,Aula> listadoAulas) {
        //La carga de aulas se hará a través del fichero aulas.txt que tiene la estructura:
        //nombre;capacidad;proyector;ordenador;observaciones
        try{
            BufferedReader reader = new BufferedReader(new FileReader("aulas.txt"));
            String linea = reader.readLine();
            while(linea != null){
                String listaLinea[] = linea.split(";");
                listadoAulas.put(listaLinea[0], new Aula(listaLinea[0], Integer.parseInt(listaLinea[1]),listaLinea[2], listaLinea[3],listaLinea[4]));
                linea = reader.readLine();
            }
            reader.close();
        }catch(IOException e){
            System.err.println("Error en la carga de las aulas");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}