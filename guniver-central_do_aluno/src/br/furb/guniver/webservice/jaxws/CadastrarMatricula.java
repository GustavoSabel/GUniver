
package br.furb.guniver.webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "cadastrarMatricula", namespace = "http://webservice.guniver.furb.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastrarMatricula", namespace = "http://webservice.guniver.furb.br/")
public class CadastrarMatricula {

    @XmlElement(name = "arg0", namespace = "")
    private br.furb.guniver.modelo.Matricula arg0;

    /**
     * 
     * @return
     *     returns Matricula
     */
    public br.furb.guniver.modelo.Matricula getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(br.furb.guniver.modelo.Matricula arg0) {
        this.arg0 = arg0;
    }

}
