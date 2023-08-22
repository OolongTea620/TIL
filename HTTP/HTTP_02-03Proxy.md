## 원 서버 직접 접근

`if` 만약 원 서버가 미국에 있다면...?   
=> 요청, 응답에 많은 시간이 소요....

#### 프로시 캐시 도입
원 서버 외 프록시 캐시 서버를 사이에 하나 두어서 원 서버 요청 전에 프록시 캐시 서버에서 요청을 처리하도록 한다. 
CDA 서비스라고도 한다.

### 프록시 캐시 서버가 있는 경우 헤더

- Cache-Control: public
    - 응답이 public 캐시에 저장되어도 됨

- Cache-Control: private
    - 응답이 해당 사용자만을 위한 것임, private 캐시에 저장해야 함(기본값)

- Cache-Control: s-message
    - 프록시 캐시에만 적용되는 max-age

- Age:60(HTTP 헤더)
    - 오리진 서버에서 응답 후 프록시 캐시 내에 머문 시간(초)

### 캐시 무효화 
#### 확실한 캐시 무효화
GET요청이 들어오는 경우, 브라우저에서 임의로 캐싱을 자동화 한다.  
따라서 특정 페이지에서 캐싱을 완벽하게 금지를 하려면 아래와 같이 헤더를 넣으면 된다.
- Cache-Control: no-cache, no-store, must-revalidate
- Pragma: no-cache (HTTP1.0 히위호환)

##### 상세 설명
- Cache-Control: no-cache 
  - 데이터는 캐시해도 되지만, 항상, **원 서버에 검증하고 사용**(이름에 주의)
- Cache-Control: no-store
  - 데이터에 민감한 정보가 있으므로, 저장하면 안됨  
    (메로리에서 사용하고 최대한 빨리 삭제)
- Cache-Control: must-revalidate
  - 캐시 만료 후 최초 조회시 **원 서버에 검증**을 해야함
  - **원 서버 접근 실패 시, 반드시 오류가 발생해야함** (프록시 서버는 client에게 504 Gateway Timeout)
  - must-revalidate는 캐시 유효 시간이라면 캐시를 사용함
- Pragma: no-cache (HTTP 1.0 하위 호환)