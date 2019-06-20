package com.steven.shiro.config;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.steven.shiro.entity.SysPermission;
import com.steven.shiro.entity.SysRole;
import com.steven.shiro.entity.SysUserRole;
import com.steven.shiro.entity.UserInfo;
import com.steven.shiro.mapper.SysPermissionMapper;
import com.steven.shiro.mapper.SysRoleMapper;
import com.steven.shiro.mapper.SysUserRoleMapper;
import com.steven.shiro.mapper.UserInfoMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principals.getPrimaryPrincipal();

        //获取用户所拥有的角色
        List<SysRole> sysUserRoles = sysRoleMapper.selectListByUid(userInfo.getUid());
        for(SysRole role:sysUserRoles){
            authorizationInfo.addRole(role.getRole());

            //获取角色所拥有的权限
            List<SysPermission> sysPermissions = sysPermissionMapper.selectListByRoleId(role.getId());
            for(SysPermission p:sysPermissions){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取用户的输入的账号.
        String username = (String)authenticationToken.getPrincipal();

        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        UserInfo newUserInfo = userInfoMapper.selectOne(userInfo);

        if(newUserInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                newUserInfo, //用户名
                newUserInfo.getPassword(), //密码
                ByteSource.Util.bytes(newUserInfo.getSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    /**
     * [工具] 此工具用于注册时对密码进行加密
     * @param password, salt
     * @return java.lang.String
     * @author StevenGuo
     * @date 16:07 2019/6/18
     **/
    public static final String md5(String password, String salt){
        //加密方式
        String hashAlgorithmName = "MD5";
        //盐：为了即使相同的密码不同的盐加密后的结果也不同
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        //密码
        Object source = password;
        //加密次数
        int hashIterations = 1024;
        SimpleHash result = new SimpleHash(hashAlgorithmName, source, byteSalt, hashIterations);
        return result.toString();
    }


}
