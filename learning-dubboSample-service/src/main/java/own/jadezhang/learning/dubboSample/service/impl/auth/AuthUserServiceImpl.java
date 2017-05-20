/*
{*****************************************************************************
{  dubbo示例 v1.0													
{  版权信息 (c) 2005-2017 http://git.oschina.net/htengen
{  创建人：  zjw
{  审查人：
{  模块：											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2017-05-20  zjw        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package own.jadezhang.learning.dubboSample.service.impl.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.jadezhang.base.common.dao.IBaseDAO;
import own.jadezhang.base.common.service.impl.AbstractBaseService;
import own.jadezhang.learning.dubboSample.dao.auth.IAuthUserDAO;
import own.jadezhang.learning.dubboSample.domain.auth.AuthUser;
import own.jadezhang.learning.dubboSample.service.auth.IAuthUserService;

/**
 * 《用户表》 业务逻辑服务类
 * @author zjw
 */
@Service("AuthUserServiceImpl")
public class AuthUserServiceImpl extends AbstractBaseService<IBaseDAO<AuthUser>, AuthUser> implements IAuthUserService<IBaseDAO<AuthUser>, AuthUser> {
    @Autowired
    private IAuthUserDAO authUserDAO;

    @Override
    public IBaseDAO<AuthUser> getDao() {
        return authUserDAO;
    }

}