
package br.furb.guniver.webservice.jaxws;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getHorariosResponse", namespace = "http://webservice.guniver.furb.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHorariosResponse", namespace = "http://webservice.guniver.furb.br/")
public class GetHorariosResponse {

    @XmlElement(name = "return", namespace = "")
    private Collection<br.furb.guniver.modelo.Horario> _return;

    /**
     * 
     * @return
     *     returns Collection<Horario>
     */
    public Collection<br.furb.guniver.modelo.Horario> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Collection<br.furb.guniver.modelo.Horario> _return) {
        this._return = _return;
    }

}
