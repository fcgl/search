package com.fcgl.madrid.dev;

import com.fcgl.madrid.search.payload.InternalStatus;
import com.fcgl.madrid.search.payload.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/dev")
public class IndexController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private SampleDataSet sampleDataSet;

    @GetMapping(value = "/populate")
    public Response<String> populate() {
        sampleDataSet.populateData();
        return new Response<>(InternalStatus.OK, "Done");

    }
}
