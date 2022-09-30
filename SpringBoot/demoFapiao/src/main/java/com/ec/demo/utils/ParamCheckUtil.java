package com.ec.demo.utils;

import org.apache.commons.lang3.StringUtils;

public class ParamCheckUtil {
    /**
     * 空值校验
     * @param param
     * @return
     */
    public static boolean nullValueCheck(String param){
        return StringUtils.isAllBlank(param);
    }

    /**
     * 校验手机号（有返回值）
     * 手机号码格式校验
     * 中国移动号段：134 135 136 137 138 139 147 148 150 151 152 157 158 159 165 172 178 182 183 184 187 188 198
     * 中国联通号段：130 131 132 145 146 155 156 166 170 171 175 176 185 186
     * 中国电信号段：133 149 153 170 173 174 177 180 181 189 191 199
     * 虚拟运营商号段：162 165 167 170 171
     *
     * @param phoneNum
     * @return
     */
    public static boolean phoneNoCheck(String phoneNum){
        //[1]中的数字代表下一位为多少，[0-9]表示可以为0-9中的一个，[5,6]表示可以为5,6中的一个，[^4]表示除4之外的任何一个，\\d{8}代表后面8位可以是0~9的数字，^匹配开始位置，$匹配结束位置
        String telRegex = "^((13[0-9])|(14[5-9])|(15[^4])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[1,8,9]))\\d{8}$";
        if (StringUtils.isBlank(phoneNum) || phoneNum.length() != 11) {
            return false;
        } else {
            return phoneNum.matches(telRegex);
        }
    }

    public static boolean postalCodeCheck(String postalCode){
        String regex = "^[1-9]\\d{5}$";
        return postalCode.matches(regex);
    }
}
