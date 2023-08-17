HTTP Form 데이터 전송

- HTML Form submit시 **POST** 전송
- Content-Type: application/x-www-form-urlencoded 사용
  - form의 내용을 메시지 바디를 통해서 전송 (key=value, 쿼리 파라미터 형식)
  - 전송 데이터를 url encoding 처리
  
- HTML Form은 GET 전송도 가능하다
- Content-Type: multipart/form-data
  - 파일 업로드 같은 바이너리 데이터 전송시 사용
  - 다른 종류의 려러 파일과 폼의 내용 함쎄 전송 가능

HTTP API 데이터 전송

서버 to 서버
- 백엔드 시스템 통신
앱 클라이언트
- 아이폰, 안드로이드
웹 클라이언트
- HTML에서 Form 전송 대신 자바 스크림트를 통한 통신에 사용(AJAX)

POST,PUT,PATCH : 메시지 바디를 통해 데이터 전송
GET : 조회, 쿼리 파라미터로 데이터 전달

Content-Type: application/json을 주로 사용
  - TEXT, XML, JSON등

스토어 : 클라이언트가 리소스를 어디서 가져와야 하는지 알고 다루는 저장소

### 컨트롤 URL

GET, POST 만 지원 (제약 있음)
동사로 리소스 경로 사용
POST의 /new, /edit, /delete 가 컨트롤 uri
HTTP 메서드로 해결하기 애매한 경우 사용(HTTP API 포함)


### 참고하면 좋은 URI 설계 개념

**문서(document)**
    
  - 단일 개념(파일 하나, 객체 인스턴스, 데이터베이스 row)
  - /member/100, files/star.jpg

**컬렉션(collection)**

  - 서버가 관리하는 리소스 디렉터리
  - 서버가 리소스의 URI를 생성하고 관리
  - /members

**스토어(store)**

  - 클라이언트가 관리하는 자원 저장소
  - 클라이언트가 리소스의 URI를 알고 관리
  - /files

**컨트롤러(controller),컨트롤 URI**

- 문서, 컬렉션, 스토어로 해결하기 어려운 추가 프로세스 실행
- 동사를 직접 사용
- /members/{id}/delete