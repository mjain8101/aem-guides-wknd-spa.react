package com.adobe.aem.guides.wkndspa.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;

// Sling Models intended to be used with SPA Editor must extend ComponentExporter interface
public interface HeroModel extends ComponentExporter {
    public String getText();
    public String getLinklabel();
    public String getLink();
    public String getMobileImage();
}