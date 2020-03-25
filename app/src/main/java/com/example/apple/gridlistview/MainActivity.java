package com.example.apple.gridlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    ArrayList<GridItem> gridArray = new ArrayList<GridItem>();
    private JSONArray SampleProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridview);

//        gridArray.add(0,"Home");
//        gridArray.add(new Item(userIcon,"User"));
//        gridArray.add(new Item(homeIcon,"House"));
//        gridArray.add(new Item(userIcon,"Friend"));
//        gridArray.add(new Item(homeIcon,"Home"));
//        gridArray.add(new Item(userIcon,"Personal"));
//        gridArray.add(new Item(homeIcon,"Home"));
//        gridArray.add(new Item(userIcon,"User"));
//        gridArray.add(new Item(homeIcon,"Building"));
//        gridArray.add(new Item(userIcon,"User"));
//        gridArray.add(new Item(homeIcon,"Home"));
//        gridArray.add(new Item(userIcon,"xyz"));
       renderJson();

        gridView.setAdapter(new ImageAdapter(this,R.layout.row_grid,SampleProducts));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, " "+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ListViewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void renderJson() {
        String sampleJsonString = "[{prod_name : \"Nikon D5300\", prod_thumb : \"https://cameradecision.com/img/px300_300/front_straight/Nikon-D5500.jpg\", prod_price : \"$460\", prod_desc : \"DSLR crafted to be lightweight yet full-on functionality, helping you revamp your photographic skills\"}, " +
                "{prod_name : \"Redmi Note 5\", prod_thumb : \"https://stat.homeshop18.com/homeshop18/images/productImages/385/micromax-spark-vdeo-q415-dual-sim-android-mobile-phone-gold-medium_6e3ae87ea6c41df8b74b798fcbc700ab.jpg\", prod_price : \"$120\", prod_desc : \"Stunning visuals on a 15.2 cm, 18:9 full-screen display with rounded corners\"}," +
                "{prod_name : \"IIK BLACK Watch\", prod_thumb : \"https://images.costco-static.com/ImageDelivery/imageService?profileId=12026539&imageId=1180670-894__1&recipeName=350\", prod_price : \"$50\", prod_desc : \"IIK COLLECTION BLACK for men\"}," +
                "{prod_name : \"V-neck Multicolor T-Shirt\", prod_thumb : \"https://3.imimg.com/data3/FG/CT/MY-8814506/polo-t-shirt-500x500.jpg\", prod_price : \"$20\", prod_desc : \"High quality cut & sew Designer V-Neck Tshirt direct from the manufacturers\"}]";
        try {
            SampleProducts = new JSONArray(sampleJsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
