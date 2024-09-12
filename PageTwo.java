public class PageTwo extends AppCompatActivity {

    //Step 1: 宣告物件變數
    RadioGroup rgSet;  //只宣告RadioGroup, 在程式中没有用radioButton, 所以没有宣告對應物件變數
    CheckBox [] I = new CheckBox[5]; //宣告CheckBox, 以陣列方式宣告變數
    EditText pro;
    Button btn2;  //宣告按鈕,按下後,可以轉到下一頁
    int [] Values;  //用來存使用者在頁面上的選擇結果
    int contents;   //記錄被選的配料數目
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

        //Step 2: 連結UI元件及物件變數
        btn2 = findViewById(R.id.btn2);
        rgSet = findViewById(R.id.rgSet);
        I[0] = findViewById(R.id.cb0);
        I[1] = findViewById(R.id.cb1);
        I[2] = findViewById(R.id.cb2);
        I[3] = findViewById(R.id.cb3);
        I[4] = findViewById(R.id.cb4);
        pro=findViewById(R.id.pro);
        //Step 3: 安裝Listener
        rgSet.setOnCheckedChangeListener(rgListener);
        btn2.setOnClickListener(btn2Listener);

    }

    //Step 4: 當選擇套餐的選項更動時,要執行的動作
    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            /* Values[] 是記錄使用者的選項, 因為只用了陣列來資料,來做為傳送到下一頁
               在Values[0]:儲存套餐的選項,如果選A套餐, 則存入0, 並設定配料數contents為2;
                          如果選B套餐, 則存入1, 並設定配料數contents為3; ...
             */

            if(checkedId == R.id.rb0) {
                Values = new int[3];
                Values[0] = 0;
                contents = 2;
            }
            if(checkedId == R.id.rb1) {
                Values = new int[4];
                Values[0] = 1;
                contents = 3;
            }
            if(checkedId == R.id.rb2) {
                Values = new int[3];
                Values[0] = 2;
                contents = 2;
            }
            if(checkedId == R.id.rb3) {
                Values = new int[4];
                Values[0] = 3;
                contents = 3;
            }
        }
    };

    //Step 4: 設定按下按鈕時, 會記錄使用者選的配料, 並將使用者的所有選擇資料Values送到下一頁
    View.OnClickListener btn2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             /*在Values[1], Values[2], (可能有Values[3]) :儲存配料的代號
                    如果選Apple,則存入0; 如果選Banana, 則存入1; ...
             */
            int count = 1;
            for(int i=0; i<I.length; i++){
                if(I[i].isChecked()){
                    Values[count] = i;
                    count++;
                    if(count>contents)
                        break;
                }
            }



            num=Integer.parseInt(pro.getText().toString());
            //Values[]中是使用者的所有選擇資料,並將Values[]送到下一頁
            Intent it2 = new Intent(PageTwo.this, PageThree.class);
            Bundle bd2 = new Bundle();
            bd2.putIntArray("ice", Values);
            bd2.putInt("pro",num);
            it2.putExtras(bd2);
            startActivity(it2);
        }
    };
} 
