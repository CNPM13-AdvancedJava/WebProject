/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import controller.ControllerCatalog;
import entities.Gametype;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Nguyen
 */
public class ActionCatalog extends ActionSupport implements ServletRequestAware {

    private Gametype gametype;
    private ControllerCatalog controller;
    private HttpServletRequest request;
    private List<Gametype> lstGametype = new ArrayList<Gametype>();
    private List<Gametype> lstGame = new ArrayList<Gametype>();

    public ActionCatalog() {
        controller = new ControllerCatalog();
    }

    public String getMenu() {
        lstGametype = controller.getMenu();
        int size = lstGametype.size();
        lstGame = controller.getGamtype(size);
        return SUCCESS;
    }

    public Gametype getGametype() {
        return gametype;
    }

    public void setGametype(Gametype gametype) {
        this.gametype = gametype;
    }

    public ControllerCatalog getController() {
        return controller;
    }

    public void setController(ControllerCatalog controller) {
        this.controller = controller;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public List<Gametype> getLstGametype() {
        return lstGametype;
    }

    public void setLstGametype(List<Gametype> lstGametype) {
        this.lstGametype = lstGametype;
    }

    public List<Gametype> getLstGame() {
        return lstGame;
    }

    public void setLstGame(List<Gametype> lstGame) {
        this.lstGame = lstGame;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

}
