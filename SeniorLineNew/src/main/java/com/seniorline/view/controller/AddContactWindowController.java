package com.seniorline.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.seniorline.screenconstant.ScreenConstant;
import com.seniorline.view.controller.service.ControllerI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class AddContactWindowController implements Initializable, ControllerI {

	@FXML
	AnchorPane anchorPane;

	@FXML
	JFXButton addContact;
	@FXML
	JFXButton callAContact;
	@FXML
	JFXButton activities;
	@FXML
	JFXButton scheduleAppointment;
	@FXML
	JFXButton healthStatus;
	@FXML
	JFXButton profile;
	@FXML
	JFXButton calendar;
	@FXML
	JFXButton document;

	@FXML
	Circle circleImage;

	// @FXML
	// ImageView profile_photo;

	Image profileImage = new Image(ScreenConstant.IMAGE_BASE + "Rectangle.png");

	Image img1 = new Image(ScreenConstant.IMAGE_BASE + "AddContactNew.png");
	Image img2 = new Image(ScreenConstant.IMAGE_BASE + "CallAContactNew.png");
	Image img3 = new Image(ScreenConstant.IMAGE_BASE + "ActivitiesNew.png");
	Image img4 = new Image(ScreenConstant.IMAGE_BASE + "HealthStatusUpdateNew.png");
	Image img5 = new Image(ScreenConstant.IMAGE_BASE + "ScheduleAppointmentNew.png");
	Image img6 = new Image(ScreenConstant.IMAGE_BASE + "ProfileNew.png");
	Image img7 = new Image(ScreenConstant.IMAGE_BASE + "CalendarNew.png");
	Image img8 = new Image(ScreenConstant.IMAGE_BASE + "DocumentNew.png");

	ImageView view1 = new ImageView(img1);
	ImageView view2 = new ImageView(img2);
	ImageView view3 = new ImageView(img3);
	ImageView view4 = new ImageView(img4);
	ImageView view5 = new ImageView(img5);
	ImageView view6 = new ImageView(img6);
	ImageView view7 = new ImageView(img7);
	ImageView view8 = new ImageView(img8);

	public void init(MainController mainController) {
		// TODO Auto-generated method stub

	}

	public void handleActionControl(String control) {
		// TODO Auto-generated method stub

	}

	public void initialize(URL location, ResourceBundle resources) {
		circleImage.setFill(new ImagePattern(profileImage));
		anchorPane.setStyle("-fx-background-image:  url('" + ScreenConstant.IMAGE_BASE
				+ "bg-1.png'); -fx-background-position: center center;");
		addContact.setText("");
		callAContact.setText("");
		activities.setText("");
		scheduleAppointment.setText("");
		healthStatus.setText("");
		profile.setText("");
		calendar.setText("");
		document.setText("");

		view1.setFitHeight(80);
		view1.setFitWidth(200);
		view1.setPreserveRatio(true);
		addContact.setGraphic(view1);

		view2.setFitHeight(80);
		view2.setFitWidth(200);
		view2.setPreserveRatio(true);
		callAContact.setGraphic(view2);

		view3.setFitHeight(80);
		view3.setFitWidth(200);
		view3.setPreserveRatio(true);
		activities.setGraphic(view3);

		view4.setFitHeight(80);
		view4.setFitWidth(200);
		view4.setPreserveRatio(true);
		healthStatus.setGraphic(view4);

		view5.setFitHeight(80);
		view5.setFitWidth(200);
		view5.setPreserveRatio(true);
		scheduleAppointment.setGraphic(view5);

		view6.setFitHeight(80);
		view6.setFitWidth(200);
		view6.setPreserveRatio(true);
		profile.setGraphic(view6);

		view7.setFitHeight(80);
		view7.setFitWidth(200);
		view7.setPreserveRatio(true);
		calendar.setGraphic(view7);

		view8.setFitHeight(80);
		view8.setFitWidth(200);
		view8.setPreserveRatio(true);
		document.setGraphic(view8);

	}

}
