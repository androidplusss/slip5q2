package com.example.slip5q2option;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private String[] friends = {"Amit", "sakshi", "kirti", "Sumit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnShowFriends = findViewById(R.id.btnShowFriends);
        btnShowFriends.setOnClickListener(v -> showCustomDialog());
    }
    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.activity_second, null);
        builder.setView(dialogView);
        LinearLayout friendsContainer = dialogView.findViewById(R.id.friendsContainer);
        for (String friend : friends) {
            Button friendButton = new Button(this);
            friendButton.setText(friend);
            friendButton.setOnClickListener(v -> showGreeting(friend));
            friendsContainer.addView(friendButton);
        }
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void showGreeting(String friendName) {
        new AlertDialog.Builder(this)
                .setTitle("Greeting")
                .setMessage("Hello, " + friendName + "! Have a great day 😊")
                .setPositiveButton("OK", null)
                .show();
    }
}
