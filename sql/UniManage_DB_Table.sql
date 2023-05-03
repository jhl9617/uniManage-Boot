DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE FREEBOARD CASCADE CONSTRAINTS;
DROP TABLE FREEBOARD_REP CASCADE CONSTRAINTS;
DROP TABLE SCHEDULE CASCADE CONSTRAINTS;
DROP TABLE SCHOLARSHIP CASCADE CONSTRAINTS;
DROP TABLE TOTAL_SCORE CASCADE CONSTRAINTS;
DROP TABLE COURSE_REGI CASCADE CONSTRAINTS;
DROP TABLE GRADE CASCADE CONSTRAINTS;
DROP TABLE SCORE CASCADE CONSTRAINTS;
DROP TABLE LECTURE CASCADE CONSTRAINTS;
DROP TABLE NOTICE CASCADE CONSTRAINTS;
DROP TABLE STATUS CASCADE CONSTRAINTS;
DROP TABLE EVALUATION CASCADE CONSTRAINTS;
DROP TABLE TUITION CASCADE CONSTRAINTS;
DROP TABLE DEPARTMENT CASCADE CONSTRAINTS;
DROP TABLE LECTURE_CLASS_TIME CASCADE CONSTRAINTS;
DROP TABLE BUILDING CASCADE CONSTRAINTS;
DROP TABLE LECTURE_CLASS CASCADE CONSTRAINTS;
DROP TABLE LECTURE_SCHEDULE CASCADE CONSTRAINTS;
DROP TABLE LECTURE_ROOM_TIMETABLE CASCADE CONSTRAINTS;
DROP TABLE LECTURE_NOTICE CASCADE CONSTRAINTS;
DROP TABLE LECTURE_ROOM CASCADE CONSTRAINTS;
DROP TABLE LECTURE_ROOM_FILE CASCADE CONSTRAINTS;
DROP TABLE HOMEWORK CASCADE CONSTRAINTS;
DROP TABLE HOMEWORK_FILE CASCADE CONSTRAINTS;
DROP TABLE ATTENDANCE CASCADE CONSTRAINTS;
DROP TABLE CANCELLED_LECTURE CASCADE CONSTRAINTS;


DROP SEQUENCE MEMBER_IDX_SEQ;
DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE LECTURE_ID_SEQ;
DROP SEQUENCE FREE_ID_SEQ;
DROP SEQUENCE FREE_REP_ID_SEQ;
DROP SEQUENCE SCHE_ID_SEQ;
DROP SEQUENCE STATUS_ID_SEQ;
DROP SEQUENCE SCHO_ID_SEQ;
DROP SEQUENCE COURSE_REGI_ID_SEQ;
DROP SEQUENCE SCORE_ID_SEQ;
DROP SEQUENCE EVALUATION_ID_SEQ;
DROP SEQUENCE BUILDING_CODE_SEQ;
DROP SEQUENCE LECTURE_ROOM_CODE_SEQ;
DROP SEQUENCE LECTURE_NOTICE_ID_SEQ;
DROP SEQUENCE LECTURE_ROOM_ID_SEQ;
DROP SEQUENCE HOMEWORK_ID_SEQ;
DROP SEQUENCE ATTENDANCE_ID_SEQ;
DROP SEQUENCE NOTICE_ID_SEQ;
DROP SEQUENCE TUITION_ID_SEQ;





CREATE TABLE DEPARTMENT (
                          DEPARTMENT_ID NUMBER PRIMARY KEY,
                          DEPARTMENT_NAME VARCHAR2(100) NOT NULL,
                          CATEGORY VARCHAR2(100) NOT NULL
);

COMMENT ON TABLE DEPARTMENT IS '학과';
COMMENT ON COLUMN DEPARTMENT.DEPARTMENT_ID IS '학과코드';
COMMENT ON COLUMN DEPARTMENT.DEPARTMENT_NAME IS '학과명';
COMMENT ON COLUMN DEPARTMENT.CATEGORY IS '계열';

CREATE TABLE MEMBER (
                      MEMBER_IDX NUMBER PRIMARY KEY,
                      MEMBER_ID NUMBER UNIQUE NOT NULL,
                      MEMBER_PWD VARCHAR2(100) NOT NULL,
                      NAME VARCHAR2(30) NOT NULL,
                      DEPARTMENT_ID NUMBER,
                      GRADE NUMBER,
                      BIRTHDAY DATE NOT NULL,
                      PHONE VARCHAR2(50) NOT NULL,
                      EMAIL VARCHAR2(100) NOT NULL,
                      POSTCODE NUMBER NOT NULL,
                      ADDRESS1 VARCHAR2(100) NOT NULL,
                      ADDRESS2 VARCHAR2(100) NOT NULL,
                      AUTH NUMBER NOT NULL,
                      FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT(DEPARTMENT_ID)
);

COMMENT ON TABLE MEMBER IS '멤버';
COMMENT ON COLUMN MEMBER.MEMBER_IDX IS '순번';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '아이디';
COMMENT ON COLUMN MEMBER.MEMBER_PWD IS '비밀번호';
COMMENT ON COLUMN MEMBER.NAME IS '이름';
COMMENT ON COLUMN MEMBER.DEPARTMENT_ID IS '학과';
COMMENT ON COLUMN MEMBER.GRADE IS '학년';
COMMENT ON COLUMN MEMBER.BIRTHDAY IS '생년월일';
COMMENT ON COLUMN MEMBER.PHONE IS '전화번호';
COMMENT ON COLUMN MEMBER.EMAIL IS '이메일';
COMMENT ON COLUMN MEMBER.POSTCODE IS '우편번호';
COMMENT ON COLUMN MEMBER.ADDRESS1 IS '상세주소1';
COMMENT ON COLUMN MEMBER.ADDRESS2 IS '상세주소2';
COMMENT ON COLUMN MEMBER.AUTH IS '회원 구분';




CREATE TABLE LECTURE (
                       LECTURE_ID NUMBER PRIMARY KEY,
                       MEMBER_ID NUMBER NOT NULL,
                       LECTURE_TITLE VARCHAR2(20) NOT NULL,
                       DEPARTMENT_ID VARCHAR2(20) NOT NULL,
                       SEMESTER NUMBER NOT NULL,
                       CREDIT NUMBER NOT NULL,
                       CLASSIFICATION CHAR(1) NOT NULL,
                       ROOMCODE1 VARCHAR2(10) NOT NULL,
                       ROOMCODE2 VARCHAR2(10),
                       ROOMCODE3 VARCHAR2(10),
                       TIMECODE1 NUMBER NOT NULL,
                       TIMECODE2 NUMBER,
                       TIMECODE3 NUMBER,
                       NUMBER_OF_STUDENT NUMBER,
                       SYLLABUS_TITLE VARCHAR2(100) NOT NULL,
                       SYLLABUS_RENAME VARCHAR2(100),
                       LECTURE_APPLY_STATUS CHAR(1) DEFAULT '1' NOT NULL,
                       FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER(MEMBER_ID)
);

COMMENT ON TABLE LECTURE IS '강의';
COMMENT ON COLUMN LECTURE.LECTURE_ID IS '강의번호';
COMMENT ON COLUMN LECTURE.MEMBER_ID IS '아이디';
COMMENT ON COLUMN LECTURE.LECTURE_TITLE IS '강의명';
COMMENT ON COLUMN LECTURE.DEPARTMENT_ID IS '학과번호';
COMMENT ON COLUMN LECTURE.SEMESTER IS '학기';
COMMENT ON COLUMN LECTURE.CREDIT IS '학점';
COMMENT ON COLUMN LECTURE.CLASSIFICATION IS '구분';
COMMENT ON COLUMN LECTURE.ROOMCODE1 IS '강의실코드1';
COMMENT ON COLUMN LECTURE.ROOMCODE2 IS '강의실코드2';
COMMENT ON COLUMN LECTURE.ROOMCODE3 IS '강의실코드3';
COMMENT ON COLUMN LECTURE.TIMECODE1 IS '시간코드1';
COMMENT ON COLUMN LECTURE.TIMECODE2 IS '시간코드2';
COMMENT ON COLUMN LECTURE.TIMECODE3 IS '시간코드3';
COMMENT ON COLUMN LECTURE.NUMBER_OF_STUDENT IS '정원';
COMMENT ON COLUMN LECTURE.SYLLABUS_TITLE IS '강의계획서명';
COMMENT ON COLUMN LECTURE.SYLLABUS_RENAME IS '강의계획서_리네임';
COMMENT ON COLUMN LECTURE.LECTURE_APPLY_STATUS IS '강의 승인여부';



CREATE TABLE FREEBOARD (
                         FREE_ID NUMBER PRIMARY KEY,
                         FREE_TITLE VARCHAR2(500) NOT NULL,
                         FREE_CONTENT VARCHAR2(1000) NOT NULL,
                         CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
                         MEMBER_ID NUMBER NOT NULL,
                         FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID)
);

COMMENT ON TABLE FREEBOARD IS '자유게시판';
COMMENT ON COLUMN FREEBOARD.FREE_ID IS '자유게시판 번호';
COMMENT ON COLUMN FREEBOARD.FREE_TITLE IS '자유게시판 제목';
COMMENT ON COLUMN FREEBOARD.FREE_CONTENT IS '자유게시판 내용';
COMMENT ON COLUMN FREEBOARD.CREATED_DATE IS '자유게시판 작성일';
COMMENT ON COLUMN FREEBOARD.MEMBER_ID IS '자유게시판 작성자';


CREATE TABLE FREEBOARD_REP (
                             FREE_REP_ID NUMBER PRIMARY KEY,
                             FREE_ID NUMBER NOT NULL,
                             FREE_REP_CONTENT VARCHAR2(1000) NOT NULL,
                             CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
                             MEMBER_ID NUMBER NOT NULL,
                             FOREIGN KEY (FREE_ID) REFERENCES FREEBOARD (FREE_ID),
                             FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID)
);

COMMENT ON TABLE FREEBOARD_REP IS '자유게시판 댓글';
COMMENT ON COLUMN FREEBOARD_REP.FREE_REP_ID IS '자유게시판 댓글 번호';
COMMENT ON COLUMN FREEBOARD_REP.FREE_ID IS '자유게시판 번호';
COMMENT ON COLUMN FREEBOARD_REP.FREE_REP_CONTENT IS '댓글 내용';
COMMENT ON COLUMN FREEBOARD_REP.CREATED_DATE IS '댓글 작성일';
COMMENT ON COLUMN FREEBOARD_REP.MEMBER_ID IS '댓글 작성자';


CREATE TABLE SCHEDULE (
                        SCHE_ID NUMBER PRIMARY KEY,
                        SCHE_TITLE VARCHAR2(500) NOT NULL,
                        SCHE_CONTENT VARCHAR2(1000),
                        START_DATE DATE NOT NULL,
                        END_DATE DATE NOT NULL
);


COMMENT ON TABLE SCHEDULE IS '학사일정';
COMMENT ON COLUMN SCHEDULE.SCHE_ID IS '학사일정 번호';
COMMENT ON COLUMN SCHEDULE.SCHE_TITLE IS '학사일정 제목';
COMMENT ON COLUMN SCHEDULE.SCHE_CONTENT IS '학사일정 내용';
COMMENT ON COLUMN SCHEDULE.START_DATE IS '학사일정 시작날짜';
COMMENT ON COLUMN SCHEDULE.END_DATE IS '학사일정 끝날짜';


CREATE TABLE STATUS (
                      STATUS_ID NUMBER PRIMARY KEY,
                      MEMBER_ID NUMBER NOT NULL,
                      START_DATE DATE NOT NULL,
                      END_DATE DATE NOT NULL,
                      REASON_OF_LEAVE VARCHAR2(100),
                      RETURN_DATE DATE NOT NULL,
                      APPLY_LEAVE_DATE DATE DEFAULT SYSDATE,
                      APPLY_RETURN_DATE DATE DEFAULT SYSDATE,
                      ALLOWED_LEAVE CHAR(1)  DEFAULT '1' NOT NULL,
                      FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID)
);

COMMENT ON TABLE STATUS IS '학적변동';
COMMENT ON COLUMN STATUS.STATUS_ID IS '학적변동 번호';
COMMENT ON COLUMN STATUS.MEMBER_ID IS '학생 번호';
COMMENT ON COLUMN STATUS.START_DATE IS '휴학 시작일';
COMMENT ON COLUMN STATUS.END_DATE IS '휴학 끝일';
COMMENT ON COLUMN STATUS.REASON_OF_LEAVE IS '휴학사유';
COMMENT ON COLUMN STATUS.RETURN_DATE IS '복학일';
COMMENT ON COLUMN STATUS.APPLY_LEAVE_DATE IS '휴학접수날짜';
COMMENT ON COLUMN STATUS.APPLY_RETURN_DATE IS '복학접수날짜';
COMMENT ON COLUMN STATUS.ALLOWED_LEAVE IS '휴/복학허용여부';



CREATE TABLE SCHOLARSHIP (
                           SCHO_ID NUMBER PRIMARY KEY,
                           SCHO_TERM NUMBER,
                           SCHO_NAME VARCHAR2(100),
                           AMOUNT NUMBER NOT NULL,
                           MEMBER_ID NUMBER,
                           FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID)
);

COMMENT ON TABLE SCHOLARSHIP IS '장학금';
COMMENT ON COLUMN SCHOLARSHIP.SCHO_ID IS '장학금 번호';
COMMENT ON COLUMN SCHOLARSHIP.SCHO_TERM IS '장학금 학기';
COMMENT ON COLUMN SCHOLARSHIP.SCHO_NAME IS '장학금명';
COMMENT ON COLUMN SCHOLARSHIP.AMOUNT IS '장학금액';
COMMENT ON COLUMN SCHOLARSHIP.MEMBER_ID IS '회원 번호';



CREATE TABLE COURSE_REGI (
                           COURSE_REGI_ID NUMBER PRIMARY KEY,
                           MEMBER_ID NUMBER NOT NULL,
                           LECTURE_ID NUMBER NOT NULL,
                           COURSE_REGI_TERM NUMBER NOT NULL,
                           FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID),
                           FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE (LECTURE_ID)
);

COMMENT ON TABLE COURSE_REGI IS '수강신청';
COMMENT ON COLUMN COURSE_REGI.COURSE_REGI_ID IS '수강신청 번호';
COMMENT ON COLUMN COURSE_REGI.MEMBER_ID IS '학생 번호';
COMMENT ON COLUMN COURSE_REGI.LECTURE_ID IS '강의 ID';
COMMENT ON COLUMN COURSE_REGI.COURSE_REGI_TERM IS '신청학기';


CREATE TABLE TUITION (
                       TUITION_ID NUMBER PRIMARY KEY,
                       MEMBER_ID NUMBER NOT NULL,
                       TUITION_AMOUNT NUMBER NOT NULL,
                       PAID CHAR(1) DEFAULT 'N' NOT NULL,
                       TUITION_TERM NUMBER NOT NULL,
                       FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID)
);

COMMENT ON TABLE TUITION IS '등록금';
COMMENT ON COLUMN TUITION. TUITION_ID IS '등록금 번호';
COMMENT ON COLUMN TUITION.MEMBER_ID IS '학생 번호';
COMMENT ON COLUMN TUITION.TUITION_AMOUNT IS '등록금액';
COMMENT ON COLUMN TUITION.PAID IS '납부여부';
COMMENT ON COLUMN TUITION.TUITION_TERM IS '등록금 학기';

CREATE TABLE SCORE (
                     SCORE_ID NUMBER PRIMARY KEY,
                     MEMBER_ID NUMBER NOT NULL,
                     LECTURE_ID NUMBER NOT NULL,
                     MID_SCORE NUMBER NOT NULL,
                     FINAL_SCORE NUMBER NOT NULL,
                     ASSIGN_SCORE NUMBER NOT NULL,
                     TOTAL_SCORE NUMBER NOT NULL,
                     FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID),
                     FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE (LECTURE_ID)
);

COMMENT ON TABLE SCORE IS '성적';
COMMENT ON COLUMN SCORE.SCORE_ID IS '성적 번호';
COMMENT ON COLUMN SCORE.MEMBER_ID IS '학생 번호';
COMMENT ON COLUMN SCORE.LECTURE_ID IS '강의 ID';
COMMENT ON COLUMN SCORE.MID_SCORE IS '중간고사 점수';
COMMENT ON COLUMN SCORE.FINAL_SCORE IS '기말고사 점수';
COMMENT ON COLUMN SCORE.ASSIGN_SCORE IS '과제점수';
COMMENT ON COLUMN SCORE.TOTAL_SCORE IS '학기 총점수';


CREATE TABLE TOTAL_SCORE (
                           MEMBER_ID NUMBER NOT NULL,
                           TOTAL_AVERAGE NUMBER NOT NULL,
                           MAX_CREDIT NUMBER NOT NULL,
                           NOW_CREDIT NUMBER NOT NULL,
                           FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID)
);

COMMENT ON TABLE TOTAL_SCORE IS '총학기 성적';
COMMENT ON COLUMN  TOTAL_SCORE .MEMBER_ID IS '학생 번호';
COMMENT ON COLUMN TOTAL_SCORE .TOTAL_AVERAGE IS '전체학기 평점';
COMMENT ON COLUMN TOTAL_SCORE .MAX_CREDIT IS '최대 이수학점';
COMMENT ON COLUMN TOTAL_SCORE .NOW_CREDIT IS '현재 이수학점';


CREATE TABLE EVALUATION (
                          EVALUATION_ID NUMBER PRIMARY KEY,
                          MEMBER_ID NUMBER NOT NULL,
                          LECTURE_ID NUMBER NOT NULL,
                          SCORE1 NUMBER NOT NULL,
                          SCORE2 NUMBER NOT NULL,
                          SCORE3 NUMBER NOT NULL,
                          SCORE4 NUMBER NOT NULL,
                          SCORE5 NUMBER NOT NULL,
                          COMMENTS VARCHAR2(300),
                          FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID),
                          FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE (LECTURE_ID)
);

COMMENT ON TABLE EVALUATION IS '강의평가';
COMMENT ON COLUMN EVALUATION.EVALUATION_ID IS '강의평가 번호';
COMMENT ON COLUMN EVALUATION.MEMBER_ID IS '학생 번호';
COMMENT ON COLUMN EVALUATION.LECTURE_ID IS '강의 ID';
COMMENT ON COLUMN EVALUATION.SCORE1 IS '1번 문항 점수';
COMMENT ON COLUMN EVALUATION.SCORE2 IS '2번 문항 점수';
COMMENT ON COLUMN EVALUATION.SCORE3 IS '3번 문항 점수';
COMMENT ON COLUMN EVALUATION.SCORE4 IS '4번 문항 점수';
COMMENT ON COLUMN EVALUATION.SCORE5 IS '5번 문항 점수';
COMMENT ON COLUMN EVALUATION.COMMENTS IS '하고싶은 말';



CREATE TABLE NOTICE (
                      NOTICE_ID NUMBER PRIMARY KEY,
                      NOTICE_TITLE VARCHAR2(500) NOT NULL,
                      NOTICE_CONTENT VARCHAR2(1000),
                      MEMBER_ID NUMBER,
                      CREATED_DATE DATE DEFAULT SYSDATE,
                      READCOUNT NUMBER DEFAULT '0',
                      FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID)
);

COMMENT ON TABLE  NOTICE IS '전체 공지사항';
COMMENT ON COLUMN  NOTICE.NOTICE_ID IS '공지사항 번호';
COMMENT ON COLUMN NOTICE.NOTICE_TITLE IS '공지사항 제목';
COMMENT ON COLUMN NOTICE.NOTICE_CONTENT IS '공지사항 내용';
COMMENT ON COLUMN NOTICE.MEMBER_ID IS '작성자';
COMMENT ON COLUMN NOTICE.CREATED_DATE IS '등록일';
COMMENT ON COLUMN NOTICE.READCOUNT IS '조회수';

CREATE TABLE LECTURE_CLASS_TIME(
                                 TIMECODE NUMBER PRIMARY KEY,
                                 START_TIME VARCHAR2(20) NOT NULL,
                                 END_TIME VARCHAR2(20) NOT NULL,
                                 DAY_TIME VARCHAR2(10) NOT NULL
);

COMMENT ON TABLE  LECTURE_CLASS_TIME IS '강의 시간';
COMMENT ON COLUMN LECTURE_CLASS_TIME. TIMECODE IS '시간코드';
COMMENT ON COLUMN LECTURE_CLASS_TIME.START_TIME IS '시작시간';
COMMENT ON COLUMN LECTURE_CLASS_TIME.END_TIME IS '종료시간';
COMMENT ON COLUMN LECTURE_CLASS_TIME.DAY_TIME IS '요일';

CREATE TABLE LECTURE_SCHEDULE(
                               MEMBER_ID NUMBER NOT NULL,
                               TIMECODE NUMBER NOT NULL,
                               LECTURE_ID NUMBER NOT NULL,
                               FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID),
                               FOREIGN KEY (TIMECODE) REFERENCES LECTURE_CLASS_TIME (TIMECODE)
);

COMMENT ON TABLE  LECTURE_SCHEDULE IS '강의 시간표';
COMMENT ON COLUMN LECTURE_SCHEDULE.MEMBER_ID IS '아이디';
COMMENT ON COLUMN LECTURE_SCHEDULE.TIMECODE IS '시간코드';
COMMENT ON COLUMN LECTURE_SCHEDULE.LECTURE_ID IS '강의번호';

CREATE TABLE LECTURE_CLASS(
                            LECTURE_ROOM_CODE VARCHAR2(10) PRIMARY KEY,
                            BUILDING_CODE VARCHAR2(30) NOT NULL,
                            BUILDING_NAME VARCHAR2(30) NOT NULL,
                            NUMBER_FLOOR NUMBER NOT NULL,
                            LECTURE_ROOM_NUM VARCHAR2(10) NOT NULL,
                            CLASS_CAPACITY NUMBER NOT NULL
);

COMMENT ON TABLE  LECTURE_CLASS IS '강의실';
COMMENT ON COLUMN LECTURE_CLASS.LECTURE_ROOM_CODE IS '강의실 코드';
COMMENT ON COLUMN LECTURE_CLASS.BUILDING_CODE IS '건물코드';
COMMENT ON COLUMN LECTURE_CLASS.BUILDING_NAME IS '건물명';
COMMENT ON COLUMN LECTURE_CLASS.NUMBER_FLOOR IS '층수';
COMMENT ON COLUMN LECTURE_CLASS.LECTURE_ROOM_NUM IS '강의실 호수';
COMMENT ON COLUMN LECTURE_CLASS.CLASS_CAPACITY IS '강의실 수용인원';


CREATE TABLE LECTURE_ROOM_TIMETABLE(
                                     TIMECODE NUMBER NOT NULL,
                                     LECTURE_ROOM_CODE VARCHAR2(10) NOT NULL,
                                     LECTURE_ROOM_EMPTY CHAR(1) DEFAULT 'N' NOT NULL,
                                     FOREIGN KEY (TIMECODE) REFERENCES LECTURE_CLASS_TIME (TIMECODE),
                                     FOREIGN KEY (LECTURE_ROOM_CODE) REFERENCES LECTURE_CLASS (LECTURE_ROOM_CODE)
);

COMMENT ON TABLE  LECTURE_ROOM_TIMETABLE IS '강의실 사용시간표';
COMMENT ON COLUMN LECTURE_ROOM_TIMETABLE.TIMECODE IS '시간코드';
COMMENT ON COLUMN LECTURE_ROOM_TIMETABLE.LECTURE_ROOM_CODE IS '강의실코드';
COMMENT ON COLUMN LECTURE_ROOM_TIMETABLE.LECTURE_ROOM_EMPTY IS '강의실 사용여부';

CREATE TABLE LECTURE_NOTICE(
                             LECTURE_NOTICE_ID NUMBER PRIMARY KEY,
                             LECTURE_ID NUMBER NOT NULL,
                             LECTURE_NOTICE_TITLE VARCHAR2(300) NOT NULL,
                             LECTURE_NOTICE_CONTENT VARCHAR2(1000) NOT NULL,
                             CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
                             READCOUNT NUMBER DEFAULT '0' NOT NULL,
                             FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE (LECTURE_ID)
);

COMMENT ON TABLE  LECTURE_NOTICE IS '강의 공지사항';
COMMENT ON COLUMN LECTURE_NOTICE.LECTURE_NOTICE_ID IS '강의공지 글번호';
COMMENT ON COLUMN LECTURE_NOTICE.LECTURE_ID IS '강의번호';
COMMENT ON COLUMN LECTURE_NOTICE.LECTURE_NOTICE_TITLE IS '강의공지 제목';
COMMENT ON COLUMN LECTURE_NOTICE.LECTURE_NOTICE_CONTENT IS '강의공지 내용';
COMMENT ON COLUMN LECTURE_NOTICE.CREATED_DATE IS '강의공지 작성일';
COMMENT ON COLUMN LECTURE_NOTICE.READCOUNT IS '조회수';

CREATE TABLE LECTURE_ROOM(
                           LECTURE_ROOM_ID NUMBER PRIMARY KEY,
                           LECTURE_ID NUMBER NOT NULL,
                           MEMBER_ID NUMBER NOT NULL,
                           LECTURE_ROOM_TITLE VARCHAR2(300) NOT NULL,
                           LECTURE_ROOM_CONTENT VARCHAR2(1000) NOT NULL,
                           CREATED_DATE DATE DEFAULT SYSDATE NOT NULL,
                           READCOUNT NUMBER DEFAULT '0' NOT NULL,
                           FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE (LECTURE_ID),
                           FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID)
);

COMMENT ON TABLE  LECTURE_ROOM IS '강의자료실';
COMMENT ON COLUMN LECTURE_ROOM.LECTURE_ROOM_ID IS '강의자료실 글번호';
COMMENT ON COLUMN LECTURE_ROOM.LECTURE_ID IS '강의번호';
COMMENT ON COLUMN LECTURE_ROOM.MEMBER_ID IS '강의자료 작성자';
COMMENT ON COLUMN LECTURE_ROOM.LECTURE_ROOM_TITLE IS '강의자료 제목';
COMMENT ON COLUMN LECTURE_ROOM.LECTURE_ROOM_CONTENT IS '강의자료 내용';
COMMENT ON COLUMN LECTURE_ROOM.CREATED_DATE IS '강의자료 작성일';
COMMENT ON COLUMN LECTURE_ROOM.READCOUNT IS '조회수';

CREATE TABLE LECTURE_ROOM_FILE(
                                LECTURE_ROOM_ID NUMBER NOT NULL,
                                FILE_NAME VARCHAR(300) NOT NULL,
                                FILE_RENAME VARCHAR(300) NOT NULL,
                                FOREIGN KEY (LECTURE_ROOM_ID) REFERENCES LECTURE_ROOM (LECTURE_ROOM_ID)
);

COMMENT ON TABLE  LECTURE_ROOM_FILE IS '강의자료 파일';
COMMENT ON COLUMN LECTURE_ROOM_FILE.LECTURE_ROOM_ID IS '강의자료실 글번호';
COMMENT ON COLUMN LECTURE_ROOM_FILE.FILE_NAME IS '강의자료 파일명';
COMMENT ON COLUMN LECTURE_ROOM_FILE.FILE_RENAME IS '변경된 강의자료 파일명';

CREATE TABLE HOMEWORK(
                       HOMEWORK_ID NUMBER PRIMARY KEY,
                       MEMBER_ID NUMBER NOT NULL,
                       LECTURE_ID NUMBER NOT NULL,
                       HOMEWORK_NAME VARCHAR(300) NOT NULL,
                       HOMEWORK_CONTENT VARCHAR(1000) NOT NULL,
                       DEADLINE DATE NOT NULL,
                       SUBMITTED CHAR(1) DEFAULT 'N' NOT NULL,
                       FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID),
                       FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE (LECTURE_ID)
);

COMMENT ON TABLE  HOMEWORK IS '과제현황';
COMMENT ON COLUMN HOMEWORK.HOMEWORK_ID IS '과제글 번호';
COMMENT ON COLUMN HOMEWORK.MEMBER_ID IS '학생 번호';
COMMENT ON COLUMN HOMEWORK.LECTURE_ID IS '강의번호';
COMMENT ON COLUMN HOMEWORK.HOMEWORK_NAME IS '과제제목';
COMMENT ON COLUMN HOMEWORK.HOMEWORK_CONTENT IS '과제내용';
COMMENT ON COLUMN HOMEWORK.DEADLINE IS '과제 제출기한';
COMMENT ON COLUMN HOMEWORK.SUBMITTED IS '과제 제출여부';

CREATE TABLE HOMEWORK_FILE(
                            HOMEWORK_ID NUMBER NOT NULL,
                            FILE_NAME VARCHAR2(300) NOT NULL,
                            FILE_RENAME VARCHAR2(300) NOT NULL,
                            FOREIGN KEY (HOMEWORK_ID) REFERENCES HOMEWORK (HOMEWORK_ID)
);

COMMENT ON TABLE  HOMEWORK_FILE IS '과제글 번호';
COMMENT ON COLUMN HOMEWORK_FILE.HOMEWORK_ID IS '과제글 번호';
COMMENT ON COLUMN HOMEWORK_FILE.FILE_NAME IS '과제파일명';
COMMENT ON COLUMN HOMEWORK_FILE.FILE_RENAME IS '변경된 과제파일명';

CREATE TABLE ATTENDANCE(
                         ATTENDANCE_ID NUMBER PRIMARY KEY,
                         LECTURE_ID NUMBER NOT NULL,
                         MEMBER_ID NUMBER NOT NULL,
                         ATTENDANCE_DAY NUMBER NOT NULL,
                         ATTENDANCE CHAR(1) NOT NULL,
                         MAX_CHECKIN NUMBER NOT NULL,
                         NOW_CHECKIN NUMBER NOT NULL,
                         FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID),
                         FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE (LECTURE_ID)
);

COMMENT ON TABLE  ATTENDANCE IS '출석관리';
COMMENT ON COLUMN ATTENDANCE.ATTENDANCE_ID IS '출석ID';
COMMENT ON COLUMN ATTENDANCE.LECTURE_ID IS '강의번호';
COMMENT ON COLUMN ATTENDANCE.MEMBER_ID IS '아이디';
COMMENT ON COLUMN ATTENDANCE.ATTENDANCE_DAY IS '수업일차';
COMMENT ON COLUMN ATTENDANCE.ATTENDANCE IS '출석여부';
COMMENT ON COLUMN ATTENDANCE.MAX_CHECKIN IS '최대출석일';
COMMENT ON COLUMN ATTENDANCE.NOW_CHECKIN IS '현재출석일';

CREATE TABLE CANCELLED_LECTURE(
                                LECTURE_ID NUMBER NOT NULL,
                                MEMBER_ID NUMBER NOT NULL,
                                CANCELED_DATE DATE NOT NULL,
                                CANCELED_TIMECODE NUMBER NOT NULL,
                                SUPPLY_DATE NUMBER NOT NULL,
                                CANCELED_REASON VARCHAR2(1000),
                                CANCELED_FILE VARCHAR2(300),
                                CANCELED_FILE_RENAME VARCHAR2(300),
                                CANCELED_APPLY CHAR(1) DEFAULT '1' NOT NULL,
                                FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (MEMBER_ID),
                                FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE (LECTURE_ID)
);

COMMENT ON TABLE  CANCELLED_LECTURE IS '휴강';
COMMENT ON COLUMN CANCELLED_LECTURE.LECTURE_ID IS '강의번호';
COMMENT ON COLUMN CANCELLED_LECTURE.MEMBER_ID IS '아이디';
COMMENT ON COLUMN CANCELLED_LECTURE.CANCELED_DATE IS '휴강일';
COMMENT ON COLUMN CANCELLED_LECTURE.CANCELED_TIMECODE IS '휴강시간';
COMMENT ON COLUMN CANCELLED_LECTURE.SUPPLY_DATE IS '보강일시';
COMMENT ON COLUMN CANCELLED_LECTURE.CANCELED_REASON IS '휴강사유';
COMMENT ON COLUMN CANCELLED_LECTURE.CANCELED_FILE IS '제출서류 파일명';
COMMENT ON COLUMN CANCELLED_LECTURE.CANCELED_FILE_RENAME IS '변경된 제출서류 파일명';
COMMENT ON COLUMN CANCELLED_LECTURE.CANCELED_APPLY IS '휴강승인여부';

CREATE SEQUENCE MEMBER_IDX_SEQ
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE LECTURE_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE FREE_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE FREE_REP_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE SCHE_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE STATUS_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE SCHO_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE COURSE_REGI_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE TUITION_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE SCORE_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE EVALUATION_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE NOTICE_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE BUILDING_CODE_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE LECTURE_ROOM_CODE_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE LECTURE_NOTICE_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE LECTURE_ROOM_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE HOMEWORK_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;

CREATE SEQUENCE ATTENDANCE_ID_SEQ
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE
  MINVALUE 1
  NOCYCLE
  NOCACHE;


commit;

