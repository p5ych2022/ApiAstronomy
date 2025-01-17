package com.astronomy.astronomyapi.utils;

import com.astronomy.astronomyapi.DTO.UserParamDTO;

import java.util.List;

public class ParamUtils {

    public static String buildUserListParams(List<UserParamDTO> userList) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < userList.size(); i++) {
            UserParamDTO user = userList.get(i);
            builder.append("&user_list%5B")
                    .append(i)
                    .append("%5D%5Blongitude%5D=")
                    .append(user.getLongitude())
                    .append("&user_list%5B")
                    .append(i)
                    .append("%5D%5Blatitude%5D=")
                    .append(user.getLatitude())
                    .append("&user_list%5B")
                    .append(i)
                    .append("%5D%5Btz%5D=")
                    .append(user.getTz())
                    .append("&user_list%5B")
                    .append(i)
                    .append("%5D%5Bbirthday%5D=")
                    .append(user.getBirthday());
        }
        return builder.toString();
    }
}
