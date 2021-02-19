package com.cqjtu.studentdocument.controller;

import com.cqjtu.studentdocument.entity.SystemInfo;
import com.cqjtu.studentdocument.service.SystemInfoService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(description = "系统信息相关接口")
@Controller
@RequestMapping(value = "api/systemInfo")
public class SystemInfoController extends BaseController<SystemInfoService,SystemInfo,Integer> {
}
