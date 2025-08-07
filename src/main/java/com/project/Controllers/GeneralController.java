package com.project.Controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Models.Objects.KeyValueModel;
import com.project.Objects.Entities.AnswerEntity;
import com.project.Objects.Entities.QuestionEntity;
import com.project.Objects.Entities.UserEntity;
import com.project.Models.Responses.*;
import com.project.Services.GeneralService;
import com.project.Utils.CustomLogger;
import com.project.Utils.DbUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.project.Utils.ErrorCodes.ERROR_CODE_GENERAL;


@RestController
@RequestMapping(value = "/fm1")
public class GeneralController {


    @Autowired
    private GeneralService generalService;

    @Autowired
    private DbUtils dbUtils;

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


    @RequestMapping (method = {RequestMethod.POST, RequestMethod.GET}, value = "/add-user")
    public BaseResponseModel addUser (BaseResponseModel baseResponseModel, String phone, String name) {
        boolean error = false;
        Integer code = null;
        try {
            UserEntity userEntity = new UserEntity(phone, name);
            int id = dbUtils.insertUser(userEntity);
            baseResponseModel = new IntegerResponseModel(baseResponseModel, id);
        } catch (Exception e) {
            LOGGER.log(e, "addUser {}", e);
            code = ERROR_CODE_GENERAL;
            error = true;
        }
        baseResponseModel.setError(error);
        baseResponseModel.setCode(code);
        return baseResponseModel;
    }



    @RequestMapping (method = {RequestMethod.POST, RequestMethod.GET}, value = "/questions")
    public BaseResponseModel questions (BaseResponseModel baseResponseModel) {
        boolean error = false;
        Integer code = null;
        try {
            List<QuestionEntity> questions = dbUtils.getAllQuestions();
            baseResponseModel = new QuestionsResponseModel(baseResponseModel, questions);
        } catch (Exception e) {
            LOGGER.log(e, "questions {}", e);
            code = ERROR_CODE_GENERAL;
            error = true;
        }
        baseResponseModel.setError(error);
        baseResponseModel.setCode(code);
        return baseResponseModel;
    }

    @RequestMapping (method = {RequestMethod.POST, RequestMethod.GET}, value = "/submit")
    public BaseResponseModel submit (BaseResponseModel baseResponseModel, String data, int userId) {
        boolean error = false;
        Integer code = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> map = objectMapper.readValue(data, Map.class);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                AnswerEntity answerEntity = new AnswerEntity(userId, Integer.valueOf(entry.getKey()), entry.getValue());
                dbUtils.insertAnswer(answerEntity);
            }
        } catch (Exception e) {
            LOGGER.log(e, "submit {}", e);
            code = ERROR_CODE_GENERAL;
            error = true;
        }
        baseResponseModel.setError(error);
        baseResponseModel.setCode(code);
        return baseResponseModel;
    }



}
