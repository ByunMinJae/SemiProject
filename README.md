#본 프로젝트는 terminal 브랜치에 자료를 모아두고 있습니다.
#아래 데이터는 ORACLE DB 더미데이터입니다.

-- 유저 정보 --
DROP TABLE user_info;
CREATE TABLE user_info (
   userno NUMBER CONSTRAINT pk_userno PRIMARY KEY,
   userid VARCHAR2(20) UNIQUE NOT NULL,
   userpw VARCHAR2(20) NOT NULL,
   username VARCHAR2(30)NOT NULL, --유저 이름 컬럼 추가
   gender VARCHAR2(6) CHECK(gender IN('남자','여자')),
   address VARCHAR2(100) NOT NULL,
   phone VARCHAR2(30) NOT NULL, --NUMBER -> VARCHAR2(14)로 변경
   birth DATE NOT NULL,
   email VARCHAR2(50) UNIQUE NOT NULL,
   nick VARCHAR2(20) UNIQUE NOT NULL,
   joinday DATE NOT NULL,
   userupdate DATE,
   gradeno NUMBER
);
DROP SEQUENCE user_info_seq;
CREATE SEQUENCE user_info_seq START WITH 1000;

-- 유저 등급 --
DROP TABLE user_level;
CREATE TABLE user_level (
   gradeno NUMBER CONSTRAINT pk_gradeno PRIMARY KEY,
   gradename VARCHAR2(20) CHECK(gradename IN('일반회원','VIP','관리자','정지회원')),
   gradegrant VARCHAR2(10) CHECK(gradegrant IN('일반', '관리자')) -- '일반','관리자'
);

DROP SEQUENCE user_level_seq;
CREATE SEQUENCE user_level_seq START WITH 1000;

-- 상품 정보 --
DROP TABLE product;
CREATE TABLE product (
   prodno NUMBER CONSTRAINT pk_prodno PRIMARY KEY,
   prodname VARCHAR2(100) NOT NULL,
   prodprice NUMBER NOT NULL,
   prodimage VARCHAR2(1000) NOT NULL,
   prodcon VARCHAR2(1000) NOT NULL,
   proddate DATE NOT NULL,
   prodpop NUMBER NULL
);
DROP SEQUENCE product_seq;
CREATE SEQUENCE product_seq START WITH 1000;


-- 주문 정보 --
DROP TABLE user_orderbefore;
CREATE TABLE user_orderbefore (
   orderno NUMBER CONSTRAINT pk_orderno PRIMARY KEY,
   buyprodname VARCHAR2(200),
   totalamount NUMBER(30),
   userno NUMBER NOT NULL
);

DROP SEQUENCE user_orderbefore_seq;
CREATE SEQUENCE user_orderbefore_seq START WITH 1000;



-- 게시글 정보 --
DROP TABLE board_info;
CREATE TABLE board_info (
   boardno NUMBER CONSTRAINT pk_boardno PRIMARY KEY,
   boardtitle VARCHAR2(50) NOT NULL,
   boardcon VARCHAR2(2000) NOT NULL,
   boarddate DATE NOT NULL,
   userno NUMBER NOT NULL,
   categoryno NUMBER NOT NULL,
   hit NUMBER NOT NULL,
   nick VARCHAR2(20) NOT NULL
);

DROP SEQUENCE board_info_seq;
CREATE SEQUENCE board_info_seq START WITH 1000;

-- 게시글 카테고리 --
DROP TABLE board_category;
CREATE TABLE board_category (
   categoryno NUMBER CONSTRAINT pk_categoryno PRIMARY KEY,
   categoryname VARCHAR2(20) UNIQUE NOT NULL
);

-- 댓글 --
DROP TABLE board_comment;
CREATE TABLE board_comment (
   commno NUMBER CONSTRAINT pk_commno PRIMARY KEY,
   commcon VARCHAR2(200) NOT NULL,
   commdate VARCHAR2(200) NOT NULL,
    userno NUMBER NOT NULL,
   boardno NUMBER NOT NULL
);
DROP SEQUENCE board_comment_seq;
CREATE SEQUENCE board_comment_seq START WITH 1000;

-- 신고 --
DROP TABLE board_report;
CREATE TABLE board_report (
   reportno NUMBER CONSTRAINT pk_reportno PRIMARY KEY,
   reportcon VARCHAR2(150) NOT NULL,
   reportdate DATE NOT NULL,
   userno NUMBER NOT NULL,
   boardno NUMBER NOT NULL
);
DROP SEQUENCE board_report_seq;
CREATE SEQUENCE board_report_seq START WITH 1000;

-- 장바구니 --
DROP TABLE cart;
CREATE TABLE cart (
   cartno NUMBER CONSTRAINT pk_cartno PRIMARY KEY,
   cartcount NUMBER NOT NULL,
    userno NUMBER NOT NULL,
    prodno NUMBER NOT NULL
);
DROP SEQUENCE cart_seq;
CREATE SEQUENCE cart_seq START WITH 1000;

-- 결제 정보 --
DROP TABLE pay;
CREATE TABLE pay (
   payno NUMBER CONSTRAINT pk_payno PRIMARY KEY,
   payoption VARCHAR2(20) NOT NULL,
   paydate DATE NOT NULL,
    orderno NUMBER NOT NULL
);
DROP SEQUENCE pay_seq;
CREATE SEQUENCE pay_seq START WITH 1000;





-- 주문 내역 --
DROP TABLE user_orderafter;
CREATE TABLE user_orderafter (
   orderafterno NUMBER CONSTRAINT pk_orderafterno PRIMARY KEY,
   orderprocess VARCHAR2(20) NULL,
   pay_method VARCHAR2(20) NOT NULL,
   merchant_uid VARCHAR2(30) NOT NULL,
   prodname VARCHAR2(50) NOT NULL,
   amount NUMBER NOT NULL,
   buyer_email VARCHAR2(100) NOT NULL,
   buyer_name VARCHAR2(20) NOT NULL,
   buyer_tel VARCHAR2(40) NOT NULL,
   buyer_addr VARCHAR2(100) NOT NULL,
   orderdate VARCHAR2(30) NOT NULL,
   orderno NUMBER NOT NULL,
   userno NUMBER NOT NULL
);

--ALTER TABLE user_orderafter ADD userno NUMBER NOT NULL;


DROP SEQUENCE user_orderafter_seq;
CREATE SEQUENCE user_orderafter_seq START WITH 1100000;


-- 회원정보 찾기 --
DROP TABLE user_find;
CREATE TABLE user_find (
   createno NUMBER CONSTRAINT pk_createno PRIMARY KEY,
   createdat DATE NOT NULL,
   email VARCHAR2(30) NOT NULL,
   id VARCHAR2(30) NOT NULL,
   pw VARCHAR2(30) NOT NULL,
   authno NUMBER NOT NULL
);
DROP SEQUENCE user_find_seq;
CREATE SEQUENCE user_find_seq START WITH 1000;

-- 첨부 파일 --
DROP TABLE board_file;
CREATE TABLE board_file (
    fileno NUMBER CONSTRAINT pk_fileno PRIMARY KEY,
    boardno NUMBER NOT NULL,
    fileoriginname VARCHAR2(1000) NOT NULL,
    filestoredname VARCHAR2(1000) NOT NULL,
    filesize NUMBER NOT NULL,
    boarddate DATE NOT NULL
);

DROP SEQUENCE board_file_seq;
CREATE SEQUENCE board_file_seq START WITH 1000;

-- 주문 목록  --
DROP TABLE user_orderlist;
CREATE TABLE user_orderlist (
   listno NUMBER CONSTRAINT pk_listno PRIMARY KEY,
   ordercount NUMBER NOT NULL,
   orderprice NUMBER NOT NULL,
   orderno NUMBER NOT NULL,
   prodno NUMBER NOT NULL
);

DROP SEQUENCE user_orderlist_seq;
CREATE SEQUENCE user_orderlist_seq START WITH 1000;

----------------------------------------------------------------------

ALTER TABLE user_info
ADD CONSTRAINT fk_user_info_gradeno foreign KEY(gradeno) references user_level (gradeno);

ALTER TABLE user_orderbefore
ADD CONSTRAINT fk_orderbefore_userno foreign KEY(userno) references user_info (userno);

ALTER TABLE user_orderafter
ADD CONSTRAINT fk_orderafter_userno foreign KEY(userno) references user_info (userno);

ALTER TABLE board_info
ADD CONSTRAINT fk_board_info_userno foreign KEY(userno) references user_info (userno);

ALTER TABLE board_info
ADD CONSTRAINT fk_board_info_categoryno foreign KEY(categoryno) references board_category (categoryno);

ALTER TABLE board_comment
ADD CONSTRAINT fk_board_comment_userno foreign KEY(userno) references user_info (userno);

ALTER TABLE board_comment
ADD CONSTRAINT fk_board_comment_boardno foreign KEY(boardno) references board_info (boardno);

ALTER TABLE board_report
ADD CONSTRAINT fk_board_report_userno foreign KEY(userno) references user_info (userno);

ALTER TABLE board_report
ADD CONSTRAINT fk_board_report_boardno foreign KEY(boardno) references board_info (boardno);

ALTER TABLE cart
ADD CONSTRAINT fk_cart_userno foreign KEY(userno) references user_info (userno);

ALTER TABLE cart
ADD CONSTRAINT fk_cart_prodno foreign KEY(prodno) references product (prodno);

--ALTER TABLE pay
--ADD CONSTRAINT fk_pay_orderno foreign KEY(orderno) references user_orderbefore (orderno);

--ALTER TABLE user_orderafter
--ADD CONSTRAINT fk_orderafter_payno foreign KEY(payno) references pay (payno);

ALTER TABLE user_orderafter
ADD CONSTRAINT fk_orderafter_orderno foreign KEY(orderno) references user_orderbefore (orderno);

ALTER TABLE board_file
ADD CONSTRAINT fk_board_file_boardno foreign KEY(boardno) references board_info (boardno);

ALTER TABLE user_orderlist
ADD CONSTRAINT fk_orderlist_orderno foreign KEY(orderno) references user_orderbefore (orderno);

ALTER TABLE user_orderlist
ADD CONSTRAINT fk_orderlist_prodno foreign KEY(prodno) references product (prodno);

ALTER TABLE board_info
ADD CONSTRAINT fk_board_info foreign KEY(nick) references user_info (nick);


--DROP TABLE user_orderlist;
--DROP TABLE user_orderbefore;
--DROP TABLE user_orderafter;
--DROP TABLE user_level;
--DROP TABLE user_info;
--DROP TABLE user_find;
--DROP TABLE product;
--DROP TABLE pay;
--DROP TABLE mountain_info;
--DROP TABLE cart;
--DROP TABLE board_report;
--DROP TABLE board_info;
--DROP TABLE board_file;
--DROP TABLE board_comment;
--DROP TABLE board_category;



INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '맘모스 패치', 1800, 'cmcpatch1_600.jpg'
,'3대 캐니언이 위치한 미서부 지역은 웅장한 대자연을 체험하고 절벽 위에 있는 
전망대에 올라서면 겹겹이 이어지는 계곡이 파노라마처럼 펼쳐지는 수십억 연간 비와 바람이 만들어낸 예술작품을 의류에 부착해 보세요.
3대 캐니언 중 가장 아름다운 풍광으로 유명한 곳, ''맘모스 캐니언''을 담고 있는 맘모스 캐니언 패치입니다.', '21/07/21', 232);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '어드벤처 패치', 2100, 'cmcpatch2_600.jpg'
,'어드벤처의 대가 ''로버트 스타크''는 항상 도전하는 마음으로 세계의 높은 산들을 정복하곤 했습니다 
그의 젊은 시절 산속에서 겪었던 일화를 레퍼런스로 제작한 등산 패치입니다.', '21/08/14', 523);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '캠프 패치', 2500, 'cmcpatch3_600.jpg'
,'뉴 마운틴의 시대가 열리며 항상 꿈꿔온 산중 캠프를 상상하며 
그때의 따뜻함을 느낄 수 있는 캠프파이어를 그려낸 캠프 패치입니다.', '21/09/02', 273);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '월드랜드 패치', 2100, 'cmcpatch4_600.jpg'
,'에베레스트의 높은 고지를 완주하고 그 속에서 느껴지는 추위와 기압을 이겨내고 며칠간 그곳에서 
산과 싸우며 내려온 삶들이 얼마나 고되고 귀한지 
알게 해주는 등산을 완주한 모든 이들의 열정이 담긴 패치입니다.', '21/10/21', 113);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '맘모스 패치', 1800, 'cmcpatch1_600.jpg'
,'3대 캐니언이 위치한 미서부 지역은 웅장한 대자연을 체험하고 절벽 위에 있는 
전망대에 올라서면 겹겹이 이어지는 계곡이 파노라마처럼 펼쳐지는 수십억 연간 비와 바람이 만들어낸 예술작품을 의류에 부착해 보세요.
3대 캐니언 중 가장 아름다운 풍광으로 유명한 곳, ''맘모스 캐니언''을 담고 있는 맘모스 캐니언 패치입니다.', '22/01/22', 282);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '어드벤처 패치', 2100, 'cmcpatch2_600.jpg'
,'어드벤처의 대가 ''로버트 스타크''는 항상 도전하는 마음으로 세계의 높은 산들을 정복하곤 했습니다 
그의 젊은 시절 산속에서 겪었던 일화를 레퍼런스로 제작한 등산 패치입니다.', '22/02/15', 653);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '캠프 패치', 2100, 'cmcpatch3_600.jpg'
,'뉴 마운틴의 시대가 열리며 항상 꿈꿔온 산중 캠프를 상상하며 
그때의 따뜻함을 느낄 수 있는 캠프파이어를 그려낸 캠프 패치입니다.', '22/02/16', 189);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '월드랜드 패치', 2500, 'cmcpatch4_600.jpg'
,'에베레스트의 높은 고지를 완주하고 그 속에서 느껴지는 추위와 기압을 이겨내고 며칠간 그곳에서 
산과 싸우며 내려온 삶들이 얼마나 고되고 귀한지 
알게 해주는 등산을 완주한 모든 이들의 열정이 담긴 패치입니다.', '22/03/01', 143);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '맘모스 패치', 2500, 'cmcpatch1_600.jpg'
,'3대 캐니언이 위치한 미서부 지역은 웅장한 대자연을 체험하고 절벽 위에 있는 
전망대에 올라서면 겹겹이 이어지는 계곡이 파노라마처럼 펼쳐지는 수십억 연간 비와 바람이 만들어낸 예술작품을 의류에 부착해 보세요.
3대 캐니언 중 가장 아름다운 풍광으로 유명한 곳, ''맘모스 캐니언''을 담고 있는 맘모스 캐니언 패치입니다.', '22/03/04', 232);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '어드벤처 패치', 1900, 'cmcpatch2_600.jpg'
,'어드벤처의 대가 ''로버트 스타크''는 항상 도전하는 마음으로 세계의 높은 산들을 정복하곤 했습니다 
그의 젊은 시절 산속에서 겪었던 일화를 레퍼런스로 제작한 등산 패치입니다.', '22/03/14', 523);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '캠프 패치', 2100, 'cmcpatch3_600.jpg'
,'뉴 마운틴의 시대가 열리며 항상 꿈꿔온 산중 캠프를 상상하며 
그때의 따뜻함을 느낄 수 있는 캠프파이어를 그려낸 캠프 패치입니다.', '22/04/02', 273);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '월드랜드 패치', 2500, 'cmcpatch4_600.jpg'
,'에베레스트의 높은 고지를 완주하고 그 속에서 느껴지는 추위와 기압을 이겨내고 며칠간 그곳에서 
산과 싸우며 내려온 삶들이 얼마나 고되고 귀한지 
알게 해주는 등산을 완주한 모든 이들의 열정이 담긴 패치입니다.', '22/04/04', 143);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '캠프 패치', 2500, 'cmcpatch3_600.jpg'
,'뉴 마운틴의 시대가 열리며 항상 꿈꿔온 산중 캠프를 상상하며 
그때의 따뜻함을 느낄 수 있는 캠프파이어를 그려낸 캠프 패치입니다.', '22/04/16', 129);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '월드랜드 패치', 2100, 'cmcpatch4_600.jpg'
,'에베레스트의 높은 고지를 완주하고 그 속에서 느껴지는 추위와 기압을 이겨내고 며칠간 그곳에서 
산과 싸우며 내려온 삶들이 얼마나 고되고 귀한지 
알게 해주는 등산을 완주한 모든 이들의 열정이 담긴 패치입니다.', '22/04/24', 933);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '맘모스 패치', 1900, 'cmcpatch1_600.jpg'
,'3대 캐니언이 위치한 미서부 지역은 웅장한 대자연을 체험하고 절벽 위에 있는 
전망대에 올라서면 겹겹이 이어지는 계곡이 파노라마처럼 펼쳐지는 수십억 연간 비와 바람이 만들어낸 예술작품을 의류에 부착해 보세요.
3대 캐니언 중 가장 아름다운 풍광으로 유명한 곳, ''맘모스 캐니언''을 담고 있는 맘모스 캐니언 패치입니다.', '22/04/25', 2352);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '어드벤처 패치', 2200, 'cmcpatch2_600.jpg'
,'어드벤처의 대가 ''로버트 스타크''는 항상 도전하는 마음으로 세계의 높은 산들을 정복하곤 했습니다 
그의 젊은 시절 산속에서 겪었던 일화를 레퍼런스로 제작한 등산 패치입니다.', '22/04/27', 233);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '맘모스 패치', 9000, 'cmcpatch1_600.jpg'
,'3대 캐니언이 위치한 미서부 지역은 웅장한 대자연을 체험하고 절벽 위에 있는 
전망대에 올라서면 겹겹이 이어지는 계곡이 파노라마처럼 펼쳐지는 수십억 연간 비와 바람이 만들어낸 예술작품을 의류에 부착해 보세요.
3대 캐니언 중 가장 아름다운 풍광으로 유명한 곳, ''맘모스 캐니언''을 담고 있는 맘모스 캐니언 패치입니다.', '22/05/01', 252);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '어드벤처 패치', 3000, 'cmcpatch2_600.jpg'
,'어드벤처의 대가 ''로버트 스타크''는 항상 도전하는 마음으로 세계의 높은 산들을 정복하곤 했습니다 
그의 젊은 시절 산속에서 겪었던 일화를 레퍼런스로 제작한 등산 패치입니다.', '22/05/15', 974);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '캠프 패치', 2100, 'cmcpatch3_600.jpg'
,'뉴 마운틴의 시대가 열리며 항상 꿈꿔온 산중 캠프를 상상하며 
그때의 따뜻함을 느낄 수 있는 캠프파이어를 그려낸 캠프 패치입니다.', '22/05/16', 1135);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '월드랜드 패치', 2100, 'cmcpatch4_600.jpg'
,'에베레스트의 높은 고지를 완주하고 그 속에서 느껴지는 추위와 기압을 이겨내고 며칠간 그곳에서 
산과 싸우며 내려온 삶들이 얼마나 고되고 귀한지 
알게 해주는 등산을 완주한 모든 이들의 열정이 담긴 패치입니다.', '22/06/01', 1243);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '맘모스 패치', 1900, 'cmcpatch1_600.jpg'
,'3대 캐니언이 위치한 미서부 지역은 웅장한 대자연을 체험하고 절벽 위에 있는 
전망대에 올라서면 겹겹이 이어지는 계곡이 파노라마처럼 펼쳐지는 수십억 연간 비와 바람이 만들어낸 예술작품을 의류에 부착해 보세요.
3대 캐니언 중 가장 아름다운 풍광으로 유명한 곳, ''맘모스 캐니언''을 담고 있는 맘모스 캐니언 패치입니다.', '22/06/04', 2142);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '어드벤처 패치', 3000, 'cmcpatch2_600.jpg'
,'어드벤처의 대가 ''로버트 스타크''는 항상 도전하는 마음으로 세계의 높은 산들을 정복하곤 했습니다 
그의 젊은 시절 산속에서 겪었던 일화를 레퍼런스로 제작한 등산 패치입니다.', '22/06/14', 593);

INSERT INTO board_category VALUES (1, '공지사항');
INSERT INTO board_category VALUES (2, '자유게시판');
INSERT INTO board_category VALUES (3, '맛집정보');
INSERT INTO board_category VALUES (4, '소모임게시판');
INSERT INTO board_category VALUES (5, '질문게시판');

INSERT INTO user_level VALUES (1, '일반회원', '일반');
INSERT INTO user_level VALUES (2, '관리자', '관리자');

INSERT INTO user_info
(USERNO,USERID,USERPW,USERNAME,GENDER,ADDRESS,PHONE
,BIRTH,EMAIL,NICK,JOINDAY, GRADENO)
VALUES
(17777,'changmin1234','1234', 'user2'
,'남자','서울시 송파구', '01000000000'
, '1993/12/26', 'changmin1234@naver.com','changmin'
,sysdate, 1);



INSERT INTO board_info VALUES
(1001, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1002, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1003, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1004, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1005, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1006, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1007, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1008, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1009, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1020, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1021, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1022, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1023, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1024, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1025, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1026, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1027, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1028, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1029, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1030, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1031, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1032, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1033, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1034, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1035, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1036, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1037, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1038, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1039, 'title', 'content', sysdate, 17777, 1, 1232, 'changmin');
INSERT INTO board_info VALUES
(1040, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1041, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1042, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1043, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1044, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1045, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1046, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1047, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1048, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1049, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1050, 'title', 'content', sysdate, 17777, 3, 1232, 'changmin');
INSERT INTO board_info VALUES
(1051, 'title', 'content', sysdate, 17777, 4, 1232, 'changmin');
INSERT INTO board_info VALUES
(1052, 'title', 'content', sysdate, 17777, 5, 1232, 'changmin');
INSERT INTO board_info VALUES
(1053, 'title', 'content', sysdate, 17777, 3, 1232, 'changmin');
INSERT INTO board_info VALUES
(1054, 'title', 'content', sysdate, 17777, 4, 1232, 'changmin');
INSERT INTO board_info VALUES
(1055, 'title', 'content', sysdate, 17777, 5, 1232, 'changmin');
INSERT INTO board_info VALUES
(1056, 'title', 'content', sysdate, 17777, 3, 1232, 'changmin');
INSERT INTO board_info VALUES
(1057, 'title', 'content', sysdate, 17777, 4, 1232, 'changmin');
INSERT INTO board_info VALUES
(1058, 'title', 'content', sysdate, 17777, 3, 1232, 'changmin');
INSERT INTO board_info VALUES
(1059, 'title', 'content', sysdate, 17777, 4, 1232, 'changmin');
INSERT INTO board_info VALUES
(1060, 'title', 'content', sysdate, 17777, 3, 1232, 'changmin');
INSERT INTO board_info VALUES
(1061, 'title', 'content', sysdate, 17777, 4, 1232, 'changmin');
INSERT INTO board_info VALUES
(1062, 'title', 'content', sysdate, 17777, 5, 1232, 'changmin');
INSERT INTO board_info VALUES
(1063, 'title', 'content', sysdate, 17777, 5, 1232, 'changmin');
INSERT INTO board_info VALUES
(1064, 'title', 'content', sysdate, 17777, 5, 1232, 'changmin');
INSERT INTO board_info VALUES
(1065, 'title', 'content', sysdate, 17777, 5, 1232, 'changmin');
INSERT INTO board_info VALUES
(1066, 'title', 'content', sysdate, 17777, 5, 1232, 'changmin');
INSERT INTO board_info VALUES
(1067, 'title', 'content', sysdate, 17777, 5, 1232, 'changmin');
INSERT INTO board_info VALUES
(1068, 'title', 'content', sysdate, 17777, 5, 1232, 'changmin');
INSERT INTO board_info VALUES
(1069, 'title', 'content', sysdate, 17777, 5, 1232, 'changmin');
INSERT INTO board_info VALUES
(1070, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1071, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1072, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1073, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1074, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1075, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1076, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1077, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1078, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');
INSERT INTO board_info VALUES
(1079, 'title', 'content', sysdate, 17777, 2, 1232, 'changmin');

INSERT INTO user_orderbefore VALUES ( 100, 'abc', 100, 17777);

INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '더미굿즈', 100, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',user_orderbefore_seq.nextval, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '더미굿즈', 100, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',user_orderbefore_seq.nextval, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '더미굿즈', 100, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',user_orderbefore_seq.nextval, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '더미굿즈', 100, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',user_orderbefore_seq.nextval, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '더미굿즈', 100, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',user_orderbefore_seq.nextval, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '더미굿즈', 100, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',user_orderbefore_seq.nextval, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '더미굿즈', 100, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',user_orderbefore_seq.nextval, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '더미굿즈', 100, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',user_orderbefore_seq.nextval, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '더미굿즈', 100, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',user_orderbefore_seq.nextval, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '더미굿즈', 100, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',user_orderbefore_seq.nextval, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '더미굿즈', 100, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',user_orderbefore_seq.nextval, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '더미굿즈', 100, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',user_orderbefore_seq.nextval, 17777);

--commit;
