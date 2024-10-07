- Activity
    - Activity란 무엇인가요?
        
        👉 간단히 말하면 앱의 화면. Kotlin 파일과 xml 파일로 구성 
        
    - 새로운 Activity를 만들기 위해선 어떻게 해야 할까요?
        
        👉 MainActivity가 있는 폴더 우클릭 → New → Activity → 원하는 Activity 선택 (가장 기본은 Empty Activity)
        
    - AppcompatActivity란 무엇인가요?
        
        👉 안드로이드의 하위버전을 지원하는 Activity의 일종.  (❔)
        
- Activity-Layout 결합
    - findViewById : 리소스 id를 통해서 레이아웃에 있는 뷰 객체들 중 일치하는 뷰를 가져오는 메소드
        - findViewById 사용법 :  **`findViewById(@IdRes int id)`**
    - ViewBinding : xml의 view component에 접근하는 객체를 반환받아 view에 접근하는 방식
        - ViewBinding 사용법 :  **`build.gralde`**   파일을 아래와 같이 수정
            
            ```
            android {
                ...
                buildFeatures {
                    viewBinding = true
                }
            }
            ```
            
            ```
            private lateinit var binding: ResultProfileBinding
            
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ResultProfileBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
            }
            ```
            
    - findViewById보다 ViewBinding이 권장되는 이유
        - findViewById의 단점 :
            1. ViewGroup 내부에서 탐색해야 할 View의 양이 많아질수록 성능이 저하됨
            2. Null-Safety에 위배됨. 잘못된 id로 인해 null이 반환될 시 치명적인 오류를 야기할 수 있음
        - ViewBinding의 장점 :
            1. null 반환 문제 해결 (**Null-Safety**)
            2. 반환 타입이 일치하지 않을 때 exception 발생 문제 해결 (**Type-Safety**)
            3. 뷰의 개수대로 코드를 추가 할 필요도 없음
- 새로운 Activity를 띄우는 방법
    - Intent란 무엇일까요?
        
        👉 앱 구성요소 간 작업 수행을 위한 정보를 전달하는 역할
        
    - Intent를 사용하여 Activity 간 데이터를 전달하려면 어떻게 해야할까요?
        
        👉 **`putExtra(key, value)`** 메소드를 이용해 데이터를 전달할 수 있다 !
        
- 명시적 Intent와 암시적 Intent
    - 명시적 Intent란 무엇일까요?
        
        👉 인텐트에서 클래스 객체나 컴포넌트 이름을 지정하여 **호출할 대상을 확실히 알 수 있는 경우**에 사용.  → 주로 앱 내부에서 사용
        
    - 암시적 Intent란 무엇일까요?
        
        👉 인텐트의 액션과 데이터를 지정하긴 했지만, **호출할 대상이 달라질 수 있는 경우**에 사용
        
    - 두 Intent를 사용하는 예시에는 각각 무엇이 있을까요?
        
        📍 명시적 : 사용자 작업에 응답하여 앱 내에서 새 활동을 시작하거나 백그라운드에서 파일을 다운로드 하는 서비스
        
        📍 암시적 :  사용자에게 지도에 있는 한 위치를 표시하고자 하는 경우, 암시적 인텐트를 사용하여 해당 기능을 갖춘 다른 앱이 지정된 위치를 지도에 표시하도록 요청할 수 있음
        
- Fragment
    - Framgent의 정의는 무엇일까요?
        
        👉 액티비티 내의 UI 또는 동작의 일부를 나타
        
    - Fragment를 사용하는 이유는 무엇일까요?
        
        👉 UI 중에서 재사용 가능한 부분을 재사용하기 위
        
    - 새 Fragment는 어떻게 만들 수 있을까요?
        - Fragment : New → Fragment → 원하는 Fragment 선택
    - Fragment는 어떻게 화면에 보이게 할 수 있을까요?
        
        👉 Framelayout에 Fragment 화면을 넣어줄 수 있음. (fragmentManager 사용) 
        
- Bundle
    - Bundle은 무엇일까요? : 상태/값을 전달하는 수단인 객체. Map 형태
    - Intent와 Bundle을 결합하는 방법은 무엇일까요?
        
        ```kotlin
        val intent = Intent()
        val bundle =Bundle()
        bundle.putString("key","value")
        intent.putExtra("bundle",bundle)
        ```
        
- FragmentManager
    - FragmentManager란 무엇일까요?
        
        👉 프래그먼트를 추가, 삭제 또는 교체하고 백스택에 추가하는 등의 작업을 실행하는 클래스
        
    - FragmentManager는 언제 사용해야 될까요?
        
        👉 프래그먼트 전환이 필요할때
        
- BottomNavigationView란?
    - BottomNavigationView란 무엇이고, 어떤 기능을 할까요?
        
        👉 화면 밑에 있는 네비게이션 역할을 하는 버튼 모음
        
        👉 각가의 버튼을 눌렀을 때 레이아웃에 fragment를 붙
        
    - BottomNavigationView가 사용된 예시에는 무엇이 있을까요?
        
        → 카카오톡, 인스타그램 등의 하단 바
        
- BottomNavigationView의 구성 요소
    - BottomNavigationView를 사용하려면 레이아웃에 추가를 해야합니다. 이 때 어떤 값들이 필수적으로 지정되어야 할까요?
        
        👉 menu 속성을 사용해 항목을 표시해야 한다 (구글 권장: 3~5개)
        
    - Menu 리소스 XML
        - <menu> 태그는 무엇일까요?
            
            👉 <item>, <group>을 하위 요소로 가지는 메뉴 항목의 컨테이너
            
        - <item> 태그는 무엇일까요?
            
            👉 Menu 내 단일 요소를 나타내며 속성들을 지정하여 여러가지 설정이 가능
            
        - <item> 태그에 설정할 수 있는 항목에는 무엇이 있을까요?
            
            👉 id, showAsAction, menuCategory, title, titleCondensed, icon 
            
    - 화면 구성
        
        ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f1912130-0409-4e90-a90f-6091ae253e73/3cf80661-4cea-48b2-b1b8-a432b34028db/Untitled.png)
        
        1. 왼쪽의 예시 화면에서 (A)와 (B)에 해당하는 각각의 알맞은 **화면 구성 요소**를 선택해주세요!
            - (A) = **Activity** / Fragment
            - (B) = Activity / **Fragment**
        2. 왼쪽 화면을 구성하기 위해서 일반적으로 몇 개의 Fragment가 필요한가요??
            - 정답 ) ____3______ 개
- BottomNavigationView 설정하기
    - 각 Item을 클릭했을 때 나타나는 이벤트 설정하기
        
        ```kotlin
        binding.bottomNavi.setOnItemSelectedListener { item ->
                    when (item.itemId) {
                        R.id.navigation_home -> {
                            navController.navigate(R.id.navigation_home)
                            /* 이벤트 설정 */
                            true
                        }
                        R.id.navigation_social -> {
                            navController.navigate(R.id.navigation_social)
                            true
                        }
                        R.id.navigation_record -> {
                            navController.navigate(R.id.navigation_record)
                            true
                        }
                        R.id.navigation_mypage -> {
                            navController.navigate(R.id.navigation_mypage)
                            true
                        }
                        else -> false
                    }
                }
        ```
        
    - BottomNavigationView의 주요 속성들을 정리해 주세요!
        
        👉 id, **menu**
        
        - 각 Item을 클릭했을 때 나타나는 이벤트 설정 방법은 꼭 정리하기 **[필수]**
            
            👉 위 코드와 같이 item 을 클릭했을때   해당하는 id에 이벤트 설정을 해주면 된다