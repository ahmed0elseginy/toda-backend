package com.toda.todo.service.secuirty;

import com.toda.todo.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static com.toda.todo.model.enums.TaskErrors.INVALID_REQUEST;
import static com.toda.todo.model.enums.TaskErrors.UNEXPECTED_ERROR;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    @Value("${internal.api.key}")
    private String internalApiKey;

    private static final String USER_SERVICE_URL = "http://localhost:8104/users/check/{userId}";

    @Override
    public boolean checkUserExists(Long userId) {
        System.out.println("Checking user existence for ID: " + userId);

        String url = UriComponentsBuilder
                .fromHttpUrl(USER_SERVICE_URL)
                .buildAndExpand(userId)
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", internalApiKey);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                Void.class
        );

        return responseEntity.getStatusCode() == HttpStatus.NO_CONTENT;
    }
}
