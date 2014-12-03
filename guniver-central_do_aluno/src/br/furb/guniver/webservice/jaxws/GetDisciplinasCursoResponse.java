
package br.furb.guniver.webservice.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getDisciplinasCursoResponse", namespace = "http://webservice.guniver.furb.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDisciplinasCursoResponse", namespace = "http://webservice.guniver.furb.br/")
public class GetDisciplinasCursoResponse {

    @XmlElement(name = "return", namespace = "")
    private List<br.furb.guniver.modelo.Disciplina> _return;

    /**
     * 
     * @return
     *     returns List<Disciplina>
     */
    public List<br.furb.guniver.modelo.Disciplina> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<br.furb.guniver.modelo.Disciplina> _return) {
        this._return = _return;
    }

}
