
package br.furb.guniver.webservice.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getMensalidadesPendentesResponse", namespace = "http://webservice.guniver.furb.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMensalidadesPendentesResponse", namespace = "http://webservice.guniver.furb.br/")
public class GetMensalidadesPendentesResponse {

    @XmlElement(name = "return", namespace = "")
    private List<br.furb.guniver.modelo.Mensalidade> _return;

    /**
     * 
     * @return
     *     returns List<Mensalidade>
     */
    public List<br.furb.guniver.modelo.Mensalidade> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<br.furb.guniver.modelo.Mensalidade> _return) {
        this._return = _return;
    }

}
