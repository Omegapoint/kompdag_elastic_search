package se.omegapoint;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.DummyTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

@Configuration
public class BeanFactory {


    @Bean
    public Client getClient() {
        return TransportClient
                .builder()
                .settings(getSettings())
                .build()
                .addTransportAddress(DummyTransportAddress.INSTANCE);
    }

    @Bean
    public Settings getSettings() {
        URL url = getClass().getClassLoader().getResource("elasticsearch.yml");
        Objects.requireNonNull(url);
        URI uri;
        try {
            uri = url.toURI();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(String.format("Unable to resolve URI from elasticsearch.yml URL: %s", url));
        }
        return Settings.builder()
                .loadFromPath(Paths.get(uri))
                .build();
    }
}
