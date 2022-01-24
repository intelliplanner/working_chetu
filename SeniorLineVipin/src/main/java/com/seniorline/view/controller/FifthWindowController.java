package com.seniorline.view.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.seniorline.beans.Contact;
import com.seniorline.view.controller.service.ControllerI;
import com.seniorline.view.serviceImpl.AccountServiceImpl;
import com.seniorline.view.serviceImpl.SeniorLineDao;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class FifthWindowController implements Initializable, ControllerI {

	@FXML
	private AnchorPane ROOT_ANCHORPANE;

	@FXML
	public VBox VBOX_LIST;

	private JFXButton actionBtn;

	@FXML
	public ListView<Contact> listView;

	private MainController mainController;

	ObservableList<String> items = null;

	private static final Logger logger = Logger.getLogger(FifthWindowController.class.getName());

	/**
	 * Initializes the controller class.
	 */

	public void initialize(URL url, ResourceBundle rb) {
		System.out.println("Fifth Screen Initialize");
		String data = AccountServiceImpl.getAllContacts();
		if (data == null || data.isEmpty())
			return;
		ArrayList<Contact> dataList = SeniorLineDao.parseJsonDataToList(data);
		setContactDataList(dataList);
	}

	private void setContactDataList(ArrayList<Contact> dataList) {
		// JFXButton favouriteButton = new JFXButton();
		// favouriteButton.setText("Favourite");
		ObservableList<Contact> items = FXCollections.observableArrayList();
		for (Contact contact : dataList) {
			items.add(contact);
		}
		listView.setItems(items);
		Platform.runLater(new Runnable() {

			public void run() {
				listView.setCellFactory(new Callback<ListView<Contact>, ListCell<Contact>>() {
					public ListCell<Contact> call(ListView<Contact> param) {
						return new ListCell<Contact>() {
							private ImageView imageView = new ImageView();

							@Override
							public void updateItem(final Contact contactDeatils, boolean empty) {
								super.updateItem(contactDeatils, empty);
								if (empty) {
									setText(null);
									setGraphic(null);
								} else { // Image image =
									HBox hbox = new HBox();
									hbox.setPadding(new Insets(5, 12, 5, 5));
									hbox.setSpacing(15);
									hbox.setAlignment(Pos.CENTER);

									actionBtn = new JFXButton("Favourite");
									actionBtn.setStyle(
											"-fx-background-color:#d6d6c2;-fx-stroke: white;-fx-stroke-width: 1;-fx-border-radius: 15;-fx-padding: 0 0 0 0;-fx-pref-width:80px;-fx-pref-height: 50px;");
									SeniorLineDao.parsebase64StringToImage(contactDeatils.getImage());
									Image image = SeniorLineDao.parsebase64StringToImageNew(contactDeatils.getImage());
									imageView.setImage(image);
									Label label = new Label(
											contactDeatils.getTitle() + " " + contactDeatils.getContactName() + "\n"
													+ contactDeatils.getContactNumber());
									label.setStyle(
											"-fx-font: 14px Serif;	-fx-alignment: TOP_LEFT;-fx-prompt-text-fill: black;-fx-text-fill: #000000;-fx-stroke-width: 1;-fx-pref-width: 120px;-fx-pref-height: 70px;");
									actionBtn.setOnAction(new EventHandler<ActionEvent>() {
										public void handle(ActionEvent event) {
											handleActionControl(contactDeatils.getContactName());
										}
									});

									hbox.getChildren().add(imageView);
									hbox.getChildren().add(label);
									hbox.getChildren().add(actionBtn);
									setGraphic(hbox);
								}
							}

						};
					}
				});
				VBOX_LIST.setAlignment(Pos.CENTER);
			}
		});

	}

	@FXML
	private void onMouseClicked(MouseEvent event) {
		String controllId = mainController.getSourceId(event);
		handleActionControl(controllId);
	}

	public void handleActionControl(String control) {
		System.out.println(control);
	}

	public void init(MainController mainController) {
		this.mainController = mainController;
	}
}