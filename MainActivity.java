public class MainActivity extends AppCompatActivity {
	
    //Step 1. 宣告物件變數
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 2. 連結物件變數與UI的元件
        btn1 = findViewById(R.id.btn1);

        //Step 3. 安裝傾聽者Listener
        btn1.setOnClickListener(btn1Listener);
    }

    //Step 4. 設計當按鈕按下時,要做的相對動作
    View.OnClickListener btn1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //建立Intent將頁面轉到PageTwo
            Intent it1 = new Intent(MainActivity.this, PageTwo.class);
            startActivity(it1);
        }
    };
}
