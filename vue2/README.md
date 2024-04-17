### TODO 리스트

- [ ] Vue2 강좌 수강하기
  - [ ] 코지코더 강좌 수강
  - [ ] Vue2 렌더링 정리하기
- [ ] Toy 프로젝트 진행하기

### Coputed 속성 vs Methods 속성 차이점

- `computed`는 결과를 캐싱하고 `Methods`는 캐싱을 하지 않는다.

### Watch 속성 

1. watch 안에 함수명은 변경주시할 vue 변수명을으로 맞춘다.
  

### Class 바인딩

```html
<div id="app">
        <div :class="{ red: isRed, 'font-bold': isBold }">Hello</div> // '-' 가 있는 경우, 클래스명을 ''안으로 묶는다.
        <button @click="update">Click</button>
    </div>
    <script>
        new Vue({
            el: '#app',
            data: {
                isRed: false,
                isBold: false,
            },
            methods: {
                update() {
                    this.isRed = !this.isRed;
                    this.isBold = !this.isBold;
                }
            }
        })
    </script>
```

### Style 바인딩

```html
<div id="app">
        <div :style="{ color: red, fontSize: size }">Hello</div> // '-' 가 있는 경우, 클래스명을 ''안으로 묶는다.
        <button @click="update">Click</button>
    </div>
    <script>
        new Vue({
            el: '#app',
            data: {
                red : 'red',
                size :'30px'
            },
            methods: {
                update() {
                    this.isRed = !this.isRed;
                    this.isBold = !this.isBold;
                }
            }
        })
    </script>
```

### v-if, v-else, v-else-if, v-show


```
v-if는 토글 비용 발생, v-show는 초기 렌더링 발생 
=> 공식문서는 v-if를 권장하고 있음 
```

### v-for와 key 속성 제공


### vue 객체는 여러개로 선언 가능하다.


### vue 컴포넌트
