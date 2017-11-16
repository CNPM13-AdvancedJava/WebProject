
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckOrder_QNAME = new QName("http://service/", "checkOrder");
    private final static QName _CheckOrderResponse_QNAME = new QName("http://service/", "checkOrderResponse");
    private final static QName _FinishOrder_QNAME = new QName("http://service/", "finishOrder");
    private final static QName _FinishOrderResponse_QNAME = new QName("http://service/", "finishOrderResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckOrder }
     * 
     */
    public CheckOrder createCheckOrder() {
        return new CheckOrder();
    }

    /**
     * Create an instance of {@link CheckOrderResponse }
     * 
     */
    public CheckOrderResponse createCheckOrderResponse() {
        return new CheckOrderResponse();
    }

    /**
     * Create an instance of {@link FinishOrder }
     * 
     */
    public FinishOrder createFinishOrder() {
        return new FinishOrder();
    }

    /**
     * Create an instance of {@link FinishOrderResponse }
     * 
     */
    public FinishOrderResponse createFinishOrderResponse() {
        return new FinishOrderResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "checkOrder")
    public JAXBElement<CheckOrder> createCheckOrder(CheckOrder value) {
        return new JAXBElement<CheckOrder>(_CheckOrder_QNAME, CheckOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "checkOrderResponse")
    public JAXBElement<CheckOrderResponse> createCheckOrderResponse(CheckOrderResponse value) {
        return new JAXBElement<CheckOrderResponse>(_CheckOrderResponse_QNAME, CheckOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinishOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "finishOrder")
    public JAXBElement<FinishOrder> createFinishOrder(FinishOrder value) {
        return new JAXBElement<FinishOrder>(_FinishOrder_QNAME, FinishOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinishOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "finishOrderResponse")
    public JAXBElement<FinishOrderResponse> createFinishOrderResponse(FinishOrderResponse value) {
        return new JAXBElement<FinishOrderResponse>(_FinishOrderResponse_QNAME, FinishOrderResponse.class, null, value);
    }

}
