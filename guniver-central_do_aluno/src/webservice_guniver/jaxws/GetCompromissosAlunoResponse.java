
package webservice_guniver.jaxws;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCompromissosAlunoResponse", namespace = "http://webservice_guniver/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCompromissosAlunoResponse", namespace = "http://webservice_guniver/")
public class GetCompromissosAlunoResponse {

    @XmlElement(name = "return", namespace = "")
    private Collection<webservice_guniver.model.Compromisso> _return;

    /**
     * 
     * @return
     *     returns Collection<Compromisso>
     */
    public Collection<webservice_guniver.model.Compromisso> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Collection<webservice_guniver.model.Compromisso> _return) {
        this._return = _return;
    }

}
