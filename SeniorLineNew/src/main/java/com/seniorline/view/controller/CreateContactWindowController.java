package com.seniorline.view.controller;

import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.seniorline.screenconstant.ScreenConstant;
import com.seniorline.view.controller.service.ControllerI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class CreateContactWindowController implements Initializable, ControllerI {

	@FXML
	AnchorPane anchorPane;

	@FXML
	Text textContact;
	

	@FXML
	JFXTextField textContact1;
	
	@FXML
	TextField textContact2;
	
//	@FXML
//	Circle circleImage;

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
//		circleImage.setFill(new ImagePattern(profileImage));
		anchorPane.setStyle("-fx-background-image:  url('" + ScreenConstant.IMAGE_BASE
				+ "createContactBg.png'); -fx-background-position: center center;");
	}

}
