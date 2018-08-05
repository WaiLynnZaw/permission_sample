package info.wailynnzaw.permissionsample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button callBtn = findViewById(R.id.callBtn);
    callBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });

  }

  
  private void makeCall() {
    String url = "tel:" + ("095500619");
    Intent it = new Intent(Intent.ACTION_CALL, Uri.parse(url));
    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        requestPermissions(new String[]{Manifest.permission.CALL_PHONE},
                100);
      }
      return;
    }
    startActivity(it);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    if (requestCode == 100
            && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
      makeCall();
    }
  }
}
