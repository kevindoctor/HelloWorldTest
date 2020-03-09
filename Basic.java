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
        primaryStage.setTitle("JavaFX的综合应用");
    	BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 750, Color.WHITE);

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        //第一个菜单 
        Menu sortMenu = new Menu("排序算法的Java实现");
        MenuItem bubbleMenuItem = new MenuItem("冒泡排序法");
        bubbleMenuItem.setOnAction(actionEvent -> {
        	BubbleSort bs = new BubbleSort();
        	bs.start(new Stage());
        });        
        MenuItem selectMenuItem = new MenuItem("选择排序法");
        selectMenuItem.setOnAction(actionEvent -> {
        	SelectSort ss = new SelectSort();
        	ss.start(new Stage());
        });
        
        MenuItem quickMenuItem = new MenuItem("快速排序法");
        quickMenuItem.setOnAction(actionEvent -> {
        	QuickSort.quickSortStart();        	
        });
        
        MenuItem heapMenuItem = new MenuItem("堆排序法");
        heapMenuItem.setOnAction(actionEvent -> {
        	HeapSort.heapSortStart();
        });
        
        MenuItem mergeMenuItem = new MenuItem("归并排序法");
        mergeMenuItem.setOnAction(actionEvent -> {
        	MergeSort ms = new MergeSort();
        	ms.start(new Stage());
        });
        
        MenuItem exitMenuItem = new MenuItem("退出系统");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        sortMenu.getItems().addAll(bubbleMenuItem, selectMenuItem,quickMenuItem,
                new SeparatorMenuItem(),heapMenuItem ,mergeMenuItem,
                new SeparatorMenuItem(),exitMenuItem);        
        
        Menu dataStructureMenu = new Menu("其它算法的应用");
        MenuItem twoWayLinkedList = new MenuItem("双向链表");
        twoWayLinkedList.setOnAction(actionEvent -> {
        	TwoWayLinkedList twl = new TwoWayLinkedList();
        	twl.start(new Stage());
        });
        
        MenuItem stackDemo = new MenuItem("栈");
        stackDemo.setOnAction(actionEvent -> {
        	StackDemo sd = new StackDemo();
        	sd.start(new Stage());
        });
        
        MenuItem queueDemo = new MenuItem("队列");
        queueDemo.setOnAction(actionEvent -> {
        	QueueDemo qd = new QueueDemo();
        	qd.start(new Stage());
        });        
        
        dataStructureMenu.getItems().addAll(twoWayLinkedList, stackDemo, queueDemo,
        		new SeparatorMenuItem());
        
        Menu netWorkMenu = new Menu("网络编程应用");
        MenuItem clientServer = new MenuItem("客户机服务器通信计算圆面积");
        clientServer.setOnAction(actionEvent -> {
        	Server server = new Server();
        	server.start(new Stage());
        	Client client = new Client();
        	client.start(new Stage());
        });
        
        MenuItem interestRate = new MenuItem("贷款问题计算");
        interestRate.setOnAction(actionEvent -> {
        	InterestRateServer irs = new InterestRateServer();
        	irs.start(new Stage());
        	InterestRateClient irc = new InterestRateClient();
        	irc.start(new Stage());
        });        
        
        netWorkMenu.getItems().addAll(clientServer, interestRate);
        
        Menu gameMenu = new Menu("小游戏展示");
        MenuItem bounceBall = new MenuItem("可控制的弹球");
        bounceBall.setOnAction(actionEvent -> {
        	BounceBallSlider bbs = new BounceBallSlider();
        	bbs.start(new Stage());
        });
        
        MenuItem clockAnimation = new MenuItem("走动的时钟");
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
