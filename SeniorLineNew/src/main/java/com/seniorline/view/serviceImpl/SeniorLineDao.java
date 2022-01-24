package com.seniorline.view.serviceImpl;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seniorline.beans.Contact;

import javafx.scene.image.Image;

public class SeniorLineDao {

	public static void main(String[] args) {
		// test();
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Contact> parseJsonDataToList(String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		try {
			HashMap<String, Object> o = objectMapper.readValue(data, typeRef);
			List<Object> dataList = (ArrayList<Object>) o.get("data");
			for (Object obj : dataList) {
				LinkedHashMap<String, String> pair = (LinkedHashMap<String, String>) obj;
				Contact contact = new Contact();
				contact.setTitle(pair.get("title"));
				contact.setContactName(pair.get("contactName"));
				Object objs = pair.get("contactNumber");
				contact.setContactNumber((Long) objs);
				String img = pair.get("image");
				contact.setImage((String) img);
				contactList.add(contact);
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contactList;
	}

	public static Image parsebase64StringToImage(String base64String) {
		byte[] imageBytes = Base64.getDecoder().decode(base64String);
		InputStream in = new ByteArrayInputStream(imageBytes);
		Image image = new Image(in);
		// try {
		// BufferedImage bi = ImageIO.read(in);
		// bi = resizeImage(bi, 150, 150);
		//// image = convertBufferedImageToImage(bi);
		// } catch (IO e) {
		// e.printStackTrace();
		// }
		return image;

	}

	public static Image parsebase64StringToImageNew(String base64String) {
		String reSizedImageData = SeventyPercentBase64(base64String);
		return parsebase64StringToImage(reSizedImageData);
	}

	public static String SeventyPercentBase64(String in_image) {

		String imageData = in_image;
		byte[] dta = Base64.getDecoder().decode(imageData);
		InputStream in = new ByteArrayInputStream(dta);
		try {
			BufferedImage fullSize = ImageIO.read(in);

			// Create a new image .7 the size of the original image
			double newheight_db = 64;//fullSize.getHeight() * .7;
			double newwidth_db = 64;//fullSize.getWidth() * .7;

			int newheight = (int) newheight_db;
			int newwidth = (int) newwidth_db;

			BufferedImage resized = new BufferedImage(newwidth, newheight, BufferedImage.SCALE_REPLICATE);

			Graphics2D g2 = (Graphics2D) resized.getGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

			// draw fullsize image to resized image
			g2.drawImage(fullSize, 0, 0, newwidth, newheight, null);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(resized, "png", baos);
			baos.flush();
			byte[] resizedInByte = baos.toByteArray();
			// Base64Encoder enc_resized = new Base64Encoder();
			// Base64
			String out_image = Base64.getEncoder().encodeToString(resizedInByte);

			return out_image;

		} catch (IOException e) {
			System.out.println("error resizing screenshot" + e.toString());
			return "";
		}
	}

}
