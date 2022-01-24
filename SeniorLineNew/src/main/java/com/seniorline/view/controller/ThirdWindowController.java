/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorline.view.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.seniorline.screenconstant.ScreenConstant;
import com.seniorline.view.controller.service.ControllerI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Virendra Gupta
 */
public class ThirdWindowController implements Initializable, ControllerI {

	@FXML
	private AnchorPane TARE_ROOT_ANCHORPANE;
	@FXML
	private Button CARES;
	@FXML
	private Button DOCTOR;
	@FXML
	private Button NURSE;
	@FXML
	private Button ACTIVITY_GIRL;
	@FXML
	private Button MANAGER;
	@FXML
	private Button SENIOR;
	@FXML
	private Button SENIOR_RELATIVE;
	private MainController mainController;

	private static final Logger logger = Logger.getLogger(ThirdWindowController.class.getName());
	/**
	 * Initializes the controller class.
	 */
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
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
		this.mainController.loadScreen(ScreenConstant.ScreenLinks.FOURTH_WINDOW);
	}
}
