package com.adobe.aem.guides.wkndspa.react.core.models.impl;

import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import com.adobe.aem.guides.wkndspa.react.core.models.HeroModel;

// Sling Model annotation
@Model(
    adaptables = SlingHttpServletRequest.class,
    adapters = { HeroModel.class, ComponentExporter.class },
    resourceType = HeroModelImpl.RESOURCE_TYPE,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter( //Exporter annotation that serializes the modoel as JSON
    name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
    extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class HeroModelImpl implements HeroModel {

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String linklabel; 

    @ValueMapValue
    private String link; 

    @ValueMapValue
    public String mobileImage;

    @ScriptVariable
    private Page currentPage;

    // points to AEM component definition in ui.apps
    static final String RESOURCE_TYPE = "wknd-spa-react/components/hero";

    // public getter method to expose value of private variable `label`
    // adds additional logic to default the label to "(Default)" if not set.
    @Override
    public String getText() {
        String title = currentPage.getProperties().get("title", StringUtils.EMPTY);
        return StringUtils.isNotBlank(text) ? text :title;
    }

    @Override
    public String getLinklabel() {
        return StringUtils.isNotBlank(linklabel) ? linklabel : "Link label";
    }

    @Override
    public String getLink() {
        return StringUtils.isNotBlank(link) ? link : "path";
    }

    @Override
    public String getMobileImage() {
        return StringUtils.isNotBlank(mobileImage) ? mobileImage : "Image Path";
    }

    // method required by `ComponentExporter` interface
    // exposes a JSON property named `:type` with a value of `wknd-spa-react/components/Hero`
    // required to map the JSON export to the SPA component props via the `MapTo`
    @Override
    public String getExportedType() {
        return HeroModelImpl.RESOURCE_TYPE;
    }
}
