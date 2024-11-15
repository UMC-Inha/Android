- TabLayout
    - TabLayout이란 무엇이고, 어떤 기능을 할까요?
        
        👉 탭(tab)으로 구분하는 화면에서 탭 버튼을 배치하는 레이아웃. Bottom Navagation도 TabLayout의 일종으로 볼 수 있다.
        
    - TabLayout이 사용된 예시에는 무엇이 있을까요?
        
        👉 주 메뉴 안에서 보조 메뉴를 선택할때
        
    - TabLayout에서 사용할 수 있는 속성들은 무엇이 있을까요?
        
        👉 TabItem → id, icon, text , …
        
- ViewPager2
    - ViewPager란 무엇이고, 어떤 기능을 할까요?
        
        👉 데이터를 페이지 단위로 표시하고 swipe를 통해 페이지를 전환할 수 있도록 만들어주는 컨테이너
        
    - ViewPager가 사용된 예시에는 무엇이 있을까요?
        
        👉 배달의민족 메인페이지?
        
    - ViewPager와 ViewPager2의 차이는 무엇일까요?
        
        👉로페이징뿐만 아니라 세로페이징도 제공해준다. 
        
        👉오른쪽에서 왼쪽 (RTL) 페이징을 지원한다.
        
        👉 ViewPager2는 RecyclerView를 기반으로 작성되었기 때문에 DiffUtil 클래스 (RecyclerView에서 성능을 개선해주기 위해 사용)에 접근할 수 있다.
        
    - ViewPager2에서 사용할 수 있는 속성들은 무엇이 있을까요?
        - **`android:orientation`**  페이지 방향(가로, 세로) 설정
        - **`android:layoutDirection`**  RTL 페이지 수동설정 가능
- ViewPager2 설정하기
    - ViewPager2를 이용하기 위해 어떤 라이브러리를 사용해야 할까요
        
        📍 `implementation "androidx.viewpager2:viewpager2:{version}"`
        
        - XML에 들어가야 하는 속성도 작성
            
            👉 orientation, layoutDirection
            
    - ViewPager2에서 FragmentStateAdapter는 무엇이고 어떤 기능을 할까요?
        
        👉 ViewPager2가 제공하는 Adapter 클래스로 각 화면을 프래그먼트로 구성할 때 사용이 가능하다
        
- ViewPager2 Indicator 설정하기
    - Indicator란 무엇이고, 어떤 역할을 할까요?
        
        👉 현재 페이지를 가리키는 시각적 표시 요소. 점, 아이콘 또는 텍스트로 표시되며 사용자에게 현재 페이지를 나타낸다.
        
    - ViewPager2에서 Indicator를 설정하려면 어떻게 해야할까요?
        
        👉 indicator 를 xml에 작성한 후, Activity에서 ViewPager에 indicator를 결합해주면 된다