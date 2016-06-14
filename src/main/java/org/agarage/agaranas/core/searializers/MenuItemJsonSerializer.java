package org.agarage.agaranas.core.searializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.agarage.agaranas.core.models.MenuItem;

import java.io.IOException;

/**
 * Created by Nicholas on 2016/6/14.
 */
public class MenuItemJsonSerializer extends JsonSerializer<MenuItem> {
    @Override
    public void serialize(MenuItem menuItem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("displayName", menuItem.getDisplayName());
        jsonGenerator.writeEndObject();
    }

    @Override
    public Class<MenuItem> handledType() {
        return MenuItem.class;
    }
}
