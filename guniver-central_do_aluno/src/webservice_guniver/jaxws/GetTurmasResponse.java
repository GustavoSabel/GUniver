
package webservice_guniver.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getTurmasResponse", namespace = "http://webservice_guniver/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTurmasResponse", namespace = "http://webservice_guniver/")
public class GetTurmasResponse {

    @XmlElement(name = "return", namespace = "")
    private List<modulo.cadastro.Turma> _return;

    /**
     * 
     * @return
     *     returns List<Turma>
     */
    public List<modulo.cadastro.Turma> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<modulo.cadastro.Turma> _return) {
        this._return = _return;
    }

}
