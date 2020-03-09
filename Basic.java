package com.engineering;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Basic extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX���ۺ�Ӧ��");
    	BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 750, Color.WHITE);

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        //��һ���˵� 
        Menu sortMenu = new Menu("�����㷨��Javaʵ��");
        MenuItem bubbleMenuItem = new MenuItem("ð������");
        bubbleMenuItem.setOnAction(actionEvent -> {
        	BubbleSort bs = new BubbleSort();
        	bs.start(new Stage());
        });        
        MenuItem selectMenuItem = new MenuItem("ѡ������");
        selectMenuItem.setOnAction(actionEvent -> {
        	SelectSort ss = new SelectSort();
        	ss.start(new Stage());
        });
        
        MenuItem quickMenuItem = new MenuItem("��������");
        quickMenuItem.setOnAction(actionEvent -> {
        	QuickSort.quickSortStart();        	
        });
        
        MenuItem heapMenuItem = new MenuItem("������");
        heapMenuItem.setOnAction(actionEvent -> {
        	HeapSort.heapSortStart();
        });
        
        MenuItem mergeMenuItem = new MenuItem("�鲢����");
        mergeMenuItem.setOnAction(actionEvent -> {
        	MergeSort ms = new MergeSort();
        	ms.start(new Stage());
        });
        
        MenuItem exitMenuItem = new MenuItem("�˳�ϵͳ");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        sortMenu.getItems().addAll(bubbleMenuItem, selectMenuItem,quickMenuItem,
                new SeparatorMenuItem(),heapMenuItem ,mergeMenuItem,
                new SeparatorMenuItem(),exitMenuItem);        
        
        Menu dataStructureMenu = new Menu("�����㷨��Ӧ��");
        MenuItem twoWayLinkedList = new MenuItem("˫������");
        twoWayLinkedList.setOnAction(actionEvent -> {
        	TwoWayLinkedList twl = new TwoWayLinkedList();
        	twl.start(new Stage());
        });
        
        MenuItem stackDemo = new MenuItem("ջ");
        stackDemo.setOnAction(actionEvent -> {
        	StackDemo sd = new StackDemo();
        	sd.start(new Stage());
        });
        
        MenuItem queueDemo = new MenuItem("����");
        queueDemo.setOnAction(actionEvent -> {
        	QueueDemo qd = new QueueDemo();
        	qd.start(new Stage());
        });        
        
        dataStructureMenu.getItems().addAll(twoWayLinkedList, stackDemo, queueDemo,
        		new SeparatorMenuItem());
        
        Menu netWorkMenu = new Menu("������Ӧ��");
        MenuItem clientServer = new MenuItem("�ͻ���������ͨ�ż���Բ���");
        clientServer.setOnAction(actionEvent -> {
        	Server server = new Server();
        	server.start(new Stage());
        	Client client = new Client();
        	client.start(new Stage());
        });
        
        MenuItem interestRate = new MenuItem("�����������");
        interestRate.setOnAction(actionEvent -> {
        	InterestRateServer irs = new InterestRateServer();
        	irs.start(new Stage());
        	InterestRateClient irc = new InterestRateClient();
        	irc.start(new Stage());
        });        
        
        netWorkMenu.getItems().addAll(clientServer, interestRate);
        
        Menu gameMenu = new Menu("С��Ϸչʾ");
        MenuItem bounceBall = new MenuItem("�ɿ��Ƶĵ���");
        bounceBall.setOnAction(actionEvent -> {
        	BounceBallSlider bbs = new BounceBallSlider();
        	bbs.start(new Stage());
        });
        
        MenuItem clockAnimation = new MenuItem("�߶���ʱ��");
        clockAnimation.setOnAction(actionEvent -> {
        	ClockAnimated clockAnimated = new ClockAnimated();
        	clockAnimated.start(new Stage());
        });
        
        gameMenu.getItems().addAll(bounceBall, clockAnimation);

        menuBar.getMenus().addAll(sortMenu,dataStructureMenu,netWorkMenu, gameMenu);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
