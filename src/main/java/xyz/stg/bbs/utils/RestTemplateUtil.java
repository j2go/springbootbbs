package xyz.stg.bbs.utils;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

/**
 * Created by shitiangao on 16/7/19.
 */
public class RestTemplateUtil {
    public static RestTemplate newRestTemplate() {
        return newRestTemplate((new HttpComponentsClientHttpRequestFactory()));
    }

    public static RestTemplate newRestTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new SourceHttpMessageConverter<Source>());
        messageConverters.add(new AllEncompassingFormHttpMessageConverter());
        messageConverters.add(new GsonHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate(messageConverters);
        restTemplate.setRequestFactory(clientHttpRequestFactory);

        return restTemplate;
    }
}
