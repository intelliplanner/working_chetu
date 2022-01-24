package com.seniorline.view.controller.service;

import com.seniorline.view.controller.MainController;

public interface ControllerI {

	void init(MainController mainController);

	void handleActionControl(String control);

}
