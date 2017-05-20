import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import own.jadezhang.base.common.domain.BizData4Page;
import own.jadezhang.base.common.enums.MatchTypeEnum;
import own.jadezhang.learning.dubboSample.domain.auth.AuthUser;
import own.jadezhang.learning.dubboSample.param.auth.AuthUserParam;
import own.jadezhang.learning.dubboSample.service.auth.IAuthUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhang Junwei on 2017/5/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-service.xml")
public class AuthUserTester {
    @Autowired
    private IAuthUserService authUserService;

    @Test
    public void test() throws Exception {
        AuthUser user = new AuthUser();
        user.setName("ajk");
        user.setPassword("123");
        user.setPhone("15671569027");
        user.setStatus(0);
        user.setSalt("23");

        //authUserService.add(user);
        //authUserService.add(user);
        //authUserService.add(user);

/*        Integer integer = authUserService.deleteById(1L);
        Assert.assertEquals(0, integer.intValue());

        integer = authUserService.deleteByIds(Arrays.asList(2, 3, 4));
        Assert.assertEquals(0, integer.intValue());

        Map condition = new HashMap();
        condition.put(AuthUserParam.F_Name, "");
        integer = authUserService.deleteByCondition(condition);
        Assert.assertEquals(2, integer.intValue());*/

        //user.setName("jack");
        //authUserService.update(user);
        /*Map update = new HashMap();
        update.put(AuthUserParam.F_Salt, "salt");
        Map condition = new HashMap();
        condition.put(AuthUserParam.F_Name, "jack");
        Integer integer = authUserService.updateByCondition(update, condition);
        //Assert.assertEquals(2, integer.intValue());

        update.put(AuthUserParam.F_ID, 12L);
        update.put(AuthUserParam.F_Phone, "15671561234");*/
        //integer = authUserService.updateMap(update);
        //Assert.assertEquals(1, integer.intValue());

        //integer = authUserService.deleteByProperty(AuthUserParam.F_Salt, "salt");
        //Assert.assertEquals(2, integer.intValue());


        AuthUser one = (AuthUser) authUserService.findOne(AuthUserParam.F_Name, "ajk", AuthUserParam.F_Name, "desc");
        System.out.println(one);

        AuthUserParam param = new AuthUserParam();

        param.setName("aj");

        Map condition = new HashMap();
        condition.put(AuthUserParam.F_Name, "aj");

        List like = authUserService.like(condition, null, null);
        Assert.assertEquals(7, like.size());
        Map<String, Object> map = param.toSearchFieldMap(MatchTypeEnum.ALL_FUZZY);
        BizData4Page paging = authUserService.paging(map, 1, 10);

        System.out.println(paging.getRows().size());
    }
}
