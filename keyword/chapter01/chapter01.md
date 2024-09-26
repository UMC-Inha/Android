- Android OS
    - 정의: 모바일의 가능성에 변화를 가져다주는 플랫폼
        - 모바일 : 정보통신에 있어 이동성을 가진 모든것
        - 안드로이드에서는 안드로이드 TV 또한 있다 허나 안드로이드 TV는 모바일이 아닌데 어째서 정의가 모바일의 가능성에 변화를 가져다 주는 플랫폼인걸까를 고민하면 안드로이드의 핵심가치를 알수 있다
    - 특징:
        1. 범용성 : 모바일에서 시작해서 태블릿 시계 TV 차량 까지 안드로이드는 특정 하드웨어에 의존하지 않고 여러 제품을 가져온다
        2. 개방성 : 오픈 소스 기반 누구나 접근 가능
        3. 생태계 : 플레이스토어로 다양한 기회제공
        4. 기술 혁신 : 모바일의 가능성을 무수히 확장시키고 있다
- 즉 위와 같은 이유로 안드로이드는 모바일의 가능성에 변화를 주는 플랫폼 이라는 말이 가장 적합한 용어다

---

- Android의 Architecture
    - 안드로이드의 권장 아키텍쳐는 무엇일까요?

    권장 아키텍처를 알아보기 위해 일단 구성요소를 찾아보자

    크게 보면 안드로이드는 액티비티와 프라그먼트로 구성 되어진다고 봐도 무방하다

    액티비티 :  쉽게 풀어 설명하자면 페이지 단위로 동작하는 하나의 화면이다

    그리고 이 화면은 생명주기를 가져서 상태를 관리하는 것이 웹과의 차이점이라고 생각한다

    → 모바일은 사용자가 종료하는 시점과 정지되는 시점 EX)전화가 온다 이런 다양한 상황에 알맞게 설계가 되어져야 하는데 이 상태를 관리하는것이 생명주기

    프라그먼트 : 프라그먼트는 벽돌이다 즉 재사용성 있는 커스텀 뷰들의 집합을 의미

    프라그먼트의 집합이 프라그먼트가 될 수 있고 이 프라그먼트들의 집합중 생명주기를 갖는 것을 액티비티라고 한다
    액티비티에 종속된 프라그먼트는 액티비티와 같은 생명주기를 갖게 된다 (같이 있으니까)

    서비스 : 백그라운드에서 실행되는 컴포넌트

    - 비동기 처리하는데 이를 쓰레드라고 한다

    브로드캐스트 리시버 : 앱에서 발생한 이벤트 수신하는 컴포넌트

    - 배터리상태변화 네트워크 상태변화 등 이벤트 감지해수행
    - 매니페스트에 등록하거나 코드에서 동적으로 등록가능

    콘텐츠 프로바이더 : 앱간 데이터 공유 위한 컴포넌트

    - 데이터베이스 파일시스템 등 관리
    - 연락처 앱의 콘텐츠 프로바이더 통해 앱에서도 연락처 정보 조회및 수정 가능
    - 앱의 api기능을 수행가능

    위를 토대로 안드로이드 권장 앱 아키텍처 를 알아보자

    ## 안드로이드 권장 아키텍처

    - 안드로이드 아키텍쳐 컴포넌트 (AAC)는 무엇일까요?
        - [AAC(Android Architecture Component)](https://developer.android.com/topic/libraries/architecture?hl=ko)
    - 안드로이드 디벨로퍼 에서는 3개의 계층으로 설명을 한다
    1. UI Layer : viewModel로 어플리케이션의 데이터를 표시하는 레이어
    2. Domain Layer (optinal) : 선택사항으로 UI와 Data 레이어간 상호작용 간소화
    3. Data Layer : 비즈니스 로직 및 데이터를 노출하는 파트 REpository

        ![스크린샷 2024-09-25 오전 12.30.32.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f1912130-0409-4e90-a90f-6091ae253e73/1b7b2db1-c794-45c8-b241-7e9f6d046b58/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-09-25_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_12.30.32.png)


    도메인 레이어가 어렵게 다가올 수 있는데 도메인 레이어는 가격 계산로직 , 주문 처리 로직 등과 같이 데이터가 사용되는 부분이고 이 데이터를 api호출해 저장하는 곳은 data Layer이다

    사용자에게 보여주는 부분은 당연히 UI

    - ui 레이어는 두가지로 구성 된다
        1. UI 그자체
        2. 데이터를 보유하고 ui에 노출 상태를 관리 하는 class

            ![스크린샷 2024-09-25 오전 12.36.44.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f1912130-0409-4e90-a90f-6091ae253e73/0067e1c3-d66b-433c-a4b9-0c5303b69e9c/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-09-25_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_12.36.44.png)

    - 도메인 레이어
        - 데이터와 ui 사이에 있는 선택사항이다
        - 복잡한 간단화 과정 및 캡슐화를 한다

        앱의 클래스는 종속된다 꼬리물기 코딩이 되는데 이를 해결하기 위해 의존성을 주입한다

        - 의존성은 객체가 다른객체를 사용할때 발생하는 관계
        - 의존성을 외부에서 주입함으로서 두 클래스 간의 결합도를  낮출 수 있음
        - 아래코드는 의존성을 낮추는 패턴 한개임
        - 생성자를 통해 의존성을 주입하는 방식인데 이를 통해서 객체 간의 독립성을 높인다

        ```kotlin
        // UserRepository 인터페이스 정의
        interface UserRepository {
            fun findById(id: String): User
        }

        // User 데이터 클래스 정의
        data class User(val id: String, val name: String)

        // UserRepository의 구현체
        class UserRepositoryImpl : UserRepository {
            private val users = listOf(User("1", "Alice"), User("2", "Bob"))

            override fun findById(id: String): User {
                return users.first { it.id == id }
            }
        }

        // UserService 클래스
        class UserService(private val userRepository: UserRepository) {
            fun getUser(id: String): User {
                return userRepository.findById(id)
            }
        }

        // 사용 예시
        fun main() {
            val userRepository = UserRepositoryImpl() // UserRepositoryImpl 객체 생성
            val userService = UserService(userRepository) // UserService에 UserRepository 주입

            val user = userService.getUser("1") // 사용자 조회
            println(user) // User(id=1, name=Alice) 출력
        }
        ```

        결국 도메인 레이어에서는 위와 같은 역할을 수행하는 로직을 넣어둔다

        1. data Layer
            - 앱의 나머지 데이터 부분
            - 여러 데이터 소스 간의 충돌 해결 등등
            - DB 작업 네트워킹 작업등 을 수행한다

    ## MVVM 패턴

     - 뷰 (액티비티 , 프라그먼트) 와 모델(리포지터리)이 분리 되어 있고 뷰의 이벤트로 데이터 반환,저장하는 뷰모델이 존재

    vm → 모델로 부터 받은 값을 라이브데이터에 저장하는 등 중간 관리자

    모델 : API

    ## MVC패턴

    - 뷰 모델 컨트롤러

    c → m → v

    사용자가 c 사용하면 m 통해 데이터를 받아와서 v 로 보여준다

    m은 정보 및 데이터 부분을 의미

    ## MVP 패턴

    view와 model 사이 presenter 가 있어서 둘을 연결 해준다

    view와 모델의 의존성이 없는데 mvc 패턴의 의존성을 해결한것

    ![스크린샷 2024-09-25 오전 1.36.13.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f1912130-0409-4e90-a90f-6091ae253e73/c45b8e73-dba4-4e59-bc9c-7514e5c23e4b/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-09-25_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_1.36.13.png)

    1. **MVC (Model-View-Controller)**:
        - 흐름: **Controller → Model → View**
        - `C`가 사용자 입력을 받고, 이를 `M`에 전달해 데이터를 처리한 후, 처리된 결과를 `V`로 전달
    2. **MVP (Model-View-Presenter)**:
        - 흐름: **Presenter → Model → Presenter → View**
        - `P`가 입력 받고 `M`에 전달해 데이터를 처리하고, 다시 그 결과를 `P`에서 받아 `View`

    MVP에서 중요한 점은 `View`와 `Model`이 직접적으로 상호작용하지 않는다는 것

    **모든 통신이 `Presenter`를 통해 이루어진다**는 점입니다.

    위 구조 덕분에 뷰 와 모델의 의존성을 줄일 수 가 있음

- **MVC**는 **C → M → V** (사용자 입력은 `Controller`, 데이터 처리 결과는 `Model`, 최종 출력은 `View`)
- **MVP**는 **P → M → P → V** (사용자 입력은 `Presenter`, 데이터 처리 및 결과를 `Presenter`가 관리, 최종 출력은 `View`)

    ---

- Manifest의 주요 속성
    - 패키지 설정 및 필수 정보들이 들어간다 !
    1. Manifest : 루트 / 패키지및 속성 지정
    2. application : 어플리케이션 선언 , 테마나 아이콘 등
    3. activity : 인터페이스 선언 - 액티비티를 선언하지 않으면 사용 불가
    4. intent-filter : 활동 서비스 등 인텐트의 유형 지정
        1. 브로드 캐스트의 유형 선언
    5. action : 인텐트 필터에 작업 추가
    6. premission : 권한 선언
    7. use-permission : 앱이 올바르게 작동하기 위해 부여해야하는 권한
    8. provider : 콘텐츠 제공자 구성요소 선언
    9. receiver : 브로드 캐스트 선언
    10. service :  서비스 선언

- Intent
    - Intent의 역할은 무엇일까요?
        - 인텐트는 메시징 객체다
        - 즉 통신을 위한 객체로 다른 앱 구성요소로 메시지를 통해 요청을 전달할 수 있다
        - 액티비티 서비스 브로드 캐스트 리시버를 통신할 수 있게 한다
        - 인텐트를 이용해서 시작할 수도 있다
        - startActivity 함수
        - 서비스도 startService로 시작
        - 브로드 스트에서도 마찬가지도 객체를 생성한 후 전달 할 수 있다
        - 새로운 인텐트를 전달하여 액티비티의 인스턴스를 만들고 startActivity에게 인텐트 시작할 활동을 설명하고 필요한 모든 데이터를 전달
        - 액티비티 간의 데이터를 전달하기 위한 객체라고 생각해도 무방
        - 서비스와 브로드캐스트 등과도 상호작용이 가능함 이 맞는 표현인것 같다
    - 명시적 Intent와 암시적 Intent의 차이는 무엇일까요?
        - 암시적 intetn는 전달 객체에 대해서 특정한 구성요소를 지정하지 않고 특정한 작업 지정해 구성요소에 요청을 보낼 수 있다
        - startActivity 함수 호출시 인텐트를 전달하고 액티비티를 실행시킴
        - 명시적 인텐트는 우리가 흔히 아는 방식으로 액티비티를 직접 지정하는거다
        - 하지만 암시적 인텐트는 어떤 작업을 수행할지를 지정해서 찾아서 실행하도록 하는것이다
        - 즉 다른 앱과의 상호작용이 필요할때 사용한다
        - 반대로 명시적인것은 같은 앱내에서 사용할때 사용한다
- Android Layout

    레이아웃 XML 방식

    LinearLayout  : 가로나 세로

    RelativeLayout : 상대 배치

    TableLayout : 표

    FrameLayout : 액자

    DrawerLayout :  평소에 넣어 두었다가 표시 하게 할 수 있음

    ConstaintLayout : 뷰 마다 위치 지정 가능

    **1. TextView: 텍스트 표시**

    **2. Button: 클릭 가능한 버튼**

    **3. ImageView: 이미지 표시**

    **4. RecyclerView: 스크롤 가능한 목록**

    **5. ScrollView: 단일 뷰 그룹에서 스크롤 지원**

    **6. NestedScrollView: 중첩된 스크롤을 지원하는 스크롤뷰**

    **7. BottomNavigationView: 하단에 네비게이션 탭 표시**

    **8. TabLayout: 상단에 탭을 사용하여 화면 전환**

    **9. FloatingActionButton: 둥근 모양의 강조된 버튼**

    **10. margin: 바깥 여백**

    **11. padding: 안쪽 여백**

    **12. chainStyle: ConstraintLayout에서 뷰 간의 체인 스타일 지정**

    **13. id 네이밍: @+id/로 ID를 지정하여 각 뷰를 식별**


추가

## **NestedScrollView**

- 기존의 스크롤 뷰와의 차이를 생각하면 쉽다
- 스크롤 뷰와 리사이클러 뷰 등을 사용하는 뷰가 있다
- 이 뷰들을 스크롤 할때 뷰가 겹쳐서 스크롤 되는 경우가 있다
- 뷰자체가 통째로 스크롤 되는 경우도 있음
- 이를 해결하기 위해 neseted사용한다
- 네스티드 스크롤뷰를 사용하면 아이템을 미리 다 생성한다
- → 리사이클러 뷰 의 장점이 사라짐
- 네스티드 뷰 로 리사이클러 뷰 감싸면 아예 데이터가 비효율적이 될 수 가 있다
- 두개의 스크롤 뷰가 겹치는 상황임
- 스크롤 자체를 메모리에 올리는 방식이므로 상당히 위험함
- 보통은 리사이클러 뷰를 하나 쓰는게 이득인 경우가 많다

## ScrollView

- 처음에 메모리를 모두 사용

## RecyclerView

- 반복되는 뷰를 처리할때 각각의 개별 아이템 단위로 구성하여 화면에 출력하는 뷰 그룹
- 장점이 안보이는 부분을 미리 만들지 않는다
- 또한 새로운 요소가 쓰일 경우 hidden된 뷰를 재사용 하기에 메모리 낭비가 적다

- FloatingActionButton

    ![스크린샷 2024-09-26 오전 2.10.23.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f1912130-0409-4e90-a90f-6091ae253e73/293bc42f-0672-4eac-8f3e-2207f5dfb89e/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-09-26_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_2.10.23.png)


## Framelayout

- 프레임 레이아웃은 액자에 비유
- 뷰들이 서로 겹칠 수 있게 해줌