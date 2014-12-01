
package webservice_guniver.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCursosResponse", namespace = "http://webservice_guniver/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCursosResponse", namespace = "http://webservice_guniver/")
public class GetCursosResponse {

    @XmlElement(name = "return", namespace = "")
    private modulo.cadastro.Curso _return;

    /**
     * 
     * @return
     *     returns Curso
     */
    public modulo.cadastro.Curso getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(modulo.cadastro.Curso _return) {
        this._return = _return;
    }

}
