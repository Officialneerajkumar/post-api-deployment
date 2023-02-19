package com.example.User.Management.System.util;

import com.example.User.Management.System.model.User;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator {

//    You have add validation on username ,
//    dateofBirth (date of birth should be validated with hyphen(-)),
//    email,PhoneNumber(length of phone number should be 12 digit ,
//    first two digit is country code and rest phone number)


    public List<String> validateUser(JSONObject json){

        List<String> errorList = new ArrayList<>();
        if(!json.has("userName")){
            errorList.add("userName");
        }
        if(!json.has("dateOfBirth")){
            errorList.add("dateOfBirth");
        }
        if(!json.has("email")){
            errorList.add("email");
        }
        if(!json.has("phoneNumber")) {
            errorList.add("phoneNumber");
        }
//        }else{
//            if(!validatePhoneNumber(json.getString("phoneNumber"))) errorList.add("phoneNumber");
//        }
        return errorList;
    }

    public User setUser(JSONObject json){
        User user = new User();

        String userName = json.getString("userName");
        user.setUserName(userName);

        String dateOfBirth = json.getString("dateOfBirth");
        user.setDateOfBirth(dateOfBirth);

        String email = json.getString("email");
        user.setEmail(email);

        String phoneNumber = json.getString("phoneNumber");
        user.setPhoneNumber(Integer.valueOf(phoneNumber));

        return user;
    }

    public boolean validatePhoneNumber(String phoneNumber){
        if(phoneNumber.length()!=12) return false;
        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(phoneNumber);
        return (m.matches());
    }

}
