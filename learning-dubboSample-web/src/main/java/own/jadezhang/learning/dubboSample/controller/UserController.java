package own.jadezhang.learning.dubboSample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import own.jadezhang.learning.dubboSample.api.dto.AuthUerDto;
import own.jadezhang.learning.dubboSample.api.rpc.IUserService4Rpc;

/**
 * Created by Zhang Junwei on 2017/7/22.
 */
@Controller
@RequestMapping("/dubboSample/user")
public class UserController {
    @Autowired
    private IUserService4Rpc userService4Rpc;

    @ResponseBody
    @RequestMapping(value = "/findOne")
    public AuthUerDto findOne() {
        AuthUerDto user = userService4Rpc.findUser("082ba75a22a648a680e3ea7982e7ecdb");
        return user;
    }
}
