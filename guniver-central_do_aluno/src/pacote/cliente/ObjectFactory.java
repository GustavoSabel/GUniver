
package pacote.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pacote.cliente package. 
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

    private final static QName _GetCompromissosAluno_QNAME = new QName("http://webservice_guniver/", "getCompromissosAluno");
    private final static QName _GetCompromissosAlunoResponse_QNAME = new QName("http://webservice_guniver/", "getCompromissosAlunoResponse");
    private final static QName _CriarCompromissoResponse_QNAME = new QName("http://webservice_guniver/", "criarCompromissoResponse");
    private final static QName _GetMaterialResponse_QNAME = new QName("http://webservice_guniver/", "getMaterialResponse");
    private final static QName _GetCompromissos_QNAME = new QName("http://webservice_guniver/", "getCompromissos");
    private final static QName _RemoverCompromissoResponse_QNAME = new QName("http://webservice_guniver/", "removerCompromissoResponse");
    private final static QName _CriarCompromisso_QNAME = new QName("http://webservice_guniver/", "criarCompromisso");
    private final static QName _GetMaterial_QNAME = new QName("http://webservice_guniver/", "getMaterial");
    private final static QName _GetCompromissosResponse_QNAME = new QName("http://webservice_guniver/", "getCompromissosResponse");
    private final static QName _RemoverCompromisso_QNAME = new QName("http://webservice_guniver/", "removerCompromisso");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pacote.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoverCompromisso }
     * 
     */
    public RemoverCompromisso createRemoverCompromisso() {
        return new RemoverCompromisso();
    }

    /**
     * Create an instance of {@link GetMaterial }
     * 
     */
    public GetMaterial createGetMaterial() {
        return new GetMaterial();
    }

    /**
     * Create an instance of {@link CriarCompromisso }
     * 
     */
    public CriarCompromisso createCriarCompromisso() {
        return new CriarCompromisso();
    }

    /**
     * Create an instance of {@link GetCompromissosResponse }
     * 
     */
    public GetCompromissosResponse createGetCompromissosResponse() {
        return new GetCompromissosResponse();
    }

    /**
     * Create an instance of {@link RemoverCompromissoResponse }
     * 
     */
    public RemoverCompromissoResponse createRemoverCompromissoResponse() {
        return new RemoverCompromissoResponse();
    }

    /**
     * Create an instance of {@link GetCompromissos }
     * 
     */
    public GetCompromissos createGetCompromissos() {
        return new GetCompromissos();
    }

    /**
     * Create an instance of {@link GetCompromissosAluno }
     * 
     */
    public GetCompromissosAluno createGetCompromissosAluno() {
        return new GetCompromissosAluno();
    }

    /**
     * Create an instance of {@link GetCompromissosAlunoResponse }
     * 
     */
    public GetCompromissosAlunoResponse createGetCompromissosAlunoResponse() {
        return new GetCompromissosAlunoResponse();
    }

    /**
     * Create an instance of {@link GetMaterialResponse }
     * 
     */
    public GetMaterialResponse createGetMaterialResponse() {
        return new GetMaterialResponse();
    }

    /**
     * Create an instance of {@link CriarCompromissoResponse }
     * 
     */
    public CriarCompromissoResponse createCriarCompromissoResponse() {
        return new CriarCompromissoResponse();
    }

    /**
     * Create an instance of {@link Compromisso }
     * 
     */
    public Compromisso createCompromisso() {
        return new Compromisso();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompromissosAluno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice_guniver/", name = "getCompromissosAluno")
    public JAXBElement<GetCompromissosAluno> createGetCompromissosAluno(GetCompromissosAluno value) {
        return new JAXBElement<GetCompromissosAluno>(_GetCompromissosAluno_QNAME, GetCompromissosAluno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompromissosAlunoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice_guniver/", name = "getCompromissosAlunoResponse")
    public JAXBElement<GetCompromissosAlunoResponse> createGetCompromissosAlunoResponse(GetCompromissosAlunoResponse value) {
        return new JAXBElement<GetCompromissosAlunoResponse>(_GetCompromissosAlunoResponse_QNAME, GetCompromissosAlunoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarCompromissoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice_guniver/", name = "criarCompromissoResponse")
    public JAXBElement<CriarCompromissoResponse> createCriarCompromissoResponse(CriarCompromissoResponse value) {
        return new JAXBElement<CriarCompromissoResponse>(_CriarCompromissoResponse_QNAME, CriarCompromissoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaterialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice_guniver/", name = "getMaterialResponse")
    public JAXBElement<GetMaterialResponse> createGetMaterialResponse(GetMaterialResponse value) {
        return new JAXBElement<GetMaterialResponse>(_GetMaterialResponse_QNAME, GetMaterialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompromissos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice_guniver/", name = "getCompromissos")
    public JAXBElement<GetCompromissos> createGetCompromissos(GetCompromissos value) {
        return new JAXBElement<GetCompromissos>(_GetCompromissos_QNAME, GetCompromissos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoverCompromissoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice_guniver/", name = "removerCompromissoResponse")
    public JAXBElement<RemoverCompromissoResponse> createRemoverCompromissoResponse(RemoverCompromissoResponse value) {
        return new JAXBElement<RemoverCompromissoResponse>(_RemoverCompromissoResponse_QNAME, RemoverCompromissoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarCompromisso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice_guniver/", name = "criarCompromisso")
    public JAXBElement<CriarCompromisso> createCriarCompromisso(CriarCompromisso value) {
        return new JAXBElement<CriarCompromisso>(_CriarCompromisso_QNAME, CriarCompromisso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaterial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice_guniver/", name = "getMaterial")
    public JAXBElement<GetMaterial> createGetMaterial(GetMaterial value) {
        return new JAXBElement<GetMaterial>(_GetMaterial_QNAME, GetMaterial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompromissosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice_guniver/", name = "getCompromissosResponse")
    public JAXBElement<GetCompromissosResponse> createGetCompromissosResponse(GetCompromissosResponse value) {
        return new JAXBElement<GetCompromissosResponse>(_GetCompromissosResponse_QNAME, GetCompromissosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoverCompromisso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice_guniver/", name = "removerCompromisso")
    public JAXBElement<RemoverCompromisso> createRemoverCompromisso(RemoverCompromisso value) {
        return new JAXBElement<RemoverCompromisso>(_RemoverCompromisso_QNAME, RemoverCompromisso.class, null, value);
    }

}
