/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.model.RegistryProject;

/**
 *
 * @author rgcar
 */
@SuppressWarnings("unchecked")
public class RunUI {

    public static void main(String[] args) {
        RegistryProject registryProject = new RegistryProject();
        
        ChooseProjectUI choose = new ChooseProjectUI(registryProject);
    }
}
