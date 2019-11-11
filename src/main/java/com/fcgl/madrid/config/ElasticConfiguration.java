package com.fcgl.madrid.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;

/**
 * Configuration for Elastic Search
 * TODO: move static text to a properties file
 */
@Configuration
public class ElasticConfiguration{

    private static final String TRANSPORT_PORT = "192.168.112.2";
    @Bean
    public TransportClient client() throws UnknownHostException {
        final Settings esSettings = Settings.builder().put("cluster.name", "docker-cluster").build();
        PreBuiltTransportClient client = new PreBuiltTransportClient(Settings.builder().put("cluster.name", "docker-cluster").build());
        client.addTransportAddress(new TransportAddress(InetAddress.getByName(TRANSPORT_PORT), 9300));
        return client;

    }
}
