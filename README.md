# jsp
2021.07.22.
___

* servlet: JAVA안에 HTML코드! -> WAS
* JSP: HTML안에 JAVA코드! (java대신 EL,JHTL사용하여 마치 HTML쓰는 것 처럼 하기도)
      -jsp는 서블릿으로 변환되어 실행된다. 
      -index.jsp  => servlet이 index-jsp.java, .class (바이트코드) 두 개의 파일 만들고 JVM이 이를 실행. 
* web.xml: WAS에 정보전달하는 역할. Servers의 web.xml상속받는다.

* 객체들
  1. request(요청), response(응답): 요청객제로서 요청시마다 생성된다. 
  2. session 객체: 응답객체로서 요청시마다 생성되진 않는다. unique한 아이디 생성함. (->id.pw저장하기 좋음. )

  1. Request(요청)객체
    1) getParameter: 값 1개로 넘어온거 읽음. => name 값 들어감. 모두 String으로 (intger는 변환 필요)
    2) getParameterValues: 배열객체 ex)selectionBox 불러옴.
  2. Response 객체
    1) SendRedirect: 두 번의 트래픽, 객체 전달이 힘들어서 잘 안씀. 
    2) requestdispatcher: sendRedirect 개선
  
* Get vs Post
  - get: url뒤에 변수 달고 가는 친구들
        google.com/search?q=jsp.....
        주의! 이런식의 표현은 정보가 공개되어 보안에 취약.
        
  - post: form객체 자체를 던져줘서 보안 good.
  
  * MVC패턴
    1)request
    2)CONTROLLER(servlet) -java
    3)MODEL(java class) -java
    4)VIEW(jsp)
    5)response
  
  
 * Java db작업순서 (==psudo code 작업 순서 언어로 나타냄.)

      1. VO(DTO) 객체 생성 => 기존은 테이블과 1 :  1로 매핑한다. (컬럼명을 변수명으로 쓴다.)테이블 하나당vo하나씩 join결과를 통해 vo가 확장될 경우 크게 또는 새로 만듦.
      2. DAO(DBMS 연결conn 객체)생성 :dao상속 등 여러 방법으로,,,
      3. Service Interface 객체 생성 (CRUD)
      4. Interface객체를 이용하여 serviceImpl객체(CRUD구현) 생성
      5. 보여줄 페이지 또는 조립하는 것 만들어 준다 (controller, command 만들어주기)
      5-1. command interface 만들고 
      5-2. init(), service()메서드 이용한 서블릿 클래스 만들어 줌. (Controller)
      5-3. controller안에선 hashMap사용.  HashMap<String, Command>
      5-4. 반복작업~~
  

