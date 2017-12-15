/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.base;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Bumble Bee
 */
public abstract class ActionUploadImage extends ActionSupport implements ServletRequestAware {
    protected File uploadImage;
    protected String uploadImageContentType;
    protected String uploadImageFileName;
    protected HttpServletRequest servletRequest;
    
    protected abstract String extendedPathString();
    
    /**
     * CuongCV: save lai file ma nguoi dung muon upload.
     * @param name: Ten file se duoc luu.
     * @return true neu thanh cong, false neu khong thanh cong.
     */
    protected boolean saveFile(String name) {
        try {
            String filePath = servletRequest.getSession().getServletContext().getRealPath("/")
                    .concat(extendedPathString());
            File savedFile = new File(filePath, name);
            
            if (uploadImage == null) {
                throw new IllegalArgumentException("The file trong form phai co name la \"uploadImage\"");
            } else {
                FileUtils.copyFile(this.uploadImage, savedFile);
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public File getUploadImage() {
        return uploadImage;
    }

    public void setUploadImage(File uploadImage) {
        this.uploadImage = uploadImage;
    }

    public String getUploadImageContentType() {
        return uploadImageContentType;
    }

    public void setUploadImageContentType(String userImageContentType) {
        this.uploadImageContentType = userImageContentType;
    }

    public String getUploadImageFileName() {
        return uploadImageFileName;
    }

    public void setUploadImageFileName(String userImageFileName) {
        this.uploadImageFileName = userImageFileName;
    }

    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }
}
