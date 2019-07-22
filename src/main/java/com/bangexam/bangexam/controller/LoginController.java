package com.bangexam.bangexam.controller;

import com.bangexam.bangexam.model.User;
import com.bangexam.bangexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kaneki
 * @date 2019/7/13 14:04
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/login")
    public String toLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, User user, HttpServletResponse response, HttpSession session) {
        User user1 = userService.findByUsernameAndPassword(user);
        if (user1 != null) {
            String token = "user";
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(3600);
            cookie.setPath("/");
            response.addCookie(cookie);
            session.setAttribute("id",user1.getId());
            return "index";
        }
        return "login";
    }

    //微信小程序登录
    @PostMapping("/api/login/applet")
    @ResponseBody
    public Map login4applet(String code, String nickName, String encryptedData, String iv, String avatarUrl) {
        System.out.println("code +=+++" + code);
        System.out.println("nickName +=+++" + nickName);
        System.out.println("encryptedData +=+++" + encryptedData);
        System.out.println("iv +=+++" + iv);
        System.out.println("avatarUrl +=+++" + avatarUrl);
        Map map = new HashMap();
        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }

//        //小程序唯一标识   (在微信小程序管理后台获取)
//        String wxspAppid = "";
//        //小程序的 app secret (在微信小程序管理后台获取)
//        String wxspSecret = "************************";
//        //授权（必填）client_credential
//        String grant_type = "authorization_code";
//        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
//        //请求参数
//        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
//        //发送请求
//        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
//        //解析相应内容（转换成json对象）
//        JSONObject json = JSONObject.fromObject(sr);
//        //获取会话密钥（session_key）
//        String session_key = json.get("session_key").toString();
//        //用户的唯一标识（openid）
//        String openid = (String) json.get("openid");
//
//        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
//        try {
//            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
//            if (null != result && result.length() > 0) {
//                map.put("status", 1);
//                map.put("msg", "解密成功");
//
//                JSONObject userInfoJSON = JSONObject.fromObject(result);
//                Map userInfo = new HashMap();
//                userInfo.put("openId", userInfoJSON.get("openId"));
//                userInfo.put("nickName", userInfoJSON.get("nickName"));
//                userInfo.put("gender", userInfoJSON.get("gender"));
//                userInfo.put("city", userInfoJSON.get("city"));
//                userInfo.put("province", userInfoJSON.get("province"));
//                userInfo.put("country", userInfoJSON.get("country"));
//                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
//                userInfo.put("unionId", userInfoJSON.get("unionId"));
//                map.put("userInfo", userInfo);
//                return map;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        map.put("status", 0);
        map.put("msg", "解密失败");
        return map;
    }
}
