/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorline.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.seniorline.logger.RFLogger;
import com.seniorline.misc.TokenManager;
import com.seniorline.screenconstant.ScreenConstant;
import com.seniorline.view.controller.service.ControllerI;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Virendra Gupta
 */
public class MainController implements Initializable {

	@FXML
	private BorderPane mainForm;

	@FXML
	private Label labelBlockingReason;
	@FXML
	private Button CONTROL_MANUAL;

	private AnchorPane centerView = null;

	public static ControllerI currentViewController = null;

	private static final Logger logger = Logger.getLogger(MainController.class.getName());

	/**
	 * Initializes the controller class.
	 */
	public void initialize(URL url, ResourceBundle rb) {
		initLogger();
		loadScreen(ScreenConstant.ScreenLinks.FIRST_WINDOW);

	}

	private void initLogger() {
		if (!TokenManager.isDebug) {
			RFLogger.init();
			RFLogger.RouteStdOutErrToFile();
		}
	}

	@FXML
	private void onControlKeyPress(KeyEvent event) {
	}

	@FXML
	private void controlItemClicked(MouseEvent event) {
	}

	public void loadScreen(String fxmlUrl) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlUrl));
			this.centerView = fxmlLoader.load();
			this.currentViewController = fxmlLoader.getController();
			this.currentViewController.init(this);
			mainForm.setCenter(centerView);
			// mainForm.getChildren().add(centerView);
		} catch (IOException ex) {
			logger.info("Error: " + ex);
		}
	}

	public String getSourceId(Event event) {
		if (event == null) {
			return null;
		}
		String controllerId = null;
		if (event.getTarget() instanceof JFXTextField) {
			controllerId = ((JFXTextField) event.getSource()).getId();
		} else if (event.getTarget() instanceof JFXComboBox) {
			controllerId = ((JFXComboBox) event.getSource()).getId();
		} else if (event.getTarget() instanceof JFXCheckBox) {
			controllerId = ((JFXCheckBox) event.getSource()).getId();
		} else if (event.getTarget() instanceof JFXButton) {
			controllerId = ((JFXButton) event.getSource()).getId();
		} else if (event.getTarget() instanceof Button) {
			controllerId = ((Button) event.getSource()).getId();
		} else if (event.getTarget() instanceof TextField) {
			controllerId = ((TextField) event.getSource()).getId();
		} else if (event.getTarget() instanceof ComboBox) {
			controllerId = ((ComboBox) event.getSource()).getId();
		} else if (event.getTarget() instanceof CheckBox) {
			controllerId = ((CheckBox) event.getSource()).getId();
		} else if (event.getTarget() instanceof JFXTextArea) {
			controllerId = ((JFXTextArea) event.getSource()).getId();
		} else if (event.getSource() instanceof Button) {
			controllerId = ((Button) event.getSource()).getId();
		} else if (event.getSource() instanceof ImageView) {
			controllerId = ((ImageView) event.getSource()).getId();
		} else {
			if (event.getSource() instanceof JFXButton) {
				controllerId = ((JFXButton) event.getSource()).getId();
			}
		}
		return controllerId;
	}

	Object getSource(Event event) {
		if (event == null) {
			return null;
		}
		Object control = null;
		if (event.getTarget() instanceof JFXTextField) {
			control = (JFXTextField) event.getSource();
		} else if (event.getTarget() instanceof JFXComboBox) {
			control = (JFXComboBox) event.getSource();
		} else if (event.getTarget() instanceof JFXCheckBox) {
			control = (JFXCheckBox) event.getSource();
		} else if (event.getTarget() instanceof JFXButton) {
			control = (JFXButton) event.getSource();
		} else if (event.getTarget() instanceof Button) {
			control = (Button) event.getSource();
		} else if (event.getTarget() instanceof TextField) {
			control = (TextField) event.getSource();
		} else if (event.getTarget() instanceof ComboBox) {
			control = (ComboBox) event.getSource();
		} else if (event.getTarget() instanceof CheckBox) {
			control = (CheckBox) event.getSource();
		}
		return control;
	}
}
