
package br.furb.guniver.webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCursosResponse", namespace = "http://webservice.guniver.furb.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCursosResponse", namespace = "http://webservice.guniver.furb.br/")
public class GetCursosResponse {

    @XmlElement(name = "return", namespace = "")
    private br.furb.guniver.modelo.cadastro.Curso _return;

    /**
     * 
     * @return
     *     returns Curso
     */
    public br.furb.guniver.modelo.cadastro.Curso getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(br.furb.guniver.modelo.cadastro.Curso _return) {
        this._return = _return;
    }

}
