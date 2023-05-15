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
public class MemberDto {

    private long memberIdx;    //시퀀스
    private long memberId;  //아이디
    private String memberPwd;  //비밀번호
    private String name;        //이름
    private int departmentId;  //학과
    private int grade;        //학년
    private Date birthday;      //생년월일
    private String phone;       //전화번호
    private String email;       //이메일
    private int postcode;       //우편번호
    private String address1;   //주소1
    private String address2;    //주소2
    private int auth;           //권한구분:교수 1, 교직원 2,재학생 3, 졸업생 4, 휴학생 5


    public static MemberDto fromEntity(MemberEntity memberEntity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberIdx(memberEntity.getMemberIdx());
        memberDto.setMemberId(memberEntity.getMemberId());
        memberDto.setMemberPwd(memberEntity.getMemberPwd());
        memberDto.setName(memberEntity.getName());
        memberDto.setDepartmentId(memberEntity.getDepartmentId());
        memberDto.setGrade(memberEntity.getGrade());
        memberDto.setBirthday(memberEntity.getBirthday());
        memberDto.setPhone(memberEntity.getPhone());
        memberDto.setEmail(memberEntity.getEmail());
        memberDto.setPostcode(memberEntity.getPostcode());
        memberDto.setAddress1(memberEntity.getAddress1());
        memberDto.setAddress2(memberEntity.getAddress2());
        memberDto.setAuth(memberEntity.getAuth());
        return memberDto;
    }

    public MemberEntity toEntity() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberIdx(this.getMemberIdx());
        memberEntity.setMemberId(this.getMemberId());
        memberEntity.setMemberPwd(this.getMemberPwd());
        memberEntity.setName(this.getName());
        memberEntity.setDepartmentId(this.getDepartmentId());
        memberEntity.setGrade(this.getGrade());
        memberEntity.setBirthday(this.getBirthday());
        memberEntity.setPhone(this.getPhone());
        memberEntity.setEmail(this.getEmail());
        memberEntity.setPostcode(this.getPostcode());
        memberEntity.setAddress1(this.getAddress1());
        memberEntity.setAddress2(this.getAddress2());
        memberEntity.setAuth(this.getAuth());
        return memberEntity;
    }

}
