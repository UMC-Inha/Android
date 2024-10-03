- Activity
    - Activity란 무엇인가요?
        - 액티비티는 앱의 화면이다!
        - 다이얼로그나 팝업등도 액티비티로서 띄울 수 있다
        - 코틀린 클래스와 xml로 이루어져있다 !
        - 매니페스트에 등록도 해줘야함
        
        뷰바인딩 
        
        - 뷰 바인딩은 안드로이드 개발에서 ui요소를 보다 쉽게 참조하고 조작 할 수 있게 해주는 기능
        - 코드에서 직접 findViewByid 이용하지 않고도 깔끔하게 뷰에 접근 가능해진다
            
            장점 - 
            
            1. 타입 안정성 : 뷰 타입이 자동으로 결정 
            2. 널 안정성 : 뷰가 존재하지 않을경우 
            3. 간편한 접근 
    - 새로운 Activity를 만들기 위해선 어떻게 해야 할까요?
        - 새로운 액티비티 클래스를 생성한다 !
            - 매니페스트 등록하는거 잊지말기
    - AppcompatActivity란 무엇인가요?
        - 액티비티 클래스의 확장 버전으로
        - 하위 호환성을 해결해주는 중요 컴포넌트!!
        - 최신 UI 및 기능 사용가능토록 한다
            
            ![스크린샷 2024-10-04 오전 12.13.05.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f1912130-0409-4e90-a90f-6091ae253e73/b6876a38-a516-4a5a-92d5-eb2dbb8ed6d9/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-10-04_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_12.13.05.png)
            
        - 액티비티는 상속 받아서 작동을 하는데 compat 이라는 호환성을 가진다
        - 즉 액티비티중 하위 호환성을 해결해주는 액티비를 뜻한다
        - 액션 바 지원 / 다크모드 지원
- Activity-Layout 결합
    - findViewById
        - findViewById 사용법
        
        ```jsx
        var backBtn =findViewById<Button>( R.id.back_btn)
        ```
        
    - ViewBinding
        - ViewBinding 사용법
        1. 그래들 수정 
            
            ```jsx
            android {
                ...
                viewBinding {
                    enabled = true
                }
            }
            ```
            
        2. 코드 수정 
            
            ```jsx
            // 바인딩 객체 초기화
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            
            // 뷰 바인딩을 사용해 버튼 참조
            binding.backBtn.setOnClickListener {
                // 버튼 클릭 이벤트 처리
            }
            ```
            
    - findViewById보다 ViewBinding이 권장되는 이유
        - findViewById의 단점
        - ViewBinding의 장점
        - 위 에서 설명했지만 가장 와닿은것은 아무래도 타입안정성이 아닐까 싶다
- 새로운 Activity를 띄우는 방법
    - Intent란 무엇일까요?
        - 안드로이드에서 컴포넌트 간 통신을 담당하는 객체이다 .
        - 서비스 브로드캐스트 등 명시적 인텐트와 그 외로 구성되는 암시적 인텐트가 존재한다
        - 페이지 이동할때 많이 사용된다
    - Intent를 사용하여 Activity 간 데이터를 전달하려면 어떻게 해야할까요?
        1. put으로 데이터 넣기 
        
        ```jsx
        intent.putExtra("KEY_NAME", "전달할 데이터")
        ```
        
        1. 데이터 받기 
            
            ```jsx
            val intent = intent
            val data = intent.getStringExtra("KEY_NAME")
            ```
            
        
        수 많은 인텐트 방법
        
        ```
        1.    getStringExtra() / putExtra("key", String)
        2.    getIntExtra() / putExtra("key", Int)
        3.    getBooleanExtra() / putExtra("key", Boolean)
        4.    getLongExtra() / putExtra("key", Long)
        5.    getDoubleExtra() / putExtra("key", Double)
        6.    getFloatExtra() / putExtra("key", Float)
        7.    getBundleExtra() / putExtra("key", Bundle)
        8.    getParcelableExtra() / putExtra("key", Parcelable)
        9.    getSerializableExtra() / putExtra("key", Serializable)
        10.    getStringArrayListExtra() / putExtra("key", ArrayList<String>)
        11.    getIntegerArrayListExtra() / putExtra("key", ArrayList<Int>)
        12.    getCharSequenceExtra() / putExtra("key", CharSequence)
        13.    getCharArrayExtra() / putExtra("key", CharArray)
        ```
        
- 명시적 Intent와 암시적 Intent
    - 명시적 Intent란 무엇일까요?
        - 앱 내에서 쓰이는 인텐트라고 생각하면 된다
        - 인텐트는 정보전달 객체
        - 서비스 브로드캐스트 등 앱내부에서 일어나는 정보 전달에 쓰이는 인텐트가 명시적인텐트인거임
        - 명확하게 어디로 가는지 안다는 것이 중요한거임
    - 암시적 Intent란 무엇일까요?
        - 앱 외에서 쓰이는 인텐트
        - 어떤 컴포넌트로 갈지 명확하지 않고 적절한 컴포넌트를 찾아서 쓸떄 쓰임
    - 두 Intent를 사용하는 예시에는 각각 무엇이 있을까요?
        1. 명시적 인텐트 
            - 액티비티 간 이동 시 데이터
            - 서비스 사용 / 시작
            - 브로드캐스트 전송
                - 브로드 캐스트 예시 : 배터리 잔량 변화 체크 , 네트워크 변화 체크
        2. 암시적 인텐트 
            - 웹 페이지 열기
            - 사진 , 지도 열기
- Fragment
    - Framgent의 정의는 무엇일까요?
        - 재사용 가능한 ui를 프라그먼트라고 통칭한다
        - 액티비티 내에서 다른 코드와 종속되지 않음
        - 그렇기에 재사용이 가능
        - 여러 프라그먼트를 조합해서 액티비티를 만들고 ui 가 이루어진다
    - Fragment를 사용하는 이유는 무엇일까요?
        - 모듈화를 위해서 쓰인다
        - 유지보수가 더더욱 쉬어지게 하기위해서
        - 동적으로 ui수정을 위해쓰이는 것임
        
        프라그먼트의 생명주기는 액티비티에 종속적이다 
        
    - 새 Fragment는 어떻게 만들 수 있을까요?
        
        ```jsx
        class MyFragment : Fragment() {
        
            override fun onCreateView(
                inflater: LayoutInflater, 
                container: ViewGroup?, 
                savedInstanceState: Bundle?
            ): View? {
                return inflater.inflate(R.layout.fragment_my, container, false)
            }
        }
        ```
        
    - Fragment는 어떻게 화면에 보이게 할 수 있을까요?
    - 
    
    ```jsx
    val fragment = MyFragment() // 프래그먼트 인스턴스 생성
    supportFragmentManager.beginTransaction()
        •    supportFragmentManager 현재 액티비티에 연결된 프래그먼트 관리자 지칭
        •    beginTransaction 새로운 프래그먼트 트랜잭션을 시작 (작업단위를 묶는다)
        .add(R.id.fragment_container, fragment) // 프래그먼트 추가
    .commit() // 트랜잭션 커밋
    ```
    
- Bundle
    - Bundle은 무엇일까요?
        - 데이터 전달할때 사용되는 클래스
        - 액티비티 간 또는 프래그먼트 간 데이터 잔딜시 사용
    
    ```jsx
    val bundle = Bundle()
    bundle.putString("key", "value") // 문자열 데이터 추가
    bundle.putInt("number", 123) // 정수 데이터 추가
    ```
    
    - Intent와 Bundle을 결합하는 방법은 무엇일까요?
    
    ```jsx
    val intent = Intent(this, SecondActivity::class.java)
    intent.putExtras(bundle) // 번들을 인텐트에 추가
    startActivity(intent) // 액티비티 시작
    ```
    
    ```jsx
      val bundle = intent.extras // 전달된 번들을 가져옴
    
      // 번들에서 데이터 추출
      bundle?.let {
          val value1 = it.getString("key1") // 문자열 데이터 가져오기
          val value2 = it.getInt("key2") // 정수 데이터 가져오기
    ```
    
    - 쓰는 이유
        - 데이터를 그룹화 할수 있다
            - bundle을 하나 보내는 것으로 데이터 관리할 수 있음
            - intent의 putExtra를 여러번 실행할 필요가 없음
        - 프라그먼트와 액티비티간 데이터 교환은 번들을 사용해야만 한다 intent 불가하므로
    - 인텐트와 번들의 관계를 조금 심도있게 보면 좋을듯 하다
        - intent는 화면 관리 즉 액티비티간 전환할때 쓰임
        - bundle은 데이터 저장하고 전송하는 구조이며 프라그먼트 액티비티간 3상태 저장 할떄 사용
        - intent와 함께 사용할 수 도 있음 위와 같은 구조
        - 보통은 둘다 사용함 위의 이유 때문
- FragmentManager
    - FragmentManager란 무엇일까요?
        - 프라그먼트 관리하게 해주는 클래스이다
        - 액티비티의 일부로 작동
        - 트랜잭션 , 탐색 , 백스택 관리 , 상태 유지 를 함
    - FragmentManager는 언제 사용해야 될까요?
        - 프라그먼트를 사용하고 ui를 동적으로 변경해야 할때 사용
        - 프라그먼트 추가 제거 replace 또는 전환 등 백스택 등등에서 필요할때 사용해야한다
- BottomNavigationView란?
    - BottomNavigationView란 무엇이고, 어떤 기능을 할까요?
        - 안드로이드의 디자인 컴포넌트 중 하나로 하단에 위치한 네비게이션 바이다
            
            ```jsx
            <androidx.bottomnavigation.BottomNavigationView>
            ```
            
    - BottomNavigationView가 사용된 예시에는 무엇이 있을까요?
        - 탭 페이지가 있는 어플리케이션
- BottomNavigationView의 구성 요소
    - BottomNavigationView를 사용하려면 레이아웃에 추가를 해야합니다. 이 때 어떤 값들이 필수적으로 지정되어야 할까요?
        - 네비게이션 항목 정의하는 메뉴 리소스 경로를 설정해야한다
        
        **app:menu**
        
    - Menu 리소스 XML
        - <menu> 태그는 무엇일까요?
            - 메뉴 항목들을 포함하는 컨테이너 역할 액션 바에서 ui요소등에 사용
        - <item> 태그는 무엇일까요?
            - 메뉴 태그 내부의 각각 개별항목을 정의하는 요소임
        - <item> 태그에 설정할 수 있는 항목에는 무엇이 있을까요?
            - 비슷비슷함
    - 화면 구성
        
        ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f1912130-0409-4e90-a90f-6091ae253e73/3cf80661-4cea-48b2-b1b8-a432b34028db/Untitled.png)
        
        1. 왼쪽의 예시 화면에서 (A)와 (B)에 해당하는 각각의 알맞은 **화면 구성 요소**를 선택해주세요!
            - (A) = Fragment
            - (B) =Fragment
        2. 왼쪽 화면을 구성하기 위해서 일반적으로 몇 개의 Fragment가 필요한가요??
            - 정답 ) 2개
- BottomNavigationView 설정하기
    - 각 Item을 클릭했을 때 나타나는 이벤트 설정하기
    - BottomNavigationView의 주요 속성들을 정리해 주세요!
        - 각 Item을 클릭했을 때 나타나는 이벤트 설정 방법은 꼭 정리하기 **[필수]**

main.xml에서 
- 프라그먼트 컨테이너와 네비바만 넣는거임 

그리고 프라그먼트를 갈아끼우는 방식으로 네비바를 작동시키면 됨 
예시코드 

```jsx
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.navigation_dashboard -> {
                    replaceFragment(DashboardFragment())
                    true
                }
                R.id.navigation_notifications -> {
                    replaceFragment(NotificationsFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
```

xml 따로 만들어주고 연결해줘야함 네비바랑 연결해줘야함 간단 ?
