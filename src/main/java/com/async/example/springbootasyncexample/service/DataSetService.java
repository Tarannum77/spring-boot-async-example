package com.async.example.springbootasyncexample.service;

import com.async.example.springbootasyncexample.model.DataSet;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DataSetService {
    private final List<DataSet> datasetList = new ArrayList<>();

    @PostConstruct
    public void setup() {
        createDataSets();
    }

    public List<DataSet> findAll() {
        return Collections.unmodifiableList(datasetList);
    }

    private Iterable<DataSet> createDataSets()
    {
        String name = "dummy text_";

        for (int i = 0; i < 5; i++) {
            this.datasetList.add(new DataSet(BigInteger.valueOf(i), name + i));
        }
        return datasetList;
    }
}
