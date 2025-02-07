package com.ecommerce;

 import com.ecommerce.pedidos.Pedido;
 import com.ecommerce.pagamento.Pagamento;
 import javafx.animation.FadeTransition;
 import javafx.application.Application;
 import javafx.geometry.Insets;
 import javafx.geometry.Pos;
 import javafx.scene.Scene;
 import javafx.scene.control.*;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 import javafx.scene.layout.BorderPane;
 import javafx.scene.layout.GridPane;
 import javafx.scene.layout.VBox;
 import javafx.scene.paint.Color;
 import javafx.scene.text.Font;
 import javafx.scene.text.FontWeight;
 import javafx.stage.Stage;
 import javafx.util.Duration;
 
 public class Main extends Application {
     public static void main(String[] args) {
         launch(args);
     }
 
     @Override
     public void start(Stage primaryStage) {
         primaryStage.setTitle("Sistema de Compras Online");
 
         BorderPane root = new BorderPane();
         root.setStyle("-fx-background-color: #282c36;");
 
         VBox header = new VBox();
         header.setAlignment(Pos.CENTER);
         Label title = new Label("E-Commerce System");
         title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
         title.setTextFill(Color.WHITE);
         
         ImageView icon = new ImageView(new Image("file:icon.png"));
         icon.setFitWidth(80);
         icon.setFitHeight(80);
         
         header.getChildren().addAll(icon, title);
         root.setTop(header);
 
         GridPane grid = new GridPane();
         grid.setPadding(new Insets(20));
         grid.setVgap(10);
         grid.setHgap(10);
         grid.setAlignment(Pos.CENTER);
         
         Label labelId = new Label("ID do Pedido:");
         labelId.setTextFill(Color.WHITE);
         TextField idField = new TextField();
 
         Label labelValor = new Label("Valor do Pedido:");
         labelValor.setTextFill(Color.WHITE);
         TextField valorField = new TextField();
 
         Button btnCriarPedido = new Button("Criar Pedido");
         btnCriarPedido.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
         Label statusLabel = new Label();
         statusLabel.setTextFill(Color.LIGHTGRAY);
 
         btnCriarPedido.setOnAction(e -> {
             int id = Integer.parseInt(idField.getText());
             double valor = Double.parseDouble(valorField.getText());
             Pedido pedido = new Pedido(id, valor);
             statusLabel.setText("Pedido criado com status: " + pedido.getStatus());
             fadeEffect(statusLabel);
         });
 
         Button btnPagar = new Button("Processar Pagamento");
         btnPagar.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
         btnPagar.setOnAction(e -> {
             double valor = Double.parseDouble(valorField.getText());
             if (Pagamento.processarPagamento(valor)) {
                 statusLabel.setText("Pagamento realizado com sucesso!");
                 fadeEffect(statusLabel);
             }
         });
 
         grid.add(labelId, 0, 1);
         grid.add(idField, 1, 1);
         grid.add(labelValor, 0, 2);
         grid.add(valorField, 1, 2);
         grid.add(btnCriarPedido, 0, 3);
         grid.add(btnPagar, 1, 3);
         grid.add(statusLabel, 0, 4, 2, 1);
 
         root.setCenter(grid);
         
         Scene scene = new Scene(root, 500, 400);
         primaryStage.setScene(scene);
         primaryStage.show();
     }
 
     private void fadeEffect(Label label) {
         FadeTransition fade = new FadeTransition(Duration.seconds(1.5), label);
         fade.setFromValue(0);
         fade.setToValue(1);
         fade.play();
     }
 }
 
 // Classe para representar um Pedido
 package com.ecommerce.pedidos;
 
 public class Pedido {
     private int id;
     private double valorTotal;
     private String status;
 
     public Pedido(int id, double valorTotal) {
         this.id = id;
         this.valorTotal = valorTotal;
         this.status = "Pendente";
     }
 
     public void processarPagamento() {
         this.status = "Pago";
         System.out.println("Pagamento processado para o pedido " + id);
     }
     
     public String getStatus() {
         return status;
     }
 }
 
 // Classe para integração de pagamento
 package com.ecommerce.pagamento;
 
 public class Pagamento {
     public static boolean processarPagamento(double valor) {
         System.out.println("Processando pagamento de R$ " + valor);
         return true; // Simulação de pagamento bem-sucedido
     }
 }
 