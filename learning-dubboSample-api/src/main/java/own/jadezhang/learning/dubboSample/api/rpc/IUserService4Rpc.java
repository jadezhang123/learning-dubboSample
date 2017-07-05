package own.jadezhang.learning.dubboSample.api.rpc;

import own.jadezhang.learning.dubboSample.api.dto.AuthUerDto;

/**
 * Created by Zhang Junwei on 2017/7/4.
 */
public interface IUserService4Rpc {

    AuthUerDto findUser(String userCode);

}
