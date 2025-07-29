package com.project.Controllers;


import com.project.Models.Responses.*;
import com.project.Services.GeneralService;
import com.project.Utils.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.project.Utils.ErrorCodes.ERROR_CODE_GENERAL;


@RestController
@RequestMapping(value = "/fm1")
public class GeneralController {


    @Autowired
    private GeneralService generalService;

    public static final CustomLogger LOGGER = new CustomLogger(GeneralController.class);


    @RequestMapping (method = {RequestMethod.POST, RequestMethod.GET}, value = "/start")
    public BaseResponseModel start (BaseResponseModel baseResponseModel, String id, String name) {
        boolean error = false;
        Integer code = null;
        try {


        } catch (Exception e) {
            LOGGER.log(e, "start {}", e);
            code = ERROR_CODE_GENERAL;
            error = true;
        }
        baseResponseModel.setError(error);
        baseResponseModel.setCode(code);
        return baseResponseModel;
    }





}
