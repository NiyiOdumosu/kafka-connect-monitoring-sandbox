package shipment.tracking.transformer.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;


@JacksonXmlRootElement(localName = "DIM")
public class HawbDimensions {

    @JacksonXmlProperty(localName = "WF")
    String wf;

    @JacksonXmlProperty(localName = "WU")
    String wu;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "P")
    List<String> p = new ArrayList<>();

    public void setP(List<String> pValues) {
        this.p.addAll(pValues);
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "L")
    List<String> l = new ArrayList<>();

    public void setL(List<String> lValues) {
        this.l.addAll(lValues);
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "W")
    List<String> w = new ArrayList<>();

    public void setW(List<String> wValues) {
        this.w.addAll(wValues);
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "H")
    List<String> h = new ArrayList<>();

    public void setH(List<String> hValues) {
        this.h.addAll(hValues);
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "GW")
    List<String> gw = new ArrayList<>();

    public void setGw(List<String> gwValues) {
        this.gw.addAll(gwValues);
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "VW")
    List<String> vw = new ArrayList<>();

    public void setVW(List<String> vwValues) {
        this.vw.addAll(vwValues);
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CW")
    List<String> cw = new ArrayList<>();

    public void setCw(List<String> cwValues) {
        this.cw.addAll(cwValues);
    }

    //Getters
    public String getWf() {
        return wf;
    }

    public String getWu() {
        return wu;
    }

    public List<String> getP() {
        return p;
    }

    public List<String> getL() {
        return l;
    }

    public List<String> getW() {
        return w;
    }

    public List<String> getH() {
        return h;
    }

    public List<String> getGw() {
        return gw;
    }

    public List<String> getVw() {
        return vw;
    }

    public List<String> getCw() {
        return cw;
    }

}


