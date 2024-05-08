package ehu.eus.db_project.uiControllers;

import ehu.eus.db_project.ui.MainGUI;

public class MainController implements Controller {

    private MainGUI maingui;


    @Override
    public void setMainApp(MainGUI mainGUI) {
        this.maingui = mainGUI;
    }
}