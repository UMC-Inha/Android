<aside>
💡 미션 수행하신 내용을 아래에 정리해주세요!

## <감정우표 앱 만들기>

      👉 목표 : Constraint Layout과 Linear Layout 및 Intent 에 대한 이해 

### 🖼️ 화면 구성

- 감정 우표를 선택하는 홈 화면을 표시하는 MainActivity
- 우표를 선택했을 때 임시로 넘어가는 화면인 TestActivity

### 🛠️ XML

- `activity_main.xml`
    
    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@drawable/app_background"
        tools:context=".MainActivity">
    
        <LinearLayout
            android:id="@+id/topBar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:paddingVertical="14dp"
            android:paddingHorizontal="8dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent">
            <ImageView
                android:id="@+id/arrow_back"
                android:layout_width= "24dp"
                android:layout_height= "24dp"
                android:src="@drawable/baseline_arrow_back_ios_new_24" />
        </LinearLayout>
    
        <TextView
            android:id="@+id/title"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/home_title"
            android:textSize="30sp"
            android:textStyle="bold"
            android:textAlignment="center"
            android:layout_marginTop="60dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@id/topBar" />
        
        <TextView
            android:id="@+id/subtitle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/home_subtitle"
            android:textSize="22sp"
            android:textAlignment="center"
            app:layout_constraintTop_toBottomOf="@id/title"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent" />
    
        <TextView
            android:id="@+id/description"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/home_description"
            android:textSize="12sp"
            android:textAlignment="center"
            android:layout_marginVertical="20dp"
            app:layout_constraintTop_toBottomOf="@id/subtitle"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent" />
    
        <LinearLayout
            android:id="@+id/linearLayout"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:gravity="center"
            android:orientation="vertical"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@id/description">
    
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:gravity="center"
                android:layout_weight="1"
                android:orientation="vertical">
    
                <ImageView
                    android:id="@+id/stamp_happy"
                    android:layout_width="48dp"
                    android:layout_height="48dp"
                    android:src="@drawable/stamp_happy" />
    
                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/happy_stamp_description"
                    android:textSize="16sp" />
    
            </LinearLayout>
    
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:gravity="center"
                android:layout_weight="1"
                android:orientation="vertical">
    
                <ImageView
                    android:id="@+id/stamp_excited"
                    android:layout_width="48dp"
                    android:layout_height="48dp"
                    android:src="@drawable/stamp_excited" />
    
                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/excited_stamp_description"
                    android:textSize="16sp" />
    
            </LinearLayout>
    
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:gravity="center"
                android:layout_weight="1"
                android:orientation="vertical">
    
                <ImageView
                    android:id="@+id/stamp_normal"
                    android:layout_width="48dp"
                    android:layout_height="48dp"
                    android:src="@drawable/stamp_normal" />
    
                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/normal_stamp_description"
                    android:textSize="16sp" />
    
            </LinearLayout>
    
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:gravity="center"
                android:layout_weight="1"
                android:orientation="vertical">
    
                <ImageView
                    android:id="@+id/stamp_tired"
                    android:layout_width="48dp"
                    android:layout_height="48dp"
                    android:src="@drawable/stamp_tired" />
    
                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/tired_stamp_description"
                    android:textSize="16sp" />
    
            </LinearLayout>
    
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:gravity="center"
                android:layout_weight="1"
                android:orientation="vertical">
    
                <ImageView
                    android:id="@+id/stamp_angry"
                    android:layout_width="48dp"
                    android:layout_height="48dp"
                    android:src="@drawable/stamp_angry" />
    
                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/angry_stamp_description"
                    android:textSize="16sp" />
    
            </LinearLayout>
    
        </LinearLayout>
    
    </androidx.constraintlayout.widget.ConstraintLayout>
    ```
    
    ![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f1912130-0409-4e90-a90f-6091ae253e73/e829e569-94a8-43c9-b4d9-20130b977d1f/image.png)
    
- `activity_test.xml`
    
    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@drawable/app_background"
        tools:context=".TestActivity">
    
        <TextView
            android:id="@+id/textView"
            android:text="this text will be changed"
            android:textSize="64sp"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"/>
    
    </androidx.constraintlayout.widget.ConstraintLayout>
    ```
    

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/f1912130-0409-4e90-a90f-6091ae253e73/b78af49a-3905-46d9-aa8a-fe87f9d1dee6/image.png)

### ⚙️우표를 선택했을 때 화면이 넘어가게 하기

1. 우표 클릭시 TestActivity로 넘어가는 Intent를 생성하고, 같이 보낼 text도 넣어준다.
    
    ```kotlin
    ...
     override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
    
    				//예시) 행복 우표를 클릭했을 때 이벤트
            binding.stampHappy.setOnClickListener {
                val intent = Intent(this, TestActivity::class.java)
                intent.putExtra("text", "I'm happy!!")
                startActivity(intent)
            }
           ...
    }
    ```
    
2. Intent를 실행시킨다.
3. TestActivity 에서는 Intent에 담겨있는 text를 화면에 표시해준다
    
    ```kotlin
    ...
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityTestBinding.inflate(layoutInflater)
            setContentView(binding.root)
    
            intent = getIntent()
            binding.textView.text = intent.getStringExtra("text")
        }
    ```
    

</aside>