package org.agarage.agaranas.core.beans;

import org.agarage.agaranas.core.searializers.FeatureJsonSerializer;
import org.agarage.agaranas.core.searializers.MenuItemJsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by Nicholas on 2016/6/14.
 */
@Component
public class JacksonBean {
    @Bean
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        return new Jackson2ObjectMapperBuilder().serializers(new FeatureJsonSerializer(), new MenuItemJsonSerializer());
    }
}
