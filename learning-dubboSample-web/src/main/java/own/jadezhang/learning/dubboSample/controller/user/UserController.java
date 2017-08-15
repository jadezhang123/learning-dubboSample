package own.jadezhang.learning.dubboSample.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import own.jadezhang.learning.dubboSample.api.dto.AuthUerDto;
import own.jadezhang.learning.dubboSample.api.rpc.IUserService4Rpc;
import own.jadezhang.learning.dubboSample.common.Constant;
import own.jadezhang.learning.dubboSample.common.ResultDto;
import own.jadezhang.learning.dubboSample.domain.auth.AuthUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @ResponseBody
    @RequestMapping(value = "/login")
    public ResultDto login(HttpServletRequest request, String userName, String password) {
        AuthUser user = new AuthUser();
        user.setName(userName);
        user.setPassword(password);
        request.getSession().setAttribute(Constant.LOGIN_USER, user);
        return new ResultDto(true, "登录成功");
    }

    @ResponseBody
    @RequestMapping(value = "/index")
    public ResultDto index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        AuthUser user = (AuthUser) session.getAttribute(Constant.LOGIN_USER);
        if (user != null) {
            user.setCode(session.getId());
            return new ResultDto(true, user);
        }
        return new ResultDto(false, "当前用户未登录");
    }

}
