/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.base;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Bumble Bee
 */
public abstract class ActionUploadImage extends ActionSupport implements ServletRequestAware {

    protected List<File> uploadImages;
    protected List<String> uploadImagesContentType;
    protected List<String> uploadImagesFileName;
    protected HttpServletRequest request;
    
    protected List<File> savedImages = new ArrayList<>();

    public List<File> getUploadImages() {
        return uploadImages;
    }

    public void setUploadImages(List<File> uploadImages) {
        this.uploadImages = uploadImages;
    }

    public List<String> getUploadImagesContentType() {
        return uploadImagesContentType;
    }

    public void setUploadImagesContentType(List<String> uploadImagesContentType) {
        this.uploadImagesContentType = uploadImagesContentType;
    }

    public List<String> getUploadImagesFileName() {
        return uploadImagesFileName;
    }

    public void setUploadImagesFileName(List<String> uploadImagesFileName) {
        this.uploadImagesFileName = uploadImagesFileName;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    protected abstract String extendedPathString();

    /**
     * CuongCV: save lai file ma nguoi dung muon upload.
     *
     * @param name: Ten file se duoc luu.
     * @return true neu thanh cong, false neu khong thanh cong.
     */
    public boolean saveFiles() {
        try {
            String filePath = request.getSession().getServletContext().getRealPath("/")
                    .concat(extendedPathString());

            if (uploadImages == null) {
                return false;
            } else {
                for (int i = 0; i < uploadImages.size(); i++) {
                    File savedFile = new File(filePath, uploadImagesFileName.get(i));
                    FileUtils.copyFile(uploadImages.get(i), savedFile);
                    
                    savedImages.add(savedFile);
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.request = servletRequest;
    }
}
