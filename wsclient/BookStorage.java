
package wsclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BookStorage", targetNamespace = "http://wsserver/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BookStorage {


    /**
     * 
     * @return
     *     returns wsclient.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://wsserver/BookStorage/listRequest", output = "http://wsserver/BookStorage/listResponse")
    public ArrayList list();

    /**
     * 
     * @param title
     * @return
     *     returns wsclient.Book
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://wsserver/BookStorage/findRequest", output = "http://wsserver/BookStorage/findResponse")
    public Book find(
        @WebParam(name = "title", partName = "title")
        String title);

    /**
     * 
     * @param title
     * @param type
     * @param autor
     */
    @WebMethod
    @Action(input = "http://wsserver/BookStorage/createRequest", output = "http://wsserver/BookStorage/createResponse")
    public void create(
        @WebParam(name = "title", partName = "title")
        String title,
        @WebParam(name = "autor", partName = "autor")
        String autor,
        @WebParam(name = "type", partName = "type")
        String type);

}
