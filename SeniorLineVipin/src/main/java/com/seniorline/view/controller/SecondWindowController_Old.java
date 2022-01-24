/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorline.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.seniorline.screenconstant.ScreenConstant;
import com.seniorline.view.controller.service.ControllerI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Virendra Gupta
 */
public class SecondWindowController_Old implements Initializable, ControllerI {

	@FXML
	private AnchorPane TARE_ROOT_ANCHORPANE;
	@FXML
	private ImageView PHOTO_CHOOSER;
	@FXML
	private JFXButton ENGLISH_LANG;
	@FXML
	private JFXButton FRENCH_LANG;
	@FXML
	private JFXButton DEUTSCH_LANG;
	@FXML
	private JFXButton CONSUMER_SETTING;
	@FXML
	private JFXButton ENTERPRISE_SETTING;

	private MainController mainController;

	/**
	 * Initializes the controller class.
	 */
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	@FXML
	private void onMousePressed(MouseEvent event) {
	}

	@FXML
	private void onKeyPressed(MouseEvent event) {
	}

	@FXML
	private void onMouseClicked(MouseEvent event) {
		String controllId = mainController.getSourceId(event);
		handleActionControl(controllId);
	}

	public void init(MainController mainController) {
		this.mainController = mainController;
	}

	public void handleActionControl(String control) {
		String controlId = control.toUpperCase();
		if (control.equalsIgnoreCase("ENTERPRISE_SETTING")) {
			this.mainController.loadScreen(ScreenConstant.ScreenLinks.THIRD_WINDOW);
		} else if (control.equalsIgnoreCase("PHOTO_CHOOSER")) {
			openDialogWindow();
		}
	}
	// public void doAll() {
	// ImageSelection.getImageSelectionInstance().imageProperty()
	// .addListener((obs, oldImage, newImage) -> PHOTO_CHOOSER.setImage(newImage));
	// }

	public void setImage(final Image imagse) {
		Platform.runLater(new Runnable() {
			public void run() {
				PHOTO_CHOOSER.setImage(imagse);
			}
		});
	}

	// public void takePhoto() {
	// try {
	// Stage dialogStage = new Stage(StageStyle.UNDECORATED);
	// BorderPane root =
	// FXMLLoader.load(getClass().getResource(ScreenConstant.ScreenLinks.WEBCAM_WINDOW));
	// Scene scene = new Scene(root, 650, 390);
	// dialogStage.setUserData("fromAddParent");
	// dialogStage.initModality(Modality.APPLICATION_MODAL);
	// dialogStage.setScene(scene);
	// dialogStage.show();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	public void openDialogWindow() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ScreenConstant.ScreenLinks.WEBCAM_WINDOW));
		Parent currentWindow;
		try {
			currentWindow = fxmlLoader.load();
			// CaptureWindowController dialogController =
			// fxmlLoader.<CaptureWindowController>getController();
			CaptureWindowNewController dialogController = fxmlLoader.<CaptureWindowNewController>getController();
//			dialogController.init(this);
			Scene scene = new Scene(currentWindow, 415, 390);
			Stage stage = new Stage(StageStyle.UNDECORATED);
			stage.setScene(scene);
			stage.setTitle(ScreenConstant.ScreenTitle.WEBCAM_SCREEN);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Profile Picture");
			stage.setResizable(false);
			stage.showAndWait();
		} catch (IOException ex) {
		}
	}
}
