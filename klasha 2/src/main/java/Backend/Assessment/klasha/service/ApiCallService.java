package Backend.Assessment.klasha.service;

import Backend.Assessment.klasha.dto.FetchTopCitiesReqDto;
import Backend.Assessment.klasha.dto.FetchTopResCityDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Component
@Slf4j
public class ApiCallService {
    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<Object> getCountries(String url) {
        ResponseEntity<Object> responseEntity;
        HttpEntity<Object> httpEntity = new HttpEntity<>(getHeaders());
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Object.class);
            return responseEntity;
        } catch (RestClientException e) {
            log.info("error :{}", e.getMessage());
        }

        return null;
    }

    public ResponseEntity<Object> fetchCountryInfo(String url, Map<String, String> request) {
        ResponseEntity<Object> responseEntity;
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(getHeaders());
        responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Object.class);
        return responseEntity;
    }


    private HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return  headers;
    }

}
