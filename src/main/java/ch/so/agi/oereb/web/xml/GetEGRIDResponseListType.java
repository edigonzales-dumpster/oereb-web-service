package ch.so.agi.oereb.web.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "egridType"
})
@XmlRootElement(name = "GetEGRIDResponseListType")
public class GetEGRIDResponseListType {
    @XmlElement(name = "EgridType")
    private List<GetEGRIDResponseType> egridType;
    
    public List <GetEGRIDResponseType> getEgridType() {
        if (egridType == null) {
        		egridType = new ArrayList<GetEGRIDResponseType>();
        }
        return this.egridType;
    }
}