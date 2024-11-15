## <2주차 미션>

👉 목표 : BottomNavigationView 와 Fragment 의 이해

### **🖼️ 화면 구성**

- 앱을 실행하면 가장 먼저 나오는 Splash 화면
- BottomNavigationView와 Fragment를 표시해줄 Main 화면

**🛠️ XML**

-**`activity_main.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <FrameLayout
        android:id="@+id/main_container"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toTopOf="@+id/bottom_nav"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottom_nav"
        android:layout_width="match_parent"
        android:layout_height="46dp"
        android:background="@color/white"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:menu="@menu/bottom_nav_item" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

-**`fragment_home.xml`** 

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/home_fragment"
    android:background="@drawable/background"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".HomeFragment">

        <LinearLayout
            android:id="@+id/home_top_bar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:gravity="center_vertical"
            android:paddingVertical="16dp"
            android:paddingHorizontal="24dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/app_title"
                android:textSize="24sp"
                android:textStyle="bold"/>

            <View
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="1"/>

            <ImageView
                android:id="@+id/home_notification"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:contentDescription="@string/notification"
                android:src="@drawable/baseline_notifications_24"/>
        </LinearLayout>

        <LinearLayout
            android:id="@+id/linear_layout"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:layout_marginBottom="16dp"
            app:layout_constraintBottom_toTopOf="@+id/chat_bubble_box"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="@string/day"
                android:textAlignment="center"
                android:textSize="22sp"/>

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textAlignment="center"
                android:text="@string/script"
                android:textSize="22sp"/>

        </LinearLayout>

        <ImageView
            android:id="@+id/chat_bubble_box"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/chat_bubble_box"
            android:layout_marginBottom="8dp"
            android:contentDescription="@string/chat_bubble_box"
            app:layout_constraintBottom_toTopOf="@+id/post_box"
            app:layout_constraintEnd_toEndOf="@+id/post_box"
            app:layout_constraintStart_toStartOf="@+id/post_box" />

        <ImageView
            android:id="@+id/post_box"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:contentDescription="@string/postbox"
            android:src="@drawable/post_box_example"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>

```

### **⚙️ 바텀네비게이션 아이콘을 클릭했을 때 Fragment 전환시키기 (애니메이션 추가)**

1. 앱을 처음 실행시킬때 홈 화면으로 설정
    
    ```kotlin
    supportFragmentManager.beginTransaction().replace(R.id.main_container, HomeFragment()).commit()
    ```
    
2.  setOnItemSelectedListenter 함수를 사용하여 아이콘을 클릭했을때 표시하고 싶은 화면을 설정

    
    ```kotlin
    binding.bottomNav.setOnItemSelectedListener { item ->
        val transaction = supportFragmentManager.beginTransaction()
            when (item.itemId) {
                R.id.nav_home -> {
                    transaction.setCustomAnimations(
                        R.anim.slide_in_from_left_fade_in,
                        R.anim.fadeout
                    )
                    transaction.replace(R.id.main_container, fragments[0])
                    transaction.commit()
                    currentPage = 0
                    true
                }
                R.id.nav_write -> {
                    if(currentPage < 1) {
                        transaction.setCustomAnimations(
                            R.anim.slide_in_from_right_fade_in,
                            R.anim.fadeout
                        )
                    } else {
                        transaction.setCustomAnimations(
                            R.anim.slide_in_from_left_fade_in,
                            R.anim.fadeout
                        )
                    }
                    transaction.replace(R.id.main_container, fragments[1])
                    transaction.commit()
                    currentPage = 1
                    true
                }
                R.id.nav_schedule -> {
                    if(currentPage < 2) {
                        transaction.setCustomAnimations(
                            R.anim.slide_in_from_right_fade_in,
                            R.anim.fadeout
                        )
                    } else {
                        transaction.setCustomAnimations(
                            R.anim.slide_in_from_left_fade_in,
                            R.anim.fadeout
                        )
                    }
                    transaction.replace(R.id.main_container, fragments[2])
                    transaction.commit()
                    currentPage = 2
                    true
                }
                R.id.nav_profile -> {
                    transaction.setCustomAnimations(
                        R.anim.slide_in_from_right_fade_in,
                        R.anim.fadeout
                    )
                    transaction.replace(R.id.main_container, fragments[3])
                    transaction.commit()
                    currentPage = 3
                    true
                }
                else -> false
            }
        }
    ```
    
3.  애니메이션 설정

    📍현재 페이지 번호를 고려하여 왼쪽 or 오른쪽 화면전환 애니메이션 설정

-**`fade_out.xml`** 

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <set xmlns:android="http://schemas.android.com/apk/res/android">
        <alpha android:fromAlpha="1.0"
        android:toAlpha="0.0"
        android:duration = "200"/>
    </set>
    ```

-**`slide_in_from_left_fade_in.xml`** 

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <set xmlns:android="http://schemas.android.com/apk/res/android">
        <alpha
        android:duration="200"
        android:fromAlpha="0.0"
        android:toAlpha="1.0" />
        <translate
        android:duration="200"
        android:fromXDelta="-10%"
        android:interpolator="@android:anim/decelerate_interpolator"
        android:toXDelta="0%" />
    </set>
    ```
-**`slide_in_from_right_fade_in.xml`** 

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <set xmlns:android="http://schemas.android.com/apk/res/android">
        <alpha
        android:duration="200"
        android:fromAlpha="0.0"
        android:toAlpha="1.0" />
        <translate
        android:duration="200"
        android:fromXDelta="10%"
        android:interpolator="@android:anim/decelerate_interpolator"
        android:toXDelta="0%" />
    </set>
    ```
 ****