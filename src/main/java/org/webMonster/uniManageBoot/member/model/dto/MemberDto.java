package org.webMonster.uniManageBoot.member.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class MemberDto {

    private long memberIdx;    //시퀀스
    private long memberId;  //아이디
    private String memberPwd;  //비밀번호
    private String name;        //이름
    private int departmentId;  //학과
    private int grade;        //학년
    private String birthday;      //생년월일
    private String phone;       //전화번호
    private String email;       //이메일
    private int postcode;       //우편번호
    private String address1;   //주소1
    private String address2;    //주소2
    private int auth;           //권한구분:교수 1, 교직원 2,재학생 3, 졸업생 4, 휴학생 5
}
