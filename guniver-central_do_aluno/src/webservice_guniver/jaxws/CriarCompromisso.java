
package webservice_guniver.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "criarCompromisso", namespace = "http://webservice_guniver/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarCompromisso", namespace = "http://webservice_guniver/")
public class CriarCompromisso {

    @XmlElement(name = "arg0", namespace = "")
    private webservice_guniver.model.Compromisso arg0;

    /**
     * 
     * @return
     *     returns Compromisso
     */
    public webservice_guniver.model.Compromisso getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(webservice_guniver.model.Compromisso arg0) {
        this.arg0 = arg0;
    }

}
