
package webservice_guniver.jaxws;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getMatriculasTurmaResponse", namespace = "http://webservice_guniver/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMatriculasTurmaResponse", namespace = "http://webservice_guniver/")
public class GetMatriculasTurmaResponse {

    @XmlElement(name = "return", namespace = "")
    private Collection<modulo.academico.Matricula> _return;

    /**
     * 
     * @return
     *     returns Collection<Matricula>
     */
    public Collection<modulo.academico.Matricula> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Collection<modulo.academico.Matricula> _return) {
        this._return = _return;
    }

}
