---

이번 주차에서는 Activity와 Fragment, 화면 전환, 데이터 전달에 대해 공부합니다. Activity와 Fragment는 여러분이 안드로이드 개발을 할 때 빠질 수 없는 부분인 만큼 잘 정리해 두시면 좋을 것 같습니다. 참고 자료에도 여러분들이 읽어보면 좋을 것 같은 자료들을 넣어 놓았으니 확인해 보세요!!

한 번 공부하신 적이 있거나 쉽다고 느껴지시는 분들께서는 아래의 내용을 추가로 공부해 보시는 것을 추천해 드립니다.

- 암시적 Intent
    - 웹 , 지도 등 앱 내부가 아닌 외부와 데이터 전달할떄 사용 되는 intent 말그대로 명시적으로 명확 하지 않은 정보전달 이 이루어 질때 암시적 인텐트가 쓰였다고 한다
- Activity Stack
    - 액티비티의 상태와 순서를 관리하는 방식
    - 안드로이드는 스택이 쌓이는 구조인데 이런 스택을 백스택이라고 한다
    - 스택은 LIFO임 (라스트인 퍼스트 아웃)
    - 스택에 쌓인 액티비티들은 순서대로 관리되며 맨위에 있는 액티비티 종료되면 아래로 화면 전환
    - start해주면 새로 생겨서 위로 쌓이고 뒤로가기 ,finish 누르면 액티비티 삭제되고 다시 접근 불가
    - 안드로이드의 뒤로가기 시에는 finish 가 호출이 되는 방식이다
        
        뒤로가기와 finish의 차이점은 사용자가 호출하냐 개발자가 명시적으로 호출하냐의 차이다 
        
        제어를 하고 싶을떄는 finish 를 사용하는것이 유용할 수 있겠네 
        
- Fragment BackStack
    - 프래그먼트간 내비게이션 관리할떄 뒤로가기 버튼 눌렀을때 돌아갈 수 있게 해주는 기능
    - 즉 보통 내비바로 프래그먼트 컨트롤 하는데 뒤로가기 누르면 이전 프래그먼트 가져오도록 하기위해서 사용하는거임 addTobackStack 코드로 이를 제어할 수 있음
    - 예시 코드
        
        ```kotlin
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val newFragment = MyFragment()
        
        // 새로운 프래그먼트를 추가하고 백 스택에 트랜잭션을 저장
        fragmentTransaction.replace(R.id.fragment_container, newFragment)
        fragmentTransaction.addToBackStack(null) // 백 스택에 추가
        fragmentTransaction.commit() // 트랜잭션 커밋
        ```
        
    - addToBackStack(null): 현재 프래그먼트를 백 스택에 추가하라는 의미입니다. 이 트랜잭션이 백 스택에 추가되어, 뒤로가기를 눌렀을 때 이전 프래그먼트로 돌아갈 수 있게 됩니다.
    - 사용자가 뒤로가기 버튼 무조건 쓰니까 그냥 필수 고려사항
- Fragment Result API
    - 프래그먼트간 데이터 쉽게 주고받을 수 있도록 해주는 api
    - 스타트 액티비티리절트와 유사한 방식인데 콜백으로 처리해준다
    - 장점
        - 의존성 감소 : 프래그먼트간 참조없이 데이터 주고 받을 수 있다
        - 간결코드 / 생명주기와 안정성
        
        ```kotlin
        // 버튼 클릭 시 데이터를 전달
        view.findViewById<Button>(R.id.sendResultBtn).setOnClickListener {
            val result = Bundle()
            result.putString("bundleKey", "This is the result")
            // 결과를 전송
            setFragmentResult("requestKey", result)
        }
        
        ```
        
        ```kotlin
        setFragmentResultListener("requestKey") { requestKey, bundle ->
            // 전달받은 데이터 사용
            val result = bundle.getString("bundleKey")
            // 결과를 처리하는 로직
            Toast.makeText(context, "Result: $result", Toast.LENGTH_SHORT).show()
        }
        ```
