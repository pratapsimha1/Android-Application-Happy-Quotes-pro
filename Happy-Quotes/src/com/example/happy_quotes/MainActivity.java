package com.example.happy_quotes;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressLint("ShowToast") public class MainActivity extends Activity {
	private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        img = (ImageView)findViewById(R.id.imageView);
        Button b1 = (Button)findViewById(R.id.button);
        
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent sharingIntent = new Intent(Intent.ACTION_SEND);
				Uri screenshotUri = Uri.parse("www.amazon.com");
				
				try
				{
					InputStream stream = getContentResolver().openInputStream(screenshotUri);
				}
				catch(FileNotFoundException e)
				{
					e.printStackTrace();
				}
				sharingIntent.setType("image/jpeg");
				sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
				startActivity(Intent.createChooser(sharingIntent, "share image using"));
				
			}
		});
    }
    
    public void onButtonClick1(View v)
    {
    	if(v.getId()==R.id.button1)
    	{
    		Intent i1 = new Intent(MainActivity.this,Display1.class);
    		startActivity(i1);
    	}
    }
    public void onButtonClick2(View v)
    {
    	if(v.getId()==R.id.button2)
    	{
    		Intent i2 = new Intent(MainActivity.this,Display2.class);
    		startActivity(i2);
    	}
    }
    public void onButtonClick3(View v)
    {
    	if(v.getId()==R.id.button3)
    	{
    		Intent i3 = new Intent(MainActivity.this,Display3.class);
    		startActivity(i3);
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public boolean onOptionItemSelected(MenuItem item)
    {
    	int id = item.getItemId();
    	
    	if(id==R.id.about){
    	
    		return true;
    	}
    	return super.onOptionsItemSelected(item);
    }
     @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	int id = item.getItemId();
    	switch(id)
    	{
    	case R.id.about:
    		Toast.makeText(getApplicationContext(), "Developed by Pratap Simha G K ", Toast.LENGTH_SHORT).show();
    		break;
    		}
    	return super.onOptionsItemSelected(item); 
    }
    
}
