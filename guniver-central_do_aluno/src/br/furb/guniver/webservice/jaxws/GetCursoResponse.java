
package br.furb.guniver.webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCursoResponse", namespace = "http://webservice.guniver.furb.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCursoResponse", namespace = "http://webservice.guniver.furb.br/")
public class GetCursoResponse {

    @XmlElement(name = "return", namespace = "")
    private br.furb.guniver.modelo.Curso _return;

    /**
     * 
     * @return
     *     returns Curso
     */
    public br.furb.guniver.modelo.Curso getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(br.furb.guniver.modelo.Curso _return) {
        this._return = _return;
    }

}
