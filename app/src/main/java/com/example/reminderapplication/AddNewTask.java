package com.example.reminderapplication;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.inputmethodservice.Keyboard;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.speech.RecognizerIntent;
import android.text.InputType;
import android.text.Layout;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import petrov.kristiyan.colorpicker.ColorPicker;

public class AddNewTask extends AppCompatActivity {
    ImageButton voice, enterNumber, contacts, enterTask;
    ImageView dateimg, calendarimg, repeatimg, markerimg, timerimg;
    TextView  date, time, marker, repeat, reportAs, notify, dateText, timeText, markerText, repeatText, reportAsText, notifyText;
    AlarmManager alarmManager;
    EditText enterTaskName;
    FloatingActionButton done;
    final Calendar myCalendar = Calendar.getInstance();

    private LinearLayout layout1,layout2, layout3, layout4, layout5,layout6;

    ListView listView;
    ArrayList<String> arrayList=new ArrayList<>();
    public Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
        initViews();
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               withSingleChoiceItems(listView);

//                RepeatAlarmDialogue cdd = new RepeatAlarmDialogue(AddNewTask.this);
//                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                cdd.show();
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTimeInMillis(System.currentTimeMillis());
//                int year = calendar.get(Calendar.YEAR);
//                int date = calendar.get(Calendar.DATE);
//                int hour = calendar.get(Calendar.HOUR);
//                int week = calendar.get(Calendar.DAY_OF_WEEK);
//                int month = calendar.get(Calendar.DAY_OF_MONTH);
//
//                calendar.set(Calendar.DATE, date + 1);
//                calendar.set(Calendar.YEAR, year + 1);
//                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),1,alarmIntent);
//                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 0, alarmIntent);
            }
        });
        layout4.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
//                final ColorPicker colorPicker = new ColorPicker(SampleActivity.this);
//                colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
//                    @Override
//                    public void onChooseColor(int position,int color) {
//                        // put code
//                    }
//
//                    @Override
//                    public void onCancel(){
//                        // put code
//                    }
//                })
//                        .addListenerButton("newButton", new ColorPicker.OnButtonListener() {
//                            @Override
//                            public void onClick(View v, int position, int color) {
//                                // put code
//                            }
//                        })
//                        .disableDefaultButtons(true)
//                        .setDefaultColor(Color.parseColor("#f84c44"))
//                        .setColumns(5)
//                        .setDialogFullHeight()
//                        .show();

                final ColorPicker colorPicker = new ColorPicker (AddNewTask.this);
                ArrayList<String> colors = new ArrayList<>();
                colors.add("#82B926");
                colors.add("#a276eb");
                colors.add("#6a3ab2");
                colors.add("#666666");
                colors.add("#FFFF00");
                colors.add("#3C8D2F");
                colors.add("#FA9F00");
                colors.add("#FF0000");

                colorPicker
                        .setDefaultColorButton(Color.parseColor("#f84c44"))
                        .setColors(colors)
                        .setColumns(5)
                        .setRoundColorButton(true)
                        .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                            @Override
                            public void onChooseColor(int position, int color) {
                                Log.d("position", "" + position);// will be fired only when OK button was tapped
                                markerText.setText(position);

                            }

                            @Override
                            public void onCancel() {

                            }
                        }).show();
//                        .addListenerButton("newButton", new ColorPicker.OnButtonListener() {
//                            @Override
//                            public void onClick(View v, int position, int color) {
//
//                                Log.d("position", "" + position);
//                            }
//                        }).show();
            }


        } );
        layout2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(AddNewTask.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timeText.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
//        popUp = new PopupWindow(this);
//        LinearLayout layout = new LinearLayout(this);
//        LinearLayout mainLayout = new LinearLayout(this);
//        enterNumber.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (click) {
//                    popUp.showAtLocation(layout, Gravity.BOTTOM, 10, 10);
//                    popUp.update(50, 50, 300, 80);
//                    click = false;
//                } else {
//                    popUp.dismiss();
//                    click = true;
//                }
//            }
//        });
//
//        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.WRAP_CONTENT);
//        layout.setOrientation(LinearLayout.VERTICAL);
//       enterTaskName.setText("Hi this is a sample text for popup window");
//        layout.addView(enterTaskName, params);
//        popUp.setContentView(layout);
//        // popUp.showAtLocation(layout, Gravity.BOTTOM, 10, 10);
//        mainLayout.addView(enterNumber, params);
//        setContentView(mainLayout);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

     layout1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddNewTask.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



















        enterNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterTaskName.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            }
        });
        enterTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterTaskName.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            }
        });
        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVoiceRecognitionActivity();
            }
        });
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(AddNewTask.this, Contacts.class);
//                startActivity(intent);
                checkPermission();
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                startActivityForResult(intent, 0);
            }
        });

    }





















    private void initViews() {




        voice = findViewById(R.id.voice);
        enterNumber = findViewById(R.id.enterNumber);
        contacts = findViewById(R.id.contacts);
        enterTask = findViewById(R.id.enterTask);
        dateimg = findViewById(R.id.dateimg);
        timerimg = findViewById(R.id.timerimg);
        calendarimg = findViewById(R.id.calendarimg);
        repeatimg = findViewById(R.id.repeatimg);
        markerimg = findViewById(R.id.markerimg);
        date = findViewById(R.id.date);
        repeat = findViewById(R.id.repeat);
        notify = findViewById(R.id.notify);
        time = findViewById(R.id.time);
        marker = findViewById(R.id.marker);
        reportAs = findViewById(R.id.reportAs);
        dateText = findViewById(R.id.dateText);
        repeatText = findViewById(R.id.repeatText);
        reportAsText = findViewById(R.id.reportAsText);
        markerText = findViewById(R.id.markerText);
        notifyText = findViewById(R.id.notifyText);
        timeText = findViewById(R.id.timeText);
        enterTaskName = findViewById(R.id.enterTaskName);
        done = findViewById(R.id.done);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);
        layout5 = findViewById(R.id.layout5);
        layout6 = findViewById(R.id.layout6);








    }
    public void checkPermission()
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED)
        {
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},3);
        }

    }

    private void startVoiceRecognitionActivity()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Voice recognition Demo...");
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        if(requestCode == 0 && resultCode == RESULT_OK){

        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            Uri uri = data.getData();
            Log.i("data", uri.toString());
            if (uri != null) {
                Cursor c = null;
                try {
                    c = getContentResolver()
                            .query(uri,
                                    new String[]{
                                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                                            ContactsContract.CommonDataKinds.Phone.NUMBER,
                                            ContactsContract.CommonDataKinds.Phone.TYPE},
                                    null, null, null);

                    if (c != null && c.moveToFirst()) {
                        String name = c.getString(0);
                        String number = c.getString(1);
                        int type = c.getInt(2);

                        showSelectedNumber(name, number, type);
                    }
                } finally {
                    if (c != null) {
                        c.close();
                    }
                }
            }
        }
    }
        if (requestCode == 1 && resultCode == RESULT_OK)
        {
            // Populate the wordsList with the String values the recognition engine thought it heard
            ArrayList<String> matches = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            enterTaskName.setText(matches.get(0));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void showSelectedNumber(String name, String number, int type) {
        EditText userNumber = (EditText) findViewById(R.id.enterTaskName);
        String typeNumber = (String) ContactsContract.CommonDataKinds.Phone
                .getTypeLabel(getResources(), type, "");
        userNumber.setText(name + ": " + number + " " + typeNumber);

    }
    private void updateLabel() {
        String myFormat = "MM/dd/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateText.setText(sdf.format(myCalendar.getTime()));
    }
    public void withSingleChoiceItems(View view) {
        boolean isChecked = true;
        final String[] items = {"Once", "Hourly", "Daily", "Weekly", "Monthly", "Yearly", "Custom"};

        final ArrayList<Integer> selectedList = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle ( "Repeat Alarm" ).setSingleChoiceItems (items,0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(isChecked) {
                    selectedList.add ( which );

                    switch (which) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:

                            Calendar mcurrentTime = Calendar.getInstance ();
                            int hour = mcurrentTime.get ( Calendar.HOUR_OF_DAY );
                            int minute = mcurrentTime.get ( Calendar.MINUTE );
                            TimePickerDialog mTimePicker;
                            mTimePicker = new TimePickerDialog ( AddNewTask.this, new TimePickerDialog.OnTimeSetListener () {
                                @Override
                                public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                    repeatText.setText ( selectedHour + ":" + selectedMinute );
                                }
                            }, hour, minute, true );//Yes 24 hour time
                            mTimePicker.setTitle ( "Select Time" );
                            mTimePicker.show ();

//
//                            Intent intent = new Intent(AddNewTask.this, Every.class);
//                            startActivity(intent);
//                            break;




                    }
                }
                else if (selectedList.contains ( which ))
                {
                    selectedList.remove ( which );
                }
            }
        });

// create and show the alert dialog


//
//        builder.setTitle("Repeat Alarm").setSingleChoiceItems ( items, 0, new DialogInterface.OnClickListener () {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if (isChecked) {
//                    selectedList.add(which);
//
//                     } else if (selectedList.contains(which)) {
//                                selectedList.remove(which);
//                        }
//            }
//        } ).setTitle ( "Every" ).setSingleChoiceItems ( items, 0, new DialogInterface.OnClickListener() {
//
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int Custom) {
//
//                            Calendar mcurrentTime = Calendar.getInstance ();
//                            int hour = mcurrentTime.get ( Calendar.HOUR_OF_DAY );
//                            int minute = mcurrentTime.get ( Calendar.MINUTE );
//                            TimePickerDialog mTimePicker;
//                            mTimePicker = new TimePickerDialog ( AddNewTask.this, new TimePickerDialog.OnTimeSetListener () {
//                                @Override
//                                public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
//                                    repeatText.setText ( selectedHour + ":" + selectedMinute );
//                                }
//                            }, hour, minute, true );//Yes 24 hour time
//                            mTimePicker.setTitle ( "Select Time" );
//                            mTimePicker.show ();
//
//
//                    }
//                    });
//        builder.show();

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ArrayList<String> selectedStrings = new ArrayList<>();

                for (int j = 0; j < selectedList.size(); j++) {
                    selectedStrings.add(items[selectedList.get(j)]);
                }

                Toast.makeText(getApplicationContext(), "Items selected are: " + Arrays.toString(selectedStrings.toArray()), Toast.LENGTH_SHORT).show();


            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ArrayList<String> selectedStrings = new ArrayList<>();

                for (int j = 0; j < selectedList.size(); j++) {
                    selectedStrings.add(items[selectedList.get(j)]);
                }

                Toast.makeText(getApplicationContext(), "Items selected are: " + Arrays.toString(selectedStrings.toArray()), Toast.LENGTH_SHORT).show();

          //      selectedStrings.setText(repeatText);

            }
        });




        builder.show();

    }


    }



