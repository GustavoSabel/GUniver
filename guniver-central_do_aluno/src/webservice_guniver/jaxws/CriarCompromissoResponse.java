
package webservice_guniver.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "criarCompromissoResponse", namespace = "http://webservice_guniver/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarCompromissoResponse", namespace = "http://webservice_guniver/")
public class CriarCompromissoResponse {

    @XmlElement(name = "return", namespace = "")
    private webservice_guniver.model.Compromisso _return;

    /**
     * 
     * @return
     *     returns Compromisso
     */
    public webservice_guniver.model.Compromisso getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(webservice_guniver.model.Compromisso _return) {
        this._return = _return;
    }

}
