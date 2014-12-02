
package br.furb.guniver.webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "criarCompromissoResponse", namespace = "http://webservice.guniver.furb.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarCompromissoResponse", namespace = "http://webservice.guniver.furb.br/")
public class CriarCompromissoResponse {

    @XmlElement(name = "return", namespace = "")
    private br.furb.guniver.modelo.central_do_aluno.Compromisso _return;

    /**
     * 
     * @return
     *     returns Compromisso
     */
    public br.furb.guniver.modelo.central_do_aluno.Compromisso getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(br.furb.guniver.modelo.central_do_aluno.Compromisso _return) {
        this._return = _return;
    }

}
