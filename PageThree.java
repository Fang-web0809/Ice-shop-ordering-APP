public class PageThree extends AppCompatActivity {

    //Step 1: 宣告物件變數
    Button btn3;
    TextView orderText;
    String outText;    //輸出區的文字內容
    Product p;         //儲存套餐物件
    Ice [] I = new Ice[3];  //儲存配料物件,因為配料可能有2~3種, 所以宣告成陣列
    int contents =0;     //儲存配料數

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_three);

        //Step 2: 連結物件變數及UI元件
        btn3 = findViewById(R.id.btn3);
        orderText = findViewById(R.id.orderText);

        /* 取得第二頁面所傳來的資料
           在第二頁中收集到使用者的選項資料,放入一個陣列中
           取得Intent中的ice包裹,並將內容值存入Values[]陣列中
           在第二頁中,有提到Values[0]:套餐代碼,
           Values[1],Values[2], (可能有Values[3]):配料代碼
         */
        Intent it23 = getIntent();
        Bundle bd23 = it23.getExtras();
        int [] Values = bd23.getIntArray("ice");
        int pro=bd23.getInt("pro");

        /*
        設定配料物件陣列I[]的陣列內容,
        如果Values[1:3]是0, 則在I陣列中存入一個new Apple()物件
                            並且在輸出區文字內容加上"Apple\n"
        如果Values[1:3]是1,...
         */
        outText = "你的訂單內容:\n";
        int count = 0;
        String contents = "";
        for(int i = 1; i<Values.length; i++){
            switch (Values[i]) {
                case 0:
                    I[count] = new Apple();
                    count++;
                    contents += "Apple\n";
                    break;
                case 1:
                    I[count] = new Banana();
                    count++;
                    contents += "Banana\n";
                    break;
                case 2:
                    I[count] = new Pudding();
                    count++;
                    contents += "Pudding\n";
                    break;
                case 3:
                    I[count] = new Strawberry();
                    count++;
                    contents += "Strawberry\n";
                    break;
                case 4:
                    I[count] = new Mango();
                    count++;
                    contents += "Mango\n";
                    break;
                case 5:
                    I[count] = new zeo();
                    count++;
                    break;
            }

        }

        /*
        建立套餐物件,如果Values[0]是0:建立套餐A, 並以I[0], I[1]為建構子的參數
         */
        switch (Values[0]) {
            case 0:
                p = new A(I[0], I[1]);
                outText += "A套餐: \n" + contents;
                break;
            case 1:
                p = new B(I[0], I[1], I[2]);
                outText += "B套餐: \n" + contents;
                break;
            case 2:
                p = new C(I[0], I[1]);
                outText += "C套餐: \n" + contents;
                break;
            case 3:
                p = new D(I[0], I[1], I[2]);
                outText += "D套餐: \n" + contents;
                break;
            case 4:
                p = new E(I[0], I[1], I[2], I[3], I[4]);
                outText += "客製化不加冰: \n" + contents;
                break;
            case 5:
                p = new F(I[0], I[1], I[2], I[3], I[4]);
                outText += "客製化加冰: \n" + contents;
                break;

        }
        //呼叫getPrice()方法,來取得套餐物件的售價
        outText += "金額:" + pro*p.getPrice() + "\n";
        outText += "成本:" + pro*p.getCost() + "\n";
        outText += "利潤:" + pro*p.getProfit() + "\n";
        //將輸出區文字內容設定到輸出區
        orderText.setText(outText);

        //Step 3: 為按鈕安裝傾聽者
        btn3.setOnClickListener(btn3Listener);

    }

    //Step 4: 當按下按鈕後, 將轉換到第四頁面
    View.OnClickListener btn3Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it3 = new Intent(PageThree.this, PageFour.class);
            startActivity(it3);
        }
    };
}
