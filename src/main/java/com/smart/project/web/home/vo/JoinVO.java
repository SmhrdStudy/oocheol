package com.smart.project.web.home.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class JoinVO {
    String id;
    String email;
    String pw;
    String nick;
    String gender;
    String birth;
    String locWantKey;
    String wantLoc;
}
