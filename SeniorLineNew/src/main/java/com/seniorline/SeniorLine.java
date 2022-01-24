/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorline;

import java.awt.Dimension;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Logger;

import com.seniorline.screenconstant.ScreenConstant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author vicky
 */
public class SeniorLine extends Application {

	private static final Logger logger = Logger.getLogger(SeniorLine.class.getName());

	Scene scene;

	// @Override
	public void showMainStage(Stage initStage) throws IOException {
		// FXMLLoader fxmlLoader = new
		// FXMLLoader(getClass().getResource(ScreenConstant.ScreenLinks.MAIN_WINDOW));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ScreenConstant.ScreenLinks.CREATE_CONTACT_WINDOW));
		Parent root = fxmlLoader.load();
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		double widh = screenSize.getWidth();
		double heigt = screenSize.getHeight();
		scene = new Scene(root, widh, heigt);
		initStage.setScene(scene);
		initStage.setTitle("Senior-Line-Application " + ScreenConstant.VERSION);
		initStage.setMaximized(true);
		initStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage initStage) throws Exception {
		try {
			ServerSocket ss = null;
			try {
				ss = new ServerSocket(ScreenConstant.mutexPortNo);
				final ServerSocket ss1 = ss;
				new Thread(new Runnable() {
					public void run() {
						try {
							ss1.accept();
						} catch (IOException e) {
							e.printStackTrace();
							logger.info("Error: " + e);
						}
					}
				}).start();
			} catch (Exception ex) {
				ex.printStackTrace();
				logger.info("Error: " + ex);
			}

			if (ss != null) {
				showMainStage(initStage);
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Multiple Instances runnig");
				alert.setContentText("please close running instance");
				alert.showAndWait();
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("Error: " + e);
		}
	}

	private void closePariparrels() {
		System.exit(0);
	}

	@Override
	public void stop() {
		closePariparrels();
	}
}
