
package br.furb.guniver.webservice.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAlunosTurmaResponse", namespace = "http://webservice.guniver.furb.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlunosTurmaResponse", namespace = "http://webservice.guniver.furb.br/")
public class GetAlunosTurmaResponse {

    @XmlElement(name = "return", namespace = "")
    private List<br.furb.guniver.modelo.cadastro.Aluno> _return;

    /**
     * 
     * @return
     *     returns List<Aluno>
     */
    public List<br.furb.guniver.modelo.cadastro.Aluno> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<br.furb.guniver.modelo.cadastro.Aluno> _return) {
        this._return = _return;
    }

}