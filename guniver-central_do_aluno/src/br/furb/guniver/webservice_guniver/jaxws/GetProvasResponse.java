
package br.furb.guniver.webservice_guniver.jaxws;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getProvasResponse", namespace = "http://webservice_guniver.guniver.furb.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProvasResponse", namespace = "http://webservice_guniver.guniver.furb.br/")
public class GetProvasResponse {

    @XmlElement(name = "return", namespace = "")
    private Collection<br.furb.guniver.modelo.academico.Prova> _return;

    /**
     * 
     * @return
     *     returns Collection<Prova>
     */
    public Collection<br.furb.guniver.modelo.academico.Prova> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Collection<br.furb.guniver.modelo.academico.Prova> _return) {
        this._return = _return;
    }

}
