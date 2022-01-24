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
import com.seniorline.view.controller.service.ScreenAnimationHandler;
import com.seniorline.view.controller.service.ScreenAnimationHandlerService;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Virendra Gupta
 */
public class FirstWindowController implements Initializable, ControllerI {

	@FXML
	private AnchorPane TARE_ROOT_ANCHORPANE;

	private MainController mainController;

	private static final Logger logger = Logger.getLogger(FirstWindowController.class.getName());

	/**
	 * Initializes the controller class.
	 */
	public void initialize(URL url, ResourceBundle rb) {
		changeScreenAuto();
	}

	private void changeScreenAuto() {
		ScreenAnimationHandlerService screenAnimationHandlerService = new ScreenAnimationHandlerService(
				new ScreenAnimationHandler() {
					public void initScreen(final String screenUri) {
						Platform.runLater(new Runnable() {

							public void run() {
								handleActionControl(screenUri);
								System.out.println("changeScreenAuto()");
							}
						});
					}
				}, ScreenConstant.ScreenLinks.SECOND_WINDOW);
		screenAnimationHandlerService.start();
		screenAnimationHandlerService.stop();
	}

	@FXML
	private void onMouseClicked(MouseEvent event) {
		String controllId = mainController.getSourceId(event);
		handleActionControl(controllId);
	}

	public void handleActionControl(String control) {
		this.mainController.loadScreen(ScreenConstant.ScreenLinks.SECOND_WINDOW);
	}

	public void init(MainController mainController) {
		this.mainController = mainController;
	}
}
