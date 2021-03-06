
package br.furb.guniver.webservice.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAlunosResponse", namespace = "http://webservice.guniver.furb.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlunosResponse", namespace = "http://webservice.guniver.furb.br/")
public class GetAlunosResponse {

    @XmlElement(name = "return", namespace = "")
    private List<br.furb.guniver.modelo.Aluno> _return;

    /**
     * 
     * @return
     *     returns List<Aluno>
     */
    public List<br.furb.guniver.modelo.Aluno> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<br.furb.guniver.modelo.Aluno> _return) {
        this._return = _return;
    }

}
