
package webservice_guniver.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "cadastrarCompromisso", namespace = "http://webservice_guniver/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastrarCompromisso", namespace = "http://webservice_guniver/", propOrder = {
    "arg0",
    "arg1"
})
public class CadastrarCompromisso {

    @XmlElement(name = "arg0", namespace = "")
    private int arg0;
    @XmlElement(name = "arg1", namespace = "")
    private webservice_guniver.Compromisso arg1;

    /**
     * 
     * @return
     *     returns int
     */
    public int getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(int arg0) {
        this.arg0 = arg0;
    }

    /**
     * 
     * @return
     *     returns Compromisso
     */
    public webservice_guniver.Compromisso getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(webservice_guniver.Compromisso arg1) {
        this.arg1 = arg1;
    }

}
