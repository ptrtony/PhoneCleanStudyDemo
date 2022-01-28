package com.tb.studyandroiddemo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.tb.javastudydemo.EncryptionUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityResultLauncher<Intent> searchDeviceLauncher;
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str = EncryptionUtils.a("EAIMXAAMAwlPCAQBRh5BX1FDRh8QAQQTGgYe");
        ((TextView)findViewById(R.id.text)).setText(str);
        Log.e(TAG,str);

        findViewById(R.id.button).setOnClickListener(view -> {
            Intent var1 = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            StringBuilder var2 = new StringBuilder();
            var2.append("package:");
            var2.append(getPackageName());
            var1.setData(Uri.parse(var2.toString()));
            var1.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivityForResult(var1,1);
//            searchDeviceLauncher = registerForActivityResult(new ActivityResultContract(){
//
//                @NonNull
//                @Override
//                public Intent createIntent(@NonNull Context context, Object input) {
//                    return var1;
//                }
//
//                @Override
//                public Integer parseResult(int resultCode, @Nullable Intent intent) {
//                    return resultCode;
//                }
//            },new ActivityResultCallback<Integer>(){
//
//                @Override
//                public void onActivityResult(Integer result) {
//                    if (result == Activity.RESULT_OK){
//
//                    }
//                }
//            });
//
//            searchDeviceLauncher.launch(var1);
        });
    }
}