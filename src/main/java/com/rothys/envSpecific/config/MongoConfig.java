package com.rothys.envSpecific.config;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {
    @Bean
    public MongoClient mongoClient() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                CodecRegistries.fromCodecs(new ZonedDateTimeCodec()),
                MongoClientSettings.getDefaultCodecRegistry()
        );

        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();

        return MongoClients.create(settings);
    }

}
