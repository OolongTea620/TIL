## HTTP 헤더
#### 용도  
HTTP 전송에 필요한 모든 부가 정보   
ex) 메시지 바디의 내용, 메시지 바디의 크기, 압축, 인증, 요청 클라이언트, 서버정보, 캐시 관리 정보...

- 표준 헤더가 너무 많음
- 필요시 임의의 헤더 추가 가능

#### 헤더 분류 - RFC2616(과거)

헤더 분류
- Gerneral 헤더 : 메시지 전체에 적용되는 정보
- Request 헤더 : 요청 정보, ex) User-Agent:Mozilla/5.0 
- Response 헤더 : 요청 정보, ex) Server:Apache 
- **Entity 헤더** : 엔티티 바디 정보 ex)Content-Type:text/html, Content-Length:3423

### ... HTTP 표준 변화

- ~~RFC2616(1999년)~~ ->  RFC7230 ~ 7235 (2014년)
- 
### HTTP BODY
RFC2616(과거)

- 메시지 본문(message body)은 엔티티 본문(entity body)을 전달하는데 사용
- 엔티티 본문: 요청이나 응답에서 전달할 실제 데이텅
- 엔티티 헤더는 엔티티 본문의 데이터를 해셕할 수 있는 정보 제공
  - 데이터 유형 (html, json), 데이터 길이, 압축 정보 등

**RFC2616(최신)**

- 메시지 본문(message body)을 통해 표현 데이터 전달
- 메시지 본문 = payload
- `표현데이터` : 요청이나 응답에서 전달할 실제 데이터
- `표현헤더` 는 표현데이터를 해석할 수있는 정보 제공
    - 데이터 유형(html.json), 데이터 길이 , 압축 정보 등
- 표현 헤더는 표현 메타데이터와 페이로드 메시지를 구분해햐지만.. 이부분은 생략

### 표현 
표현 헤더는 전송 응답 둘 다 사용
(현 표현 과거 Entity)

#### content-Type : 표현 데이터 형식
표현 데이터의 형식 설명   
미디어 타입, 문자 인코딩 

    - text/html; charset=utf-8
    - application/json
    - image/png


#### Content-Encoding : 표현 데이터의 압축 형식
표현 데이터를 압축하기 위해서 사용
데이터를 전달하는 곳에서 압축 후 인코딩 헤더 추가
데이터를 읽는 쪽에서 인코딩 헤더의 정보로 압축 해제

    - gzip
    - deflate
    - identity


#### Content-Language : 표현 데이터의 자연언어
표현 데이터의 자연언어를 표현

    ko ,en, en-US...

#### Content-Length : 표현 데이터의 길이
바이트 단위  
Transfer-Encoding(전송 코딩)을 사용하면 Content-Length를 사용하면 안됨

### 협상(콘텐츠 네고시에이션)
클라이언트가 선호하는 표현 유형   
협상 헤더는 요청시에만 사용

- Accept : 클라이언트가 선호하는 미디어 타입 전달
- Accept-Charset : 클라이언트가 선호하는 문자 인코딩
- Accept-Encoding: 클라이언트가 선호하는 압축 인코딩
- Accept-Language: 클라이언트가 선호하는 자연 언어

#### Quality Values 협상과 우선 순위
##### q값에 1에 가까울 수록 우선된다.

- Quality Values (q)값 사용
- 0 ~ 1, **클수록 높은 우선순위**
- 생략하면 1
- Accept-Language: ko-KR;


##### 구체적이 우선한다
- Accept: text/*, text/plain, text/plain;format=flowed, */*


    1. text/plain;format=flowed
    2. text/plain
    3. text/*
    4. */*

##### q보다는 구체적인 명시를 우선으로 미디어 타입을 갖춘다.


### 전송 방식(Transfer)
전송방식 설명

#### 단순 전송(Content-Length)

- 말 그대로 raw한 데이터로 전송하는 것

#### 압축 전송(Content-Encoding)

- client에 주는 Resource가 어떤 형식으로 압축되어 전달되는지 명시

#### 분할 전송(Transfer-Encoding)

- 특정 byte로 나누어 전송되고 마지막에 0 \r\n을 보낸다.
- 분할 전송 시에는 Content-Length가 있으면 안됨

#### 범위 전송(Range, content-Range)
client에서 Reqeust에서 Range로 헤더에 특정 범위를 지정하면
server에서 Response 헤더에 Content-Range로 응답하는 구조

### 단순 정보
#### From
유저 에이전트의 이메일 정보   
잘 사용되지 않음, 검색엔진 같은 곳에서 주로 사용.   
`Request`에서 사용

#### Refer 이전 웹 페이지 주소
- 현재 요청된 페이지의 이전 웹 페이지 주소
  - A -> B로 이동하는 경우, B를 요청할 때, **Referer:A를 포함해서 요청** >> 유입경로를 추적하는 용도
- Referer를 사용해서 유입
- `Request(요청)`헤더 에서 사용
- 참고: referer는 단어 

#### User-Agent 
유저 에이전트 애플리케이션 정보(client application 정보)
- 클라이언트의 애플리케이션 정보(웹 브라우저 정보, 등등)
- 통계 정보
- 어떤 종류의 브라우저에서 장애가 발생되는지 파악 가능
- `Request(요청)`에서 사용

#### Server 
요청을 처리하는 ORIGIN 서버의 소프트웨어 정보
- Server: Apache/2.22.22(Debian)
- server:nginx
- `Response(응답)`에서 사용

#### Date
메시지가 발생한 날짜와 시간
- Date: Tue, 15 Nov 1994 08:12:31 GMT
- `Response(응답)`에서 사용

### 특별한 정보
#### Host `필수`
요청한 호스트 정보(도메인)
- `Request(요청)`에서 사용
- 하나의 서버가 여러 도메인을 처리해야 할 때
- 하나의 서버에 여러 도메인이 적용되어 있을 때,

#### Location 
페이지 리다이렉션
- 웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 자동 이동 (리다이렉트)
- 응답코드 3xx에서 설명
- 201 (Created): Location 값은 요청에 의해 생성된 리소스 URI
- 3xx (Redirection): Location 값은 요청을 자동으로 리디렉션 하기 위한 대상 리소스를 가리킴

#### Allow
허용가능한 HTTP 메서드
405 (Method Not Allowed)에서 응답에 포함해야함
Allow : GET, HEAD, PUT

#### Retry-After
유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간
- 503(Service Unavailable): 서비스가 언제까지 불능인지 알려줄 수 있음
- Retry-After: Fri, 31 Dec 1999 23:59:59 GMT (날짜표기)
- Retry-After: 120 (초단위 표기)

### 인증
#### Authorization 
클라이언트 인즈 정보를 서버에 전달

- Authorization: Basic xxxxx...

#### WWW-Authenticate
리소스 접근시 필요한 인증 방법 정의

리소스 접근시 필요한 인증 방법 정의
401 Unauthorized 응답과 함께 사용