package ehu.eus.db_project.businessLogic;

import ehu.eus.db_project.configuration.Config;

public class BlFacadeImplementation implements BlFacade {
    Config config = Config.getInstance();
    public BlFacadeImplementation() {
        System.out.println("Creating BlFacadeImplementation instance");
        boolean initialize = config.getDataBaseOpenMode().equals("initialize");
    }
}
