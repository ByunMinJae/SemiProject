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

--SELECT * FROM product;
--SELECT prodpop FROM product WHERE prodno=1001;

-- 상품파일 정보 --
DROP TABLE productfile;
CREATE TABLE productfile (
    fileno NUMBER PRIMARY KEY,
    prodno NUMBER,
    originname VARCHAR2(300),
    storedname VARCHAR2(300),
    filesize NUMBER,
    write_date DATE DEFAULT sysdate
);
DROP SEQUENCE productfile_seq;
CREATE SEQUENCE productfile_seq START WITH 1000;

-- 주문 정보 --
DROP TABLE user_orderbefore;
CREATE TABLE user_orderbefore (
   orderno NUMBER CONSTRAINT pk_orderno PRIMARY KEY,
   buyprodname VARCHAR2(200),
   totalamount NUMBER,
   userno NUMBER NOT NULL
);

DROP SEQUENCE user_orderbefore_seq;
CREATE SEQUENCE user_orderbefore_seq START WITH 1000;

--SELECT * FROM user_orderbefore;

-- 게시글 정보 --
DROP TABLE board_info;
CREATE TABLE board_info (
   boardno NUMBER CONSTRAINT pk_boardno PRIMARY KEY,
   boardtitle VARCHAR2(50) NOT NULL,
   boardcon VARCHAR2(4000) NOT NULL,
   boarddate DATE NOT NULL,
   userno NUMBER NOT NULL,
   categoryno NUMBER NOT NULL,
   hit NUMBER NOT NULL
);

DROP SEQUENCE board_info_seq;
CREATE SEQUENCE board_info_seq START WITH 2000;

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
    prodno NUMBER NOT NULL,
    prodname VARCHAR2(100),
    prodprice NUMBER
);
DROP SEQUENCE cart_seq;
CREATE SEQUENCE cart_seq START WITH 1000;

---- 결제 정보 --
--DROP TABLE pay;
--CREATE TABLE pay (
--   payno NUMBER CONSTRAINT pk_payno PRIMARY KEY,
--   payoption VARCHAR2(20) NOT NULL,
--   paydate DATE NOT NULL,
--    orderno NUMBER NOT NULL
--);
--DROP SEQUENCE pay_seq;
--CREATE SEQUENCE pay_seq START WITH 1000;



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

DROP TABLE kakaoid;
CREATE TABLE kakaoid(
    kakaono NUMBER CONSTRAINT pk_kakaono PRIMARY KEY,
    kakaoemail varchar2(100) UNIQUE NOT NULL,
    kakaonick varchar2(50) UNIQUE NOT NULL);

DROP SEQUENCE kakaoid_seq;    
CREATE SEQUENCE kakaoid_seq START WITH 1000;

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

--ALTER TABLE board_info
--ADD CONSTRAINT fk_board_info foreign KEY(nick) references user_info (nick);

ALTER TABLE productfile
ADD CONSTRAINT productfile_fk foreign Key(prodno) references product (prodno);

INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '맘모스 패치1', 1800, 'cmcpatch1_600.jpg'
,'3대 캐니언이 위치한 미서부 지역은 웅장한 대자연을 체험하고 절벽 위에 있는 
전망대에 올라서면 겹겹이 이어지는 계곡이 파노라마처럼 펼쳐지는 수십억 연간 비와 바람이 만들어낸 예술작품을 의류에 부착해 보세요.
3대 캐니언 중 가장 아름다운 풍광으로 유명한 곳, ''맘모스 캐니언''을 담고 있는 맘모스 캐니언 패치입니다.', '21/07/21', 232);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '어드벤처 패치1', 2100, 'cmcpatch2_600.jpg'
,'어드벤처의 대가 ''로버트 스타크''는 항상 도전하는 마음으로 세계의 높은 산들을 정복하곤 했습니다 
그의 젊은 시절 산속에서 겪었던 일화를 레퍼런스로 제작한 등산 패치입니다.', '21/08/14', 523);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '캠프 패치1', 2500, 'cmcpatch3_600.jpg'
,'뉴 마운틴의 시대가 열리며 항상 꿈꿔온 산중 캠프를 상상하며 
그때의 따뜻함을 느낄 수 있는 캠프파이어를 그려낸 캠프 패치입니다.', '21/09/02', 273);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '월드랜드 패치1', 2100, 'cmcpatch4_600.jpg'
,'에베레스트의 높은 고지를 완주하고 그 속에서 느껴지는 추위와 기압을 이겨내고 며칠간 그곳에서 
산과 싸우며 내려온 삶들이 얼마나 고되고 귀한지 
알게 해주는 등산을 완주한 모든 이들의 열정이 담긴 패치입니다.', '21/10/21', 113);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '맘모스 패치2', 1800, 'cmcpatch1_600.jpg'
,'3대 캐니언이 위치한 미서부 지역은 웅장한 대자연을 체험하고 절벽 위에 있는 
전망대에 올라서면 겹겹이 이어지는 계곡이 파노라마처럼 펼쳐지는 수십억 연간 비와 바람이 만들어낸 예술작품을 의류에 부착해 보세요.
3대 캐니언 중 가장 아름다운 풍광으로 유명한 곳, ''맘모스 캐니언''을 담고 있는 맘모스 캐니언 패치입니다.', '22/01/22', 282);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '어드벤처 패치2', 2100, 'cmcpatch2_600.jpg'
,'어드벤처의 대가 ''로버트 스타크''는 항상 도전하는 마음으로 세계의 높은 산들을 정복하곤 했습니다 
그의 젊은 시절 산속에서 겪었던 일화를 레퍼런스로 제작한 등산 패치입니다.', '22/02/15', 653);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '캠프 패치2', 2100, 'cmcpatch3_600.jpg'
,'뉴 마운틴의 시대가 열리며 항상 꿈꿔온 산중 캠프를 상상하며 
그때의 따뜻함을 느낄 수 있는 캠프파이어를 그려낸 캠프 패치입니다.', '22/02/16', 189);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '월드랜드 패치2', 2500, 'cmcpatch4_600.jpg'
,'에베레스트의 높은 고지를 완주하고 그 속에서 느껴지는 추위와 기압을 이겨내고 며칠간 그곳에서 
산과 싸우며 내려온 삶들이 얼마나 고되고 귀한지 
알게 해주는 등산을 완주한 모든 이들의 열정이 담긴 패치입니다.', '22/03/01', 143);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '맘모스 패치3', 2500, 'cmcpatch1_600.jpg'
,'3대 캐니언이 위치한 미서부 지역은 웅장한 대자연을 체험하고 절벽 위에 있는 
전망대에 올라서면 겹겹이 이어지는 계곡이 파노라마처럼 펼쳐지는 수십억 연간 비와 바람이 만들어낸 예술작품을 의류에 부착해 보세요.
3대 캐니언 중 가장 아름다운 풍광으로 유명한 곳, ''맘모스 캐니언''을 담고 있는 맘모스 캐니언 패치입니다.', '22/03/04', 232);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '어드벤처 패치3', 1900, 'cmcpatch2_600.jpg'
,'어드벤처의 대가 ''로버트 스타크''는 항상 도전하는 마음으로 세계의 높은 산들을 정복하곤 했습니다 
그의 젊은 시절 산속에서 겪었던 일화를 레퍼런스로 제작한 등산 패치입니다.', '22/03/14', 523);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '캠프 패치3', 2100, 'cmcpatch3_600.jpg'
,'뉴 마운틴의 시대가 열리며 항상 꿈꿔온 산중 캠프를 상상하며 
그때의 따뜻함을 느낄 수 있는 캠프파이어를 그려낸 캠프 패치입니다.', '22/04/02', 273);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '월드랜드 패치3', 2500, 'cmcpatch4_600.jpg'
,'에베레스트의 높은 고지를 완주하고 그 속에서 느껴지는 추위와 기압을 이겨내고 며칠간 그곳에서 
산과 싸우며 내려온 삶들이 얼마나 고되고 귀한지 
알게 해주는 등산을 완주한 모든 이들의 열정이 담긴 패치입니다.', '22/04/04', 143);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '캠프 패치4', 2500, 'cmcpatch3_600.jpg'
,'뉴 마운틴의 시대가 열리며 항상 꿈꿔온 산중 캠프를 상상하며 
그때의 따뜻함을 느낄 수 있는 캠프파이어를 그려낸 캠프 패치입니다.', '22/04/16', 129);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '월드랜드 패치4', 2100, 'cmcpatch4_600.jpg'
,'에베레스트의 높은 고지를 완주하고 그 속에서 느껴지는 추위와 기압을 이겨내고 며칠간 그곳에서 
산과 싸우며 내려온 삶들이 얼마나 고되고 귀한지 
알게 해주는 등산을 완주한 모든 이들의 열정이 담긴 패치입니다.', '22/04/24', 933);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '맘모스 패치4', 1900, 'cmcpatch1_600.jpg'
,'3대 캐니언이 위치한 미서부 지역은 웅장한 대자연을 체험하고 절벽 위에 있는 
전망대에 올라서면 겹겹이 이어지는 계곡이 파노라마처럼 펼쳐지는 수십억 연간 비와 바람이 만들어낸 예술작품을 의류에 부착해 보세요.
3대 캐니언 중 가장 아름다운 풍광으로 유명한 곳, ''맘모스 캐니언''을 담고 있는 맘모스 캐니언 패치입니다.', '22/04/25', 2352);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '어드벤처 패치4', 2200, 'cmcpatch2_600.jpg'
,'어드벤처의 대가 ''로버트 스타크''는 항상 도전하는 마음으로 세계의 높은 산들을 정복하곤 했습니다 
그의 젊은 시절 산속에서 겪었던 일화를 레퍼런스로 제작한 등산 패치입니다.', '22/04/27', 233);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '맘모스 패치5', 9000, 'cmcpatch1_600.jpg'
,'3대 캐니언이 위치한 미서부 지역은 웅장한 대자연을 체험하고 절벽 위에 있는 
전망대에 올라서면 겹겹이 이어지는 계곡이 파노라마처럼 펼쳐지는 수십억 연간 비와 바람이 만들어낸 예술작품을 의류에 부착해 보세요.
3대 캐니언 중 가장 아름다운 풍광으로 유명한 곳, ''맘모스 캐니언''을 담고 있는 맘모스 캐니언 패치입니다.', '22/05/01', 252);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '어드벤처 패치5', 3000, 'cmcpatch2_600.jpg'
,'어드벤처의 대가 ''로버트 스타크''는 항상 도전하는 마음으로 세계의 높은 산들을 정복하곤 했습니다 
그의 젊은 시절 산속에서 겪었던 일화를 레퍼런스로 제작한 등산 패치입니다.', '22/05/15', 974);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '캠프 패치5', 2100, 'cmcpatch3_600.jpg'
,'뉴 마운틴의 시대가 열리며 항상 꿈꿔온 산중 캠프를 상상하며 
그때의 따뜻함을 느낄 수 있는 캠프파이어를 그려낸 캠프 패치입니다.', '22/05/16', 1135);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '월드랜드 패치5', 2100, 'cmcpatch4_600.jpg'
,'에베레스트의 높은 고지를 완주하고 그 속에서 느껴지는 추위와 기압을 이겨내고 며칠간 그곳에서 
산과 싸우며 내려온 삶들이 얼마나 고되고 귀한지 
알게 해주는 등산을 완주한 모든 이들의 열정이 담긴 패치입니다.', '22/06/01', 1243);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '맘모스 패치6', 1900, 'cmcpatch1_600.jpg'
,'3대 캐니언이 위치한 미서부 지역은 웅장한 대자연을 체험하고 절벽 위에 있는 
전망대에 올라서면 겹겹이 이어지는 계곡이 파노라마처럼 펼쳐지는 수십억 연간 비와 바람이 만들어낸 예술작품을 의류에 부착해 보세요.
3대 캐니언 중 가장 아름다운 풍광으로 유명한 곳, ''맘모스 캐니언''을 담고 있는 맘모스 캐니언 패치입니다.', '22/06/04', 2142);
INSERT INTO product
(PRODNO, PRODNAME, PRODPRICE, PRODIMAGE, PRODCON, PRODDATE, PRODPOP)
VALUES (product_seq.nextval, '어드벤처 패치6', 3000, 'cmcpatch2_600.jpg'
,'어드벤처의 대가 ''로버트 스타크''는 항상 도전하는 마음으로 세계의 높은 산들을 정복하곤 했습니다 
그의 젊은 시절 산속에서 겪었던 일화를 레퍼런스로 제작한 등산 패치입니다.', '22/06/14', 593);

INSERT INTO board_category VALUES (1, '공지사항');
INSERT INTO board_category VALUES (2, '자유게시판');
INSERT INTO board_category VALUES (3, '맛집정보');
INSERT INTO board_category VALUES (4, '소모임게시판');
INSERT INTO board_category VALUES (5, '질문게시판');

INSERT INTO user_level VALUES (1, '일반회원', '일반');
INSERT INTO user_level VALUES (2, '관리자', '관리자');
INSERT INTO user_level VALUES (3, '정지회원', '일반');
INSERT INTO user_level VALUES (4, 'VIP', '일반');

INSERT INTO user_info
(USERNO,USERID,USERPW,USERNAME,GENDER,ADDRESS,PHONE
,BIRTH,EMAIL,NICK,JOINDAY, GRADENO)
VALUES
(17777,'changmin1234','1234', 'user2'
,'남자','서울시 송파구', '01000000000'
, '1993/12/26', 'changmin1234@naver.com','changmin'
,sysdate, 1);


INSERT INTO board_info VALUES
(1001, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1002, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1003, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1004, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1005, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1006, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1007, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1008, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1009, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1020, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1021, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1022, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1023, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1024, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1025, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1026, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1027, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1028, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1029, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1030, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1031, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1032, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1033, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1034, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1035, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1036, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1037, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1038, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1039, 'title', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1040, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1041, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1042, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1043, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1044, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1045, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1046, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1047, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1048, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1049, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1050, 'title', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1051, 'title', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1052, 'title', 'content', sysdate, 17777, 5, 1232);
INSERT INTO board_info VALUES
(1053, 'title', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1054, 'title', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1055, 'title', 'content', sysdate, 17777, 5, 1232);
INSERT INTO board_info VALUES
(1056, 'title', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1057, 'title', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1058, 'title', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1059, 'title', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1060, 'title', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1061, 'title', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1062, 'title', 'content', sysdate, 17777, 5, 1232);
INSERT INTO board_info VALUES
(1063, 'title', 'content', sysdate, 17777, 5, 1232);
INSERT INTO board_info VALUES
(1064, 'title', 'content', sysdate, 17777, 5, 1232);
INSERT INTO board_info VALUES
(1065, 'title', 'content', sysdate, 17777, 5, 1232);
INSERT INTO board_info VALUES
(1066, 'title', 'content', sysdate, 17777, 5, 1232);
INSERT INTO board_info VALUES
(1067, 'title', 'content', sysdate, 17777, 5, 1232);
INSERT INTO board_info VALUES
(1068, 'title', 'content', sysdate, 17777, 5, 1232);
INSERT INTO board_info VALUES
(1069, 'title', 'content', sysdate, 17777, 5, 1232);
INSERT INTO board_info VALUES
(1070, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1071, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1072, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1073, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1074, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1075, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1076, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1077, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1078, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1079, 'title', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1080, '검색용 더미', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1081, '검색하세요', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1082, '검색 바나나', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1083, '검색 딸기', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1084, '검색 딸기', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1085, '검색 메론', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1086, '검색 수박', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1087, '검색 참외', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1088, '딸기수박참외메론', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1089, '키위', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1090, '검색용 더미', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1091, '검색하세요', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1092, '검색 바나나', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1093, '검색 딸기', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1094, '검색 딸기', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1095, '검색 메론', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1096, '검색 수박', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1097, '검색 참외', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1098, '딸기수박참외메론', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1099, '키위', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1100, '이거 검색가능!?!', 'content', sysdate, 17777, 1, 1232);
INSERT INTO board_info VALUES
(1101, '검색용 더미', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1102, '검색하세요', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1103, '검색 바나나', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1104, '검색 딸기', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1105, '검색 딸기', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1106, '검색 메론', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1107, '검색 수박', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1108, '검색 참외', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1109, '딸기수박참외메론', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1110, '키위', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1111, '이거 검색가능!?!', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1112, '검색하세요', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1113, '검색 바나나', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1114, '검색 딸기', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1115, '검색 딸기', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1116, '검색 메론', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1117, '검색 수박', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1118, '검색 참외', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1119, '딸기수박참외메론', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1120, '키위', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1121, '이거 검색가능!?!', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1122, '검색하세요', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1123, '검색 바나나', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1124, '검색 딸기', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1125, '검색 딸기', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1126, '검색 메론', 'content', sysdate, 17777, 2, 1232);
INSERT INTO board_info VALUES
(1127, '검색 수박', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1128, '검색 참외', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1129, '딸기수박참외메론', 'content', sysdate, 17777, 3, 1232);
INSERT INTO board_info VALUES
(1130, '키위', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1131, '이거 검색가능!?!', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1132, '검색하세요', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1133, '검색 바나나', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1134, '검색 딸기', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1135, '검색 딸기', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1136, '검색 메론', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1137, '검색 수박', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1138, '검색 참외', 'content', sysdate, 17777, 4, 1232);
INSERT INTO board_info VALUES
(1139, '딸기수박참외메론', 'content', sysdate, 17777, 4, 1232);

--commit;

INSERT INTO user_orderbefore VALUES ( 100, 'abc', 100, 17777);
INSERT INTO user_orderbefore VALUES ( 1, 'abc', 100, 17777);


INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치1', 6300, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '월드랜드 패치1', 6300, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-25 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치1', 6300, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-23 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '캠프 패치2', 6300, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-13 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '맘모스 패치3', 5000, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-16 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '맘모스 패치3', 7500, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-16 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '맘모스 패치1', 5400, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-24 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치3', 5700, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-11-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치1', 4200, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-07-16 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치3', 3800, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-05-24 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '캠프 패치3', 8400, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-11 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '월드랜드 패치3', 5000, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-04 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '캠프 패치4', 10000, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-12-15 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치3', 9500, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-01-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치1', 6300, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치1', 6300, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-06-19 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '맘모스 패치1', 1800, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-09-29 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '맘모스 패치1', 3600, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-07-17 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '맘모스 패치1', 5400, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-05-03 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '맘모스 패치1', 5400, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-03-03 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치1', 4200, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-13 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치1', 4200, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-02-03 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치1', 8400, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-05-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치1', 8400, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-02-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치1', 6300, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-05-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '캠프 패치5', 6300, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-02-03 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치1', 6300, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-05-17 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '캠프 패치5', 6300, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-10-17 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치5', 6000, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-06-17 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '맘모스 패치1', 3600, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-02-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '맘모스 패치1', 5400, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-06-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '월드랜드 패치5', 8400, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-05-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치4', 4400, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-05-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '캠프 패치4', 7500, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-03-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치5', 9000, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-03-26 16:40:23',1, 17777);
INSERT INTO user_orderafter
VALUES( user_orderafter_seq.nextval, '결제완료', 'card', 1234, '어드벤처 패치1', 8400, 'abcd@abc.com', '유저이름', 01012322232, '서울시 중랑구', '2022-06-26 16:40:23',1, 17777);
----------------------------------------------cascade start
--user_orderbefore 외래키 삭제
ALTER TABLE user_orderbefore DROP CONSTRAINT fk_orderbefore_userno;
--user_orderbefore 외래키 생성하면서 CASCADE 추가
ALTER TABLE user_orderbefore 
ADD CONSTRAINT fk_orderbefore_userno
FOREIGN KEY (userno)
REFERENCES user_info (userno)
ON DELETE CASCADE;

----pay 외래키 삭제
--ALTER TABLE pay DROP CONSTRAINT fk_pay_orderno;
----pay 외래키 생성하면서 CASCADE 추가
--ALTER TABLE pay 
--ADD CONSTRAINT fk_pay_orderno
--FOREIGN KEY (orderno)
--REFERENCES user_orderbefore (orderno)
--ON DELETE CASCADE;

--회원정보(userinfo)
INSERT INTO user_info (USERNO,USERID,USERPW,USERNAME,GENDER,ADDRESS,PHONE,BIRTH,EMAIL,NICK,JOINDAY,USERUPDATE, GRADENO)
VALUES(11293,'gil123','1234', '김진영','남자','서울시 송파구', '01012345678', '1999/01/01', 'gil123@naver.com','길동이',sysdate,sysdate, 1);
INSERT INTO user_info (USERNO,USERID,USERPW,USERNAME,GENDER,ADDRESS,PHONE,BIRTH,EMAIL,NICK,JOINDAY,USERUPDATE, GRADENO)
VALUES(11223,'ahefh','1234', '정윤성','남자','27213 충북 제천시 청풍면 호반로7길 19', '01033331111', '1995/01/03', 'gise3@naver.com','하하',sysdate,sysdate, 1);
INSERT INTO user_info (USERNO,USERID,USERPW,USERNAME,GENDER,ADDRESS,PHONE,BIRTH,EMAIL,NICK,JOINDAY,USERUPDATE, GRADENO)
VALUES(11234,'werwe','1234', '최진우','남자','06035 서울 강남구 가로수길 5', '01011111111', '1994/08/01', 'serew@naver.com','호호',sysdate,sysdate, 1);
INSERT INTO user_info (USERNO,USERID,USERPW,USERNAME,GENDER,ADDRESS,PHONE,BIRTH,EMAIL,NICK,JOINDAY,USERUPDATE, GRADENO)
VALUES(13493,'sdafawe','1234', '김규민','남자','18148 경기 오산시 부산중앙로 25-6', '01012333678', '1992/04/01', 'wer@naver.com','히히',sysdate,sysdate, 1);
INSERT INTO user_info (USERNO,USERID,USERPW,USERNAME,GENDER,ADDRESS,PHONE,BIRTH,EMAIL,NICK,JOINDAY,USERUPDATE, GRADENO)
VALUES(12393,'safew','1234', '박민호','남자','16661 경기도 수원시 권선구 경수대로 83', '01012366678', '2000/02/06', 'wer123@naver.com','키킼',sysdate,sysdate, 1);
INSERT INTO user_info (USERNO,USERID,USERPW,USERNAME,GENDER,ADDRESS,PHONE,BIRTH,EMAIL,NICK,JOINDAY,USERUPDATE, GRADENO)
VALUES(1100,'aweqwr','1234', '김태희','여자','11903 경기 구리시 갈매길 18', '0101234778', '1998/09/21', 'weraera@naver.com','후후',sysdate,sysdate, 1);
INSERT INTO user_info (USERNO,USERID,USERPW,USERNAME,GENDER,ADDRESS,PHONE,BIRTH,EMAIL,NICK,JOINDAY,USERUPDATE, GRADENO)
VALUES(14593,'ljuoi','1234', '한예슬','여자','04595 서울 중구 다산로 328', '01012388678', '1994/09/22', 'cdfger@naver.com','허허',sysdate,sysdate, 1);
INSERT INTO user_info (USERNO,USERID,USERPW,USERNAME,GENDER,ADDRESS,PHONE,BIRTH,EMAIL,NICK,JOINDAY,USERUPDATE, GRADENO)
VALUES(11439,'hwefh','1234', '한가인','여자','05831 서울 송파구 동남로 103 18', '01012349978', '1991/11/04', 'dfwe@naver.com','흐흐',sysdate,sysdate, 1);
INSERT INTO user_info (USERNO,USERID,USERPW,USERNAME,GENDER,ADDRESS,PHONE,BIRTH,EMAIL,NICK,JOINDAY,USERUPDATE, GRADENO)
VALUES(30011,'qoiwej','1234', '전지현','여자','11903 46716 부산 강서구 강동송백5길 55', '01012340378', '1999/01/01', 'sjdfw@naver.com','헺헤',sysdate,sysdate, 1);

--장바구니
INSERT INTO cart(cartno, cartcount,userno,prodno) VALUES(cart_seq.nextval, 1,30011,1010);
INSERT INTO cart(cartno, cartcount,userno,prodno) VALUES(cart_seq.nextval, 1,30011,1000);
INSERT INTO cart(cartno, cartcount,userno,prodno) VALUES(cart_seq.nextval, 3,30011,1021);

--user_orderafter 외래키 삭제
ALTER TABLE user_orderafter DROP CONSTRAINT fk_orderafter_userno;
--user_orderafter 외래키 생성하면서 CASCADE 추가
ALTER TABLE user_orderafter 
ADD CONSTRAINT fk_orderafter_userno
FOREIGN KEY (userno)
REFERENCES user_info (userno)
ON DELETE CASCADE;

--user_orderafter 외래키 삭제
ALTER TABLE user_orderafter DROP CONSTRAINT fk_orderafter_orderno;
--user_orderafter 외래키 생성하면서 CASCADE 추가
ALTER TABLE user_orderafter 
ADD CONSTRAINT fk_orderafter_orderno
FOREIGN KEY (orderno)
REFERENCES user_orderbefore (orderno)
ON DELETE CASCADE;

--user_orderafter 외래키 삭제
ALTER TABLE user_orderbefore DROP CONSTRAINT fk_orderbefore_userno;
--user_orderafter 외래키 생성하면서 CASCADE 추가
ALTER TABLE user_orderbefore 
ADD CONSTRAINT fk_orderbefore_userno
FOREIGN KEY (userno)
REFERENCES user_info (userno)
ON DELETE CASCADE;

--cart 외래키 삭제
ALTER TABLE cart DROP CONSTRAINT fk_cart_userno;
--cart 외래키 생성하면서 CASCADE 추가
ALTER TABLE cart 
ADD CONSTRAINT fk_cart_userno
FOREIGN KEY (userno)
REFERENCES user_info (userno)
ON DELETE CASCADE;

--board_info 외래키 삭제
ALTER TABLE board_info DROP CONSTRAINT fk_board_info_userno;
--board_info 외래키 생성하면서 CASCADE 추가
ALTER TABLE board_info 
ADD CONSTRAINT fk_board_info_userno
FOREIGN KEY (userno)
REFERENCES user_info (userno)
ON DELETE CASCADE;

--board_report 외래키 삭제
ALTER TABLE board_report DROP CONSTRAINT fk_board_report_userno;
--board_report 외래키 생성하면서 CASCADE 추가
ALTER TABLE board_report 
ADD CONSTRAINT fk_board_report_userno
FOREIGN KEY (userno)
REFERENCES user_info (userno)
ON DELETE CASCADE;

--board_report 외래키 삭제
ALTER TABLE board_report DROP CONSTRAINT fk_board_report_boardno;
--board_report 외래키 생성하면서 CASCADE 추가
ALTER TABLE board_report 
ADD CONSTRAINT fk_board_report_boardno
FOREIGN KEY (boardno)
REFERENCES board_info (boardno)
ON DELETE CASCADE;

--board_file 외래키 삭제
ALTER TABLE board_file DROP CONSTRAINT fk_board_file_boardno;
--board_file 외래키 생성하면서 CASCADE 추가
ALTER TABLE board_file 
ADD CONSTRAINT fk_board_file_boardno
FOREIGN KEY (boardno)
REFERENCES board_info (boardno)
ON DELETE CASCADE;

--board_comment 외래키 삭제
ALTER TABLE board_comment DROP CONSTRAINT fk_board_comment_userno;
--board_comment 외래키 생성하면서 CASCADE 추가
ALTER TABLE board_comment 
ADD CONSTRAINT fk_board_comment_userno
FOREIGN KEY (userno)
REFERENCES user_info (userno)
ON DELETE CASCADE;

--board_comment 외래키 삭제
ALTER TABLE board_comment DROP CONSTRAINT fk_board_comment_boardno;
--board_comment 외래키 생성하면서 CASCADE 추가
ALTER TABLE board_comment 
ADD CONSTRAINT fk_board_comment_boardno
FOREIGN KEY (boardno)
REFERENCES board_info (boardno)
ON DELETE CASCADE;
----------------------------------------------cascade end

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
--DROP TABLE kakaoid;
--DROP TABLE productfile;

--commit;
