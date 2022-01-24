/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorline.view.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.seniorline.beans.Contact;
import com.seniorline.view.controller.service.ControllerI;
import com.seniorline.view.serviceImpl.AccountServiceImpl;
import com.seniorline.view.serviceImpl.SeniorLineDao;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Virendra Gupta
 */
public class FourthWindowController implements Initializable, ControllerI {

	@FXML
	private AnchorPane TARE_ROOT_ANCHORPANE;

	@FXML
	public VBox VBOX_LIST;

	@FXML
	public ListView<Contact> listView;

	private MainController mainController;

	private final Image IMAGE_RUBY = new Image(
			"https://upload.wikimedia.org/wikipedia/commons/f/f1/Ruby_logo_64x64.png");
	// private final Image IMAGE_APPLE = new
	// Image("http://antaki.ca/bloom//img/mac_64x64.png");
	private final Image IMAGE_VISTA = new Image("http://antaki.ca/bloom/img/windows_64x64.png");
	private final Image IMAGE_TWITTER = new Image("http://antaki.ca/bloom//img/mac_64x64.png");

	private Image[] listOfImages = { IMAGE_RUBY, IMAGE_VISTA, IMAGE_TWITTER };

	ObservableList<String> items = null;

	private static final Logger logger = Logger.getLogger(FirstWindowController.class.getName());

	public void initialize(URL url, ResourceBundle rb) {
		String data = AccountServiceImpl.getAccountDetails((long) 1);
		if (data == null || data.isEmpty())
			return;
		ArrayList<Contact> dataList = SeniorLineDao.parseJsonDataToList(data);
		setContactDataList(dataList);
	}

	private void setContactDataList(ArrayList<Contact> dataList) {
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
							public void updateItem(Contact contactDeatils, boolean empty) {
								super.updateItem(contactDeatils, empty);
								if (empty) {
									setText(null);
									setGraphic(null);
								} else {
									// Image image =
									// SeniorLineDao.parsebase64StringToImage(contactDeatils.getImage());
									Image image = SeniorLineDao.parsebase64StringToImageNew(contactDeatils.getImage());
									imageView.setImage(image);
									setText(contactDeatils.getTitle() + " " + contactDeatils.getContactName() + "\n"
											+ contactDeatils.getContactNumber());
									setGraphic(imageView);
								}
							}

						};
					}
				});
				VBOX_LIST.setAlignment(Pos.CENTER);
			}
		});

	}

	public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight)
			throws IOException {
		BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = resizedImage.createGraphics();
		graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
		graphics2D.dispose();
		return resizedImage;
	}

	@FXML
	private void onMouseClicked(MouseEvent event) {
		String controllId = mainController.getSourceId(event);
		handleActionControl(controllId);

	}

	private Image convertBufferedImageToImage(BufferedImage bf) {
		WritableImage wr = null;
		if (bf != null) {
			wr = new WritableImage(bf.getWidth(), bf.getHeight());
			PixelWriter pw = wr.getPixelWriter();
			for (int x = 0; x < bf.getWidth(); x++) {
				for (int y = 0; y < bf.getHeight(); y++) {
					pw.setArgb(x, y, bf.getRGB(x, y));
				}
			}
		}
		return wr;
	}

	public void init(MainController mainController) {
		this.mainController = mainController;
	}

	public void handleActionControl(String control) {
		// TODO Auto-generated method stub

	}

}
