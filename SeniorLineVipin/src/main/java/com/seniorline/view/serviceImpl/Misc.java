package com.seniorline.view.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.seniorline.screenconstant.ScreenConstant;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

public class Misc {

	public static byte[] convertImageIntobyteArray(ImageView logo) {
		byte[] imagesBytes = null;

		try {
			ByteArrayOutputStream s = new ByteArrayOutputStream();
			BufferedImage bImage = SwingFXUtils.fromFXImage(logo.getImage(), null);
			ImageIO.write(bImage, "png", s);
			imagesBytes = s.toByteArray();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return imagesBytes;
	}

	public static File writeByte(byte[] bytes) {
		String FILEPATH = ScreenConstant.CAPTURE_IMAGE_BASE + "default.jpg";
		File file = new File(FILEPATH);
		try {
			if (file.exists()) {
				file.delete();
			}
			OutputStream os = new FileOutputStream(file);
			os.write(bytes);
			System.out.println("Successfully" + " byte inserted");
			os.close();
		}

		catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return file;
	}

}
