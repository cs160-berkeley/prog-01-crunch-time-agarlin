package com.example.annamarie.cs160proj1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.HashMap;

public class MainActivity extends Activity {
    //private GridView gridView;
    private LayoutInflater layoutInflater;
    private String exercise;
    private Boolean rep=true;
    TextView text;
    TextView Calorie;
    private double multiple;
    private double cal;
    Button mbutton;
    private int minutes;
    EditText mEdit;
    HashMap<String, Double> map;
    ArrayAdapter<CharSequence> adapter;
     Double a =0.0;
     Double b =0.0;
     Double c =0.0;
     Double d=0.0 ;
     Double e=0.0 ;
    Double f=0.0;
    Double g=0.0;
    Double h=0.0;
    Double i=0.0;
    Double j=0.0;
    Double k=0.0;
    Double l=0.0;
    boolean click = false;

    private String[] exer= {
            "Situps\n\nReps: " + a,
            "Squats\n\nReps: " + b,
            "Leg-Lifts\n\nMinutes: " + c,
            "Jumping Jacks\n\nMinutes: " + d,
            "Swimming\n\nMinutes: " + e ,
            "Planks\n\nMinutes: " + f,
            "Pullups\n\nReps: " + g,
            "Cycling\n\nMinutes " + h,
            "Jogging\n\nMinutes: " + i,
            "Walking\n\nMinutes: " + j ,
            "Climbing Stairs\n\nMinutes: " + k,
            "Pushups\n\nReps: " + l,


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final GridView gridview = (GridView) findViewById(R.id.gridView1);
        gridview.setAdapter(new ImageAdapter(this));
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
// Create an ArrayAdapter using the string array and a default spinner layout
        adapter = ArrayAdapter.createFromResource(this,
                R.array.exercises, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        text = (TextView) findViewById(R.id.reps);
        map = new HashMap<>();
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub

                switch (arg2) {

                    case 0:
                        rep = true;
                        multiple = .28571429;
                        text.setText("Reps");
                        break;
                    case 1:
                        rep = true;
                        multiple = .5;
                        text.setText("Reps");
                        break;
                    case 2:
                        rep = true;
                        multiple = .444;
                        text.setText("Reps");
                        break;
                    case 3:
                        rep = false;
                        multiple = 4;
                        text.setText("Minutes");
                        break;
                    case 4:
                        rep = false;
                        multiple = 4;
                        text.setText("Minutes");
                        break;
                    case 5:
                        rep = false;
                        multiple = 10;
                        text.setText("Minutes");
                        break;
                    case 6:
                        rep = false;
                        multiple = 1;
                        text.setText("Minutes");
                        break;
                    case 7:
                        rep = false;
                        multiple = 8.33;
                        text.setText("Minutes");
                        break;
                    case 8:
                        rep = false;
                        multiple = 5;
                        text.setText("Minutes");
                        break;
                    case 9:
                        rep = false;
                        multiple = 8.33;
                        text.setText("Minutes");
                        break;
                    case 10:
                        rep = false;
                        multiple = 7.69;
                        text.setText("Minutes");
                        break;
                    case 11:
                        rep = false;
                        multiple = 6.667;
                        text.setText("Minutes");
                        break;
                    default:
                        text.setText(" ");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
        map.put("Situps", 2.0);
        map.put("Pullups", 1.0);
        map.put("Jumping-Jacks", .1);
        map.put("Plank", .25);
        map.put("Swimming", .13);
        map.put("Cycling", .12);
        map.put("Pushups", 3.5);
        map.put("Walking", .2);
        map.put("Jogging", .12);
        map.put("Stair-Climbing", .15);
        map.put("Leg-Lifts", .25);
        map.put("Squats", 2.25);

        final MainActivity t = this;
        mbutton = (Button)findViewById(R.id.gobutton);
        Calorie  = (TextView)findViewById(R.id.textView4);
        mEdit   =  (EditText)findViewById(R.id.min);
        System.out.println(click);

        mbutton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        String s = mEdit.getText().toString();

                        if (!s.equals("")) {
                            minutes = Integer.parseInt(s);
                        }
                        cal = multiple * minutes;
                        cal = Math.floor(cal * 100) / 100;
                        Calorie.setText(Double.toString(cal));

                        a = map.get("Situps") * cal;
                        b = map.get("Squats") * cal;
                        c = map.get("Leg-Lifts") * cal;
                        d = map.get("Jumping-Jacks") * cal;
                        e = map.get("Swimming") * cal;
                        f = map.get("Plank") * cal;
                        g = map.get("Pullups") * cal;
                        h = map.get("Cycling") * cal;
                        i = map.get("Jogging") * cal;
                        j = map.get("Walking") * cal;
                        k = map.get("Stair-Climbing") * cal;
                        l = map.get("Pushups") * cal;
                        click = true;
                        exer[0] = "Situps\n\nReps: " + round(a, 0);
                        exer[1] = "Squats\n\nReps: " + round(b, 0);
                        exer[2] = "Leg-Lifts\n\nMinutes: " + round(c,1);
                        exer[3] = "Jumping Jacks\n\nMinutes: " + round(d,1 );
                        exer[4] = "Swimming\n\nMinutes: " + round(e, 1);
                        exer[5] = "Planks\n\nMinutes: " + round(f,1);
                        exer[6] = "Pullups\n\nReps: " + round(g,0);
                        exer[7] = "Cycling\n\nMinutes " + round(h,1);
                        exer[8] = "Jogging\n\nMinutes: " + round(i,1);
                        exer[9] =   "Walking\n\nMinutes: " + round(j,1);
                        exer[10] = "Climbing Stairs\n\nMinutes: " + round(k,1);
                        exer[11] = "Pushups\n\nReps: " + round(l, 0);



                        adapter.notifyDataSetChanged();
                        gridview.invalidateViews();
                        gridview.setAdapter(new ImageAdapter(t));

                    }
                });

//        if (click) {
//
//            System.out.println("exer: "+ exer);
//            gridview.setAdapter(adapter);
//            click = false;
//        }

    }


//    public void onClick(View v) {
//        if (v.getId() == (R.id.gobutton)) {
//
//            }
    public static double round(double value, int numberOfDigitsAfterDecimalPoint) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(numberOfDigitsAfterDecimalPoint,
            BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
}
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater layoutInflater;
        private int counts;


        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }


        // create a new ImageView for each item referenced by the Adapter
        public View getView(final int position, View convertView, ViewGroup parent) {
            layoutInflater = LayoutInflater.from(getApplicationContext());
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.grid_item_layout, null);
                // if it's not recycled, initialize some attributes
            }
            ImageView imageView=(ImageView)convertView.findViewById(R.id.image);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(450, 450));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
            imageView.setColorFilter(Color.argb(200, 32, 6, 64));
            imageView.setImageResource(mThumbIds[position]);
            final TextView txt= (TextView) convertView.findViewById(R.id.textgrid);

            txt.setText(exer[position]);


//            mbutton.setOnClickListener(
//                    new View.OnClickListener() {
//                        public void onClick(View view) {
//                            String name = getResources().getStringArray(R.array.exercises)[position];
//                            Double num = map.get(name);
//                            if (num != null) {
//                                txt.setText(exer[position] + Double.toString(cal * num));
//                            }
//
//                        }
//                    });
            return convertView;
        }

        // references to our images

    }private Integer[] mThumbIds = {
            R.drawable.situp5,
            R.drawable.squats,
            R.drawable.leglifts,
            R.drawable.jumpingjacks,
            R.drawable.swimming,
            R.drawable.pl,
            R.drawable.pullup,
            R.drawable.cycling, R.drawable.jogging,
            R.drawable.walking,
            R.drawable.stairs,
            R.drawable.pushup,

    };






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
