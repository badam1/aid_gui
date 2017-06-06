package com.fornax.test.service;

/*
 * Created by Adam Bodansky on 2017.06.06..
 */

import com.fornax.test.dto.AidDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AidService {

    private static final Logger log = LoggerFactory.getLogger(AidService.class);

    private final RestTemplate restTemplate;

    @Autowired
    public AidService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<AidDTO> createAidDTOListFromJsonAidList() {
        List<AidDTO> aidDTOList = new ArrayList<>();
        ResponseEntity<AidDTO[]> responseEntity = restTemplate.getForEntity("http://localhost:8880/api/aid-list", AidDTO[].class);
        AidDTO[] aids = responseEntity.getBody();
        aidDTOList.addAll(Arrays.asList(aids));
        log.info("createAidDTOListFromJsonAidList() {}", aidDTOList);
        return aidDTOList;
    }
}
