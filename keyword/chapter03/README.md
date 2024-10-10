- CollapsingToolbarLayout
    - [ ]  → 움직이는 상단바 / 프레임 레이아웃의 솏겅을 가지고 있음
    
    ```xml
    <CoordinatorLayout>   << CollapsingToolbarLayout을 사용하기 위해서는 꼭 CoordinatorLayout을 사용해야함
    
        <AppBarLayout>   << appBarLayout 안에 CollapsingToolbarLayout을 넣음
        
            <CollapsingToolbarLayout>   << 스크롤시 접히거나 나타날 부분을 넣는 layout
            
                <ImageView/>            << 접히거나 나타날 이미지
                
                <Toolbar/>              << 접혔을 때에도 남아있을 툴바
                
            </CollapsingToolbarLayout>
        
        </AppBarLayout>
        
        <ViewPager2/>   << 스크롤할 뷰 (NestedScrollView나, RecyclerView도 가능)
    
    </CoordinatorLayout>
    ```
    
- CardView
    - **카드 형태의 레이아웃**을 만들기 위한 뷰
    - 모서리 둥글고 그림자가 적용된 모양으로 여러 요소 묶을때 사용하면 좋다
- Floating Button
    - 화면에 떠있는 원형 버튼을 의미한다
    - 주로 화면의 우측 하단에 고정되게 위치하게 한다
- Jetpack Navigation Graph
    - 제트팩 라이브러리의 내비게이션 구조를 정의하는 xml 파일
    - 코드가 아닌 xml에서 화면사이의 전환을 정의 가능하다

## 🎯 키워드 Essential

---

<aside>
💡 주요 내용들에 대해 조사해보고, 자신만의 생각을 통해 정리해보세요!
강의와 레퍼런스를 참고하여 정의, 속성, 장단점 등을 적어주셔도 됩니다.
조사는 공식 홈페이지 **Best**, 블로그(최신 날짜) **Not Bad**

</aside>

- TabLayout
    - TabLayout이란 무엇이고, 어떤 기능을 할까요?
        - 바텀 네비게이션에 대해서 먼저 생각해보자
        - 바텀 네비게이션은 하단에 들어간 바였다
        - 탭 레이아웃은 화면 상단에 존재하고 세부 섹션을 움직일때 사용하고
        - 주요 섹션은 바텀 네비게이션을 통해 전환한다
    - TabLayout이 사용된 예시에는 무엇이 있을까요?
        - 카카오톡의 채팅 친구 설정 검색 등 기능
        - 인스타그램의 하트 등이 탭 레이아웃임
    - TabLayout에서 사용할 수 있는 속성들은 무엇이 있을까요?
        - 타이틀 , 아이콘 , 색상 , 슬라이딩 위치
        - 수직으로 만들고 싶을떄는 커스텀 즉 ilinear 등에 달아주는게 일반적
- ViewPager2
    - ViewPager란 무엇이고, 어떤 기능을 할까요?
        - 뷰 페이저는 다양한 view를 스와이프 하는것을 제어 가능
    - ViewPager가 사용된 예시에는 무엇이 있을까요?
        - 모양으로 본다면 안드로이드 기본 화면에서 스와이프 하는 방식과 유사
        - onBording - 듀톨리얼 화면을 좌우로 넘기는데 이때 븊이저 사용
    - ViewPager와 ViewPager2의 차이는 무엇일까요?
        - 뷰페이저는 페이지 어댑터를 이용해 관리한다
        - 뷰페이저2는 리사이클러 뷰를 기반으로 작동한다
        - 뷰페이저는 수평 방향만 고정  , 2는 수평 수직 둘다 된다
        - 뷰페이저는 비활성화된 프래그먼트를 메모리에서 유지한다 → 메모리 문제 발생 가능
        - 뷰페이저2 는 리사이클러 뷰를 기반으로 동작하기에 효율성이 더 좋다
        - 뷰페이저는 데이터 직접 변경 복잡하고 뷰페이저2는 효율적이다
        - 보다 유연한 애니메이션과 중첩스크롤 문제 방지에 도움을 준다
    - ViewPager2에서 사용할 수 있는 속성들은 무엇이 있을까요?
        - 수평 ,수직 / 화면밖에 유지될 개수 설정  / 특정 페이지로 이동 / 애니메이션 효과 가능
- ViewPager2 설정하기
    - ViewPager2를 이용하기 위해 어떤 라이브러리를 사용해야 할까요
        - **AndroidX 라이브러리**를 사용
    - ViewPager2에서 FragmentStateAdapter는 무엇이고 어떤 기능을 할까요?
        - 리사이클러 뷰 의 동작구조를 가져온다
        - FragmentStatePagerAdapter의 기능을 개선한 버전으로, 여러 프래그먼트를 효율적으로 관리
        - 메모리 최적화 한것이 특징
- ViewPager2 Indicator 설정하기
    - Indicator란 무엇이고, 어떤 역할을 할까요?
        - 현재 페이지의 위치를 나타내는 작은 시각적 도구
        - 점이나 숫자 탭등으로 표시
        - 현재 페이지 위치 표시 시각적 기능등을 제공
    - ViewPager2에서 Indicator를 설정하려면 어떻게 해야할까요?
        - dots 인디케이터 사용시
        - 라이브러리 추가 / 레이아웃 설정 필요
