
package com.amazonservices.mws.orders.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentMethodEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentMethodEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COD"/>
 *     &lt;enumeration value="CVS"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentMethodEnum")
@XmlEnum
public enum PaymentMethodEnum {

    COD("COD"),
    CVS("CVS"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    PaymentMethodEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentMethodEnum fromValue(String v) {
        for (PaymentMethodEnum c: PaymentMethodEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
