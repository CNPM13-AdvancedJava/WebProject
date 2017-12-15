/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.admin;

import controller.action.base.ActionUploadImage;
import controller.dao.CatalogDAO;
import controller.dao.ManufacturerDAO;
import controller.dao.ProductDAO;
import controller.dao.ProductImageDAO;
import controller.dao.TypeDAO;
import hibernate.util.HibernateTransaction;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.dbentities.Catalog;
import model.dbentities.Manufacturer;
import model.dbentities.ProductDetail;
import model.dbentities.ProductImage;
import model.dbentities.Type;

/**
 *
 * @author Linh
 */
public class ProductAction extends ActionUploadImage {

    private static final String EXTENDED_PATH = "images\\product\\";

    private HibernateTransaction transaction;
    private ProductDAO productDAO;
    private CatalogDAO catalogDAO;
    private TypeDAO typeDAO;
    private ManufacturerDAO manufacturerDAO;
    private ProductImageDAO productImageDAO;

    private List<Manufacturer> manufacturers;
    private List<ProductDetail> lstProduct;
    private List<Catalog> lstCatalog;
    private List<Type> lstType;
    private ProductDetail product;

    public ProductAction() {
        transaction = new HibernateTransaction();
        productDAO = new ProductDAO();
        catalogDAO = new CatalogDAO();
        typeDAO = new TypeDAO();
        manufacturerDAO = new ManufacturerDAO();
        productImageDAO = new ProductImageDAO();
    }

    public String getAllProduct() {
        transaction.beginTransaction();
        lstProduct = productDAO.getAllProduct();
        transaction.closeTransaction();
        ProductDetail.getThumnailImage(lstProduct);
        return SUCCESS;
    }

    public String prepareData() {
        transaction.beginTransaction();
        lstCatalog = catalogDAO.getAllCatalog();
        lstType = typeDAO.getAllType();
        manufacturers = manufacturerDAO.getAllManufacturer();
        transaction.closeTransaction();
        return SUCCESS;
    }

    public String deleteProduct() {
        String productId = request.getParameter("productId");
        transaction.beginTransaction();
        int id = Integer.parseInt(productId);
        productDAO.deleteProduct(id);
        transaction.closeTransaction();
        return SUCCESS;
    }

    public String getProductDetail() {
        String productId = request.getParameter("productId");
        try {
            transaction.beginTransaction();
            int id = Integer.parseInt(productId);
            product = productDAO.getProductById(id);
        } catch (Exception e) {
            transaction.rollback();
            System.err.println(e);
        } finally {
            transaction.closeTransaction();
        }
        return SUCCESS;
    }

    public String addNewProduct() {
        String productName = request.getParameter("productName");
        String catalogValueString = request.getParameter("catalogId");
        String typeValueString = request.getParameter("typeId");
        String manufacturerValueString = request.getParameter("manufacturerId");
        String releaseTimeValueString = request.getParameter("releaseTime");
        String language = request.getParameter("language");
        String region = request.getParameter("region");
        String priceValueString = request.getParameter("price");
        String description = request.getParameter("description");
        String introduction = request.getParameter("introduction");

        int catalogId, manufacturerId, typeId, price;
        Date releaseDate;

        try {
            catalogId = catalogValueString == null ? -1 : Integer.parseInt(catalogValueString);
        } catch (Exception e) {
            catalogId = -1;
        };
        try {
            manufacturerId = manufacturerValueString == null ? -1 : Integer.parseInt(manufacturerValueString);
        } catch (Exception e) {
            manufacturerId = -1;
        };
        try {
            typeId = typeValueString == null ? -1 : Integer.parseInt(typeValueString);
        } catch (Exception e) {
            typeId = -1;
        };
        try {
            price = priceValueString == null ? 0 : Integer.parseInt(priceValueString);
        } catch (Exception e) {
            price = 0;
        };
        try {
            String[] date = releaseTimeValueString.split("-");
            releaseDate = new Date(Integer.parseInt(date[0]) - 1901, Integer.parseInt(date[1]), Integer.parseInt(date[1]));
        } catch (Exception e) {
            releaseDate = null;
        }
        try {
            transaction.beginTransaction();

            ProductDetail product = new ProductDetail(manufacturerDAO.getManufacturer(manufacturerId),
                    typeDAO.getType(typeId), productName, releaseDate,
                    0, language, region, description, introduction, price);
            productDAO.saveOrUpdateProduct(product);

            if (saveFiles()) {
                for (int i = 0; i < savedImages.size(); i++) {
                    File file = savedImages.get(i);
                    ProductImage image = new ProductImage();
                    image.setImageId(i + product.hashCode());
                    image.setProductDetail(product);
                    image.setImageLink(EXTENDED_PATH + "\\" + file.getName());
                    if (i == 0) {
                        image.setIsAva(1);
                        image.setFlag(1);
                    } else {
                        image.setIsAva(0);
                        image.setFlag(0);
                    }
                    productImageDAO.saveOrUpdateImage(image);
                }
            }
        } finally {
            transaction.closeTransaction();
        }

        return SUCCESS;
    }

    public List<ProductDetail> getLstProduct() {
        return lstProduct;
    }

    public List<Catalog> getLstCatalog() {
        return lstCatalog;
    }

    public ProductDetail getProduct() {
        return product;
    }

    public List<Type> getLstType() {
        return lstType;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    @Override
    protected String extendedPathString() {
        return EXTENDED_PATH;
    }

}
