/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.admin;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import controller.action.base.ActionUploadImage;
import controller.dao.CatalogDAO;
import controller.dao.ManufacturerDAO;
import controller.dao.ProductDAO;
import controller.dao.TypeDAO;
import hibernate.util.HibernateTransaction;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dbentities.Catalog;
import model.dbentities.Manufacturer;
import model.dbentities.ProductDetail;
import model.dbentities.Type;
import model.dbentities.User;
import model.entities.Product;
import model.entities.UserInfo;
import org.apache.struts2.interceptor.ServletRequestAware;
import utils.Constant;
import utils.Util;

/**
 *
 * @author Linh
 */
public class ProductAction extends ActionUploadImage {
    private static final String EXTENDED_PATH = "images\\product\\";
    private static final String PRODUCT_NAME = "product.productName";
    private static final String PRODUCT_CATALOG_ID = "catalog";
    private static final String PRODUCT_GAMETYPE_ID = "product.gametype.gametypeId";
    private static final String PRODUCT_TIME_RELEASE = "timeRelease";
    private static final String PRODUCT_MANUFACTURER_ID = "product.manufacturer";
    private static final String PRODUCT_CONTEXT = "product.context";
    private static final String PRODUCT_TYPETEXT = "product.typetext";
    private static final String PRODUCT_HEAD_CONTEXT = "product.headcontext";
    private static final String PRODUCT_LANGUAGE = "product.language";
    private static final String PRODUCT_REGIME = "product.regime";
    private static final String PRODUCT_REGION = "product.region";
    private static final String PRODUCT_PRICE = "product.price";

    private HttpServletRequest request;
    private HibernateTransaction transaction;
    private ProductDAO productDAO;
    private CatalogDAO catalogDAO;
    private TypeDAO typeDAO;
    
    private List<ProductDetail> lstProduct;
    private List<Catalog> lstCatalog;
    private List<Type> lstType;
    private Product product;
    private String error;

    // CuongCV:
    private List<Manufacturer> manufacturers;

    private ManufacturerDAO manufacturerDAO;

    public ProductAction() {
        transaction = new HibernateTransaction();
        productDAO = new ProductDAO();
        catalogDAO = new CatalogDAO();
        typeDAO = new TypeDAO();
        manufacturerDAO = new ManufacturerDAO();
    }
    
    public String getAllProduct(){
        transaction.beginTransaction();
        lstProduct = productDAO.getAllProduct();
        transaction.closeTransaction();
        ProductDetail.getThumnailImage(lstProduct);
        return SUCCESS;
    }
    
    public String prepareData(){
        transaction.beginTransaction();
        lstCatalog = catalogDAO.getAllCatalog();
        lstType = typeDAO.getAllType();
        manufacturers = manufacturerDAO.getAllManufacturer();
        transaction.closeTransaction();
        return SUCCESS;
    }
    
    public String addNewProduct(){
        String name = request.getParameter(PRODUCT_NAME);
        String catalogValueString = request.getParameter(PRODUCT_CATALOG_ID);
        String context = request.getParameter(PRODUCT_CONTEXT);
        String gameTypeValueString = request.getParameter(PRODUCT_GAMETYPE_ID);
        String headContext = request.getParameter(PRODUCT_HEAD_CONTEXT);
        String languague = request.getParameter(PRODUCT_LANGUAGE);
        String maufacturerValueString = request.getParameter(PRODUCT_MANUFACTURER_ID);
        String priceValueString = request.getParameter(PRODUCT_PRICE);
        String regime = request.getParameter(PRODUCT_REGIME);
        String region = request.getParameter(PRODUCT_REGION);
        String timeReleaseValueString = request.getParameter(PRODUCT_TIME_RELEASE);
        String typeText = request.getParameter(PRODUCT_TYPETEXT);
        
        int catalogId = catalogValueString == null ? -1 : Integer.parseInt(catalogValueString);
        int gameTypeId = gameTypeValueString == null ? -1 : Integer.parseInt(gameTypeValueString);
        int maufacturerId = maufacturerValueString == null ? -1 : Integer.parseInt(maufacturerValueString);
        double price = priceValueString == null ? -1 : Double.parseDouble(priceValueString);
        Date timeRelease;
        
        try {
              String[] date = timeReleaseValueString.split("-");
              timeRelease = new Date(Integer.parseInt(date[0]) - 1901, Integer.parseInt(date[1]), Integer.parseInt(date[1]));
        } catch (Exception e) {
            error = "Dinh dang ngay phat hanh khong dung";
            return ERROR;
        }
        
        if (price < 0) {
            error = "Gia khong duoc nho hon 0";
            return ERROR;
        }
        
        ProductDetail product = new ProductDetail(manufacturerDAO.getManufacturer(maufacturerId),
                typeDAO.getType(gameTypeId), name, timeRelease, 0, languague, region,
                context, "introduction", price, 0,
                null, null);
        
        return SUCCESS;
    }
    
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        request = hsr;
    }

    public List<ProductDetail> getLstProduct() {
        return lstProduct;
    }

    public List<Catalog> getLstCatalog() {
        return lstCatalog;
    }

    public Product getProduct() {
        return product;
    }

    public List<Type> getLstType() {
        return lstType;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    protected String extendedPathString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
