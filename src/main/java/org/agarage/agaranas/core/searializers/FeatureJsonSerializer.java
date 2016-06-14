package org.agarage.agaranas.core.searializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.agarage.agaranas.core.interfaces.FeatureInterface;

import java.io.IOException;

/**
 * Created by Nicholas on 2016/6/14.
 */
public class FeatureJsonSerializer extends JsonSerializer<FeatureInterface> {
    @Override
    public void serialize(FeatureInterface featureInterface, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("displayCategory", featureInterface.getDisplayCategory());
        jsonGenerator.writeObjectField("menuItem", featureInterface.getMenuItem());
        jsonGenerator.writeEndObject();
    }

    @Override
    public Class<FeatureInterface> handledType() {
        return FeatureInterface.class;
    }
}
