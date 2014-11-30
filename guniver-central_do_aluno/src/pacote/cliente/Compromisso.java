
package pacote.cliente;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for compromisso complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="compromisso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="codigoAluno" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="dataFim" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataInicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="descricao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diaTodo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lembretes" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compromisso", propOrder = {
    "codigo",
    "codigoAluno",
    "dataFim",
    "dataInicio",
    "descricao",
    "diaTodo",
    "lembretes",
    "titulo"
})
public class Compromisso {

    protected long codigo;
    protected long codigoAluno;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFim;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInicio;
    protected String descricao;
    protected boolean diaTodo;
    @XmlElement(nillable = true)
    protected List<Integer> lembretes;
    protected String titulo;

    /**
     * Gets the value of the codigo property.
     * 
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * Sets the value of the codigo property.
     * 
     */
    public void setCodigo(long value) {
        this.codigo = value;
    }

    /**
     * Gets the value of the codigoAluno property.
     * 
     */
    public long getCodigoAluno() {
        return codigoAluno;
    }

    /**
     * Sets the value of the codigoAluno property.
     * 
     */
    public void setCodigoAluno(long value) {
        this.codigoAluno = value;
    }

    /**
     * Gets the value of the dataFim property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFim() {
        return dataFim;
    }

    /**
     * Sets the value of the dataFim property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFim(XMLGregorianCalendar value) {
        this.dataFim = value;
    }

    /**
     * Gets the value of the dataInicio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInicio() {
        return dataInicio;
    }

    /**
     * Sets the value of the dataInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInicio(XMLGregorianCalendar value) {
        this.dataInicio = value;
    }

    /**
     * Gets the value of the descricao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Sets the value of the descricao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricao(String value) {
        this.descricao = value;
    }

    /**
     * Gets the value of the diaTodo property.
     * 
     */
    public boolean isDiaTodo() {
        return diaTodo;
    }

    /**
     * Sets the value of the diaTodo property.
     * 
     */
    public void setDiaTodo(boolean value) {
        this.diaTodo = value;
    }

    /**
     * Gets the value of the lembretes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lembretes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLembretes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getLembretes() {
        if (lembretes == null) {
            lembretes = new ArrayList<Integer>();
        }
        return this.lembretes;
    }

    /**
     * Gets the value of the titulo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets the value of the titulo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

}
