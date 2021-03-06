
package br.furb.guniver.central_do_aluno.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for situacao.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="situacao">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="pago"/>
 *     &lt;enumeration value="a_pago"/>
 *     &lt;enumeration value="atrasado"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "situacao")
@XmlEnum
public enum Situacao {

    @XmlEnumValue("pago")
    PAGO("pago"),
    @XmlEnumValue("a_pago")
    A_PAGO("a_pago"),
    @XmlEnumValue("atrasado")
    ATRASADO("atrasado");
    private final String value;

    Situacao(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Situacao fromValue(String v) {
        for (Situacao c: Situacao.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
