/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorline.screenconstant;

/**
 *
 * @author vicky
 */
public class ScreenConstant {
	public static final int mutexPortNo = 16000;
	public static final String VERSION = "1.0";
	public static final String DATE_FORMAT_DDMMYYYY_HHMM = "dd/MM/yyyy HH:mm";
	public static final String DATE_FORMAT_DDMMYYYY_HHMMSS = DATE_FORMAT_DDMMYYYY_HHMM + ":ss";
	public static final String MYSQL_FORMAT_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_DDMMYY = "dd-MM-yyyy";
	public static final String TIME_FORMAT_HHMMSS = "HH:mm:ss";
	public static final String BASE = "/com/seniorline/view/ui/";// com.ipssi.ppgcl.ui.view
	public static final String BASE_NEW = "/com/seniorline/view/ui_new/";
	public static final String IMAGE_BASE = "/images/";

	public static String SAVE_FAILER_MESSAGE = "Some Exception occurs, unable to process your request\nplease try again";

	public static class SCREEN_IMAGES {
		public static final String APPLICATION_ICON = IMAGE_BASE + "logo_seniorline.png";
	}

	public static class ScreenLinks {
		public static final String MAIN_WINDOW = BASE + "MainWindowNew.fxml";
		
		public static final String FIRST_WINDOW = BASE + "FirstWindow.fxml";
		public static final String SECOND_WINDOW = BASE + "SecondWindow.fxml";
		public static final String THIRD_WINDOW = BASE + "ThirdWindow.fxml";
		public static final String FOURTH_WINDOW = BASE + "FourthWindow.fxml";
		public static final String WEBCAM_WINDOW = BASE + "CaptureImageNew.fxml";
		public static final String ADD_CONTACT_WINDOW = BASE_NEW + "AddContactWindow.fxml";
		public static final String CREATE_CONTACT_WINDOW = BASE_NEW + "CreateContactWindow.fxml";
	}

	public static class ScreenTitle {
		public static final String WELCOME_SCREEN_WINDOW = "WELCOME_SCREEN_WINDOW";
		public static final String FIRST_SCREEN = "FIRST_SCREEN";
		public static final String SECOND_SCREEN = "SECOND_SCREEN";
		public static final String THIRD_SCREEN = "THIRD_SCREEN";
		public static final String WEBCAM_SCREEN = BASE + "Take Image";
	}

	public static class ScreenItemId {
		public static final String WELCOME_SCREEN_WINDOW = "WELCOME_SCREEN_WINDOW";
		public static final String FIRST_SCREEN = "FIRST_SCREEN";
		public static final String SECOND_SCREEN = "SECOND_SCREEN";
		public static final String THIRD_SCREEN = "THIRD_SCREEN";

	}

	public static class Screen_PRIV {
		public static final int FIRST_SCREEN = 101;
		public static final int SECOND_SCREEN = 102;
		public static final int THIRD_SCREEN = 103;
		public static final int FOURTH_SCREEN = 103;
	}

}
