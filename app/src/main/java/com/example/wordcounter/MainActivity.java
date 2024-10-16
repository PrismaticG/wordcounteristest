package com.example.wordcounter;
import android.widget.TextView;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.wordcounter.utils.TextCounter;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText edUserInput;
    Spinner spSelectOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        this.tvResult= findViewById(R.id.tvCountResult);
        this.edUserInput=findViewById(R.id.edUserInput);
        this.spSelectOptions = (Spinner) findViewById(R.id.spSelectionOptions);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spSelectOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        String userPhrase = this.edUserInput.getText().toString();
        if (userPhrase.isEmpty()) {
            Toast.makeText(this, getString(R.string.empty_input_warning), Toast.LENGTH_SHORT).show();
            return;
        }
        String selectedOption = this.spSelectOptions.getSelectedItem().toString();

        if (selectedOption.equalsIgnoreCase(getString(R.string.chars_selection))) {
            // Ccharacters
            int charsCount = TextCounter.getCharsCount(userPhrase);
            this.tvResult.setText(getString(R.string.result_chars, charsCount));
        } else if (selectedOption.equalsIgnoreCase(getString(R.string.words_selection))) {
            // Cwords
            int wordsCount = TextCounter.getWordsCount(userPhrase);
            this.tvResult.setText(getString(R.string.result_words, wordsCount));
        }
    }
}