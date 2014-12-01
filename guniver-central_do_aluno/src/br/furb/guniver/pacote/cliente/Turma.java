
package br.furb.guniver.pacote.cliente;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for turma complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="turma">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ano" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="semestre" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="disciplina" type="{http://webservice_guniver/}disciplina" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "turma", propOrder = {
    "codigo",
    "ano",
    "semestre",
    "disciplina"
})
public class Turma {

    protected int codigo;
    protected short ano;
    protected short semestre;
    protected Disciplina disciplina;

    /**
     * Gets the value of the codigo property.
     * 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Sets the value of the codigo property.
     * 
     */
    public void setCodigo(int value) {
        this.codigo = value;
    }

    /**
     * Gets the value of the ano property.
     * 
     */
    public short getAno() {
        return ano;
    }

    /**
     * Sets the value of the ano property.
     * 
     */
    public void setAno(short value) {
        this.ano = value;
    }

    /**
     * Gets the value of the semestre property.
     * 
     */
    public short getSemestre() {
        return semestre;
    }

    /**
     * Sets the value of the semestre property.
     * 
     */
    public void setSemestre(short value) {
        this.semestre = value;
    }

    /**
     * Gets the value of the disciplina property.
     * 
     * @return
     *     possible object is
     *     {@link Disciplina }
     *     
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * Sets the value of the disciplina property.
     * 
     * @param value
     *     allowed object is
     *     {@link Disciplina }
     *     
     */
    public void setDisciplina(Disciplina value) {
        this.disciplina = value;
    }

}
