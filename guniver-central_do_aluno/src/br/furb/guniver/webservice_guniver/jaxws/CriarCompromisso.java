
package br.furb.guniver.webservice_guniver.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "criarCompromisso", namespace = "http://webservice_guniver.guniver.furb.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarCompromisso", namespace = "http://webservice_guniver.guniver.furb.br/")
public class CriarCompromisso {

    @XmlElement(name = "arg0", namespace = "")
    private br.furb.guniver.modelo.central_do_aluno.Compromisso arg0;

    /**
     * 
     * @return
     *     returns Compromisso
     */
    public br.furb.guniver.modelo.central_do_aluno.Compromisso getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(br.furb.guniver.modelo.central_do_aluno.Compromisso arg0) {
        this.arg0 = arg0;
    }

}