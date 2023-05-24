package org.webMonster.uniManageBoot.member.model.dto;

import lombok.*;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class MemberDepartmentDto {
    private long memberIdx;    //시퀀스
    private long memberId;  //아이디
    private String memberPwd;  //비밀번호
    private String name;        //이름
    private long departmentId;  //학과
    private Integer grade;        //학년
    private Date birthday;      //생년월일
    private String phone;       //전화번호
    private String email;       //이메일
    private int postcode;       //우편번호
    private String address1;   //주소1
    private String address2;    //주소2
    private int auth;           //권한구분:교수 1, 교직원 2,재학생 3, 졸업생 4, 휴학생 5

    private String departmentName;  //학과이름

    public static MemberDepartmentDto fromEntity(MemberEntity memberEntity) {
        MemberDepartmentDto dto = new MemberDepartmentDto();
        dto.setMemberId(memberEntity.getMemberId());
        dto.setName(memberEntity.getName());
        dto.setMemberPwd(memberEntity.getMemberPwd());
        dto.setDepartmentId(memberEntity.getDepartmentId());
        dto.setGrade(memberEntity.getGrade());
        dto.setBirthday(memberEntity.getBirthday());
        dto.setPhone(memberEntity.getPhone());
        dto.setEmail(memberEntity.getEmail());
        dto.setPostcode(memberEntity.getPostcode());
        dto.setAddress1(memberEntity.getAddress1());
        dto.setAddress2(memberEntity.getAddress2());
        dto.setAuth(memberEntity.getAuth());
        dto.setDepartmentName(memberEntity.getDepartment().getDepartmentName());
        return dto;
    }
}
