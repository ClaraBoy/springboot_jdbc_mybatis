package com.yu.springboot_jdbc_mybatis.tool;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yu.springboot_jdbc_mybatis.pojo.Users;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class Token {
    //过期时间
    private static final Integer TIME_OUT_DAY = 30;
    //需要重新生成的天数 如果token的时间超过这个 则重新生成token
    private static final Integer NEED_CREATE_DAY = 7;
    /**
     * token秘钥
     */
    private static final String TOKEN_SECRET = "Clara";

    public static String sign(String username, String loginTime,String key) {
        try {
        // 设置过期时间
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE,TIME_OUT_DAY);
        // 私钥和加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        // 设置头部信息
        Map<String, Object> header = new HashMap<>(2);
        header.put("Type", "Jwt");
        header.put("alg", "HS256");
        // 返回token字符串
        return JWT.create()
                .withHeader(header)
                .withClaim("loginName", username)
                .withClaim("key", DigestUtils.md5DigestAsHex(key.getBytes()))
                .withClaim("loginTime", loginTime)
                .withExpiresAt(calendar.getTime())
                .sign(algorithm);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    /**
     * 检验token是否正确
     * @param token 需要校验的token
     * @return 校验是否成功
     */
    public static DecodedJWT verify(String token){
        try {
            //设置签名的加密算法：HMAC256
            DecodedJWT verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build().verify(token);;
            return verifier;
        } catch (Exception e){
            return null;
        }
    }
    /**
     * 获取用户ID
     * @param decodedJWT
     * @return
     */
    public static String getUserId(DecodedJWT decodedJWT){
        return decodedJWT.getClaim("loginName").asString();
    }

    /**
     * 验证是否修改过密码
     * @param decodedJWT
     * @param users
     * @return
     */
    public static boolean isUpdatedPassword(DecodedJWT decodedJWT, Users users){
        String oldPwd = decodedJWT.getClaim("key").asString();
        String newPwd = DigestUtils.md5DigestAsHex(users.getUpwd().getBytes());
        return oldPwd.equals(newPwd)?false:true;
    }

    /**
     * 是否需要重新生成token （为了延续token时长）
     * @param decodedJWT
     * @return
     */
    public static boolean needCreate(DecodedJWT decodedJWT) {
        Date timeoutDate = decodedJWT.getExpiresAt();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, TIME_OUT_DAY - NEED_CREATE_DAY);
        if (timeoutDate.before(calendar.getTime())) {
            return true;
        }
        return false;
    }
    public static String getTime(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
//    @Test
//    public void token() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Token Buildtoken=new Token();
//        String Time=Buildtoken.getTime();
//        Class login=Class.forName("com.yu.springboot_jdbc_mybatis.pojo.LoginVo");
//        System.out.println(login.getName());
//        Constructor constructor=login.getDeclaredConstructor(Integer.class,String.class,String.class,String.class,String.class);
//        String token=Buildtoken.sign("admin",Time);
//        LoginVo loginVo= (LoginVo) constructor.newInstance(0,"admin","123456",token,Time);
//       System.out.println(loginVo.getToken());
//        System.out.println(verify(token));
//    }

}
