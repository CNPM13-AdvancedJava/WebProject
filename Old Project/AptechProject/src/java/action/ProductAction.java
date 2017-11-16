/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import controller.ProductController;
import entities.Catalog;
import entities.Gametype;
import entities.Product;
import entities.ProductKey;
import entities.Saled;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Linh
 */
public class ProductAction extends ActionSupport implements ServletRequestAware {

    private File productImage;
    private ProductKey productKey;
    private Product product;
    private Product initProduct;
    private Saled sale;
    private Gametype gametype;
    private ProductController controller;
    List<Product> listProduct = new ArrayList<>();
    List<Gametype> listGametype = new ArrayList<>();
    List<Catalog> listCatalog = new ArrayList<>();
    List<Saled> listSale = new ArrayList<>();
    List<Product> list = new ArrayList<>();
    List<ProductKey> listKey = new ArrayList<>();
    private HttpServletRequest request;
    private String productImageFileName;
    private String timeRelease;

    public ProductAction() {
        controller = new ProductController();
    }

    public String checkProductName() throws InterruptedException {
        String prodName = request.getParameter("product.productName");
        list = controller.isNameExist(prodName);
        if (list.isEmpty()) {
            String filePath = request.getSession().getServletContext().getRealPath("\\").concat("images\\product");
            String fname = "";
            String realName = "";
            try {
                int x = productImageFileName.lastIndexOf(".");
                String tail = productImageFileName.substring(x);
                fname = createName() + tail;
                File fileToCreate = new File(filePath, fname);
                FileUtils.copyFile(productImage, fileToCreate);
                realName = "images/product/" + fname;
                product.setImages(realName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Date time = java.sql.Date.valueOf(timeRelease);
            product.setTimeRelease(time);
            
            listSale = controller.getAnotherSale();
            listCatalog = controller.getCatalog();
            listGametype = controller.getGametype();
            listProduct = controller.addProduct(this.getProduct());
            return SUCCESS;

        } else {
            return ERROR;
        }
    }

    public String fail() {
        return ERROR;
    }

    public String success() {
        return SUCCESS;
    }

    public String getAll() {
        listSale = controller.getSale();
        listGametype = controller.getGametype();
        listCatalog = controller.getCatalog();
        listProduct = controller.getProduct();
        return SUCCESS;
    }


    private String createName() {
        String name = "";
        Date now = new Date();
        name += now.getYear() + "" + now.getMonth() + "" + now.getDay() + "" + now.getHours() + "" + now.getMinutes() + "" + now.getSeconds();
        return name;
    }

    public String insertProduct() {
        String filePath = request.getSession().getServletContext().getRealPath("/").concat("images");
        String fname = "";
        String realName = "";
        try {
            int x = productImageFileName.lastIndexOf(".");
            String tail = productImageFileName.substring(x);
            fname = createName() + tail;
            File fileToCreate = new File(filePath, fname);
            FileUtils.copyFile(productImage, fileToCreate);
            realName = filePath + "/" + fname;
            product.setImages(realName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listProduct = controller.addProduct(this.getProduct());
        if (listProduct.isEmpty()) {
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    public String initUpdate() {
        String ID = request.getParameter("productId");
        int productID = 0;
        try {
            productID = Integer.parseInt(ID);
        } catch (Exception ex) {
        }
        listGametype = controller.getListGametype();
        listSale = controller.getAnotherSale();
        initProduct = controller.getProductByID(productID);
        return SUCCESS;
    }

    public String deleteKey() {
        String id = request.getParameter("idProductkey");
        int productKeyID = 0, productID = 0;
        try {
            productKeyID = Integer.parseInt(id);
        } catch (Exception ex) {
        }
        listProduct = controller.deleteKey(productKeyID);
        if (listProduct.isEmpty()) {
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    public String getKeyByID() {
        String ID = request.getParameter("productId");
        int productID = 0;
        try {
            productID = Integer.parseInt(ID);
        } catch (Exception ex) {
        }
        listKey = controller.getListKeyByID(productID);
        return SUCCESS;
    }

    public String deleteProduct() {
        String id = request.getParameter("productId");
        int productID = 0;
        try {
            productID = Integer.parseInt(id);
        } catch (Exception ex) {
        }
        listSale = controller.getSale();
        listGametype = controller.getGametype();
        listCatalog = controller.getCatalog();
        listProduct = controller.deleteProduct(productID);
        if (listProduct.isEmpty()) {
            return ERROR;
        } else {
            return SUCCESS;
        }

    }

    public String updateProduct() {
        listProduct = controller.updateProduct(this.getProduct());
        if (listProduct.isEmpty()) {
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    public String insertKey() {
        char[] key = productKey.getProductkeyKey().toCharArray();
        if (key.length != 19 || key[4] != '-' || key[9] != '-' || key[14] != '-') {
            listProduct = controller.getAllProduct();
            return ERROR;
        }
        listProduct = controller.addKey(getProductKey());
        if (!listProduct.isEmpty()) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String findProductID() {
        String ID = request.getParameter("productId");
        int productID = 0;
        try {
            productID = Integer.parseInt(ID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        initProduct = controller.getProductByID(productID);
        return SUCCESS;
    }
    
    public String goInsert(){
        return SUCCESS;
    }

    public Product getInitProduct() {
        return initProduct;
    }

    public void setInitProduct(Product initProduct) {
        this.initProduct = initProduct;
    }

    public ProductController getController() {
        return controller;
    }

    public void setController(ProductController controller) {
        this.controller = controller;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    public ProductKey getProductKey() {
        return productKey;
    }

    public void setProductKey(ProductKey productKey) {
        this.productKey = productKey;
    }

    public File getProductImage() {
        return productImage;
    }

    public void setProductImage(File productImage) {
        this.productImage = productImage;
    }

    public List<ProductKey> getListKey() {
        return listKey;
    }

    public void setListKey(List<ProductKey> listKey) {
        this.listKey = listKey;
    }

    public String getProductImageFileName() {
        return productImageFileName;
    }

    public void setProductImageFileName(String productImageFileName) {
        this.productImageFileName = productImageFileName;
    }

    public List<Gametype> getListGametype() {
        return listGametype;
    }

    public void setListGametype(List<Gametype> listGametype) {
        this.listGametype = listGametype;
    }

    public List<Catalog> getListCatalog() {
        return listCatalog;
    }

    public void setListCatalog(List<Catalog> listCatalog) {
        this.listCatalog = listCatalog;
    }

    public List<Saled> getListSale() {
        return listSale;
    }

    public void setListSale(List<Saled> listSale) {
        this.listSale = listSale;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public Saled getSale() {
        return sale;
    }

    public void setSale(Saled sale) {
        this.sale = sale;
    }

    public Gametype getGametype() {
        return gametype;
    }

    public void setGametype(Gametype gametype) {
        this.gametype = gametype;
    }

    public String getTimeRelease() {
        return timeRelease;
    }

    public void setTimeRelease(String timeRelease) {
        this.timeRelease = timeRelease;
    }

}
