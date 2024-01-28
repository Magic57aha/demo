package com.example.firstspringboot.provider;

import com.alibaba.fastjson.JSON;
import com.example.firstspringboot.dto.AccessTokenDTO;
import com.example.firstspringboot.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json");
        OkHttpClient client = new OkHttpClient();
//        打印Json信息
//        System.out.println(JSON.toJSONString(accessTokenDTO));

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            // 拆解响应内容，得到accessToken
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            System.out.println(token);
            return token;
        } catch (IOException e) {
            // 打印异常信息
//            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        // 替换为你的GitHub访问令牌
        String token = "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";

        // GitHub API请求URL
        String apiUrl = "https://api.github.com/user";

        // 创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();

        // 构建请求
        Request request = new Request.Builder()
                .url(apiUrl)
                .header("Authorization", "Bearer " + token)
                .build();

        // 发送请求并处理响应
        try (Response response = client.newCall(request).execute()) {
            // 检查响应是否成功
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }

            // 获取响应体
            String responseBody = response.body().string();
            // 输出响应内容
//            System.out.println("Response Code: " + response.code());
//            System.out.println("Response Body: " + responseBody);
            // 转换响应内容为GithubUser类
            GithubUser githubUser = JSON.parseObject(responseBody, GithubUser.class);
            return githubUser;

        } catch (IOException e) {
//            异常信息
            e.printStackTrace();
        }
        return null;
    }
}
