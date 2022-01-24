/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorline.view.controller;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.github.sarxos.webcam.Webcam;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Virendra Gupta
 */
public class CaptureWindowNewController  implements Initializable {

	
	@FXML
	private AnchorPane bpWebCamPaneHolder;
	@FXML
	private ImageView imgWebCamCapturedImage;
	@FXML
	private Button btnStartCamera;
	@FXML
	private Font x1;
	@FXML
	private Button btnDisposeCamera;
	@FXML
	private Font x11;

	private boolean stopCamera = false;
	private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();
	Image mainiamge;
	private Webcam selWebCam = null;
	private BufferedImage grabbedImage;
	private SecondWindowController secondWindowController;
	private static final Logger logger = Logger.getLogger(CaptureWindowNewController.class.getName());
	/**
	 * Initializes the controller class.
	 */
	@SuppressWarnings("restriction")
	public void initialize(URL url, ResourceBundle rb) {
		try {
			initializeWebCam(0);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error: "+e);
		}

		Platform.runLater(new Runnable() {
			public void run() {
				// userData = (String) fpBottomPane.getScene().getWindow().getUserData();
				setImageViewSize();
			}
		});
	}

	protected void setImageViewSize() {

		double height = bpWebCamPaneHolder.getHeight();
		double width = bpWebCamPaneHolder.getWidth();
		imgWebCamCapturedImage.setFitHeight(height);
		imgWebCamCapturedImage.setFitWidth(width);
		imgWebCamCapturedImage.prefHeight(height);
		imgWebCamCapturedImage.prefWidth(width);
		imgWebCamCapturedImage.setPreserveRatio(true);

	}

	protected void initializeWebCam(final int webCamIndex) {

		Task<Void> webCamIntilizer = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				if (selWebCam == null) {
					// selWebCam = Webcam.getWebcams().get(webCamIndex);
					selWebCam = Webcam.getDefault();
					selWebCam.open();
				} else {
					closeCamera();
					// selWebCam = Webcam.getWebcams().get(webCamIndex);
					selWebCam = Webcam.getDefault();
					selWebCam.open();

				}
				startWebCamStream();
				return null;
			}

		};

		new Thread(webCamIntilizer).start();
		// fpBottomPane.setDisable(false);
		// btnProceedCamera.setDisable(true);
		// btnResetCamera.setDisable(true);
	}

	protected void startWebCamStream() {

		stopCamera = false;
		Task<Void> task = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				while (!stopCamera) {
					try {
						if ((grabbedImage = selWebCam.getImage()) != null) {

							Platform.runLater(new Runnable() {
								public void run() {
									mainiamge = SwingFXUtils.toFXImage(grabbedImage, null);
									imageProperty.set(mainiamge);
								}
							});

							grabbedImage.flush();

						}
					} catch (Exception e) {
						logger.info("Error: "+e);
					} finally {

					}

				}

				return null;

			}

		};
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
		imgWebCamCapturedImage.imageProperty().bind(imageProperty);

	}

	private void closeStage() {
		closeCamera();
		((Stage) bpWebCamPaneHolder.getScene().getWindow()).close();
	}

	private void closeCamera() {
		if (selWebCam != null) {
			selWebCam.close();
		}
	}

	public void proceed() {
//		ImageSelection.getImageSelectionInstance().setImage(imgWebCamCapturedImage.getImage());
//		SecondWindowController apc = new SecondWindowController();
//		apc.doAll();
		closeStage();
	}

	public void proceedToAddPartner() {

	}

	public void stopCamera(ActionEvent event) {
		stopCamera = true;
		btnStartCamera.setDisable(true);
		// btnResetCamera.setDisable(false);

		// btnProceedCamera.setDisable(false);
		secondWindowController.setImage(mainiamge);
		// secondWindowController.doAll();
		// ImageSelection.getImageSelectionInstance().imageProperty()
		// .addListener((obs, oldImage, newImage) ->
		// secondWindowController.PHOTO_CHOOSER.setImage(newImage));
		closeStage();
	}

	public void startCamera(ActionEvent event) {
		stopCamera = false;
		startWebCamStream();
		btnStartCamera.setDisable(false);
		// btnResetCamera.setDisable(true);
		// btnProceedCamera.setDisable(true);
	}

	public void startCamera() {
		stopCamera = false;
		startWebCamStream();
		btnStartCamera.setDisable(false);
		// btnResetCamera.setDisable(true);
		// btnProceedCamera.setDisable(true);
	}

	public void disposeCamera(ActionEvent event) {
		stopCamera = true;
		// closeCamera();
		// Webcam.shutdown();
		// btnStopCamera.setDisable(true);
		// btnStartCamera.setDisable(true);
		closeStage();
	}

	public void init(SecondWindowController secondWindowController) {
		this.secondWindowController = secondWindowController;
	}
	
	public void stop() {
		closeStage();
	}


}
